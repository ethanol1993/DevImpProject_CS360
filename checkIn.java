import java.util.ArrayList;

public class checkIn {
    
    static class printTest{
        
    }

    private ArrayList<String> history;

    public String checkStatus(member member) {
        //check in isn't successful if membership is expired or there are unpaid dues
        return member.getMembership(); //? depends on what this method actually returns
    }

    

    public void checkHistory(member member) {
        
        System.out.println("Check-in history:");
        for (int i = 0; i < history.size(); i++) {
            System.out.println(history.get(i));
        }
    }

}
