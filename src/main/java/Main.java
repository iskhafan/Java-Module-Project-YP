import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static final int MAX_SPEED = 250;
    public static final int MIN_SPEED = 0;

    public static void main(String[] args) {


        System.out.println("Let's race!\nEnter 3 racer names and their speeds:");
        Scanner scanner = new Scanner(System.in);
        Race race = new Race();
        boolean pass;
        for (int i=1; i<=3; i++) {
            pass = false;
            while(!pass) {
                System.out.println("Enter name of racer #" + i + ":");
                String name = readNonEmptyTxt(scanner);
                while(!pass) {
                    System.out.println("Enter speed of racer #" + i + ":");
                    double inputSpeed;
                    try {
                        inputSpeed = scanner.nextDouble();
                    } catch (InputMismatchException e) {
                        System.out.println("Non-numeric input! Please, try again.");
                        scanner.nextLine();
                        continue;
                    }
                    scanner.nextLine();
                    int speed = (int) inputSpeed;
                    if ((double) speed != inputSpeed || speed < MIN_SPEED || speed > MAX_SPEED) {
                        System.out.println("Invalid speed! Please, try again.");
                        continue;
                    }
                    Car car = new Car(name, speed);
                    race.updateLeader(car);
                    pass = true;
                }
            }
        }
        System.out.println("The winner is: " + race.leader);
        scanner.close();
        System.out.println("See you next time!");
    }

    public static String readNonEmptyTxt(Scanner scanner) {
        String txt;
        while(true) {
            txt = scanner.nextLine();
            if(txt.isEmpty()) {
                System.out.println("Empty input! Please, try again.");
            } else {
                break;
            }
        }
        return txt;
    }
}
