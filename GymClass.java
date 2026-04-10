import java.time.LocalDate; 
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Queue; 

public class GymClass {

    public LocalTime time;
    public int capacity;
    public Trainer trainer;
    public LocalDate day;
    public String type;

    public ArrayList<Member> bookedMembers;
    public Queue<Member> waitlist; 

    public GymClass(LocalTime time, int capacity, Trainer trainer, LocalDate day, String type) {
        this.time = time;
        this.capacity = capacity;
        this.trainer = trainer;
        this.day = day;
        this.type = type;
        this.bookedMembers = new ArrayList<>();
    }

    public boolean bookClass(Member member) {
        if (bookedMembers.size() < capacity) {
            bookedMembers.add(member);
            return true;
        } else {
            System.out.println("The class is full, so you will be added to a waitlist.");
            waitlist.add(member);
            return false;
        }
    }

    public void cancelBooking(Member member) {
        bookedMembers.remove(member);
        fillEmptyClassSpot();
        
    }

    public void fillEmptyClassSpot() {
        if (!waitlist.isEmpty() && bookedMembers.size() < capacity) {
            bookedMembers.add(waitlist.poll()); 
        }
    }

    //editable by staff
    public LocalTime getTime() {
        return time;
    }
    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Trainer getTrainer() {
        return trainer;
    }
    public void setTrainer(Trainer trainer) {
        this.trainer = trainer;
    }

    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    //members browse by
    public LocalDate getDay() {
        return day;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return String.format("Time: %s\nCapacity: %d\nTrainer: %s\nDay: %s\nType: %s",
        time, capacity, trainer, day, type);
    }

}
