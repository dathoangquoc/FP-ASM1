import java.util.ArrayList;

public abstract class Customer {
    String customerID;
    String name;
    InsuranceCard insuranceCard;
    ArrayList<Claim> claims;
    static int count;

    public Customer(String name, InsuranceCard insuranceCard) {
        this.customerID = String.valueOf(count);
        this.name = name;
        this.insuranceCard = insuranceCard;
        this.claims = new ArrayList<Claim>();
        count++;
    }
}
