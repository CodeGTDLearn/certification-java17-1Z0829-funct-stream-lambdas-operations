import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class MyProduct {
  private String id;
  private String category;

  public MyProduct(String id, String category) {

    this.id = id;
    this.category = category;
  }

  public String toString() {

    return id + " " + category;
  }


  public static void main(String[] args) {

    List<MyProduct> s1 = Arrays.asList(
         new MyProduct("OCAJP", "Java"),
         new MyProduct("OCPJP", "Java"),
         new MyProduct("C#", "C#"),
         new MyProduct("OCEJPA", "Java")
    );

    s1.stream()
      .collect(Collectors.groupingBy(c -> c.getCategory()))
      .forEach((key_String_of_the_category, value_is_a_List_of_Objects) -> {
        
        System.out.println(key_String_of_the_category);
        System.out.println(value_is_a_List_of_Objects);
        System.out.println(value_is_a_List_of_Objects.get(0).id+" selecionado");
      });
  }

}