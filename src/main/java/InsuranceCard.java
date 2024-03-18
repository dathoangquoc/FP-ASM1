import java.util.Date;

public class InsuranceCard {
    private String cardNum;
    private Customer cardHolder;
    private PolicyHolder policyOwner;
    private Date expirationDate;
    private static int count = 0;

    public InsuranceCard(Customer cardHolder, PolicyHolder policyOwner, Date expirationDate) {
        count++;
        this.cardNum = String.format("%010d", count);
        this.cardHolder = cardHolder;
        this.policyOwner = policyOwner;
        this.expirationDate = expirationDate;
    }

    public String getCardNum() {
        return cardNum;
    }

    public Customer getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(Customer cardHolder) {
        this.cardHolder = cardHolder;
    }

    public PolicyHolder getPolicyOwner() {
        return policyOwner;
    }

    public void setPolicyOwner(PolicyHolder policyOwner) {
        this.policyOwner = policyOwner;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public static int getCount() {
        return count;
    }

}
