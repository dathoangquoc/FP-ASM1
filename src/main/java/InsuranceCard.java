import java.util.Date;

public class InsuranceCard {
    String cardNum;
    Customer cardHolder;
    PolicyHolder policyOwner;
    Date expirationDate;
    static int count = 1;

    public InsuranceCard(Customer cardHolder, PolicyHolder policyOwner, Date expirationDate) {
        this.cardNum = String.format("%010d", count);
        this.cardHolder = cardHolder;
        this.policyOwner = policyOwner;
        this.expirationDate = expirationDate;
        count++;
    }
}
