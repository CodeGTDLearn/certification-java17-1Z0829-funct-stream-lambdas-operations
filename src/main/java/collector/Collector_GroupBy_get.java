package collector;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Collector_GroupBy_get {

  public static void main(String[] args) {

    IntStream is1 = IntStream.range(1, 3);
    IntStream is2 = IntStream.rangeClosed(1, 3);
    IntStream is3 = IntStream.concat(is1, is2);


    //    final Map<Integer, List<Integer>> val =
    List<Integer> val =
         is3
              .boxed()
              .collect(Collectors.groupingBy(k -> k))
              .get(2); // Here, is taking the "KEY" from Map<Integer, List<Integer>>
    System.out.println(val);
  }
}