package library;

import java.util.ArrayList;

import book.AnyBook;
import member.Member;

public class Library {
	
	// ArrayLists to keep items and members.
	private ArrayList<AnyBook> anyBookArrayList;
	private ArrayList<Member> memberArrayList;
	
	public Library() {
		anyBookArrayList = new ArrayList<>();
		memberArrayList = new ArrayList<>();
	}
	
	public void initializeLibrary() {
		// read the file, get data to array lists, borrow the books.
		new FileIO().readItems(anyBookArrayList, memberArrayList);
		borrowAllBooks();
	}
	
	private void borrowAllBooks() {
		for(int i = 0; i < memberArrayList.size(); i++)
			if(!anyBookArrayList.get(i).isBorrowed())
				anyBookArrayList.get(i).borrow(memberArrayList.get(i));
		
	}
	
	public void printAllBooks() {
		for(AnyBook book: anyBookArrayList) {
			print(book);
		}
	}
	
	public void print(AnyBook book) {
		// print method that gives information about a borrowed book.
		if(book == null)
			throw new NullPointerException();
		
		int dayExceed = book.calculateDayExceed();
		String exceed = "Not Exceeds";
		if(dayExceed > 0)
			exceed = "Exceeds";
		
		System.out.printf("Item Number: %s Title: %s Item Type: %s"
				+ " Borrowing Days: %s days Exceed: %s Total Price: %.2f$\n",
				book.getItemNumber(), book.getTitle(), book.getItemType(), 
				book.getMemberBorrowed().getBorrowedDays(), exceed,
				book.calculateTotalCharge());
	}
	
	public AnyBook searchBook(String title) {
		// method that finds the first book that has the title.
		AnyBook book;
		for(AnyBook tempBook: anyBookArrayList) {
			if(tempBook.search(title)) {
				book = tempBook;
				return book;
			}
		}
		return null;
	}

	public AnyBook searchBook(String title, String itemType) {
		// method that finds the first book that has the title in given itemType.
		AnyBook book;
		for(AnyBook tempBook: anyBookArrayList) {
			if(tempBook.search(title, itemType)) {
				book = tempBook;
				return book;
			}
		}
		return null;
	}
}
