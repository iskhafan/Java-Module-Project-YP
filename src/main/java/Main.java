import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Let's race!\nEnter 3 racer names and their speeds:");
        Scanner scanner = new Scanner(System.in);
        Race race = new Race();
        boolean pass;
        for (int i=1; i<=3; i++) {
            pass = false;
            while(!pass) {
                System.out.println("Enter name of racer #" + i + ":");
                String name = scanner.nextLine();
                if(name.isEmpty()) {
                    System.out.println("Empty name! Please, try again.");
                    continue;
                }
                while(!pass) {
                    System.out.println("Enter speed of racer #" + i + ":");
                    double inputSpeed = scanner.nextDouble();
                    scanner.nextLine();
                    int speed = (int) inputSpeed;
                    if ((double) speed != inputSpeed || speed < 0 || speed > 250) {
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
}
