/**
 * @author <Hoang Quoc Dat - s3979331>
 */

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Customer implements Serializable {
    private String customerID;
    private String name;
    private String cardNum;
    private ArrayList<Claim> claims;
    private static int count = 0;

    public Customer(String name, String cardNum) {
        count++;
        this.customerID = String.format("C%07d", count);
        this.name = name;
        this.cardNum = cardNum;
        this.claims = new ArrayList<>();
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public String getCardNum() {
        return cardNum;
    }

    protected void setInsuranceCard(InsuranceCard insuranceCard) {
        this.cardNum = cardNum;
    }

    public ArrayList<Claim> getClaims() {
        return claims;
    }

    public void addClaim(Claim claim) {
        this.claims.add(claim);
    }

    public static int getCount() {
        return count;
    }

    protected static void setCount(int count) {
        Customer.count = count;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID='" + customerID + '\'' +
                ", name='" + name + '\'' +
                ", cardNum='" + cardNum + '\'' +
                ", claims=" + claims +  // infinite loop
                '}';
    }
}
