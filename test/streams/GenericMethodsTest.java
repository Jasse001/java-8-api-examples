package streams;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

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

  @Test
  public void filter_removeEmptyAndMissing() {
    List<String> phrases = Arrays.asList("phrase", null, "phrase2", "phrase3", "");

    List<String> validPhrases = service.removeEmptyAndMissing(phrases);

    assertEquals(3, validPhrases.size());
    assertEquals("phrase", validPhrases.get(0));
    assertEquals("phrase2", validPhrases.get(1));
    assertEquals("phrase3", validPhrases.get(2));
  }

  @Test
  public void max_highestNumberInList() {
    List<Integer> numbers = Arrays.asList(30, 34, 34, 14);

    Integer highestNumber = service.highestNumber(numbers);

    assertEquals(34, highestNumber.intValue());
  }

  @Test
  public void max_emptyList() {
    List<Integer> numbers = Arrays.asList();

    Integer highestNumber = service.highestNumber(numbers);

    assertNull(highestNumber);
  }

  @Test
  public void min_LowestNumberInList() {
    List<Integer> numbers = Arrays.asList(30, 13, 34, 14);

    Integer lowestNumber = service.lowestNumber(numbers);

    assertEquals(14, lowestNumber.intValue());
  }

  @Test
  public void min_emptyList() {
    List<Integer> numbers = Arrays.asList();

    Integer lowestNumber = service.lowestNumber(numbers);

    assertNull(lowestNumber);
  }

  @Test
  public void toArray_streamOfCharacters() {
    Stream<String> stream = Stream.of("j", "o", "h", "n");

    String[] result = service.createStringArray(stream);

    assertEquals(4, result.length);
    assertEquals("j", result[0]);
    assertEquals("o", result[1]);
    assertEquals("h", result[2]);
    assertEquals("n", result[3]);
  }
}