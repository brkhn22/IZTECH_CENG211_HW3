package member;

import java.time.LocalDate;

public class General extends Member {

	// General member without any discount.
	public General(String id, LocalDate startBorrow, LocalDate endBorrow) {
		super(id, DiscountType.GENERAL, startBorrow, endBorrow);
	}

	
}
