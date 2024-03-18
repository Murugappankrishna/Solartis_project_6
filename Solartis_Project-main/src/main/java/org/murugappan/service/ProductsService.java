package org.murugappan.service;
import org.murugappan.DAO.ProductsDAO;
import org.murugappan.DAO.ProductsImpl;
import org.murugappan.model.ProductDetails;

import java.util.Scanner;

public class ProductsService {
    ProductDetails details =new ProductDetails();
    ProductsDAO productsImplementation =new ProductsImpl();
    
    Scanner input = new Scanner(System.in);
    public void addProduct(){
    	


        System.out.println("Enter The Product Name");
        details.productDetails.put("ProductName", input.next());
        System.out.println("Enter The Cost  Price");
        details.productDetails.put("CostPrice", input.next());
        System.out.println("Enter The Selling Price");
        details.productDetails.put("SellingPrice", input.next());
        System.out.println("Enter The StockNo");
        details.productDetails.put("Stock", input.next());
        System.out.println("Enter The Product Description");
        details.productDetails.put("Description", input.next());
        System.out.println("Enter The Tax Percent");
        details.productDetails.put("Tax", input.next());
        productsImplementation.addProducts(details.productDetails.get("ProductName"), details.productDetails.get("Description"),Integer.parseInt(details.productDetails.get("CostPrice")),Integer.parseInt(details.productDetails.get("SellingPrice")),Integer.parseInt(details.productDetails.get("Stock")),Integer.parseInt(details.productDetails.get("Tax")));

    }
    public void deleteProduct(){
        System.out.println("Enter The ProductId To Be Deleted");
        int productId= input.nextInt();
        productsImplementation.deleteProduct(productId);
    }
	public void showProducts() {
		System.out.println("Here The List of Available Products In the Inventory!");
		System.out.println();
		productsImplementation.showProducts();
	}
	public void editProducts() {
	    System.out.println("Enter the detail to be edited:\n" +
	            "1. Edit Product Name\n" +
	            "2. Edit Product Selling Price\n" +
	            "3. Edit Cost Price\n" +
	            "4. Edit Product Description\n" +
	            "5. Edit The Total Stock\n" +
	            "6. Edit The Tax Percent");

	    int choice = input.nextInt();
	    String columnToUpdate = null;
	    int productId;

	    switch (choice) {
	        case 1:
	            columnToUpdate = "product_name";
	            break;
	        case 2:
	            columnToUpdate = "selling_price";
	            break;
	        case 3:
	            columnToUpdate = "cost_price";
	            break;
	        case 4:
	            columnToUpdate = "product_des";
	            break;
	        case 5:
	            columnToUpdate = "Stock";
	            break;
	        case 6:
	            columnToUpdate = "Tax_Percent";
	            break;
	        default:
	            System.out.println("Enter a valid choice");
	            return; // Exit method if choice is invalid
	    }

	    System.out.println("Enter the product ID:");
	    productId = input.nextInt();
	    System.out.println("Enter the new value to be updated:");
	    String newValue = input.next();

	    productsImplementation.editProduct(columnToUpdate, productId, newValue);
	}

	
	
}