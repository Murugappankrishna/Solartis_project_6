package org.murugappan.service;

import java.util.Scanner;



public class WorkFlowService {
	UserDetailsService ucs= new UserDetailsService();
    ProductsService ps=new ProductsService();
    CartService cs=new CartService();
    TransactionService ts=new TransactionService(); 
    Scanner ip=new Scanner(System.in);
    String userFlag;
    public void login() {
    
    		System.out.println("Enter 1 To Register As A New User \nEnter 2 To Login As Existing User");
    		int isNewUserOrExistingUser = ip.nextInt();
    		 if (isNewUserOrExistingUser == 1) {
    			 ucs.createUser();
    			 login();
    			 }
    		 else if (isNewUserOrExistingUser == 2) {   	         
    				 userFlag= (ucs.fetchRole().toUpperCase());
    				 System.out.println(userFlag);
    			 }
    	        } 
    	
    
     public void manageProduct() {
    	   if(userFlag.equals("MANAGER")) {
    		   int managerFunction;
    		   System.out.println("Welcome Manager!\nHave A Nice Day");
    		   System.out.println("Enter 1 To See All Products In The Inventory\nEnetr 2 To Add A Product\nEnter 3 To Edit A Product\nEnter 4 To Remove A Productt");
    		   managerFunction=ip.nextInt();
    		   if(managerFunction==1) 
            	  ps.showProducts();
            	else if(managerFunction==2)
            		ps.addProduct();
            	else if(managerFunction==3)
            		ps.editProducts();           		
            	else if(managerFunction==4)
            		ps.deleteProduct();
            
            	
    	   }
    	   else if(userFlag.equals("SALESPERSON")) {
    		   System.out.println("Welcome SalesPerson!\nHave A Nice Day");
    		   System.out.println("Enetr 1 To Add A Product\nEnter 2 To Edit A Product\nEnter 3 To Remove A Product");
    		   int salespersonFunction;
    		   salespersonFunction=ip.nextInt();
    		   if(salespersonFunction==1)
    			   ps.addProduct();
    		   else if(salespersonFunction==2)
    			   ps.editProducts();
    		   else if(salespersonFunction==3)
    			   ps.deleteProduct();
    		 
    			  
    		   else 
    			   System.out.println("Enter a Valid Choice");
    		   
    	   }
     }
   public  void manageTransaction() {
    	if(userFlag.equals("MANAGER")) {
    		System.out.println("Welcome Manager\nHave A Nice Day");
    		System.out.println("Enter 1 To Show Profit For A Particular Date\nEnter 2 Get The Tax Paid For a Particular Day\nEnter 3 See The Items Sold\nEnter 4 To See The Products Based On Mode OF Payment\nEnter 5 To See Tax Paid For Each Product");
    		int managerFunction=ip.nextInt();
    		if(managerFunction==1)
    			ts.showProfitForADay();
 		   else if(managerFunction==2)
 			  ts.showTaxForMonth();
 		   else if(managerFunction==3)
 			  ts.showItemBought();
 		   else if(managerFunction==4)
 			  ts.productsOnPaymentMode();
 		   else if(managerFunction==5)
 			 ts.TaxForEachProduct();
    		
    	}
    	else if(userFlag.equals("SALESPERSON")){
    		System.out.println("Welcome SalesPerson!\nHave A Nice Day");
    		System.out.println("Enter 1 See The Items Sold\nEnter 2 To See The Products Based On Mode OF Payment\n Enter 3 To See Tax Paid For Each Product");
    		 int salespersonFunction=ip.nextInt();
    		   if(salespersonFunction==1)
    			   ts.showItemBought();
    		   else if(salespersonFunction==2)
    			   ts.productsOnPaymentMode();
    		   else if(salespersonFunction==3)
    			   ts.TaxForEachProduct();	   
    		   else 
    			   System.out.println("Enter a Valid Choice");
    		  
    	}
    }
  
     public void addToCart() {
    	 cs.addToCart();
     }
}


