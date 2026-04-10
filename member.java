// Would need to connect this to a database since there would be multiple accounts in the database.
public class Member {
    String name = "";
    String membership = "";
    double money = 0;

    account account;

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

    public void makeAcount(){
        account.createAccount();
        name = account.getAccount();
        membership = account.getMembership();
    }

    public void signIn(){
        // Requires checking input name and password and searching the data base to find it.
        // Sets name and membership to the account's name and memebership.
        // Requires database.
        this.name = account.getAccount();
        this.membership = account.getMembership();
        this.money = account.getMoney();
    }

    // Makes QR code to check in. Can't make for obvious reason.
    public int checkIn(){
        int QRAuthntication = 1;
        return QRAuthntication;
    }


}