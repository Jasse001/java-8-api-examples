package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GenericMethods {
  public List<String> lowercaseAndTrim(List<String> phrases) {
    return phrases.stream().map(phrase -> phrase.toLowerCase().trim()).collect(Collectors.toList());
  }

  public List<Integer> countNumbersInWords(List<String> phrases) {
    List<Integer> lengths = new ArrayList<>();
    phrases.stream().forEach(phrase -> lengths.add(phrase.length()));
    return lengths;
  }
}
