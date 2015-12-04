import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * It defines the methods that define a Trie data structure.
 * @author Luis Galárraga.
 *
 */
public class Trie {
	
	//private Vertex root;
	private  Vertex root = new Vertex((char) 0, false);
 
    protected class Vertex{
        public char letter;
        public boolean end;
        public Map<Character, Vertex> edges = new HashMap<Character,Vertex>();
        Vertex(char letter, boolean end) {
        	this.letter = letter;
			this.end = end;
        }
    }
    
   
    /** *//**
     * List all words in the Trie.
     * 
     * @return
     */

    /*public List< String> listAllWords() {
       
        List< String> words = new ArrayList< String>();
        Vertex[] edges = root.edges;
       
        for (int i = 0; i < edges.length; i++) {
            if (edges[i] != null) {
                     String word = "" + (char)('a' + i);
                depthFirstSearchWords(words, edges[i], word);
            }
        }        
        return words;
    }*/

     /** *//**
     * Depth First Search words in the Trie and add them to the List.
     * 
     * @param words
     * @param vertex
     * @param wordSegment
     */

   /* private void depthFirstSearchWords(List words, Vertex vertex, String wordSegment) {
        Vertex[] edges = vertex.edges;
        boolean hasChildren = false;
        for (int i = 0; i < edges.length; i++) {
            if (edges[i] != null) {
                hasChildren = true;
                String newWord = wordSegment + (char)('a' + i);                
                depthFirstSearchWords(words, edges[i], newWord);
            }            
        }
        if (!hasChildren) {
            words.add(wordSegment);
        }
    }*/


    
    /**
	 * Adds a string to the trie.
	 * @param word
	 * @return true if the trie changed as a result of this operation, that is if
	 * the new string was not in the dictionary.
	 */

    public boolean add(String word) {
        if(!contains(word)){
        	Vertex ver;
        	
        	char first = word.charAt(0);
        	if(root.edges.containsKey(first)){
        		ver = root.edges.get(first);
        	}
        	else{
        		Vertex node = new Vertex(first,false);
        		root.edges.put(first, node);
        		ver = node;
        	}
        	
        	for(int i = 1; i<word.length(); i++){
        		char cha = word.charAt(i);
        		if(ver.edges.containsKey(cha)){
        			ver = ver.edges.get(cha);
        		}
        		else{
        			Vertex node = new Vertex(cha,false);
        			ver.edges.put(cha, node);
        			ver = node;
        		}
        	}
        	ver.end = true;
        	return true;
        }
        else return false;
    	
    }

    
	
	/**
	 * Checks whether a string exists in the trie.
	 * @param str
	 * @return true if the string is in the trie, false otherwise. 
	 */
	public boolean contains(String str) {
		if(str == null || str.equals(""))
			return false;
		
		char first = str.charAt(0);
		if(root.edges.containsKey(first)){
			Vertex current = root.edges.get(first);
			for(int i = 1; i < str.length(); i++){
				char character = str.charAt(i);
				if(current.edges.containsKey(character)){
					current = current.edges.get(character);
				}
				else
					return false;
			}
			return current.end;
		}
		else
			return false;
	}
	
	/**
	 * Given an input text and a start position, it returns the length of the longest word in the trie 
	 * occurring from <var>startPos</var> in the input text. 
	 * For example, if the trie contains words "York" and "New York", containedLength("I live in New York!", 10)
	 * returns 8, that is, the length of the word "New York" because this is the longest word registered in the trie 
	 * starting at position 10 in the input text.
	 * @param s
	 * @param startPos
	 * @return int
	 */
	public int containedLength(String s, int startPos) {
		if(s == null || s.equals(""))
			return -1;
		
		Vertex current;
		
		char first = s.charAt(startPos);
		if(root.edges.containsKey(first)){
			current = root.edges.get(first);
			int k = -1;
			
			for(int i = 1; i < s.length()-startPos; i++){
				if(current.end)
					return k = i;
				else{
					char character = s.charAt(i+startPos);
					if(current.edges.containsKey(character)){
						current = current.edges.get(character);
					}
					else
						break;
				}
			}
			return k;
		}
		else
			return -1;

	}
	
	/** Constructs a Trie from the lines of a file*/
	public Trie(File file) throws IOException {
		try(BufferedReader in=new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF8"))) {
			String line;
			while((line=in.readLine())!=null) {
				add(line);
			}
		}
	}
	
	/** Constructs an empty Trie*/
	public Trie() {
		 //this.root = new Vertex((char) 0, false);
	}

	/** Constructs a Trie from a collection*/
	public Trie(Iterable<String> collection) {
		for(String s : collection) add(s);
	}
	
	/** Use this to test your implementation. Provide the file with list of Wikipedia titles as argument to this program.*/ 
	public static void main(String[] args) throws IOException {		
		Trie trie = new Trie(new File(args[0]));
		
		for(String test : Arrays.asList("Brooklyn","Dudweiler","Elvis Presley","Juan Pihuave")) {
			System.out.println(test + " is in trie: " + trie.contains(test));
		}

	}
}
