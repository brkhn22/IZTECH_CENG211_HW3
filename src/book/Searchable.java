package book;

public interface Searchable {
	// searchable interface that checks whether given title or title/type is this object.
	public boolean search(String title);
	
	public boolean search(String title, String type);
}
