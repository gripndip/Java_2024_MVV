package lr5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Work10 {

    public static List<Integer> filterNumbersLessThan(List<Integer> numbers, int maxValue) {
        return numbers.stream()
                .filter(n -> n < maxValue)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, -7, -8, -9, 0);
        int maxValue = 5;
        List<Integer> filteredNumbers = filterNumbersLessThan(numbers, maxValue);
        System.out.println(filteredNumbers);
    }
}

