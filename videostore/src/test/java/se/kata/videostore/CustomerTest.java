package se.kata.videostore;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

import se.kata.videostore.formatter.HtmlFormatter;

public class CustomerTest {

	private Customer customer;

	@Before
	public void createCustomer() {
		customer = new Customer("Bob");

		customer.addRental(createRental("Terminator", Movie.REGULAR, 1));
		customer.addRental(createRental("Terminator 2", Movie.REGULAR, 3));

		customer.addRental(createRental("Hobbit 1", Movie.NEW_RELEASE, 1));
		customer.addRental(createRental("Hobbit 2", Movie.NEW_RELEASE, 2));

		customer.addRental(createRental("Bilar", Movie.CHILDRENS, 1));
		customer.addRental(createRental("Flygplan", Movie.CHILDRENS, 4));
	}

	@Test
	public void shouldSumAmount() throws Exception {
		assertThat(customer.totalAmount(), is(19.0));
	}

	@Test
	public void shouldSumFrequentRenterPoints() throws Exception {
		assertThat(customer.totalFrequentRenterPoints(), is(7));
	}

	@Test
	public void shouldPresentCorrectReport() throws Exception {
		assertEquals(customer.statement(), //
				"Rental Record for Bob\n" + //
						"\tTerminator	2.0\n" + //
						"\tTerminator 2	3.5\n" + //
						"\tHobbit 1	3.0\n" + //
						"\tHobbit 2	6.0\n" + //
						"\tBilar	1.5\n" + //
						"\tFlygplan	3.0\n" + //
						"Amount owed is 19.0\n" + //
						"You earned 7frequent renter points");
	}

	@Test
	public void shouldExpressHtmlWithHtmlFormatter() throws Exception {

		customer.setFormatter(new HtmlFormatter());

		String html = customer.statement();
		assertThat(html, containsString("<body>"));
		assertThat(html, containsString("Rental Record for Bob"));
		assertThat(html, containsString("<tr><td>Hobbit 1</td><td>3.0</td></tr>"));
	}

	private Rental createRental(String title, int priceCode, int daysRented) {
		return new Rental(new Movie(title, priceCode), daysRented);
	}
}
