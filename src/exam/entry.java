package exam;

import java.util.Scanner;

public class entry {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Email: ");
        String mail = scan.nextLine();

        database db = new database();
        db.accountDatabase(mail);

        if (db.isLogin) {
            manage m = new manage();

            while (true) {
                System.out.println("\nWelcome to our cyber club!!!\nRE - Reverse Engineer\nDF - Digital Forenscs\nPWN - Pwnable\n");

                System.out.print("Option: ");
                String option = scan.nextLine();

                switch (option) {
                    case "RE" ->
                        m.ReverseEngineer();
                    case "DF" ->
                        m.Forensics();
                    case "PWN" ->
                        m.Pwnable();
                    default -> {
                        System.out.println("There is no " + option + " command!!!");
                    }
                }
            }
        } else {
            System.out.print("You want to change it? [Y/N]: ");
            String forgot = scan.nextLine();

            if (forgot.equals("Y") || forgot.equals("y")) {
                System.out.print("Enter old mail: ");
                String oldm = scan.nextLine();
                System.out.print("Enter new mail: ");
                String newm = scan.nextLine();

                newmail nm = new newmail(oldm, newm);
                nm.updateMail();
                
                main(args);
            }
        }
    }
}
