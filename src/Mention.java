/**
 * It represents the mention of an entity within a wikipedia 
 * article.
 */
public class Mention {
	
	public String mention;
	
	public String article;
	
	public Mention(String article, String mention) {
		this.mention = mention;
		this.article = article;
	}

	@Override
	public String toString() {
		return article + "\t" + mention;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((article == null) ? 0 : article.hashCode());
		result = prime * result + ((mention == null) ? 0 : mention.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mention other = (Mention) obj;
		if (article == null) {
			if (other.article != null)
				return false;
		} else if (!article.equals(other.article))
			return false;
		if (mention == null) {
			if (other.mention != null)
				return false;
		} else if (!mention.equals(other.mention))
			return false;
		return true;
	}
}
