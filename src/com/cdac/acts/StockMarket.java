package com.cdac.acts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

public class StockMarket implements Serializable {
	// StockMarket class that represents the stock market system
	//New created account saved in investors ArrayList
	//stocks Arraylist contains all stocks available in Market
	private ArrayList<Stock> stocks;//Association
	private ArrayList<Investor> investors;//Association
	public StockMarket() {
		this.stocks=new ArrayList<>();
		this.investors=new ArrayList<>();
	}
	

	public void buyStock(Investor i, Stock s, int quantity) {//this method buy the stock in investor portfolio
		if(investors.size()==0) System.out.println("First add account");
		else{Stock temp=null;			
			for (Stock st:stocks) {
				if(s.getSymbol().equalsIgnoreCase(st.getSymbol()))
						s=temp=st;}//if symbol of user entered stock and market stock matches then replace value of s
		if(s==temp) {for(Investor u: investors) {
		if(	u.getName().equals(i.getName())){// verify the user available in arrayList
			u.buyStock(s, quantity);
			System.out.println("Successfully buy");
			}
		}} else System.out.println("Invalid stock");
		
		}}
	
	public void sellStock(Investor i, Stock s, int quantity) {//this method sell the stock in investor portfolio
		if(investors.size()==0)  System.out.println("First add new account");
		else {Stock temp=null;
			for (Stock st:stocks) {
				if(s.getSymbol().equalsIgnoreCase(st.getSymbol()))
					s=temp=st;}
			if(s==temp) { for(Investor u: investors) {
			if(	u.getName().equals(i.getName())){
			u.sellStock(s, quantity);	
			System.out.println("Successfully sell");
			}
		}}else System.out.println("Invalid Stock");
	}}

	public void addInvestor(Investor i) {//this method adds the investor in the arraylist
	    for (Investor u : investors) {
	        if (u.getName().equals(i.getName())) {
	            System.out.println("Account already exists");
	            return;
	        }
	    }
	    investors.add(i);
	    System.out.println("Successfully added investor");
	}
	
	public void removeInvestor(Investor i) {//this method remove the investor in the arraylist
		if(investors.size()==0)  System.out.println("First add new account");
		
		else {for(Investor u: investors) {
		if(u.getName().equals(i.getName())){
			investors.remove(i);
			System.out.println("INvestor removed successfully");
		}	else continue;
		}
	}}
		public void showInvestorInfo(Investor i) {//shows all stocks available in portfolio
		
		if(investors.size()==0)  System.out.println("First add new account");
		else{for(Investor u: investors) {
		if(	u.getName().equals(i.getName())){
			           u.showStocks();   			}
	}
	}}
	public void showAllStocks() {
		Collections.sort(stocks);System.out.println("=====================================================================================================");
		System.out.println("Available Stocks in current Market");
		System.out.printf("%-40s %-15s %-20s \n", "oStock Name", "Stock Symbol", "Unit Price");
	for(Stock s:this.stocks)	{
		System.out.print("\033[0;32m");// change font colour
		System.out.println("||"+s+"||");
		System.out.print("\033[0m"); // reset the text color
		System.out.println("=====================================================================================================");
	}
	}
	public void addBalance(Investor i, double money) {// add money into user account
        if (investors.isEmpty()) {
            System.out.println("First add new account");
        } else {
            for (Investor u : investors) {
                if (u.getName().equals(i.getName())) {
                    u.addBalance(money);    
                    System.out.println("Balance added successfully");
                    return;
                } 
            }
            System.out.println("Name is incorrect");
        }
    }

	public void addStock(Stock stock) {//IPO in stock market
		stocks.add(stock);
	}
	public void removeStock(Stock stock) {//Delisting of stock in stock market
		stocks.remove(stock);
	}
	
	
	public void updateStockPrice(Stock stock,double newPrice) {//update stock price
		stock.setPrice(newPrice);
	}


	public void showAllInvestors() { //show available investor in stock market instance
		System.out.print("\033[0;31m"); // set the color to red
		System.out.printf("%-20s %-20s \n", "Investor Name", "Investor Balance");
		for(Investor i: this.investors)
			System.out.println(i);
		System.out.print("\033[0m"); // reset the color to default
	
		
	}
}