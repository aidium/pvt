package se.kata.videostore.pricecode;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import se.kata.videostore.Movie;

public class RegularPriceCodeTest {
	private RegularPriceCode priceCode = new RegularPriceCode(Movie.REGULAR);

	@Test
	public void shouldhandleAmountCorrecty() throws Exception {
		assertThat(priceCode.amount(1), is(2.0));
		assertThat(priceCode.amount(2), is(2.0));
		assertThat(priceCode.amount(3), is(3.5));
		assertThat(priceCode.amount(4), is(5.0));
		assertThat(priceCode.amount(5), is(6.5));
	}

	@Test
	public void shouldHandleFrequentRenterPointsCorrectly() throws Exception {
		assertThat(priceCode.frequentRenterPoints(1), is(1));
		assertThat(priceCode.frequentRenterPoints(5), is(1));
	}
}
