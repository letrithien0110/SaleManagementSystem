package model;

import java.util.ArrayList;

public class ProductManager {

    private ArrayList<Product> productList;

    public ProductManager() {
        productList = new ArrayList<>();
    }

    // Add Product
    public void addProduct(Product product) {

        if (product == null) {
            return;
        }

        for (Product p : productList) {
            if (p.getId().equalsIgnoreCase(product.getId())) {
                System.out.println("Product ID already exists");
                return;
            }
        }

        productList.add(product);
        System.out.println("Product added successfully");
    }

    // Search Product (ID hoặc Name)
    public void searchProduct(String keyword) {

        boolean found = false;

        for (Product product : productList) {

            if (product.getId().equalsIgnoreCase(keyword)
                    || product.getName().toLowerCase()
                    .contains(keyword.toLowerCase())) {

                System.out.println("ID: " + product.getId());
                System.out.println("Name: " + product.getName());
                System.out.println("Category: " + product.getCategory());
                System.out.println("Price: " + product.getPrice());
                System.out.println("Stock Quantity: " + product.getStockQuantity());
                System.out.println("---------------------");

                found = true;
            }
        }

        if (!found) {
            System.out.println("Product not found");
        }
    }

    // Update Stock
    public void updateStock(String productId, int newQuantity) {

        for (Product product : productList) {

            if (product.getId().equalsIgnoreCase(productId)) {

                product.setStockQuantity(newQuantity);

                System.out.println("Stock updated successfully");
                return;
            }
        }

        System.out.println("Product not found");
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }
}
// Remove Product
public void removeProduct(String productId) {

    for (Product product : productList) {

        if (product.getId().equalsIgnoreCase(productId)) {

            productList.remove(product);

            System.out.println("Product removed successfully");
            return;
        }
    }

    System.out.println("Product not found");
}
