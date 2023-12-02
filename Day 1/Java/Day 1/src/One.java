import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class One {
    public static void main(String[] args) {
        try (Stream<String> lines = Files.lines(Paths.get("input/input.txt"))) {
            System.out.println(
                    (Integer) lines
                            .map(line -> line.replaceAll("[^0-9]", ""))
                            .map(line ->
                                    {
                                        int length = line.length();
                                        char first = line.charAt(0);
                                        char last = line.charAt(length - 1);

                                        return String.format("%c%c", first, last);
                                    }
                            )
                            .mapToInt(Integer::parseInt)
                            .sum()
            );

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}