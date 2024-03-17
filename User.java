package UserPackage;
import TaskPackage.Task;
import UtilityPackage.Utils;

import java.util.Scanner;

public class User
{

    private String username;
    private String password;
    public String first_name;
    public String last_name;
    public String email;
    public int streak;
    private  Task[] tasks;

    private int  taskCount;
    public User(String username, String password,String first_name,String last_name,String email){
        this.username=username;
        this.password=password;
        this.first_name=first_name;
        this.last_name = last_name;
        this.email = email;
        this.streak = 0;
        this.tasks=new Task[10];
        this.taskCount = 0;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username2){

        this.username = username2;
    }
    public  String getPassword(){
        return password;
    }
    public void setPassword(String password){
        Scanner scan = new Scanner(System.in);
        if(Utils.isPasswordValid(password)){
        this.password= password ;}
        else {
                System.out.println("Invalid password");
                 password = scan.next();
                setPassword(password);

        }
    }
    public  String getFullName(){
        return  first_name + " " +last_name;
    }
    public Task createTask(String name, String color) {
        if (!isTaskRepetitive(name)) {
            if (taskCount < tasks.length) {
                Task newTask = new Task(name, this, color);

                tasks[taskCount++] = newTask;
                return newTask;
            } else {
                System.out.println("Cannot create task. Task limit reached.");
                return null;
            }
        } else {
            System.out.println("There is a task with the same name.");
            return null;
        }
    }

    public boolean isTaskRepetitive(String name){
        for (int i=0;i<taskCount;i++){
            if(tasks[i].name.equals(name)){
                return true;
            }
        }
        return false;
    }
}