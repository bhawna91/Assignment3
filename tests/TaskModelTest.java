import org.junit.Test;

import static org.junit.Assert.assertTrue;

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
        TaskModel task = new TaskModel();
        task.setTask("task1");
        task.setTime("2h");
        task.setTag("this is a tag");
        TaskModel testTask = new TaskModel(task.getTask(), task.getTime(), task.getTag(), task.getCurrentDate());
        String expected = "12/09/25||Task=task1||Time =2h||Tag=this is a tag";
        String actual = testTask.toString();
        assertTrue(actual.equals(expected));
    }
}

