package TaskPackage;
import java.util.Scanner;
import UserPackage.User;



public class Task {
    public String name;
    public final String color;
    private double start_time;

    private double finish_time;
    private User user;

    public Task (String name,User user,String color){
        this.name=name;
        this.start_time=0.0;
        this.finish_time=0.0;
        this.color=color;
        this.user=user;
    }
    public double getStart_time(){
        return start_time;
    }
    public double getFinish_time(){
        return finish_time;
    }
    public void setStart_time(double start_time) {
        if (start_time < 0) {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Enter start time:");
                double userInput = scanner.nextDouble();
                if (userInput < 0) {
                    System.out.println("Start time cannot be negative. Please enter a valid start time.");
                } else {
                    this.start_time = userInput;
                    break;
                }
            }
        } else {
            this.start_time = start_time;
        }
    }


    public  void setFinish_time(double finish_time) {
        if (finish_time < 0) {
            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("Enter finish time:");
                double input = scanner.nextDouble();
                if (input < 0) {
                    System.out.println("Finish time cannot be negative. Please enter a valid finish time.");
                } else {
                    this.finish_time = input;
                    break;
                }
            }
        }
            else{
                this.finish_time=finish_time;
        }
    }
    public void setColor(String newColor){
        if(!isColorValid(newColor)){
            System.out.println("error color,Enter task color:  ");

            Scanner scanner = new Scanner(System.in);
            newColor =scanner.next();
            setColor(newColor);

        }


    }


    public boolean isColorValid(String color){
        if(color.length()!=6){
            return false;
        }
        for (int i=0;i<color.length();i++){
            char c=color.charAt(i);
        if(!((c>='A'&&c<='F')||(c>='1'&&c<='9'))){
            return false;
        }
     }
        return true;
    }
    public double getDuration(){

        return  this.finish_time - this.start_time;
    }
}