// Would need to connect this to a database since there would be multiple accounts in the database.

import java.util.Scanner;

public class member {
    private String name;
    private String membership;
    private double money;

    Scanner scan = new Scanner(System.in);

    account account = new account();

    // Getters

    public String getName(){
        return name = account.getAccount();
    }

    protected double getMoney(){
        return money = account.getMoney();
    }

    public String getMembership(){
        return membership = account.getMembership();
    }


    // Functions

    public void updateMembership(String newMembership){
        account.updateMembership(newMembership);
    }

    public void makeAcount(){
        account.createAccount();
        name = account.getAccount();
        membership = account.getMembership();
    }

    public int signIn(){
        System.out.println("Please enter your username");
        String username = scan.nextLine();

        System.out.println("Please enter your password");
        String password = scan.nextLine();
        if(username.equals(name) && password.equals(account.getPassword())){
            System.out.println("Login successful!");
            return 1;
        }else{
            System.out.println("Login failed.");
            return 3;
        }
    }

    // Makes QR code to check in. Can't make for obvious reason.
    public int checkIn(){
        int QRAuthntication = 1;
        return QRAuthntication;
    }


}