import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Manager{
    ArrayList<Claim> claims;
    ArrayList<InsuranceCard> insuranceCards;
    ArrayList<Customer> customers;

    public Manager() {
        this.claims = new ArrayList<>();
        this.insuranceCards = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    public void importFile() {
//        Add dependent -> policy holder -> insurance card -> claim
//        File file import smt smt
//        for each line {
//          addClaim(line)
//        }

    }

    private Customer findCustomer(String name) {
        for (Customer c: customers) {
            if (c.getName().equalsIgnoreCase(name)) {
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

    public boolean addClaim(String input) {
        if (input.equals("0")) {
            return false;
        }
//        Remove whitespaces and non-visible characters, then split
        String[] info = input.replaceAll("\\s+","").split(",");

        String inputClaimDate;
        String inputInsuredPerson;
        String inputCardNum;
        String inputExamDate;
        String inputDocuments;
        String inputClaimAmount;
        String inputStatus;
        String inputReceiver;


        try {
        inputClaimDate = info[0];
        inputInsuredPerson = info[1];
        inputCardNum = info[2];
        inputExamDate = info[3];
        inputDocuments = info[4];
        inputClaimAmount = info[5];
        inputStatus = info[6];
        inputReceiver = info[7];

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
            insuredPerson = findCustomer(inputInsuredPerson);
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
            cardNum = findInsuranceCard(inputCardNum).getCardNum();
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
            System.out.println("Added" + claim);
        return true;
    }


    public void update() {

    }


    public boolean delete(Claim claim) {
        return false;
    }


    public String getOne(String id) {
        return null;
    }


    public String getAll() {
        return null;
    }
}
