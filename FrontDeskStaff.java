import java.time.LocalDate;
import java.time.LocalTime;

public class FrontDeskStaff {

    public void createClass(LocalTime time, int capacity, Trainer trainer, LocalDate day, String type) {
        new GymClass(time, capacity, trainer, day, type);
    }

    public void editClassTime(GymClass gymClass, LocalTime time) {
        gymClass.setTime(time);
    }
    public void editClassTrainer(GymClass gymClass, Trainer trainer) {
        gymClass.setTrainer(trainer);
    }
    public void editClassCapacity(GymClass gymClass, int capacity) {
        gymClass.setCapacity(capacity);
    }

    //use QR's methods to scan QR

}
