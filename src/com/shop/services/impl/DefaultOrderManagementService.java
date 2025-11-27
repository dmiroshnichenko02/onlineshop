package com.shop.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.shop.enteties.Order;
import com.shop.services.OrderManagementService;

public class DefaultOrderManagementService implements OrderManagementService {

    private static final int DEFAULT_ORDER_CAPACITY = 10;

    private static DefaultOrderManagementService instance;
    private List<Order> orders;

    {
        orders = new ArrayList<>(DEFAULT_ORDER_CAPACITY);
    }

    public static OrderManagementService getInstance() {
        if (instance == null) {
            instance = new DefaultOrderManagementService();
        }
        return instance;
    }

    @Override
    public void addOrder(Order order) {
        if (order == null) {
            return;
        }
        orders.add(order);
    }

    @Override
    public List<Order> getOrdersByUserId(int userId) {

        List<Order> userOrders = new ArrayList<>();

        for (Order order : orders) {
            if (order != null && order.getCustomerId() == userId) {
                userOrders.add(order);
            }
        }

        return userOrders;
    }

    @Override
    public List<Order> getOrders() {

        List<Order> nonNullOrders = new ArrayList<>();

        for (Order order : orders) {
            if (order != null) {
                nonNullOrders.add(order);
            }
        }

        return nonNullOrders;
    }

    void clearServiceState() {
        orders.clear();
    }

}