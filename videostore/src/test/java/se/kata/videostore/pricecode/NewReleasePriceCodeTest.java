package se.kata.videostore.pricecode;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import se.kata.videostore.Movie;

public class NewReleasePriceCodeTest {
	private NewReleasePriceCode priceCode = new NewReleasePriceCode(Movie.NEW_RELEASE);

	@Test
	public void shouldhandleAmountCorrecty() throws Exception {
		assertThat(priceCode.amount(1), is(3.0));
		assertThat(priceCode.amount(5), is(15.0));
	}

	@Test
	public void shouldHandleFrequentRenterPointsCorrectly() throws Exception {
		assertThat(priceCode.frequentRenterPoints(1), is(1));
		assertThat(priceCode.frequentRenterPoints(2), is(2));
		assertThat(priceCode.frequentRenterPoints(5), is(2));
	}
}
