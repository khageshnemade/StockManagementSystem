package com.cdac.acts;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

class Stock implements Serializable,Comparable<Stock>{
	//Stock class that represents a single stock in the market
	
@Override
	public int hashCode() {
		return Objects.hash(symbol);
	}
	@Override
	public boolean equals(Object obj) {//check equality by using symbol name
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stock other = (Stock) obj;
		return Objects.equals(symbol, other.symbol);
	}
private String name;
private String symbol;
double price;

public Stock(String name, String symbol, double price) {
	
	this.name = name;
	this.symbol = symbol;
	this.price = price;
}
@Override
public String toString() {
	return String.format("%-40s%-15s%-20.3f",this.name,this.symbol,this.price);
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getSymbol() {
	return symbol;
}
public void setSymbol(String symbol) {
	this.symbol = symbol;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
	
}
@Override
public int compareTo(Stock o) {
	// TODO Auto-generated method stub
	return this.getName().compareTo(o.getName());
}
}




