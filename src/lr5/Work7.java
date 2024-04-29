package lr5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Work7 {

    public static List<String> filterStringsByLength(List<String> strings, int minLength) {
        return strings.stream()
                .filter(s -> s.length() >= minLength)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Папа", "Сын", "Универсал");
        int minLength = 4;
        List<String> filteredStrings = filterStringsByLength(strings, minLength);
        System.out.println(filteredStrings);
    }
}

