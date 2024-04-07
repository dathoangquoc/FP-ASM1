/**
 * @author <Hoang Quoc Dat - s3979331>
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Manager m = new Manager();
        if (m.loadData()) {
            System.out.println("Data loaded successfully!");
        } else {
            System.out.println("Data error");
        }
        String input = "";
        while (!input.equals("!")) {
            System.out.println("""
                _____________________Good afternoon Manager_____________________
                [!] Save and exit
                -------------------------
                [1] Add new claim
                [2] Update a claim
                [3] Delete a claim
                [4] Get a claim
                [5] Get all claims
                [6] Generate Report
                -------------------------
                ENTER NUMBER:
                """);
            input = scanner.nextLine().trim();
            switch (input) {
                case "1":
                    do {
                        System.out.println("""
                _____________________Add New Claim_____________________
                [0] Go back
                -------------------------
                Enter the claim with this format:
                
                claim date, insured person's ID, exam date, documents name, claim amount, status, receiver info
                
                Date format: dd-MM-yyyy (e.g. 01-01-2024)
                Card number: 10 digits
                Documents format: document1-document2-...-documentN (e.g. SecretInformation-PublicFile)
                Receiver Info format: Bank-Name-Number
                
                e.g. 01-01-2024, C0000001, 31-12-2024, evidence1-policies-evidence2, 90000, 1, Techcombank-Tim-19001900
                -------------------------
                ENTER 0 or a claim:
                """);
                        input = scanner.nextLine();
                        m.newClaim(input);
                    } while (!input.equals("0"));
                    break;
                case "2":
                    do {
                        System.out.println("""
                _____________________Update A Claim_____________________
                [0] Go back
                -------------------------
                Enter the claim ID:
                
                """);
                        input = scanner.nextLine();
                        if (input.equals("0")) {
                            break;
                        } else if (m.getOneClaim(input) != null) {
                            System.out.println("Enter a claim: ");
                            System.out.println("claim date, insured person's ID, exam date, documents name, claim amount, status, receiver info");
                            String newClaim = scanner.nextLine();
                            m.updateClaim(input, newClaim);
                        } else {
                            System.out.println("No claim found with ID: " + input);
                        }
                    } while (true);
                    break;
                case "3":
                    do {
                        System.out.println("""
                _____________________Delete A Claim_____________________
                [0] Go back
                -------------------------
                Enter the claim ID:
                
                """);
                        input = scanner.nextLine();
                        if (input.equals("0")) {
                            break;
                        } else if (m.deleteClaim(input)) {
                            System.out.println("Deleted claim");
                        } else {
                            System.out.println("No claim found with ID: " + input);
                        }
                    } while (true);
                    break;
                case "4":
                    do {
                        System.out.println("""
                _____________________Get A Claim_____________________
                [0] Go back
                -------------------------
                Enter the claim ID:
                
                """);
                        input = scanner.nextLine();
                        Claim claim = m.getOneClaim(input);
                        if (claim != null) {
                            System.out.println(claim);
                        } else {
                            System.out.println("No claim found with ID: " + input);
                        }
                    } while (!input.equals("0"));
                    break;
                case "5":
                    m.getAllClaims();
                    System.out.println("Press [Enter] to continue");
                    input = scanner.nextLine();
                    break;
                case "6":
                    m.getReport();
                    break;
            }
        }
    }
}

