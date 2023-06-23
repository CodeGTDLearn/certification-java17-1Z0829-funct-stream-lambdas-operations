package map_flatmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FlatMap_Stream_Of {
  public static void main(String[] args) {


    /*╔═════════════════════════════════════════════════════╗
      ║ STREAM.OF ONLY WORKS WITH INDIVIDUAL ITEMS (values) ║
      ╠═════════════════════════════════════════════════════╣
      ║                    NOT WITH LISTS                   ║
      ╚═════════════════════════════════════════════════════╝*/
    String l11 = "a";
    String l22 = "a";

    Stream.of(l11, l22)
          .flatMap((StringItem) -> Stream.of(StringItem))
          .forEach((x) -> System.out.println(x));

    Stream.of(l11, l22)
          .flatMap((StringItem) -> Stream.of(StringItem))
          .forEach((x) -> System.out.println(x));

    /*╔════════════════════════════╗
      ║ .stream() WORKS WITH LISTS ║
      ╚════════════════════════════╝*/
    List<String> l1 = Arrays.asList("b", "b");
    List<String> l2 = Arrays.asList("1", "1");
    Stream.of(l1, l2)
          .flatMap((x) -> x.stream())
          .forEach((x) -> System.out.println(x));

    ArrayList<String> l111 = new ArrayList<>();
    ArrayList<String> l222 = new ArrayList<>();

    l111.addAll(List.of("c", "c"));
    l222.addAll(List.of("d", "d"));

    Stream.of(l111, l222)
          .flatMap((listItem) -> listItem.stream())
          .forEach((x) -> System.out.println(x));
  }
}