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

    private Customer findCustomer(String customerID) {
        for (Customer c: customers) {
            if (c.getCustomerID().equalsIgnoreCase(customerID)) {
                return c;
            }
        }
        return null;
    }

    private InsuranceCard findInsuranceCard(String cardNum) {
        for (InsuranceCard c: insuranceCards) {
            if (c.getCardNum().equalsIgnoreCase(cardNum)) {
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

    public boolean newClaim(String input) {
        if (input.equals("0")) {
            return false;
        }
//        Remove whitespaces and non-visible characters, then split
        String[] info = input.replaceAll("\\s+","").split(",");

        String inputClaimDate;
        String inputInsuredPersonID;
        String inputExamDate;
        String inputDocuments;
        String inputClaimAmount;
        String inputStatus;
        String inputReceiver;


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
            return false;
        }
//        Validate claimDate
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

        Date claimDate;
        try {
            claimDate = format.parse(inputClaimDate);
        } catch (ParseException e) {
            System.out.println("Invalid date format. dd-MM-yyyy.");
            return false;
        }

//        Validate insuredPerson
        Customer insuredPerson;
        try {
        insuredPerson = findCustomer(inputInsuredPersonID);
            if (insuredPerson == null) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Customer not found");
            return false;
        }

//        Validate cardNum
        String cardNum;
        try {
            cardNum = insuredPerson.getCardNum();
        } catch (NullPointerException e) {
            System.out.println("No Insurance Card found");
            return false;
        }

//        Validate examDate
        Date examDate;
        try {
            examDate = format.parse(inputExamDate);
        } catch (ParseException e) {
            System.out.println("Invalid date format. dd-MM-yyyy.");
            return false;
        }

//        Store documents
        String[] documents = inputDocuments.split("-");

//        Validate claimAmount
        double claimAmount;
        try {
            claimAmount = Double.parseDouble(inputClaimAmount);
        } catch (NumberFormatException e) {
            System.out.println("Invalid Claim Amount");
            return false;
        }

//        Validate status
        int status;
        try {
            status = Integer.parseInt(inputStatus);
            if (status > 2) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("Status number has to be 0 or 1 or 2");
            return false;
        }

//        Validate receiver info


//        Add new claim
        Claim claim = new Claim(claimDate, insuredPerson, cardNum, examDate, claimAmount, status, inputReceiver);
        for (String s: documents) {
            claim.addDocument(s);
        }
        claims.add(claim);
        this.saveData();
        this.loadData();
        System.out.println("Added" + claim);
        return true;
    }


    public void updateClaim() {
        this.saveData();
        this.loadData();
    }


    public boolean deleteClaim(Claim claim) {
        return false;
    }


    public String getOne(String id) {
        return null;
    }


    public void getAll() {
        for (Claim c : claims) {
            System.out.println(c);
        }
    }
}
