import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Two {
    public static void main(String[] args) {
        try (Stream<String> lines = Files.lines(Paths.get("input/input.txt"))) {
            System.out.println(
                    lines
                            .map(
                                    line -> {
                                        StringBuilder output = new StringBuilder();
                                        Pattern pattern = Pattern.compile("^(one|two|three|four|five|six|seven|eight|nine)");

                                        for (int i = 0; i < line.length(); i++) {
                                            String matchLine = line.substring(i);
                                            Matcher matcher = pattern.matcher(matchLine);

                                            if (matcher.find()) {
                                                output.append(stringToNumber(matcher.group()));
                                            } else {
                                                output.append(matchLine.charAt(0));
                                            }
                                        }

                                        return output.toString();
                                    }
                            )
                            .map(line -> line.replaceAll("[^0-9]", ""))
                            .map(
                                    line ->
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

    private static int stringToNumber(String number) {
        return switch (number) {
            case "one" -> 1;
            case "two" -> 2;
            case "three" -> 3;
            case "four" -> 4;
            case "five" -> 5;
            case "six" -> 6;
            case "seven" -> 7;
            case "eight" -> 8;
            case "nine" -> 9;
            default -> throw new RuntimeException("Invalid number");
        };
    }
}
