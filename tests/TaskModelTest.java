import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static junit.framework.Assert.assertEquals;

/**
 * Test for toString()
 * User: Bhawna
 * Date: 9/25/12
 * Time: 9:00 PM
 */
public class TaskModelTest {
    @Test
    public void testToString() {
        System.out.println("Test if toString() returns the expected string...");
        ArrayList<String> tag = new ArrayList<String>( Arrays.asList("this is a tag"));
        TaskModel testTask = new TaskModel("task1","2h",tag,"12/09/25");
        String expected = "12/09/25||Task=task1||Time =2h||Tag=this is a tag";
        String actual = testTask.toString();
        assertEquals(expected,actual);
    }
}

