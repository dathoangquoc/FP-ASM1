import java.util.ArrayList;

public abstract class Customer {
    private String customerID;
    private String name;
    private InsuranceCard insuranceCard;
    private ArrayList<Claim> claims;
    private static int count = 0;

    public Customer(String name, InsuranceCard insuranceCard) {
        count++;
        this.customerID = String.format("C%07d", count);
        this.name = name;
        this.insuranceCard = insuranceCard;
        this.claims = new ArrayList<>();
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public InsuranceCard getInsuranceCard() {
        return insuranceCard;
    }

    public void setInsuranceCard(InsuranceCard insuranceCard) {
        this.insuranceCard = insuranceCard;
    }

    public ArrayList<Claim> getClaims() {
        return claims;
    }

    public static int getCount() {
        return count;
    }
}
