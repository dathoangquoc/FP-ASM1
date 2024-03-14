import java.util.ArrayList;
import java.util.Date;

public class Claim {
    String claimID;
    Date claimDate;
    Customer insuredPerson;
    String cardNum;
    Date examDate;
    ArrayList<Object> documents;  //Change the object
    double claimAmount;
    String status;
    String receiverInfo;
    static int count = 1;

    public Claim(Date claimDate, Customer insuredPerson, String cardNum, Date examDate, ArrayList<Object> documents, double claimAmount, String status, String receiverInfo) {
        this.claimID = String.format("F%010d", count);
        this.claimDate = claimDate;
        this.insuredPerson = insuredPerson;
        this.cardNum = cardNum;
        this.examDate = examDate;
        this.documents = documents;
        this.claimAmount = claimAmount;
        this.status = status;
        this.receiverInfo = receiverInfo;
        count++;
    }
}
