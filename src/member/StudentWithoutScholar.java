package member;

import java.time.LocalDate;

public class StudentWithoutScholar extends Student {

	public StudentWithoutScholar(String id, LocalDate startBorrow, LocalDate endBorrow) {
		super(id, DiscountType.STUDENTWITHOUTSCHOLARSHIP, startBorrow, endBorrow);
	}

}
