package lr5;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Work9 {

    private static final Pattern ONLY_LETTERS_PATTERN = Pattern.compile("[a-zA-Z]+");

    public static List<String> filterStringsWithOnlyLetters(List<String> strings) {
        return strings.stream()
                .filter(s -> ONLY_LETTERS_PATTERN.matcher(s).matches())
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("work", "se se.", "12345", "@#$%^&*");
        List<String> filteredStrings = filterStringsWithOnlyLetters(strings);
        System.out.println(filteredStrings);
    }
}

