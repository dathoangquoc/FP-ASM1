/**
 * @author <Hoang Quoc Dat - s3979331>
 */

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Claim implements Serializable {
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
    private static final String[] statuses = {"New", "Processing", "Done"};

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

    protected void setClaimID(String claimID) {
        this.claimID = claimID;
    }

    public Date getClaimDate() {
        return claimDate;
    }

    protected void setClaimDate(Date claimDate) {
        this.claimDate = claimDate;
    }

    public Customer getInsuredPerson() {
        return insuredPerson;
    }

    protected void setInsuredPerson(Customer insuredPerson) {
        this.insuredPerson = insuredPerson;
    }

    public String getCardNum() {
        return cardNum;
    }

    protected void setCardNum(String cardNum) {
        this.cardNum = cardNum;
    }

    public Date getExamDate() {
        return examDate;
    }

    protected void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    public ArrayList<String> getDocuments() {
        return documents;
    }

    protected void addDocument(String document) {
        // Replace spaces with "_"
        document = document.replaceAll("\\s+","_");
        this.documents.add(this.getClaimID() + "_" + this.getCardNum() + "_" + document + ".pdf");
    }

    public double getClaimAmount() {
        return claimAmount;
    }

    protected void setClaimAmount(double claimAmount) {
        this.claimAmount = claimAmount;
    }

    public String getStatus() {
        return status;
    }

    protected void setStatus(int statusNum) {
            this.status = statuses[statusNum];
    }

    public String getReceiverInfo() {
        return receiverInfo;
    }

    protected void setReceiverInfo(String receiverInfo) {
        this.receiverInfo = receiverInfo;
    }

    public static int getCount() {
        return count;
    }

    protected static void setCount(int count) {
        Claim.count = count;
    }

    @Override
    public String toString() {
        return  String.format("| %s | %s | %-20s | %s | %s | %-60s | %-10s | %-10s | %s |" ,
                getClaimID(), getClaimDate(), getInsuredPerson().getName(), getCardNum(),
                getExamDate(), getDocuments(), getClaimAmount(), getStatus(), getReceiverInfo());
    }
}
