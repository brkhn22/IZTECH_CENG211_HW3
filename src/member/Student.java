package member;

import java.time.LocalDate;

public class Student extends Member {
	
	// student member with some discount.
	public Student(String id, DiscountType discountType, LocalDate startBorrow, LocalDate endBorrow) {
		super(id, discountType,startBorrow, endBorrow);
	}
	
}
