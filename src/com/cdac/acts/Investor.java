package com.cdac.acts;
import java.io.Serializable;
import java.util.*;
import java.util.Objects;

class Investor implements Serializable,Comparable<Investor>{
	// Investor class that represents an investor in the stock market
	//Investor can buy ,sell stocks  
private String name;
private double balance;
private Map<Stock,Integer> stocks; //key=stock value =current quantity in portfolio

@Override
public int hashCode() {
	return Objects.hash(name);
}

@Override
public boolean equals(Object obj) {// checks by the investor names
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Investor other = (Investor) obj;
	return Objects.equals(name, other.name);
}

public Investor(String name, double balance) {
	
	this.name = name;
	this.balance = balance;
	this.stocks=new HashMap<>();
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}

public double getBalance() {
	return balance;
}
public void setBalance(double balance) {
	this.balance = balance;
}
public Map<Stock, Integer> getStocks() {
	return stocks;
}
public void setStocks(Map<Stock, Integer> stocks) {
	this.stocks = stocks;
}
public void addBalance(double amount) {
	balance+=amount;
}
public void subtractBalance(double amount) {
	balance-=amount;}

	public void sellStock(Stock stock, int quantity) {//investor can sell stock
		if(this.hasStock(stock, quantity)) {// check availability of stock in porttfolio
	    int currentQuantity = stocks.get(stock);//current quantity
	    if (currentQuantity ==quantity) {
	        stocks.remove(stock);
	        this.balance+=quantity*stock.getPrice();
	    } else {
	        stocks.put(stock, currentQuantity - quantity);//overrite existing data
	        this.balance+=quantity*stock.getPrice();
	    }}
	}

	public void buyStock(Stock stock, int quantity) {
	    if (stocks.containsKey(stock)) {//checks investor portfolio/MAP can contains stock
	        int currentQuantity = stocks.get(stock);
	        stocks.put(stock, currentQuantity + quantity);//overrite  value of existing key
	        this.balance-=quantity*stock.getPrice();
	        System.out.println("Successful");
	    } else {
	        stocks.put(stock, quantity);//buy new stock 
	        this.balance-=quantity*stock.getPrice();
	        System.out.println("Successful");
	    }	}
	
	public void showStocks() {//show available stock in MAP
		System.out.println("========================================================================================================================");
		System.out.println("Investor name: " + this.name + " | Balance: " + this.balance);
		System.out.printf("%-35s %-15s %-15s %-20s %-20s\n", "Stock Name", "Stock Symbol", "Unit Price", "Quantity", "Total Value");
		double totalPortfolioValue=0.0;
		for (Map.Entry<Stock, Integer> entry : this.stocks.entrySet()) {//etract key ,values from map
		    System.out.print("\033[0;32m");//change colour to green				
			Stock stock = entry.getKey();//extract stock
			int quantity = entry.getValue();//extract current quantity
			double unitPrice = stock.getPrice();//current price
			double totalValue = quantity * unitPrice;//total value of specific stock
			totalPortfolioValue+=totalValue;
			System.out.printf("**%-35s %-15s %-19.2f %-20d %-19.2f**\n", stock.getName(), stock.getSymbol(), unitPrice, quantity, totalValue);
		}		System.out.print("\033[0;31m"); // set the color to red
		System.out.printf("%-35s %-15s %-15s %-20s %-20.5f\n", "Total Porfolio Value", "", "", "", totalPortfolioValue);
		System.out.print("\033[0m"); // reset the text color
		System.out.println("========================================================================================================================");
	}

	public boolean hasStock(Stock stock, int quantity) {//it checks if investor has stock or not
	    if (stocks.containsKey(stock)) {
	        int currentQuantity = stocks.get(stock);
	        if (currentQuantity >= quantity) {
	            return true;
	        }
	    } return false;
	    }

	@Override
	public String toString() {
		return String.format("%-20s%-20.5f", this.name,this.balance);
	}

	@Override
	public int compareTo(Investor o) {
		
		return this.name.compareTo(o.name);
	}

	public void buyDividendStock(DividendStock s, int quantity) {
		// TODO Auto-generated method stub
		
	}

	

	}
	
	
	   

	
	
	   

