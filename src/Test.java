/**
 * Module1
 * User: Bhawna
 * Date: 9/18/12
 * Time: 4:00 PM
 * View
 */

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Test {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        Task task = new Task();
        System.out.print("Enter the employee code:");                // Prompt the user to input Employee code.
        task.userCode = userInput.next();
        System.out.println("Enter the task name:");                  // Prompt the user to input task.
        task.userTask = userInput.next();
        System.out.println("Enter the time taken for the task:");    // Prompt the user to input task.
        task.userTime = userInput.next();
        System.out.println("Do you want to add a tag yes/no?");
        task.answer = userInput.next();
        if (task.answer.equals("yes")) {
            InputStreamReader in = new InputStreamReader(System.in);
            BufferedReader bin = new BufferedReader(in);
            System.out.println("Enter the tag:");
            task.storeTag(bin);
        }
        //display the user command.
        System.out.println("You have entered the following command:" + task.storeCommand());
        task.storeInputInFile();

    }
}
