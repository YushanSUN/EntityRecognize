import java.io.IOException;
import java.io.Writer;

/**
 * Reference implementation for the class "Web Search - Information Extraction"
 * at Telecom ParisTech, Paris, France in Spring 2011
 * 
 * @author Fabian M. Suchanek
 * 
 * This class holds a triple of subject, predicate and object
 */

public class Triple {

	/** Subject */
	public String subject;

	/** Predicate */
	public String predicate;

	/** Object */
	public String object;

	/** Hash code */
	protected int hashCode;

	/** Constructs a triple */
	public Triple(String subject, String predicate, String object) {
		super();
		this.subject = subject;
		this.predicate = predicate;
		this.object = object;
		this.hashCode = subject.hashCode() ^ predicate.hashCode()
				^ object.hashCode();
	}

	@Override
	public String toString() {
		return "<" + subject + ", " + predicate + ", " + object + ">";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Triple other = (Triple) obj;
		if (object == null) {
			if (other.object != null)
				return false;
		} else if (!object.equals(other.object))
			return false;
		if (predicate == null) {
			if (other.predicate != null)
				return false;
		} else if (!predicate.equals(other.predicate))
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		return (hashCode);
	}

	/** Writes the triple in TAB separated format to a writer */
	public void writeTo(Writer w) throws IOException {
		w.write(subject);
		w.write("\t");
		w.write(predicate);
		w.write("\t");
		w.write(object);
		w.write("\n");
	}
}
