import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.hadoop.hbase.client.HTablePool;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;
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


    private static Put makePut(TaskModel task) {            //Prepare object for writing to HBase
        Put p = new Put(Bytes.toBytes(task.getCurrentDate()));
        p.add(Bytes.toBytes("cf1"), Bytes.toBytes("Code"), Bytes.toBytes(task.getCode()));
        p.add(Bytes.toBytes("cf1"), Bytes.toBytes("Name"), Bytes.toBytes(task.getTask()));
        p.add(Bytes.toBytes("cf1"), Bytes.toBytes("Time"), Bytes.toBytes(task.getTime()));
        p.add(Bytes.toBytes("cf1"), Bytes.toBytes("Tag"),  Bytes.toBytes(task.getTagAsString()));
        p.add(Bytes.toBytes("cf2"), Bytes.toBytes("Date"),  Bytes.toBytes(task.getCurrentDate()));
        p.add(Bytes.toBytes("cf2"), Bytes.toBytes("Task"),  Bytes.toBytes(task.toString()));
        return p;
    }

    public void writeToHBase(TaskModel task)throws IOException {     //Write to HBase
        HTablePool pool = new HTablePool();
        HTableInterface taskTable = pool.getTable(Bytes.toBytes("Task1"));
        Put p = makePut(task);
        taskTable.put(p);
        taskTable.close();
    }
}