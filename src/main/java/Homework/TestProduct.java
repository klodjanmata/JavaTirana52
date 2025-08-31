package Homework;

import Homework.Entity.Product;
import Homework.Repo.ProductRepo;

public class TestProduct {
    public static void main(String[] args) {
        ProductRepo productRepo = new ProductRepo();
        Product product = new Product();
        product.setName("Phone");
        product.setPrice(1000);
        product.setQuantity(10);
        product.setDescription("Samsung Galaxy S20 Ultra");
        productRepo.save(product);
    }
}
