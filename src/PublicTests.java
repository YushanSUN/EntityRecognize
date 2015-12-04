import java.io.IOException;

import org.junit.Test;

public class PublicTests extends BaseTests {
	
	public PublicTests() throws IOException {
		super();
	}

	@Test
	public void testTrieContains() {
		assertTrue(dictionary.contains("Brooklyn"));
	}
	
	@Test
	public void testTrieDoesNotContain() {
		assertFalse(dictionary.contains("Dudweiler"));
	}
	
	@Test
	public void testTrieDoesNotContainEmpty() {
		assertFalse(dictionary.contains(""));
	}
	
	@Test
	public void testContainedLength() {
		assertEquals(dictionary.containedLength("I live in New York and I like it", 10), 8);
	}
	
	@Test
	public void testDoesNotContainedLength1() {
		assertEquals(dictionary.containedLength("Paris is beautiful", 9), -1);
	}
	
	@Test
	public void testDoesNotContainedLength2() {
		assertEquals(dictionary.containedLength("I live in dudweiler and I hate it", 2), -1);
	}
	
	@Test
	public void testNamedEntityRecognition1() {
		assertTrue(mentions.contains(new Mention("Alan Turing", "England")));
	}
	
	@Test
	public void testNamedEntityRecognition2() {
		assertFalse(mentions.contains(new Mention("Alan Turing", "France")));
	}
	
	@Test
	public void testNamedEntityRecognition3() {
		assertTrue(mentions.contains(new Mention("Ad hominem", "Ad hominem")));
	}

	@Test
	public void testNamedEntityRecognition4() {
		assertFalse(mentions.contains(new Mention("New York", "York")));
	}
}
