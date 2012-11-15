import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class TaskModel implements Serializable {
    private String userTask="";                                      // String to store the user task.
    private String userTime="";                                      // String to store the user time
    private String tag = "";                                        // String to store the tag

    private String userCode="";                                      // String to store Employee code
    private String currentDate;
    ArrayList<String> userTag = new ArrayList<String>();

    // Constructor to initialize the task object
    public TaskModel() {
    }

    public TaskModel(String task, String time, ArrayList tag, String date) {
        this.userTask = task;
        this.userTime = time;
        this.userTag = tag;
        this.currentDate = date;
    }

    public void test(){

    }
    public void setCode(String code) {      //Stores the user code.
        userCode = code;
    }

    public void setTask(String task) {     //Stores the user task
        userTask = task;
    }

    public void setTime(String time) {     //Stores the user time.
        userTime = time;
    }

    //Function to store the Tag.
    public void setTag(String tag) {      //Stores the user tag.
        userTag.add(tag);
    }

    public String getCode() {             //Retrieve the user code.
        return userCode;
    }

    public String getTask() {             //Retrieve the user task
        return userTask;
    }

    public String getTime() {            //Retrieve the user time.
        return userTime;
    }

    public ArrayList getTag() {          //Retrieve the user tag.
        return userTag;
    }

    public String getCurrentDate() {    //retrieve the current date.
        Calendar currentDate = Calendar.getInstance();
        SimpleDateFormat formatter = new SimpleDateFormat("yy/MM/dd");
        String dateNow = formatter.format(currentDate.getTime());
        return dateNow;
    }

    public String getTagAsString(){      // Retrieve the tag as String value.
        int flag = 0;
        for (String s : userTag) {
            if (flag == 0)
                tag +=s;
            else
                tag += "~" +s;
            flag++;
        }
        return tag;
    }

    public String toString() {         //Override toString function

        String commandString = "";
        commandString=getCurrentDate()+"||"+"Task="+getTask()+"||"+"Time ="+getTime();
        tag= getTagAsString();
        if (!(userTag.isEmpty())) {
            commandString += "||" + "Tag=" +tag;
            commandString = commandString.replace("[", "").replace("]", "");
        }
        return commandString;
    }
}
