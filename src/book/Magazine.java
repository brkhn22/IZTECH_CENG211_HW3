package book;

public class Magazine extends AnyBook {

	// additional Magazine information that inherited from AnyBook.
	private static final String TYPE = "Magazine";
	private static final double CHARGE_PER_DAY = 10;
	private static final int DAY_LENGTH = 7;
	
	public Magazine(String itemNumber, String title, BookType bookType, String authorName,
			String publisherName) {
		super(itemNumber, title, bookType, TYPE, authorName, publisherName);
	}
	
	@Override
	public int calculateDayExceed() {
		// return zero or minus value if the borrowed day has not been passed the limit.
		return getMemberBorrowed().getBorrowedDays() - DAY_LENGTH;
	}

	@Override
	public double calculateBorrowingCharge() {
		// charge = days * priority * charge_per_day 
		return getMemberBorrowed().getBorrowedDays() * CHARGE_PER_DAY * getBookType().getPriority();

	}
	
	@Override
	public double calculateLateCharge() {
		int days = getMemberBorrowed().getBorrowedDays();
		if(days > DAY_LENGTH)
			return 2;
		else
			return 0;
	}

}
