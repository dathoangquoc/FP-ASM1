import java.util.Date;

public class Main {
    public static void main(String[] args) {
        InsuranceCard ic = new InsuranceCard("001", null, null, new Date(1,0,2024));
        PolicyHolder ph = new PolicyHolder("dat", ic);
        Dependent d = new Dependent("not dat", ic);
        Claim c = new Claim("21345", new Date(1, 0, 2024), d, "000000", new Date(1, 0 ,2077), null, 10000, "pending", "dunno");

    }
}
