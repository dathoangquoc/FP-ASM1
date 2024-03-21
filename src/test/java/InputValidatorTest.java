import java.util.Scanner;

public class InputValidatorTest {
    public static void main(String[] args) {
        Manager m = new Manager();
        Scanner scanner = new Scanner(System.in);

        do {

        System.out.println("""
                _____________________Add New Claim_____________________
                [0] Go back
                -------------------------
                Enter the claim with this format:
                
                claim date, insured person's name, card number, exam date, documents name, claim amount, status, receiver info
                
                Date format: dd-MM-yyyy (e.g. 01-01-2024)
                Card number: 10 digits
                Documents format: document1-document2-...-documentN (e.g. SecretInformation-PublicFile)
                Receiver Info format: Bank-Name-Number
                
                e.g. 01-01-2024, Tim Henson, 0000000001, 31-12-2024, evidence1-policies-evidence2, 90000, 1, Techcombank-Tim-19001900
                -------------------------
                ENTER [ ] or a claim:
                """);
        String input = scanner.nextLine().trim();
//01-01-2024, Tim Henson, 0000000001, 31-12-2024, evidence1-policies-evidence2, 90000, 1, Techcombank-Tim-19001900
        } while (m.addClaim(""));
        System.out.println(m.claims.get(0));  // Cannot invoke "Customer.getName()" because "this.insuredPerson" is null
    }
}
