import java.util.ArrayList;
import java.util.Date;

public class Claim {
    private String claimID;
    private Date claimDate;
    private Customer insuredPerson;
    private String cardNum;
    private Date examDate;
    private ArrayList<String> documents;  //Change the object
    private double claimAmount;
    private String status;
    private String receiverInfo;
    private static int count = 0;
    private static String[] statuses = {"New", "Processing", "Done"};

    public Claim(Date claimDate, Customer insuredPerson, String cardNum, Date examDate, double claimAmount, int statusNum, String receiverInfo) {
        count++;
        this.claimID = String.format("F%010d", count);
        this.claimDate = claimDate;
        this.insuredPerson = insuredPerson;
        this.cardNum = cardNum;
        this.examDate = examDate;
        this.documents = new ArrayList<>();
        this.claimAmount = claimAmount;
        this.status = statuses[statusNum];
        this.receiverInfo = receiverInfo;
    }

    public String getClaimID() {
        return claimID;
    }

    public Date getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(Date claimDate) {
        this.claimDate = claimDate;
    }

    public Customer getInsuredPerson() {
        return insuredPerson;
    }

    public void setInsuredPerson(Customer insuredPerson) {
        this.insuredPerson = insuredPerson;
    }

    public String getCardNum() {
        return cardNum;
    }

    public void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    public ArrayList<String> getDocuments() {
        return documents;
    }

    public void addDocument(String document) {

        this.documents.add(this.getClaimID() + "_" + this.getCardNum() + "_" + document + ".pdf");
    }

    public double getClaimAmount() {
        return claimAmount;
    }

    public void setClaimAmount(double claimAmount) {
        this.claimAmount = claimAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(int statusNum) {
        this.status = statuses[statusNum];
    }

    public String getReceiverInfo() {
        return receiverInfo;
    }

    public void setReceiverInfo(String receiverInfo) {
        this.receiverInfo = receiverInfo;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Claim{" +
                "claimID='" + claimID + '\'' +
                ", claimDate=" + claimDate +
                ", insuredPerson=" + insuredPerson.getName() +
                ", cardNum='" + cardNum + '\'' +
                ", examDate=" + examDate +
                ", documents=" + documents +
                ", claimAmount=" + claimAmount +
                ", status='" + status + '\'' +
                ", receiverInfo='" + receiverInfo + '\'' +
                '}';
    }
}
