package streams;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class GenericMethods {
  public List<String> lowercaseAndTrim(List<String> phrases) {
    return phrases.stream().map(phrase -> phrase.toLowerCase().trim()).collect(toList());
  }

  public List<Integer> countNumbersInWords(List<String> phrases) {
    List<Integer> lengths = new ArrayList<>();
    phrases.stream().forEach(phrase -> lengths.add(phrase.length()));
    return lengths;
  }

  public List<String> removeEmptyAndMissing(List<String> phrases) {
    return phrases.stream().filter(phrase -> phrase != null && !phrase.trim().isEmpty()).collect(toList());
  }
}
