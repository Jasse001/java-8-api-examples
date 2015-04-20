package streams;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GenericMethodsTest {

  private GenericMethods service;

  @Before
  public void before() {
    service = new GenericMethods();
  }

  @Test
  public void map_lowercaseAndTrimList() {
    List<String> phrases = Arrays.asList(" Some Word ", " JohN DOe", "jAne ");

    List<String> processedPhrases = service.lowercaseAndTrim(phrases);

    assertEquals(3, processedPhrases.size());
    assertEquals("some word", processedPhrases.get(0));
    assertEquals("john doe", processedPhrases.get(1));
    assertEquals("jane", processedPhrases.get(2));
  }

  @Test
  public void forEach_countsPhrasesLengths() {
    List<String> words = Arrays.asList("w1", "w12", "w123");

    List<Integer> lengths = service.countNumbersInWords(words);

    assertEquals(3, lengths.size());
    assertEquals(2, lengths.get(0).intValue());
    assertEquals(3, lengths.get(1).intValue());
    assertEquals(4, lengths.get(2).intValue());
  }
}