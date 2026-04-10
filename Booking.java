import java.time.LocalDate;
import java.util.ArrayList;

public class Booking {
// member should be able to browse schedule by day, trainer, and type
    private ArrayList<GymClass> schedule;

    public void browseByDay(LocalDate day) {
        for (GymClass g : schedule) {
            if (g.getDay().equals(day)) {
                System.out.println(g);
            }
        }
    }

    public void browseByTrainer(Trainer trainer) {
        for (GymClass g : schedule) {
            if (g.getTrainer().equals(trainer)) {
                System.out.println(g);
            }
        }
    }

    public void browseByType(String type) {
        for (GymClass g : schedule) {
            if (g.getType().equals(type)) {
                System.out.println(g);
            }
        }
    }

}
