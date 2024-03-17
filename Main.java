import UserPackage.User;
import TaskPackage.Task;
import UtilityPackage.Utils;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        // Taking user input and creating a user
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter your username: ");
        String username = scan.next();
        System.out.println("Enter your password: ");
        String password = scan.next();

        System.out.println("Enter your full name: ");
        String first_name = scan.next();
        String last_name = scan.next();
        System.out.println("Enter your email: ");
        String email = scan.next();

        User user = new User(username, password, first_name, last_name, email);
        user.setPassword(password);
        // Displaying the user info
        System.out.println("---User Created---");
        System.out.println("Welcome " + user.getFullName() + "!");
        printUserInfo(user);

        // Creating task for a specific user
        System.out.println("Would you like to create a task? (y/n)");
        char answer = scan.next().charAt(0);
        if (answer == 'y'){
            System.out.println("Creating task...");

            System.out.println("Enter task name: ");
            String taskName =scan.next();
            System.out.println("Enter task color: ");
            String taskColor=scan.next();
            double start_time,finish_time;
            System.out.println("Enter task start time: ");
            start_time = scan.nextDouble();
            System.out.println("Enter task finish time: ");
            finish_time = scan.nextDouble();
            Task task1 = new Task(taskName,user,taskColor);
            task1.setColor(taskColor);
            task1.setStart_time(start_time);
            task1.setFinish_time(finish_time);
            user.createTask(taskName,taskColor);

            DecimalFormat df = new DecimalFormat("##.00");
            System.out.println(taskName + " duration: " + df.format(task1.getDuration()));
        }

        // Changing username and password with setter methods
        System.out.println("Would you like to change your username and password? (y/n)");
        answer = scan.next().charAt(0);
        if (answer == 'y'){
            System.out.println("Changing username and password...");
            System.out.println("Enter new username: ");
            String username2 = scan.next();
            user.setUsername(username2);
            System.out.println("Enter new password: ");
            String password2 = scan.next();
            user.setPassword(password2);
            // Changing the streak
            user.streak = 2;
            printUserInfo(user);
        }

        // Closing the Scanner
        scan.close();
    }

    public static void printUserInfo(User user){
        System.out.println("Username: " + user.getUsername() + "\nFull name: " + user.getFullName()
                + "\nPassword: " + user.getPassword() + "\nEmail: " + user.email + "\nYou have been using the app for " + user.streak + " days.");
    }
}



