import java.time.*;
import java.util.Scanner;

class main {
    public static void main(String[] var0) {

        Scanner scan = new Scanner(System.in);
        String[] classArray = {"", "", ""};
        //Class 1
            LocalTime class1time = LocalTime.of(5,30);
            LocalDate class1date = LocalDate.of(2026, 5, 25);
            Trainer Bob = new Trainer("Bob", "1");
            GymClass Jogging = new GymClass(class1time, 15, Bob, class1date, "Jogging");
        //Class 2
            LocalTime class2time = LocalTime.of(5,30);
            LocalDate class2date = LocalDate.of(2026, 5, 25);
            Trainer Dave = new Trainer("Bob", "1");
            GymClass Swimming = new GymClass(class2time, 30, Dave, class2date, "Swimming");
        //Class 3
            LocalTime class3time = LocalTime.of(5,30);
            LocalDate class3date = LocalDate.of(2026, 5, 25);
            Trainer Steve = new Trainer("Bob", "1");
            GymClass Weights = new GymClass(class3time, 7, Steve, class3date, "Weights");
        member newMember = new member();
        int option = 0;
        int option2 = 0;
        while(option != 1){
        System.out.println("Please choose an option:");
        System.out.println("1. Sign in.");
        System.out.println("2. Create account.");
        option = scan.nextInt();
            switch(option){
                case 1: 
                    if(newMember.getName() == null){
                        option = 0;
                        System.out.println("No account detected, unable to sign in.");
                    }
                    break;

                case 2:
                    newMember.makeAcount();
                    System.out.println("You may now sign in with your new account");
                    break;

                default:
                    System.out.println("Invalid option.\n");
            }
        }
        option = 0;

        while(option != 1){
        System.out.println("Please choose an option:");
        System.out.println("1. Normal Sign in.");
        System.out.println("2. QR Sign in.");
        option = scan.nextInt();
                switch(option){
                    case 1:
                        option = newMember.signIn();
                        break;

                    case 2:
                        qr newqr = new qr();
                        newqr.scanQR();
                        option = 1;
                        break;  

                    default:
                        System.out.println("Invalid option.\n");
                }
        }
        option = 0;

        
        while(option != 5){
            System.out.println("Please choose an option:");
            System.out.println("1. View classes.");
            System.out.println("2. Book a class.");
            System.out.println("3. View bookings.");
            System.out.println("4. Cancel bookings.");
            System.out.println("5. Exit.");
            option = scan.nextInt();
            switch(option){
                case 1:
                    System.out.println("");
                    System.out.println(Jogging.toString());
                    System.out.println("");
                    System.out.println(Swimming.toString());
                    System.out.println("");
                    System.out.println(Weights.toString());
                    System.out.println("");
                    break;

                case 2:
                    System.out.println("Which class would you like to book?");
                    System.out.println("1. Jogging.");
                    System.out.println("2. Swimming.");
                    System.out.println("3. Weights.");
                    option2 = scan.nextInt();
                    switch(option2){
                        default:
                            System.out.println("Invalid option.\n");
                            break;
                        case 1:
                            Jogging.bookClass(newMember);
                            classArray[0] = "Jogging";
                            break;
                        
                        case 2:
                            Swimming.bookClass(newMember);
                            classArray[1] = "Swimming";
                            break;

                        case 3:
                            Weights.bookClass(newMember);
                            classArray[2] = "Jogging";
                            break;
                    }
                    option2 = 0;
                    break;
                
                case 3:
                    if(classArray[0].equals("Jogging")){
                        System.out.println("Jogging");
                    }
                    if(classArray[1].equals("Swimming")){
                        System.out.println("Swimming");
                    }
                    if(classArray[2].equals("Weights")){
                        System.out.println("Weights");
                    }
                    break;

                case 4:
                    System.out.println("Which class would you like to cancel?");
                    System.out.println("1. Jogging.");
                    System.out.println("2. Swimming.");
                    System.out.println("3. Weights.");
                    option2 = scan.nextInt();
                    switch(option2){
                        default:
                            System.out.println("Invalid option.\n");
                            break;
                        case 1:
                            Jogging.cancelBooking(newMember);
                            break;
                        
                        case 2:
                            Swimming.cancelBooking(newMember);
                            break;

                        case 3:
                            Weights.cancelBooking(newMember);
                            break;
                    }
                    option2 = 0;
                    break;
                
                case 5:
                    break;

                default:
                    System.out.println("Invalid option.\n");
            }
        }
        
    }
}