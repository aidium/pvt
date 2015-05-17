package se.kata.videostore;

import se.kata.videostore.pricecode.PriceCode;
import se.kata.videostore.pricecode.PriceCodeFactory;

public class Movie {
	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;

	private final String _title;
	private PriceCode _priceCode;

	public Movie(String title, int priceCode) {
		_title = title;
		setPriceCode(priceCode);
	}

	public int getPriceCode() {
		return _priceCode.priceCode();
	}

	public void setPriceCode(int priceCode) {
		_priceCode = PriceCodeFactory.createPriceCode(priceCode);
	}

	public String getTitle() {
		return _title;
	}

	double amount(int daysRented) {
		return _priceCode.amount(daysRented);
	}

	int frequentRenterPoints(int daysRented) {
		return _priceCode.frequentRenterPoints(daysRented);
	}
}