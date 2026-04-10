import java.util.Scanner;
import static java.lang.System.out;

public class account {
    
    String userAccount;
    String password;
    String membership;
    String contact;
    double money;

    Scanner scan = new Scanner(System.in);

    // Getters
        public String getAccount(){
        return this.userAccount;
    }
        public String getPassword(){
        return this.password;
    }
        public String getMembership(){
        return this.membership;
    }
        public String getContact(){
        return this.contact;
    }
        public double getMoney(){
        return this.money;
    }

    // Setters
        public void setAccount(String account){
        this.userAccount = account;
    }
        public void setPassword(String password){
        this.password = password;
    }
        public void setMembership(String membership){
        this.membership = membership;
    }
        public void setContact(String contact){
        this.contact = contact;
    }
        public void setMoney(double money){
        this.money = money;
    }

    // Functions

    // Updates info

    public void readProfile(){
    System.out.println("Account Name: " + userAccount);
    System.out.println("Membership Status: " + membership);
    System.out.println("Contact Info: " + contact);
    }


    public void updateProfile(){

    // Checks if the person is the account owner by checking if they know the password.
        System.out.println("Please enter password to continue or nothing to return.");
        boolean check  = false;

        while (check == false){
            String tempPassword;
            tempPassword = scan.nextLine();
            if (tempPassword.equals(password)){
                check = true;
            }
            else if (tempPassword.equals("")){
                return;
            }
            else{
            System.out.println("Please try again.");
            }
        }

        System.out.println("Enter new name.");
        this.userAccount = scan.nextLine();

        System.out.println("Enter new password.");
        this.password = scan.nextLine();

        this.membership = "unpaid";

    // Gets contact and checks if it's a valid amount of characters in the float.
        System.out.println("Enter new emergency contact number.");
        do {
            this.contact = scan.nextLine();
            if (contact.length() != 10){
                 System.out.println("Please enter a valid number.");
            }
        } while (contact.length() != 10);
    }

    // Creates account
    public void createAccount(){
        System.out.println("Enter new account name.");
        this.userAccount = scan.nextLine();

        System.out.println("Enter new account password.");
        this.password = scan.nextLine();

        this.membership = "Non-member";

    // Gets contact and checks if it's a valid amount of characters in the float.
        System.out.println("Enter new account emergency contact number.");
        do {
            this.contact = scan.nextLine();
            if (contact.length() != 10){
                 System.out.println("Please enter a valid number.");
            }
        } while (contact.length() != 10);

    }

    // Views only membership status.
    public void memberStatus(String membership){
    System.out.println("Membership Status: " + membership);
    }


    // Reruires transfferingn money from the bank, not able to implement currently.
    public void balance(double money){
    this.money = money;
    }


    // A setter to set membership to member.
    // Renews member, but would need to track days if we want to make the membership expire.
    public void renewMember(String membership, double money){
        // Checks if balance is enough and removes the needed money. Need access to bank.
        this.membership = "Active";
        // If certain numbe of days, set to expired.
    }
}