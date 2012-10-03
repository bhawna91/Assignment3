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
 * Test for getInput()
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
        testTask = new TaskModel("task1", "2h", tag, "12/10/02");
    }

    @Test
    public void testToString() {
        System.out.println("Test if toString() returns the expected string...");
        String expected = "12/10/02||Task=task1||Time =2h||Tag=this is a tag";
        String actual = testTask.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetInput() {
        IOClass inputObj = Mockito.mock(IOClass.class);
        when(inputObj.getString()).thenReturn("1001").thenReturn("task1").thenReturn("2h");
        TaskController taskController = new TaskController();
        TaskModel taskModel = Mockito.mock(TaskModel.class);
        taskController.getInput(taskModel, inputObj);
        verify(taskModel, times(1)).setCode("1001");
        verify(taskModel, times(1)).setTask("task1");
        verify(taskModel, times(1)).setTime("2h");
    }
}

