package member;

import java.time.LocalDate;

public abstract class Member {
	
	// Member that borrows AnyBook.
	private DiscountType discountType;
	private LocalDate startBorrow;
	private LocalDate endBorrow;
	private String id; // Unique id for each member of the library.
	
	public Member(String id, DiscountType discountType, LocalDate startBorrow, LocalDate endBorrow) {
		this.id = id;
		this.discountType = discountType;
		this.startBorrow = LocalDate.of(startBorrow.getYear(), startBorrow.getMonth(), startBorrow.getDayOfMonth());
		this.endBorrow = LocalDate.of(endBorrow.getYear(), endBorrow.getMonth(), endBorrow.getDayOfMonth());
	}
	
	public double getDiscount() {
		return discountType.getDiscount();
	}
	
	public int getBorrowedDays() {
		// compareTo calculates the difference between endBorrow and startBorrow.
		// add +1 for counting the initial day.
		return endBorrow.compareTo(startBorrow) + 1;
	}
	
	public String getId() {
		return this.id;
	}

	@Override
	public boolean equals(Object other) {
		// checks whether this Member equals to the other. 
		if(other != null) {
			if(other instanceof Member) {
				Member otherMember = (Member) other;
				return this.id.equals(otherMember.getId());
			}
		}
		return false;
	}
}
