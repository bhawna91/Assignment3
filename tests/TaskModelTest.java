import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static junit.framework.Assert.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Test for toString()
 * User: Bhawna
 * Date: 9/25/12
 * Time: 9:00 PM
 */
public class TaskModelTest {
    TaskModel testTask;
    ArrayList<String> tag;

    @Before
    public void before() {
        tag = new ArrayList<String>(Arrays.asList("this is a tag"));
        testTask = new TaskModel("task1", "2h", tag, "12/09/25");
    }

    @Test
    public void testToString() {
        System.out.println("Test if toString() returns the expected string...");
        String expected = "12/09/30||Task=task1||Time =2h||Tag=this is a tag";
        String actual = testTask.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetInput() {

        TaskModel taskModel = Mockito.mock(TaskModel.class);
        TaskController taskController = new TaskController();
        taskController.getInput(taskModel);
        verify(taskModel, times(1)).setCode(anyString());
        verify(taskModel, times(1)).setTask(anyString());
        verify(taskModel, times(1)).setTask(anyString());
    }


}

