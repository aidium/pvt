package se.kata.videostore.formatter;

public interface Formatter {

	public abstract String header(String name);

	public abstract String line(String title, double amount);

	public abstract String footer(double totalAmount, int totalFrequentRenterPoints);

}