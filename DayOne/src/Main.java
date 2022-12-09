import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    System.out.println("Hello world!");

    List<Integer>[] elves = readInput("input.txt");

    //noinspection OptionalGetWithoutIsPresent
    System.out.println(
        Arrays.stream(elves)
            .mapToInt(elf -> elf.stream().reduce(Integer::sum).get())
            .sorted()
            .skip(elves.length - 3)
            .sum());
  }

  public static List<Integer>[] readInput(final String PATH) {
    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(PATH))) {

      String line = bufferedReader.readLine();
      List<List<Integer>> elves = new ArrayList<>();
      List<Integer> elf = new ArrayList<>();

      while (line != null) {
        if (line.isEmpty()) {
          elves.add(elf);
          elf = new ArrayList<>();
        } else {
          elf.add(Integer.valueOf(line));
        }

        line = bufferedReader.readLine();
      }

      return elves.toArray(new List[0]);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
