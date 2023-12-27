package book;

public enum BookType {
	// enum book types for different priorities.
	NOTEWORTHY(1),
	HIGHLYSIGNIFICANT(2),
	INVALUEABLE(3);
	
	private final int priority;
	
	private BookType(int priority){
		this.priority = priority;
	}
	
	
	public int getPriority() {
		return this.priority;
	}
	
}
