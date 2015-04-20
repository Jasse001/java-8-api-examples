package streams;

import java.util.List;
import java.util.stream.Collectors;

public class Map {
  public List<String> processWords(List<String> originalWords) {
    return originalWords.stream().map(word -> word.toLowerCase().trim()).collect(Collectors.toList());
  }
}
