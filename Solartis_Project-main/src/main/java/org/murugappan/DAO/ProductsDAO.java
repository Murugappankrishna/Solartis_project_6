package org.murugappan.DAO;

public interface ProductsDAO {
    void addProducts(String productName,String description,int costPrice,int sellingPrice , int stock,int tax);
    void deleteProduct(int productId);
	void showProducts();
	void editProduct(String columnToUpdate, int productId,String newValue);
	String showLowStockItems();
	

}