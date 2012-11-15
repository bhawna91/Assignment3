import java.io.*;

public class TaskController {

    //Function to get the mandatory input from the user.
    public void getInput(TaskModel task, IOClass io) {
        System.out.print("Enter the employee code:");                // Prompt the user to input Employee code.
        String userCode = io.getString();
        task.setCode(userCode);
        System.out.println("Enter the task name:");                  // Prompt the user to input task.
        String userTask = io.getString();
        task.setTask(userTask);
        System.out.println("Enter the time taken for the task:");    // Prompt the user to input time for task.
        String userTime = io.getString();
        task.setTime(userTime);
        task.test();
    }

    //Function to check for presence of tag and store it.
    public void checkTag(TaskModel task, IOClass io) {
        String option = "y";
        String str = "Do you want to enter a tag?y/n";
        while (option.equals("y")) {
            System.out.println(str);
            option = io.getString();
            if (option.equals("y")) {
                System.out.println("Enter the tag:");
                task.setTag(io.getLine());
            }
            str = "Do you want to enter another tag?y/n";
        }
    }


    //Function to store input in file.
    public void storeInput(TaskModel task, IOClass io) {
        TaskModel createTask = new TaskModel(task.getCode(),task.getTask(), task.getTime(), task.getTag(), task.getCurrentDate());
            io.writeToHBase(createTask);
        } catch (IOException ex) {
            ex.printStackTrace();
          }
    }


    //Main function.
    public static void main(String[] args) {
        TaskModel task = new TaskModel();
        IOClass ioObject = new IOClass();
        TaskController taskObj = new TaskController();
        taskObj.getInput(task, ioObject);
        taskObj.checkTag(task, ioObject);
        taskObj.storeInput(task, ioObject);
        System.out.println("Your Task has been successfully stored.");
    }
}
