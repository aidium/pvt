package se.kata.videostore.formatter;

public class TextFormatter implements Formatter {

	public String header(String name) {
		return "Rental Record for " + name + "\n";
	}

	public String line(String title, double amount) {
		return "\t" + title + "\t" + String.valueOf(amount) + "\n";
	}

	public String footer(double totalAmount, int totalFrequentRenterPoints) {
		String footer = "Amount owed is " + String.valueOf(totalAmount) + "\n";
		footer += "You earned " + String.valueOf(totalFrequentRenterPoints) + "frequent renter points";
		return footer;
	}
}