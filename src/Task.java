/**
 * Module1
 * User: Bhawna
 * Date: 9/20/12
 * Time: 11:00 PM
 * Model
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;


public class Task {

    public String userTask;                                      // String to store the user task.
    public String userTime;                                      // String to store the user time
    public String tag = "";                                        // String to store the tag
    public String answer;                                        // Shows absence or presence of tag.
    public String userCode;                                      // String to store Employee code
    public String userCommand;                                   //String to store user Command

    // Function  to store the user command.
    public String storeCommand() {
        userCommand = userTask + " " + userTime + " " + tag;
        return userCommand;
    }

    //Function to store the input in file.
    public void storeInputInFile() {
        try {
            FileWriter file = new FileWriter(userCode + ".txt", true);   // Create file
            BufferedWriter out = new BufferedWriter(file);
            out.write("Task is:" + userTask);
            out.newLine();
            out.write("Time taken:" + userTime);
            out.newLine();
            out.write("Tag is:" + tag);
            out.newLine();
            out.close();                                        //Close the output stream
        } catch (Exception e) {                              //Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }
    }

    //Function to store the Tag.
    public void storeTag(BufferedReader obj) {
        ArrayList<String> userTag = new ArrayList<String>();
        try {
            tag = obj.readLine();
        } catch (java.io.IOException exp) {
            exp.printStackTrace();
        }
        userTag.add(tag);
        tag = userTag.toString().replace("[", "").replace("]", "");
    }
}


