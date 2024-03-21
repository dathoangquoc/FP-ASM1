import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
public class MainTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Manager m = new Manager();
//        m.import(File file)
        System.out.println("""
                _____________________Good afternoon Manager_____________________
                [0] Save and exit
                -------------------------
                [1] Add new claim
                [2] Update existing claim
                [3] Delete existing claim
                [4] Get 1 claim
                [5] Get all claims
                -------------------------
                ENTER NUMBER:
                """);
        String input = scanner.nextLine().trim();
        switch (input) {
            case "1":
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
                ENTER 0 or a claim:
                """);
                input = scanner.nextLine();
                m.addClaim(input);
                } while (!input.equals("0"));
                break;
            case "2":
                break;
        }
    }
}

