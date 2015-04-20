package streams;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class GenericMethodsTest {

  private GenericMethods service;

  @Before
  public void before() {
    service = new GenericMethods();
  }

  @Test
  public void map_lowercaseAndTrimList() {
    List<String> phrases = asList(" Some Word ", " JohN DOe", "jAne ");

    List<String> processedPhrases = service.lowercaseAndTrim(phrases);

    assertEquals(3, processedPhrases.size());
    assertEquals("some word", processedPhrases.get(0));
    assertEquals("john doe", processedPhrases.get(1));
    assertEquals("jane", processedPhrases.get(2));
  }

  @Test
  public void forEach_countsPhrasesLengths() {
    List<String> words = asList("w1", "w12", "w123");

    List<Integer> lengths = service.countNumbersInWords(words);

    assertEquals(3, lengths.size());
    assertEquals(2, lengths.get(0).intValue());
    assertEquals(3, lengths.get(1).intValue());
    assertEquals(4, lengths.get(2).intValue());
  }

  @Test
  public void filter_removeEmptyAndMissing() {
    List<String> phrases = asList("phrase", null, "phrase2", "phrase3", "");

    List<String> validPhrases = service.removeEmptyAndMissing(phrases);

    assertEquals(3, validPhrases.size());
    assertEquals("phrase", validPhrases.get(0));
    assertEquals("phrase2", validPhrases.get(1));
    assertEquals("phrase3", validPhrases.get(2));
  }

  @Test
  public void max_highestNumberInList() {
    List<Integer> numbers = asList(30, 34, 34, 14);

    Integer highestNumber = service.highestNumber(numbers);

    assertEquals(34, highestNumber.intValue());
  }

  @Test
  public void max_emptyList() {
    List<Integer> numbers = asList();

    Integer highestNumber = service.highestNumber(numbers);

    assertNull(highestNumber);
  }

  @Test
  public void min_LowestNumberInList() {
    List<Integer> numbers = asList(30, 13, 34, 14);

    Integer lowestNumber = service.lowestNumber(numbers);

    assertEquals(14, lowestNumber.intValue());
  }

  @Test
  public void min_emptyList() {
    List<Integer> numbers = asList();

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
  
  @Test
  public void reduce_calculatesTotalAge() {
    List<Integer> ages = asList(10, 5, 3);

    Integer totalAge = service.totalAge(ages);

    assertEquals(18, totalAge.intValue());
  }

  @Test
  public void anyMatch_matchExists() {
    List<String> candidates = asList("john", "mary", "paul", "linda");

    boolean exists = service.personExists("john", candidates);

    assertTrue(exists);
  }

  @Test
  public void anyMatch_noMatch() {
    List<String> candidates = asList("john", "mary", "paul", "linda");

    boolean exists = service.personExists("jack", candidates);

    assertFalse(exists);
  }
}