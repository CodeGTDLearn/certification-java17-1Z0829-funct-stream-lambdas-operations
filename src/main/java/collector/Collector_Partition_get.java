package collector;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.chrono.IsoChronology;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Getter
@Setter
public class Collector_Partition_get {
  private String title;
  private LocalDate releaseDate;

  public Collector_Partition_get(String title, LocalDate releaseDate) {

    this.title = title;
    this.releaseDate = releaseDate;
  }
}

class MyClass {
  ArrayList<Collector_Partition_get> collectPartit =
       new ArrayList<>(List.of(
            new Collector_Partition_get("The Outsider", LocalDate.of(2019, 1, 1)),
            new Collector_Partition_get("Becoming", LocalDate.of(2018, 1, 1)),
            new Collector_Partition_get("Uri", LocalDate.of(2017, 1, 1))
       ));

  Predicate<Collector_Partition_get> p =
       b -> b.getReleaseDate()
             .isAfter(IsoChronology.INSTANCE.date(2018, 1, 1));

  Set<String> books =
       collectPartit
            .stream()
            .collect(Collectors.partitioningBy(p))
            .get(true) // This a simple Collection.get() method taking the 'map key'
            .stream()
            .map(Collector_Partition_get::getTitle)
            .collect(
                 Collectors.toCollection(TreeSet::new));
}