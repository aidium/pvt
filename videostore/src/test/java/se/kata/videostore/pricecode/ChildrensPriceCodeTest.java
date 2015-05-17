package se.kata.videostore.pricecode;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import se.kata.videostore.Movie;

public class ChildrensPriceCodeTest {
	private ChildrensPriceCode priceCode = new ChildrensPriceCode(Movie.CHILDRENS);

	@Test
	public void shouldhandleAmountCorrecty() throws Exception {
		assertThat(priceCode.amount(1), is(1.5));
		assertThat(priceCode.amount(3), is(1.5));
		assertThat(priceCode.amount(4), is(3.0));
		assertThat(priceCode.amount(5), is(4.5));
	}

	@Test
	public void shouldHandleFrequentRenterPointsCorrectly() throws Exception {
		assertThat(priceCode.frequentRenterPoints(1), is(1));
		assertThat(priceCode.frequentRenterPoints(5), is(1));
	}
}
