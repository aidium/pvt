package se.kata.videostore.pricecode;

public abstract class PriceCode {

	private final int priceCode;

	public PriceCode(int priceCode) {
		this.priceCode = priceCode;
	}

	public int priceCode() {
		return priceCode;
	}

	public abstract double amount(int daysRented);

	public int frequentRenterPoints(int daysRented) {
		return 1;
	}

}