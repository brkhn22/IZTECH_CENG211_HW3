package member;

public enum DiscountType {
	// enum discount types for members of different types.
	GENERAL(0),
	STUDENTWITHOUTSCHOLARSHIP(0.2d),
	STUDENTWITHSCHOLARSHIP(0.3d);
	
	private final double discount;
	private DiscountType(double discount) {
		this.discount = discount;
	}
	
	public double getDiscount() {
		return this.discount;
	}
}
