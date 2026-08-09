import java.util.ArrayList;
import java.util.List;

public class TestHelper {

    public static List<Long> convertArrayToList(long[] array) {
        List<Long> result = new ArrayList<>();

        for (long number : array) {
            result.add(number);
        }

        return result;
    }
}
