package lr5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Work8 {

    public static List<Integer> filterNumbersGreaterThan(List<Integer> numbers, int minValue) {
        return numbers.stream()
                .filter(n -> n > minValue)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, -7, -8, -9, 0);
        int minValue = 2;
        List<Integer> filteredNumbers = filterNumbersGreaterThan(numbers, minValue);
        System.out.println(filteredNumbers);
    }
}

