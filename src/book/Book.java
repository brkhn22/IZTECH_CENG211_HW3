package book;

public class Book extends AnyBook {

	// additional Book information that inherited from AnyBook.
	private static final String TYPE = "Book";
	private static final double CHARGE_PER_DAY = 5;
	private static final int DAY_LENGTH = 10;

	public Book(String itemNumber, String title, BookType bookType, String authorName,
			String publisherName) {
		super(itemNumber, title, bookType, TYPE, authorName, publisherName);
	}
	
	@Override
	public int calculateDayExceed() {
		// returns zero or minus value if the borrowed days has not passed the limit.
		return getMemberBorrowed().getBorrowedDays() - DAY_LENGTH;
	}
	
	@Override
	public double calculateBorrowingCharge() {
		// charge = days * priority * charge_per_day 
		return getMemberBorrowed().getBorrowedDays() * CHARGE_PER_DAY * getBookType().getPriority();
	}
	@Override
	public double calculateLateCharge() {
		if(calculateDayExceed() > 0)
			return 5;
		else
			return 0;
	}
}
