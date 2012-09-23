/**
 * User: Bhawna
 * Date: 9/23/12
 * Time: 4:45 PM
 * Controller
 */


import java.io.*;
import java.util.Scanner;

public class TaskController {

    //Function to get the mandatory inputs from the user.
    public void getInput(TaskModel task) {
        Scanner userInput = new Scanner(System.in);
        System.out.print("Enter the employee code:");                // Prompt the user to input Employee code.
        task.setCode(userInput.next());
        System.out.println("Enter the task name:");                  // Prompt the user to input task.
        task.setTask(userInput.next());
        System.out.println("Enter the time taken for the task:");    // Prompt the user to input time for task.
        task.setTime(userInput.next());

    }

    //Function to check for presence of tag.
    public void checkTag(TaskModel task) {
        String option = "y";
        Scanner input = new Scanner(System.in);
        String str = "Do you want to enter a tag?y/n";
        while (option.equals("y")) {
            System.out.println(str);
            option = input.next();
            if (option.equals("y")) {
                System.out.println("Enter the tag:");
                storeTag(task);
            }
            str = "Do you want to enter another tag?y/n";
        }
    }

    //Function to store the tag.
    public void storeTag(TaskModel task) {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader bin = new BufferedReader(in);
        try {
            task.setTag(bin.readLine());
        } catch (java.io.IOException exp) {
            exp.printStackTrace();
        }
    }

    //Function to store input in file.
    public void storeInputInFile(TaskModel task) {
        String filename = task.getCode() + ".txt";
        TaskModel createTask = new TaskModel(task.getTask(), task.getTime(), task.getTag(), task.getCurrentDate());
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(filename, true);
            out = new ObjectOutputStream(fos);
            out.writeObject(createTask);
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    //Main function.
    public static void main(String[] args) {
        TaskModel task = new TaskModel();
        TaskController taskObj = new TaskController();
        taskObj.getInput(task);
        taskObj.checkTag(task);
        taskObj.storeInputInFile(task);
        System.out.println("Your Task has been successfully stored.");

    }
}
