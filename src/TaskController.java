/**
 * Created with IntelliJ IDEA.
 * User: Bhawna
 * Date: 9/22/12
 * Time: 8:36 PM
 * To change this template use File | Settings | File Templates.
 */

import java.io.*;
import java.util.Scanner;

public class TaskController {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        TaskModel task = new TaskModel();
        System.out.print("Enter the employee code:");                // Prompt the user to input Employee code.
        task.userCode = userInput.next();
        System.out.println("Enter the task name:");                  // Prompt the user to input task.
        task.userTask = userInput.next();
        System.out.println("Enter the time taken for the task:");    // Prompt the user to input time for task.
        task.userTime = userInput.next();
        System.out.println("Do you want to add a tag yes/no?");      //Prompt the user for tag.
        task.answer = userInput.next();

        if (task.answer.equals("yes")) {
            InputStreamReader in = new InputStreamReader(System.in);
            BufferedReader bin = new BufferedReader(in);
            System.out.println("Enter the tag:");
            try {
                task.tag = bin.readLine();
            } catch (java.io.IOException exp) {
                exp.printStackTrace();
            }
            task.storeTag();
        }

        //store input in file
        String filename = task.userCode + ".txt";
        TaskModel createTask = new TaskModel(task.userTask, task.userTime, task.tag);
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

        //display the user command.
        System.out.println("You have entered the following command:" + task.toString());
    }
}
