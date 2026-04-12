public class GymSystem {

    String membership;
    double money;
    
    public double sendReceipt() {
        return 0.0;
    }

    public void updateMembership (String membership, member member) {
        member.updateMembership(membership);
    }

    public double getMoney() {
        return money;
    }

}
