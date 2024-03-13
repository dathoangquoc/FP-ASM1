import java.util.Date;

public class InsuranceCard {
    String cardNum;
    Customer cardHolder;
    PolicyHolder policyOwner;
    Date expirationDate;

    public InsuranceCard(String cardNum, Customer cardHolder, PolicyHolder policyOwner, Date expirationDate) {
        this.cardNum = cardNum;
        this.cardHolder = cardHolder;
        this.policyOwner = policyOwner;
        this.expirationDate = expirationDate;
    }
}
