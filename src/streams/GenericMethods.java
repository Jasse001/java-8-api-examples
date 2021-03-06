package streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class GenericMethods {
  public List<String> lowercaseAndTrim(List<String> phrases) {
    return phrases.stream().map(phrase -> phrase.toLowerCase().trim()).collect(toList());
  }

  public List<Integer> countNumbersIn(List<String> phrases) {
    List<Integer> lengths = new ArrayList<>();
    phrases.stream().forEach(phrase -> lengths.add(phrase.length()));
    return lengths;
  }

  public List<String> removeEmptyAndMissing(List<String> phrases) {
    return phrases.stream().filter(phrase -> phrase != null && !phrase.trim().isEmpty()).collect(toList());
  }

  public Integer highestNumber(List<Integer> numbers) {
    return numbers.stream().max(Integer::compare).orElse(null);
  }

  public Integer lowestNumber(List<Integer> numbers) {
    return numbers.stream().min(Integer::min).orElse(null);
  }

  public String[] createStringArray(Stream<String> stream) {
    return stream.toArray(String[]::new);
  }

  public Integer totalAge(List<Integer> ages) {
    return ages.stream().reduce(0, (a, b) -> a + b);
  }

  public boolean personExists(String name, List<String> candidates) {
    return candidates.stream().anyMatch(name::equals);
  }

  public boolean allNamesStartWith(String phrase, List<String> candidates) {
    return candidates.stream().allMatch(candidate -> candidate.startsWith(phrase));
  }

  public boolean personNameNotInList(String name, List<String> candidates) {
    return candidates.stream().noneMatch(name::equals);
  }

  public Long countNamesIn(List<String> names) {
    return names.stream().count();
  }
}
