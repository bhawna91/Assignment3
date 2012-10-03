import java.io.*;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Bhawna
 * Date: 10/2/12
 * Time: 6:54 PM
 * To change this template use File | Settings | File Templates.
 */
public class IOClass {
    public String getString() {                                 //function to return user input string
        Scanner userInput = new Scanner(System.in);
        String data = userInput.next();
        return data;
    }

    public String getLine() {                                   //function to return user input line
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader bin = new BufferedReader(in);
        String data = "";
        try {
            data = bin.readLine();
        } catch (java.io.IOException exp) {
            exp.printStackTrace();
        }
        return data;
    }

    public void writeToFile(String filename, Object object) {  //function to write an object into a file
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(filename, true);
            out = new ObjectOutputStream(fos);
            out.writeObject(object);
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
