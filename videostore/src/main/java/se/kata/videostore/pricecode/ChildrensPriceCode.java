package se.kata.videostore.pricecode;

class ChildrensPriceCode extends PriceCode {
	public ChildrensPriceCode(int aPriceCode) {
		super(aPriceCode);
	}

	@Override
	public double amount(int daysRented) {
		double thisAmount = 1.5;
		if (daysRented > 3) {
			thisAmount += (daysRented - 3) * 1.5;
		}
		return thisAmount;
	}
}