package se.kata.videostore;

import java.util.ArrayList;
import java.util.List;

import se.kata.videostore.formatter.Formatter;
import se.kata.videostore.formatter.TextFormatter;

/**
 * A First Example taken from Refactoring by Martin Fowler p. 4-6.
 */
public class Customer {
	private final String _name;
	private final List<Rental> _rentals = new ArrayList<Rental>();
	private Formatter formatter = new TextFormatter();

	public Customer(String name) {
		_name = name;
	}

	public void addRental(Rental arg) {
		_rentals.add(arg);
	}

	public String getName() {
		return _name;
	}

	public void setFormatter(Formatter aFormatter) {
		formatter = aFormatter;
	}

	public String statement() {
		String result = formatter.header(getName());
		for (Rental each : _rentals) {
			result += formatter.line(each.title(), each.amount());
		}
		result += formatter.footer(totalAmount(), totalFrequentRenterPoints());
		return result;
	}

	int totalFrequentRenterPoints() {
		int totalFrequentRenterPoints = 0;
		for (Rental each : _rentals) {
			totalFrequentRenterPoints += each.frequentRenterPoints();
		}
		return totalFrequentRenterPoints;
	}

	double totalAmount() {
		double totalAmount = 0;
		for (Rental each : _rentals) {
			totalAmount += each.amount();
		}
		return totalAmount;
	}
}
