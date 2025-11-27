package com.shop.services;

import com.shop.enteties.Product;

import java.util.List;

public interface ProductManagementService {

    List<Product> getProducts();

    Product getProductById(int productIdToAddToCart);

}
