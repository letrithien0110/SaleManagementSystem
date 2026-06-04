package model;

import java.util.ArrayList;

public class ProductManager {

    private ArrayList<Product> productList;

    public ProductManager() {
        productList = new ArrayList<>();
    }

    // Add Product
    public void addProduct(Product product) {

        for (Product p : productList) {

            if (p.getProductId().equalsIgnoreCase(product.getProductId())) {

                System.out.println("Product ID already exists");
                return;
            }
        }

        productList.add(product);

        System.out.println("Product added successfully");
    }

    // Search Product (also check stock)
    public void searchProduct(String keyword) {

        boolean found = false;

        for (Product product : productList) {

            if (product.getProductId().equalsIgnoreCase(keyword)
                    || product.getProductName().toLowerCase()
                    .contains(keyword.toLowerCase())) {

                System.out.println("ID: " + product.getProductId());
                System.out.println("Name: " + product.getProductName());
                System.out.println("Category: " + product.getCategory());
                System.out.println("Price: " + product.getPrice());
                System.out.println("Stock Quantity: "
                        + product.getStockQuantity());

                found = true;
            }
        }

        if (!found) {
            System.out.println("Product not found");
        }
    }

    // Update Stock
    public void updateStock(String productId,
                            int newQuantity) {

        for (Product product : productList) {

            if (product.getProductId()
                    .equalsIgnoreCase(productId)) {

                product.setStockQuantity(newQuantity);

                System.out.println("Stock updated");
                return;
            }
        }

        System.out.println("Product not found");
    }

    // Remove Product
    public void removeProduct(String productId) {

        for (int i = 0; i < productList.size(); i++) {

            if (productList.get(i)
                    .getProductId()
                    .equalsIgnoreCase(productId)) {

                productList.remove(i);

                System.out.println("Product removed successfully");
                return;
            }
        }

        System.out.println("Product not found");
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }
}
