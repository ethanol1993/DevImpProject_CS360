public class GymSystem {

    String membership;
    double money;
    
    public String sendReceipt() {
        String receipt = "Current balance: " + money + "\nCurrent Membership: " + membership;
        return receipt;
    }

    public void updateMembership (String membership, member member) {
        member.updateMembership(membership);
    }

    public double getMoney() {
        return money;
    }

}