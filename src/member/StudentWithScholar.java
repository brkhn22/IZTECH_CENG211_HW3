package member;

import java.time.LocalDate;

public class StudentWithScholar extends Student {

	public StudentWithScholar(String id, LocalDate startBorrow, LocalDate endBorrow) {
		super(id, DiscountType.STUDENTWITHSCHOLARSHIP, startBorrow, endBorrow);
	}

}
