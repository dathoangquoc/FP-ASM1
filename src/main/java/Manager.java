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

    public void add(String input) {
//        Remove whitespaces and non-visible characters, then split
        String[] info = input.replaceAll("\\s+","").split(",");

        String inputClaimDate = info[0];
        String inputInsuredPerson = info[1];
        String inputCardNum = info[2];
        String inputExamDate = info[3];
        String inputDocuments = info[4];
        String inputClaimAmount = info[5];
        String inputStatus = info[6];
        String inputReceiver = info[7];

//        Validate claimDate
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

        Date claimDate = new Date();
        try {
            claimDate = format.parse(inputClaimDate);
        } catch (ParseException e) {
            System.out.println("Invalid date format. dd-MM-yyyy.");
        }

//        Validate insuredPerson
        Customer insuredPerson = null;
        try {
        insuredPerson = findCustomer(inputInsuredPerson);
        } catch (NullPointerException e) {
            System.out.println("No customer found");
        }

//        Validate cardNum
        String cardNum = "";
        try {
            cardNum = findInsuranceCard(inputCardNum).getCardNum();
        } catch (NullPointerException e) {
            System.out.println("No Insurance Card found");
        }

//        Validate examDate
        Date examDate = new Date();
        try {
            examDate = format.parse(inputExamDate);
        } catch (ParseException e) {
            System.out.println("Invalid date format. dd-MM-yyyy.");
        }

//        Store documents
        String[] documents = inputDocuments.split("-");

//        Validate claimAmount
        double claimAmount = 0.0;
        try {
            claimAmount = Double.parseDouble(inputClaimAmount);
        } catch (NumberFormatException e) {
            System.out.println("Invalid Claim Amount");
        }

//        Validate status
        int status = Integer.parseInt(inputStatus);
        if (status > 2) {
            throw new RuntimeException("Status number has to be 0 or 1 or 2");
        }

//        Validate receiver info


//        Add new claim
        Claim claim = new Claim(claimDate, insuredPerson, cardNum, examDate, claimAmount, status, inputReceiver);
        for (String s: documents) {
            claim.addDocument(s);
        }
        claims.add(claim);
    }

    public void add(InsuranceCard insuranceCard) {
        this.insuranceCards.add(insuranceCard);
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
