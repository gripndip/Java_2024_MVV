package lr5;

import java.util.Arrays;

public class Work2 {

    public static int[] findCommonElements(int[] array1, int[] array2) {
        return Arrays.stream(array1)
                .filter(n -> Arrays.stream(array2)
                        .anyMatch(m -> m == n))
                .distinct()
                .toArray();
    }

    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {3, 4, 5, 6, 7};
        int[] commonElements = findCommonElements(array1, array2);
        System.out.println(Arrays.toString(commonElements));
    }
}

