package org.murugappan.service;
import org.murugappan.DAO.TransactionImpl;
import org.murugappan.DAO.TransactionDAO;
import java.util.*;

public class TransactionService {
Scanner ip=new Scanner(System.in);
	TransactionDAO transactionImpl=new TransactionImpl();
	Scanner input = new Scanner(System.in);
public void showProfitForADay() {
	
	System.out.println("Enter The Date To See The Profit Made On That Day In The Format Of YYYY-MM-DD");
	String date= input.next();
	System.out.println(transactionImpl.fetchProfitByDate(date));
	
}
public void  showTaxForMonth(){
	int month;
	int year;
	System.out.println("Enter The Month In The Format Of MM To See The Tax Paid For The Month");
	month= input.nextInt();
	System.out.println("Enter The Year In The Format Of YYYY");
	year=input.nextInt();
	System.out.println("The Total Pax For The Month is "+transactionImpl.fetchTaxByMonth(month,year));
}
public void showItemBought() {
	System.out.println("Here the List Of Products Bought Over The Period Of Time");
	transactionImpl.fetchItemBought();
	
}
public void TaxForEachProduct() {
	System.out.println("Here is The List of Products Sold Along With The Tax");
	transactionImpl.fetchTaxForEachProduct();
}

public void productsOnPaymentMode() {
	System.out.println("Enter The Mode Of Payment");
	String modeOfPay=ip.next();
	System.out.println("Here Is The Products Based On The Mode Of Pay");
	transactionImpl.fetchProductsOnPaymentMode(modeOfPay);
}
}