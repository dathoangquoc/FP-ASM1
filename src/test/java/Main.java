import java.util.Date;

public class Main {
    public static void main(String[] args) {
        InsuranceCard ic = new InsuranceCard( null, null, new Date(1,0,2024));
        PolicyHolder ph = new PolicyHolder("dat", ic);
        Dependent d = new Dependent("not dat", ic);
        Claim c = new Claim(new Date(1, 0, 2024), d, "000000", new Date(1, 0 ,2077), null, 10000, "pending", "dunno");

        ic.policyOwner = ph;
        ic.cardHolder = d;
        c.cardNum = ic.cardNum;
        c.insuredPerson = d;

        System.out.println(ic.cardHolder.customerID);
        System.out.println(ic.cardNum);
    }
}
