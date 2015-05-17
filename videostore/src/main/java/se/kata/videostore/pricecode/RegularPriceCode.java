package se.kata.videostore.pricecode;

class RegularPriceCode extends PriceCode {
	public RegularPriceCode(int aPriceCode) {
		super(aPriceCode);
	}

	@Override
	public double amount(int daysRented) {
		double thisAmount = 2;
		if (daysRented > 2) {
			thisAmount += (daysRented - 2) * 1.5;
		}
		return thisAmount;
	}
}