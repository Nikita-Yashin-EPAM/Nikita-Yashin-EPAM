import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author  Nikita Yashin
 * @version 1.0
 */


public abstract class Lesson1 {
    public static <T> T[] swap(T[] arr, int i, int j) throws IndexOutOfBoundsException {
        if (arr.length >= 2 && arr[i] != null && arr[j] != null) {
            T temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            return arr;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }
    public static <T> ArrayList transformToArrayList(T[] arr){
        return new ArrayList<T>(Arrays.asList(arr));
    }

}
