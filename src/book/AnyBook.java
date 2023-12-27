package book;
import member.Member;

public abstract class AnyBook implements Borrowing<Member>, Searchable {
	
	// book/magazine data.
	private String itemNumber;
	private String title;
	private String authorName;
	private String itemType;
	private String publisherName;
	private Member memberBorrowed;
	private BookType bookType;
	
	public AnyBook(String itemNumber, String title, BookType bookType, String itemType, String authorName,  String publisherName) {
		this(itemNumber, title, bookType, itemType, authorName, publisherName, null);

	}
	
	public AnyBook(String itemNumber, String title, BookType bookType, String itemType, String authorName,  String publisherName, Member memberBorrowed) {
		this.itemNumber = itemNumber;
		this.title = title;
		this.bookType = bookType;
		this.itemType = itemType;
		this.authorName = authorName;
		this.publisherName = publisherName;
		this.memberBorrowed = memberBorrowed;

	}
	
	public String getItemNumber() {
		return itemNumber;
	}
	public String getTitle() {
		return title;
	}
	public BookType getBookType() {
		return this.bookType;
	}
	public String getAuthorName() {
		return authorName;
	}
	public String getItemType() {
		return itemType;
	}
	public String getPublisherName() {
		return publisherName;
	}
	public Member getMemberBorrowed() {
		return this.memberBorrowed;
	}
	
	public boolean borrow(Member member) {
		this.memberBorrowed = member;
		return isBorrowed();
	}
	
	public boolean isBorrowed() {
		return memberBorrowed != null;
	}
	
	public boolean search(String title) {
		return this.title.toLowerCase().equals(title.toLowerCase());
	}
	
	public boolean search(String title, String itemType) {
		return search(title) && this.itemType.toLowerCase().equals(itemType.toLowerCase());
	}
	// abstract methods that are passed to child classes to implement.
	public abstract int calculateDayExceed();
	public abstract double calculateBorrowingCharge();
	public abstract double calculateLateCharge();
	
	public double calculateDiscount() {
		// discount = borrowing charge * discount percentage.
		return calculateBorrowingCharge()*memberBorrowed.getDiscount();
	}
	public double calculateTotalCharge() {
		// total charge = (borrowing charge - discount) + late charge
		return (calculateBorrowingCharge() - calculateDiscount()) + calculateLateCharge();
	}
	
}
