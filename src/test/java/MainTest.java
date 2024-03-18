import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
public class MainTest {
    public static void main(String[] args) {
//        InsuranceCard ic = new InsuranceCard( null, null, new Date(1,0,2024));
//        PolicyHolder ph = new PolicyHolder("dat", ic);
//        Dependent d = new Dependent("not dat", ic);
//        Claim c = new Claim(new Date(1, 0, 2024), d, "000000", new Date(1, 0 ,2077), null, 10000, "pending", "dunno");
//
//        ic.setPolicyOwner(ph);
//        ic.setCardHolder(d);
//
//        c.setCardNum(ic.getCardNum());
//
//        System.out.println(ic.getPolicyOwner().getCustomerID());
//        System.out.println(ic.getCardNum());

        Scanner scanner = new Scanner(System.in);
        SimpleDateFormat format = new SimpleDateFormat("dd-mm-YYYY");  // Change format as needed

        System.out.println("Enter a date in dd-mm-YYYY format: ");
        String inputDate = scanner.nextLine();

        try {
            Date date = format.parse(inputDate);
            System.out.println("Date object created: " + date);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use YYYY-MM-DD.");
        }
    }
}

