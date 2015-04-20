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
  public void lowercaseAndTrimList() {
    List<String> words = Arrays.asList(" Some Word ", " JohN DOe", "jAne ");

    List<String> processedWords = service.processWords(words);

    assertEquals(3, processedWords.size());
    assertEquals("some word", processedWords.get(0));
    assertEquals("john doe", processedWords.get(1));
    assertEquals("jane", processedWords.get(2));
  }
}