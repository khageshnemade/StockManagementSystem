package com.cdac.acts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.Scanner;


public class Test {
	private static Scanner sc=new Scanner(System.in);
	public static int menuList() {
		System.out.println("============*****************===================");
		System.out.println("0.Exit");
		System.out.println("1.For new Stock account");
		System.out.println("2.Buy Stocks");
		System.out.println("3.sell STocks ");
		System.out.println("4.Show all Portfolio of investor");
		System.out.println("5.Show StockMarket stocks ");
		System.out.println("6.Show All investors and balance ");
		System.out.println("7. Read previous data ");
		System.out.println("8.Write current data ");
		System.out.println("9.Add Balance ");	
		System.out.println("============*****************===================");System.out.println("Enter Choice : ");
		return sc.nextInt();
			}
	static File f= new File("file.txt"); //new file created in existing directory
	public static void writeRecord(StockMarket NSE) {
	
	try {
		ObjectOutputStream ob=	new ObjectOutputStream(new FileOutputStream(f)) ;
		ob.writeObject(NSE);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	public static StockMarket readRecord() {
		StockMarket NSE = null;
		try {
			ObjectInputStream ob=	new ObjectInputStream(new FileInputStream(f)) ;
			
			NSE=(StockMarket)ob.readObject();
			
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return NSE;
	}
public static void main(String[] args) {
	Stock d1=new DividendStock("Indiamart Intermesh Limited", "INDIAMART ", 5225.00,45);
	StockMarket NSE=new StockMarket();
	NSE.addStock(d1);
	NSE.addStock(new Stock("Tata Motors Limited", "TATA", 471.20));
	NSE.addStock(new Stock("Wipro Limited", "WIPRO", 368.00));
	NSE.addStock(new Stock("TATA CONSULTANCY SERVICES LIMITED", "TCS", 3169.00));
	NSE.addStock(new Stock("HCL TECHNOLOGIES LIMITED", "HCL", 1048.20));
	NSE.addStock(new Stock("ULTRATECH CEMENT LIMITED", "ULTRACEMCO", 7355.95));
	NSE.addStock(new Stock("ADANI POWER LIMITED", "ADANIPOWER", 471.20));
	NSE.addStock(new Stock("Reliance Industries Limited", "RELIANCE", 2365.40));
	NSE.addStock(new Stock("Infosys Limited", "INFY", 1498.65));
	NSE.addStock(new Stock("Bajaj Auto Limited", "BAJAJ-AUTO", 4087.00));
	NSE.addStock(new Stock("Mahindra & Mahindra Limited", "M&M", 930.80));
	NSE.addStock(new Stock("ITC Limited", "ITC", 213.55));
	NSE.addStock(new Stock("State Bank of India", "SBIN", 429.30));
	NSE.addStock(new Stock("Hindustan Unilever Limited", "HINDUNILVR", 2546.20));
	NSE.addStock(new Stock("Asian Paints Limited", "ASIANPAINT", 3502.95));
	NSE.addStock(new Stock("Kotak Mahindra Bank Limited", "KOTAKBANK", 2066.60));
	NSE.addStock(new Stock("Bajaj Finance Limited", "BAJFINANCE", 7424.35));
	NSE.addStock(new Stock("Axis Bank Limited", "AXISBANK", 781.10));
	NSE.addStock(new Stock("Titan Company Limited", "TITAN", 2349.75));
	NSE.addStock(new Stock("Power Grid Corporation of India Limited", "POWERGRID", 174.95));
	NSE.addStock(new Stock("Bharat Petroleum Corporation Limited", "BPCL", 446.85));
	NSE.addStock(new Stock("Indian Oil Corporation Limited", "IOC", 94.55));
	NSE.addStock(new Stock("NTPC Limited", "NTPC", 136.50));
	NSE.addStock(new Stock("Bharti Airtel Limited", "BHARTIARTL", 590.10));
	NSE.addStock(new Stock("Reliance Infrastructure Limited", "RELINFRA", 55.85));
	NSE.addStock(new Stock("Hindalco Industries Limited", "HINDALCO", 525.35));
	NSE.addStock(new Stock("Oil and Natural Gas Corporation Limited", "ONGC", 106.25));
	NSE.addStock(new Stock("Tata Steel Limited", "TATASTEEL", 1450.55));
	NSE.addStock(new Stock("HDFC Bank Limited", "HDFCBANK", 1567.65));
	NSE.addStock(new Stock("Coal India Limited", "COALINDIA", 174.25));
	NSE.addStock(new Stock("Tata Power Company Limited", "TATAPOWER", 127.90));
	NSE.addStock(new Stock("Bharat Heavy Electricals Limited", "BHEL", 67.35));


			
			
		
			int choice;
			while((choice=Test.menuList())!=0) {
				switch(choice) {
				case 1:System.out.println("Enter your first name only as username then money you want to deposit");
					Investor i=new Investor(sc.next(), sc.nextDouble());//add investor and amount to deposit
					NSE.addInvestor(i);
				break;
				case 2://buy stock
					System.out.println("Type your name");
					i=new Investor(sc.next(), 0);
					System.out.println("Symbol of stock");
					Stock s=new DividendStock("Sample", sc.next(), 0.0,0.0);//Upcasting
					System.out.println("Enter quantity");
					NSE.buyStock(i, s, sc.nextInt() );		
					break;
				case 3:System.out.println("Type your name");//sell stocks
				i=new Investor(sc.next(), 0);
				System.out.println("Symbol of stock");
				 s=new DividendStock("Sample", sc.next(), 0.0,0.0);//Upcasting
				System.out.println("Enter quantity");
				NSE.sellStock(i, s, sc.nextInt());
						break;
				case 4:System.out.println("Type your name");
				i=new Investor(sc.next(), 0);
			
				NSE.showInvestorInfo(i);//show user portfolio
						break;
				case 5://show  all stock market stocks
					NSE.showAllStocks();
					break;
				case 6:NSE.showAllInvestors(); // show all investors in stock market
				break;
				
				case 7:NSE = Test.readRecord();//read from hard disk in file.txt
				break;
				case 8:Test.writeRecord(NSE);//write into file.txt
				break;
				case 9:
				System.out.println("Type your name");
				i=new Investor(sc.next(), 0);//add money in existing balance
				System.out.println("ENter Money to add");
				NSE.addBalance(i,sc.nextDouble());
					break;
				default:System.out.println("Please Enter Valid Choice");
					break;
					
				}

			}
			
}
}
