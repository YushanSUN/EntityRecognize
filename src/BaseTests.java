import java.io.File;
import java.io.IOException;
import java.util.List;

import junit.framework.TestCase;

public class BaseTests extends TestCase {

	protected static Trie dictionary;
	
	protected static List<Mention> mentions;
	
	static {
		try {
			dictionary = new Trie(new File("entities.txt"));
			mentions = EntityRecognizer.findMentions(new File("text"), dictionary);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
