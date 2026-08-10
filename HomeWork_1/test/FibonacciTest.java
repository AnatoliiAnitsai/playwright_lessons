import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class FibonacciTest {

    private Fibonacci fibonacci;

    @BeforeMethod
    public void setUp() {
        fibonacci = new Fibonacci();
    }

    @AfterMethod
    public void tearDown() {
        fibonacci = null;
    }

    @DataProvider(name = "fibonacciData")
    public Object[][] fibonacciData() {
        return new Object[][]{
                {3, List.of(0L, 1L, 1L)},
                {5, List.of(0L, 1L, 1L, 2L, 3L)},
                {7, List.of(0L, 1L, 1L, 2L, 3L, 5L, 8L)},
                {10, List.of(0L, 1L, 1L, 2L, 3L, 5L, 8L, 13L, 21L, 34L)}
        };
    }

    @Test(groups = {"positive"})
    public void shouldReturnZeroForLengthOne() {
        long[] result = fibonacci.getFibonacciByLength(1);

        Assert.assertEquals(result, new long[]{0});
    }

    @Test(groups = {"positive"})
    public void shouldReturnZeroAndOneForLengthTwo() {
        long[] result = fibonacci.getFibonacciByLength(2);

        Assert.assertEquals(result, new long[]{0, 1});
    }

    @Test(dataProvider = "fibonacciData", groups = {"positive", "dataProvider"})
    public void shouldReturnCorrectFibonacciSequence(int length, List<Integer> expected) {
        long[] result = fibonacci.getFibonacciByLength(length);
        List<Long> actual = TestHelper.convertArrayToList(result);

        Assert.assertEquals(actual, expected);
    }

    @Test(groups = {"positive"})
    public void shouldReturnCorrectLength() {
        long[] result = fibonacci.getFibonacciByLength(90);

        Assert.assertEquals(result.length, 90);
    }

    @Test(groups = {"positive"})
    public void shouldStartWithZeroAndOne() {
        long[] result = fibonacci.getFibonacciByLength(5);

        Assert.assertEquals(result[0], 0);
        Assert.assertEquals(result[1], 1);
    }

    @Test(groups = {"negative"}, expectedExceptions = IllegalArgumentException.class)
    public void shouldThrowExceptionForNegativeLength() {
        fibonacci.getFibonacciByLength(-1);
    }

    @Test(groups = {"negative"}, expectedExceptions = IllegalArgumentException.class)
    public void shouldThrowExceptionForZero() {
        fibonacci.getFibonacciByLength(0);
    }
}
