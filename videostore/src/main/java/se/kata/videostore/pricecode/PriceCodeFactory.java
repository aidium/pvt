package se.kata.videostore.pricecode;

import se.kata.videostore.Movie;

public class PriceCodeFactory {
	public static PriceCode createPriceCode(int priceCode) {
		switch (priceCode) {
			case Movie.NEW_RELEASE:
				return new NewReleasePriceCode(priceCode);
			case Movie.REGULAR:
				return new RegularPriceCode(priceCode);
			case Movie.CHILDRENS:
				return new ChildrensPriceCode(priceCode);
			default:
				throw new IllegalArgumentException("Unkown price code");
		}
	}
}
