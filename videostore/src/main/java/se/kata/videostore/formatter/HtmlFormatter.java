package se.kata.videostore.formatter;

public class HtmlFormatter implements Formatter {

	public String header(String name) {
		return "<!DOCTYPE html><html><header><title>Rental Record for " + name + "</title></header><body><h3>Rental Record for "
				+ name + "</h3><table><thead><tr><td>Title</td><td>Amount</td></tr></thead><tbody>";
	}

	public String line(String title, double amount) {
		return "<tr><td>" + title + "</td><td>" + String.valueOf(amount) + "</td></tr>";
	}

	public String footer(double totalAmount, int totalFrequentRenterPoints) {
		String footer = "</tbody></table><p>Amount owed is " + String.valueOf(totalAmount) + "</p>";
		footer += "<p>You earned " + String.valueOf(totalFrequentRenterPoints) + " frequent renter points</p></body></html>";
		return footer;
	}
}