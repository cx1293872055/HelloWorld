package kotlinFisrt;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author chenxin
 * @date 2023/11/24 星期五 10:52
 */
public class JavaClass {

    public int getZero() {
        return 0;
    }

    public List<String> convertToUpper(List<String> names) {
        return names.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }

    public void suspend() {
        System.out.println("suspending ...");
    }

    public String when() {
        return "Now!";
    }
}
