package lr5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Work3 {

    public static List<String> filterCapitalizedStrings(List<String> strings) {
        return strings.stream()
                .filter(s -> Character.isUpperCase(s.charAt(0)))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Abcde", "heLLo", "worlD", "42");
        List<String> capitalizedStrings = filterCapitalizedStrings(strings);
        System.out.println(capitalizedStrings);
    }
}
