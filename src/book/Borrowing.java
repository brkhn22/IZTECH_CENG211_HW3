package book;

public interface Borrowing<T> {
	// Borrowing interface to borrow the books to customers.
	public boolean borrow(T customer);
	public boolean isBorrowed();
	
}
