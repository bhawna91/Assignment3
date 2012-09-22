/**
 * Created with IntelliJ IDEA.
 * User: Bhawna
 * Date: 9/22/12
 * Time: 8:53 PM
 * Model
 */

import java.io.Serializable;
import java.util.ArrayList;

public class TaskModel implements Serializable {
    public String userTask;                                      // String to store the user task.
    public String userTime;                                      // String to store the user time
    public String tag = "";                                        // String to store the tag
    public String answer;                                        // Shows absence or presence of tag.
    public String userCode;                                      // String to store Employee code
    ArrayList<String> userTag = new ArrayList<String>();

    // Constructors to initialize the task object
    public TaskModel() {
    }

    public TaskModel(String task, String time, String tag) {
        this.userTask = task;
        this.userTime = time;
        this.tag = tag;
    }

    //Function to store the Tag.
    public void storeTag() {
        userTag.add(tag);
    }

    //Override toString function
    public String toString() {
        String commandString = "";
        commandString += "Task=" + userTask + " " + "Time =" + userTime + " ";
        for (String s : userTag) {
            tag = s;
        }
        if (!(userTag.isEmpty())) {
            System.out.println(userTag);
            commandString += "Tag=" + tag;
            commandString = commandString.replace("[", "").replace("]", "");
        }
        return commandString;
    }
}
