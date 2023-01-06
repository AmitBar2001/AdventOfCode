import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.stream.Stream;

public class Main {
  public static void main(String[] args) throws FileNotFoundException {
    Stream<String> lines = new BufferedReader(new FileReader("input.txt")).lines();

    long overlappingPairs =
        lines
            .map(line -> line.split(","))
            .filter(pair -> doesContain(pair[0], pair[1]) || doesContain(pair[1], pair[0]))
            .count();
    System.out.println(overlappingPairs);
  }

  public static boolean doesContain(String str, String other) {
    int first = Integer.parseInt(str.substring(0, str.indexOf("-")));
    int second = Integer.parseInt(str.substring(str.indexOf("-") + 1));

    int third = Integer.parseInt(other.substring(0, other.indexOf("-")));
    int fourth = Integer.parseInt(other.substring(other.indexOf("-") + 1));

    return (first >= third && first <= fourth) || (second >= third && second <= fourth);
  }
}
