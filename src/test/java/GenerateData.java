import java.io.*;
import java.util.Date;
import java.util.Scanner;

public class GenerateData {
    public static void main(String[] args) {
        Manager m = new Manager();

        // PolicyHolders
        PolicyHolder p1 = new PolicyHolder("Peter Parker", "0000000001");
        PolicyHolder p2 = new PolicyHolder("Bruce Wayne", "0000000002");
        PolicyHolder p3 = new PolicyHolder("Clark Kent", "0000000003");
        PolicyHolder p4 = new PolicyHolder("Diana Prince", "0000000004");
        PolicyHolder p5 = new PolicyHolder("Steve Rogers", "0000000005");
        PolicyHolder p6 = new PolicyHolder("Tony Stark", "0000000006");
        PolicyHolder p7 = new PolicyHolder("Natasha Romanoff", "0000000007");
        PolicyHolder p8 = new PolicyHolder("Clint Barton", "0000000008");
        PolicyHolder p9 = new PolicyHolder("James Rhodes", "0000000009");
        PolicyHolder p10 = new PolicyHolder("Sam Wilson", "0000000010");
        PolicyHolder p11 = new PolicyHolder("Wanda Maximoff", "0000000011");
        PolicyHolder p12 = new PolicyHolder("Vision", "0000000012");
        PolicyHolder p13 = new PolicyHolder("Bucky Barnes", "0000000013");
        PolicyHolder p14 = new PolicyHolder("Loki Laufeyson", "0000000014");
        PolicyHolder p15 = new PolicyHolder("Thor Odinson", "0000000015");

        // Dependents
        Dependent d1 = new Dependent("Daniel Lee", "0000000001");
        Dependent d2 = new Dependent("Diana Prince", "0000000002");
        Dependent d3 = new Dependent("David Smith", "0000000003");
        Dependent d4 = new Dependent("Dorothy Brown", "0000000004");
        Dependent d5 = new Dependent("Dominic Nguyen", "0000000005");
        Dependent d6 = new Dependent("Daisy Miller", "0000000006");
        Dependent d7 = new Dependent("Dylan Jones", "0000000007");
        Dependent d8 = new Dependent("Darlene Williams", "0000000008");
        Dependent d9 = new Dependent("Derrick Thompson", "0000000009");
        Dependent d10 = new Dependent("Denise Garcia", "0000000010");
        Dependent d11 = new Dependent("Dustin Baker", "0000000011");
        Dependent d12 = new Dependent("Danielle Moore", "0000000012");
        Dependent d13 = new Dependent("David Lee", "0000000013");
        Dependent d14 = new Dependent("Deborah Clark", "0000000014");
        Dependent d15 = new Dependent("Daniel Robinson", "0000000015");

        // InsuranceCards
        InsuranceCard ic1 = new InsuranceCard(d1, "X-Men", new Date(2024, 1, 1));
        InsuranceCard ic2 = new InsuranceCard(d2, "X-Men", new Date(2024, 2, 1));
        InsuranceCard ic3 = new InsuranceCard(d3, "X-Men", new Date(2024, 3, 1));
        InsuranceCard ic4 = new InsuranceCard(d4, "X-Men", new Date(2024, 4, 1));
        InsuranceCard ic5 = new InsuranceCard(d5, "S.H.I.E.L.D.", new Date(2024, 5, 1));
        InsuranceCard ic6 = new InsuranceCard(p6, "S.H.I.E.L.D.", new Date(2024, 6, 1));
        InsuranceCard ic7 = new InsuranceCard(p7, "Fantastic Four Inc.", new Date(2024, 7, 1));
        InsuranceCard ic8 = new InsuranceCard(p8, "Fantastic Four Inc.", new Date(2024, 8, 1));
        InsuranceCard ic9 = new InsuranceCard(p9, "Fantastic Four Inc.", new Date(2024, 9, 1));
        InsuranceCard ic10 = new InsuranceCard(p10, "Wayne Industries", new Date(2024, 10, 1));
        InsuranceCard ic11 = new InsuranceCard(p11, "Wayne Industries", new Date(2024, 11, 1));
        InsuranceCard ic12 = new InsuranceCard(p12, "Wayne Industries", new Date(2024, 12, 1));
        InsuranceCard ic13 = new InsuranceCard(p13, "Wayne Industries", new Date(2025, 1, 1));
        InsuranceCard ic14 = new InsuranceCard(p14, "OSCORP", new Date(2025, 2, 1));
        InsuranceCard ic15 = new InsuranceCard(p15, "OSCORP", new Date(2025, 3, 1));

        // Claims
        Claim c1 = new Claim(new Date(2024, 0, 1), p1, "0000000001", new Date(2024, 1, 2), 50000, 0, "Peter Parker - 1100");
        Claim c2 = new Claim(new Date(2024, 1, 1), p2, "0000000002", new Date(2024, 2, 5), 100000, 1, "Bruce Wayne - 1200");
        Claim c3 = new Claim(new Date(2024, 2, 1), p3, "0000000003", new Date(2024, 3, 10), 20000, 2, "Clark Kent - 1300");
        Claim c4 = new Claim(new Date(2024, 3, 1), p4, "0000000004", new Date(2024, 4, 15), 80000, 0, "Diana Prince - 1400");
        Claim c5 = new Claim(new Date(2024, 4, 1), p5, "0000000005", new Date(2024, 5, 20), 30000, 1, "Steve Rogers - 1500");
        Claim c6 = new Claim(new Date(2024, 5, 1), p6, "0000000006", new Date(2024, 6, 25), 150000, 2, "Tony Stark - 1600");
        Claim c7 = new Claim(new Date(2024, 6, 1), p7, "0000000007", new Date(2024, 7, 30), 40000, 0, "Natasha Romanoff - 1700");
        Claim c8 = new Claim(new Date(2024, 7, 1), p8, "0000000008", new Date(2024, 8, 5), 60000, 1, "Clint Barton - 1800");
        Claim c9 = new Claim(new Date(2024, 9, 1), p9, "0000000009", new Date(2024, 9, 10), 25000, 2, "James Rhodes - 1900");
        Claim c10 = new Claim(new Date(2024, 10, 1), p10, "0000000010", new Date(2024, 10, 15), 70000, 0, "Sam Wilson - 2000");
        Claim c11 = new Claim(new Date(2024, 11, 1), p11, "0000000011", new Date(2024, 11, 20), 90000, 1, "Wanda Maximoff - 2100");
        Claim c12 = new Claim(new Date(2024, 12, 1), p12, "0000000012", new Date(2024, 12, 25), 10000, 2, "Vision - 2200");
        Claim c13 = new Claim(new Date(2025, 1, 1), p13, "0000000013", new Date(2025, 1, 30), 10000, 2, "Bucky Barnes - 2300");
        Claim c14 = new Claim(new Date(2025, 2, 1), p14, "0000000014", new Date(2025, 2, 5), 10000, 2, "Loki Laufeyson - 2400");
        Claim c15 = new Claim(new Date(2025, 3, 1), p15, "0000000015", new Date(2025, 3, 10), 10000, 2, "Thor Odinson - 2500");

        //Claim.addDocument()
        c1.addDocument("Medical_Bill");
        c2.addDocument("Police_Report");
        c3.addDocument("Vehicle_Registration");
        c4.addDocument("Rental_Agreement");
        c5.addDocument("Passport");
        c6.addDocument("Bank_Statement");
        c7.addDocument("Employment_Contract");
        c8.addDocument("School_Transcript");
        c9.addDocument("Birth_Certificate");
        c10.addDocument("Death_Certificate");
        c11.addDocument("Marriage_License");
        c12.addDocument("Divorce_Decree");
        c13.addDocument("Travel_Itinerary");
        c14.addDocument("Credit_Card_Statement");
        c15.addDocument("Driver_License");

        // PolicyHolder.addDependent()
        p1.addDependent(d1);
        p2.addDependent(d2);
        p3.addDependent(d3);
        p4.addDependent(d4);
        p5.addDependent(d5);
        p6.addDependent(d6);
        p7.addDependent(d7);
        p8.addDependent(d8);
        p9.addDependent(d9);
        p10.addDependent(d10);
        p11.addDependent(d11);
        p12.addDependent(d12);
        p13.addDependent(d13);
        p14.addDependent(d14);
        p15.addDependent(d15);

        // PolicyHolder.addClaim
        p1.addClaim(c1);
        p2.addClaim(c2);
        p3.addClaim(c3);
        p4.addClaim(c4);
        p5.addClaim(c5);
        p6.addClaim(c6);
        p7.addClaim(c7);
        p8.addClaim(c8);
        p9.addClaim(c9);
        p10.addClaim(c10);
        p11.addClaim(c11);
        p12.addClaim(c12);
        p13.addClaim(c13);
        p14.addClaim(c14);
        p15.addClaim(c15);

        //Manager.add(everything)
        m.addCustomer(p1);
        m.addCustomer(p2);
        m.addCustomer(p3);
        m.addCustomer(p4);
        m.addCustomer(p5);
        m.addCustomer(p6);
        m.addCustomer(p7);
        m.addCustomer(p8);
        m.addCustomer(p9);
        m.addCustomer(p10);
        m.addCustomer(p11);
        m.addCustomer(p12);
        m.addCustomer(p13);
        m.addCustomer(p14);
        m.addCustomer(p15);

        m.addCustomer(d1);
        m.addCustomer(d2);
        m.addCustomer(d3);
        m.addCustomer(d4);
        m.addCustomer(d5);
        m.addCustomer(d6);
        m.addCustomer(d7);
        m.addCustomer(d8);
        m.addCustomer(d9);
        m.addCustomer(d10);
        m.addCustomer(d11);
        m.addCustomer(d12);
        m.addCustomer(d13);
        m.addCustomer(d14);
        m.addCustomer(d15);

        m.addInsuranceCard(ic1);
        m.addInsuranceCard(ic2);
        m.addInsuranceCard(ic3);
        m.addInsuranceCard(ic4);
        m.addInsuranceCard(ic5);
        m.addInsuranceCard(ic6);
        m.addInsuranceCard(ic7);
        m.addInsuranceCard(ic8);
        m.addInsuranceCard(ic9);
        m.addInsuranceCard(ic10);
        m.addInsuranceCard(ic11);
        m.addInsuranceCard(ic12);
        m.addInsuranceCard(ic13);
        m.addInsuranceCard(ic14);
        m.addInsuranceCard(ic15);

        m.addClaim(c1);
        m.addClaim(c2);
        m.addClaim(c3);
        m.addClaim(c4);
        m.addClaim(c5);
        m.addClaim(c6);
        m.addClaim(c7);
        m.addClaim(c8);
        m.addClaim(c9);
        m.addClaim(c10);
        m.addClaim(c11);
        m.addClaim(c12);
        m.addClaim(c13);
        m.addClaim(c14);
        m.addClaim(c15);

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("./src/data/Data.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(m);
            objectOutputStream.flush();
            objectOutputStream.close();


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            FileInputStream fileInputStream = new FileInputStream("./src/data/Data.ser");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            Manager m1 = (Manager) objectInputStream.readObject();
            System.out.println(m1.claims);
            System.out.println(m1.customers);
            System.out.println(m1.insuranceCards);

        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }
}
