package se.kata.videostore.pricecode;

class NewReleasePriceCode extends PriceCode {
	public NewReleasePriceCode(int aPriceCode) {
		super(aPriceCode);
	}

	@Override
	public double amount(int daysRented) {
		return daysRented * 3;
	}

	@Override
	public int frequentRenterPoints(int daysRented) {
		return daysRented > 1 ? 2 : 1;
	}
}