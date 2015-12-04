import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class implements a entity recognizer based on dictionary of 
 * entities.
 */
public class EntityRecognizer {

	/**
	 * Given as arguments (1) the Wikipedia corpus and (2) a dictionary of entities, 
	 * it returns a list with ALL the mentions of entities in the dictionary occurring in the text of the articles. 
	 * For instance if the article about Barack Obama mentions Michelle Obama, assuming she is in the dictionary,
	 * the function generates a mention <Michelle Obama, Barack Obama>.
	 * @throws IOException 
	 */	
	public static List<Mention> findMentions(File wikipediaCorpus, Trie dictionary) throws IOException {
		
		@SuppressWarnings("resource")
		Parser parser = new Parser(wikipediaCorpus);
		List<Mention> allMentions = new ArrayList<Mention>();
		
		while(parser.hasNext()){
			
			Page page = parser.next();
			
			int start = 0;
			String title = page.title;
			String content = page.content;
			
			while(start < content.length()){
				
				int length = dictionary.containedLength(content, start);
				
				if(length != -1){
					Mention mention = new Mention(title, content.substring(start, start+length));
					allMentions.add(mention);
					start = start + length;
				}
				else start++;
			}
		}
		
		return allMentions;
		//return null;
	}


	public static void main(String args[]) throws IOException {
		Trie dictionary = new Trie(new File(args[1]));
		for (Mention mention : findMentions(new File(args[0]), dictionary)) {
			System.out.println(mention);
		}		
	}
}
