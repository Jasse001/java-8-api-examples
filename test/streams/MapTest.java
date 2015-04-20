package streams;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MapTest {

  private Map service;

  @Before
  public void before() {
    service = new Map();
  }

  @Test
  public void streams_map_processList() {
    List<String> words = Arrays.asList(" Some Word ", " JohN DOe", "jAne ");

    List<String> processedWords = service.processWords(words);

    assertEquals(3, processedWords.size());
    assertEquals("some word", processedWords.get(0));
    assertEquals("john doe", processedWords.get(1));
    assertEquals("jane", processedWords.get(2));
  }
}