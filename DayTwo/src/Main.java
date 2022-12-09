import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) throws FileNotFoundException {
    System.out.println(secondStage());
  }

  public static int firstStage() throws FileNotFoundException {
    Map<String, Integer> game =
            Map.ofEntries(
                    new AbstractMap.SimpleEntry<>("A X", 4),
                    new AbstractMap.SimpleEntry<>("A Y", 8),
                    new AbstractMap.SimpleEntry<>("A Z", 3),
                    new AbstractMap.SimpleEntry<>("B X", 1),
                    new AbstractMap.SimpleEntry<>("B Y", 5),
                    new AbstractMap.SimpleEntry<>("B Z", 9),
                    new AbstractMap.SimpleEntry<>("C X", 7),
                    new AbstractMap.SimpleEntry<>("C Y", 2),
                    new AbstractMap.SimpleEntry<>("C Z", 6));

    Stream<String> lines = new BufferedReader(new FileReader("input.txt")).lines();

    return lines.mapToInt(game::get).sum();
  }

  public static int secondStage() throws FileNotFoundException {
    Map<String, Integer> game =
            Map.ofEntries(
                    new AbstractMap.SimpleEntry<>("A X", 3),
                    new AbstractMap.SimpleEntry<>("A Y", 4),
                    new AbstractMap.SimpleEntry<>("A Z", 8),
                    new AbstractMap.SimpleEntry<>("B X", 1),
                    new AbstractMap.SimpleEntry<>("B Y", 5),
                    new AbstractMap.SimpleEntry<>("B Z", 9),
                    new AbstractMap.SimpleEntry<>("C X", 2),
                    new AbstractMap.SimpleEntry<>("C Y", 6),
                    new AbstractMap.SimpleEntry<>("C Z", 7));

    Stream<String> lines = new BufferedReader(new FileReader("input.txt")).lines();

    return lines.mapToInt(game::get).sum();
  }
}
