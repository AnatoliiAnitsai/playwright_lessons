import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

public class ReaderTest {

    private Reader reader;

    private InputStream originalIn;
    private PrintStream originalOut;

    @BeforeMethod
    public void setUp() {
        reader = new Reader();

        originalIn = System.in;
        originalOut = System.out;
    }

    @AfterMethod
    public void tearDown() {
        System.setIn(originalIn);
        System.setOut(originalOut);

        reader = null;
    }

    @DataProvider(name = "positiveNumbers")
    public Object[][] positiveNumbers() {
        return new Object[][]{
                {"1\n", 1},
                {"5\n", 5},
                {"42\n", 42},
                {"1000\n", 1000}};
    }

    @Test(dataProvider = "positiveNumbers", groups = {"positive", "dataProvider"})
    public void shouldReturnPositiveNumber(String input, int expected) {
        System.setIn(TestHelper.createInput(input));

        int actual = reader.readNumber();

        Assert.assertEquals(actual, expected);
    }

    @Test(groups = {"negative"})
    public void shouldPrintErrorForZero() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        System.setOut(new PrintStream(output));
        System.setIn(TestHelper.createInput("0\n5\n"));

        reader.readNumber();

        Assert.assertTrue(output.toString().contains("Invalid input. The number must be greater than zero."));
    }

    @Test(groups = {"negative"})
    public void shouldPrintErrorForInvalidText() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        System.setOut(new PrintStream(output));
        System.setIn(TestHelper.createInput("abc\n5\n"));

        reader.readNumber();

        Assert.assertTrue(output.toString().contains("Invalid input. You must enter a positive integer."));
    }

    @Test(groups = {"negative"})
    public void shouldPrintErrorForNegativeNumber() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();

        System.setOut(new PrintStream(output));
        System.setIn(TestHelper.createInput("-10\n7\n"));

        reader.readNumber();

        Assert.assertTrue(output.toString().contains("Invalid input. The number must be greater than zero."));
    }
}