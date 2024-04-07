/**
 * @author <Hoang Quoc Dat - s3979331>
 */

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Manager implements Serializable {

    @Serial
    private static final long serialVersionUID = 8762550684569433657L;

    ArrayList<Claim> claims;
    ArrayList<InsuranceCard> insuranceCards;
    ArrayList<Customer> customers;

    public Manager() {
        this.claims = new ArrayList<>();
        this.insuranceCards = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    public boolean loadData() {
        try {
            FileInputStream fileInputStream = new FileInputStream("./src/data/Data.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            Manager m = (Manager) objectInputStream.readObject();

            this.customers = m.customers;
            Customer.setCount(customers.size());

            this.insuranceCards = m.insuranceCards;
            InsuranceCard.setCount(insuranceCards.size());

            this.claims = m.claims;
            Claim.setCount(claims.size());

            return true;

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void saveData() {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("./src/data/Data.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(this);
            objectOutputStream.flush();
            objectOutputStream.close();


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private Customer getOneCustomer(String customerID) {
        for (Customer c: customers) {
            if (c.getCustomerID().equalsIgnoreCase(customerID)) {
                return c;
            }
        }
        return null;
    }

    private InsuranceCard getOneInsuranceCard(String cardNum) {
        for (InsuranceCard c: insuranceCards) {
            if (c.getCardNum().equalsIgnoreCase(cardNum)) {
                return c;
            }
        }
        return null;
    }

    protected Claim getOneClaim(String claimID) {
        for (Claim c : claims) {
            if (c.getClaimID().equalsIgnoreCase(claimID)) {
                return c;
            }
        }
        return null;
    }


    public void addClaim(Claim claim) {
        this.claims.add(claim);
    }

    public void addCustomer(Customer customer) {
        this.customers.add(customer);
    }

    public void addInsuranceCard(InsuranceCard insuranceCard) {
        this.insuranceCards.add(insuranceCard);
    }

    public Claim parseClaim(String input) {
        String[] info = input.replaceAll("\\s+","").split(",");

        String inputClaimDate = null;
        String inputInsuredPersonID = null;
        String inputExamDate = null;
        String inputDocuments = null;
        String inputClaimAmount = null;
        String inputStatus = null;
        String inputReceiver = null;

        try {
            inputClaimDate = info[0];
            inputInsuredPersonID = info[1];
            inputExamDate = info[2];
            inputDocuments = info[3];
            inputClaimAmount = info[4];
            inputStatus = info[5];
            inputReceiver = info[6];

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Not enough information");
        }
//        Validate claimDate
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

        Date claimDate = null;
        try {
            claimDate = format.parse(inputClaimDate);
        } catch (ParseException e) {
            System.out.println("Invalid date format. dd-MM-yyyy.");
        }

//        Validate insuredPerson
        Customer insuredPerson = null;
        try {
            insuredPerson = getOneCustomer(inputInsuredPersonID);
            if (insuredPerson == null) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Customer not found");
        }

//        Validate cardNum
        String cardNum = null;
        try {
            cardNum = insuredPerson.getCardNum();
        } catch (NullPointerException e) {
            System.out.println("No Insurance Card found");
        }

//        Validate examDate
        Date examDate = null;
        try {
            examDate = format.parse(inputExamDate);
        } catch (ParseException e) {
            System.out.println("Invalid date format. dd-MM-yyyy.");
        }

//        Store documents
        String[] documents = inputDocuments.split("-");

//        Validate claimAmount
        double claimAmount = 0;
        try {
            claimAmount = Double.parseDouble(inputClaimAmount);
        } catch (NumberFormatException e) {
            System.out.println("Invalid Claim Amount");
        }

//        Validate status
        int status = 0;

        try {
            status = Integer.parseInt(inputStatus);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Status number has to be 0 or 1 or 2");
        }

//        Add new claim
        Claim claim = new Claim(claimDate, insuredPerson, cardNum, examDate, claimAmount, status, inputReceiver);
        for (String s: documents) {
            claim.addDocument(s);
        }
        return claim;
    }

    public boolean newClaim(String input) {
        if (input.equals("0")) {
            return false;
        }
        Claim claim = parseClaim(input);
        claims.add(claim);
        this.saveData();
        this.loadData();
        System.out.println("Added" + claim);
        return true;
    }


    public void updateClaim(String claimID, String newClaim) {
//        Create new claim
        int oldCount = Claim.getCount();
        Claim claim = parseClaim(newClaim);  // This increase claimCount by 1, so it has to be reset
        Claim.setCount(oldCount);

//        Replace in claims list
        Claim oldClaim = getOneClaim(claimID);
        claim.setClaimID(oldClaim.getClaimID());
        claims.set(claims.indexOf(oldClaim), claim);
        System.out.println("Updated claim" + oldClaim.getClaimID());

//        Save and reload
        this.saveData();
        this.loadData();
    }


    public boolean deleteClaim(String claimID) {
        if (claims.remove(getOneClaim(claimID))) {
            this.saveData();
            this.loadData();
            return true;
        }
        return false;
    }
    
    public void getAllClaims() {
        for (Claim c : claims) {
            System.out.println(c);
        }
    }

    protected void getReport() {
        try {
            FileWriter fw = new FileWriter("./src/report/report.txt");
            for (Claim c : claims) {
                fw.write(c + System.lineSeparator());
            }
            fw.flush();
            fw.close();
            System.out.println("Report generated at /report/report.txt");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
