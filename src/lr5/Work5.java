package lr5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Work5 {

    public static List<String> filterStringsBySubstring(List<String> strings, String substring) {
        return strings.stream()
                .filter(s -> s.contains(substring))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("Hello, World!", "Это сообщение.", "Что-то другое.");
        String targetSubstring = "Это";
        List<String> filteredStrings = filterStringsBySubstring(strings, targetSubstring);
        System.out.println(filteredStrings);
    }
}

