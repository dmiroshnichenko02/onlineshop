package com.shop.enteties.impl;

import java.util.ArrayList;
import java.util.List;

import com.shop.enteties.Cart;
import com.shop.enteties.Product;

public class DefaultCart implements Cart {

    private static final int DEFAULT_PRODUCT_CAPACITY = 10;
    private List<Product> products;

    {
        products = new ArrayList<>(DEFAULT_PRODUCT_CAPACITY);
    }

    @Override
    public boolean isEmpty() {
        if (products.isEmpty()) {
            return true;
        }

        for (Product product : products) {
            if (product != null) {
                return false;
            }
        }

        return true;
    }

    @Override
    public void addProduct(Product product) {
        if (product == null) {
            return;
        }
        products.add(product);
    }

    @Override
    public List<Product> getProducts() {

        List<Product> nonNullProducts = new ArrayList<>();
        for (Product product : products) {
            if (product != null) {
                nonNullProducts.add(product);
            }
        }

        return nonNullProducts;
    }

    @Override
    public void clear() {
        products.clear();
    }

}