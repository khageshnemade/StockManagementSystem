package com.cdac.acts;

public class DividendStock extends Stock{
	// This class represents special stocks which gives Dividend
	private double dividend;
	public DividendStock(String name, String symbol, double price,double dividend) {
		super(name, symbol, price);
      this.dividend=dividend;	}
	public double getDividend() {
		return dividend;
	}
	public void setDividend(double dividend) {
		this.dividend = dividend;
	}


@Override
public String toString() {
	return String.format("%-40s%-15s%-7.3f Dividend=%-10.2f",this.getName(),this.getSymbol(),this.getPrice(),this.getDividend());
}
}
