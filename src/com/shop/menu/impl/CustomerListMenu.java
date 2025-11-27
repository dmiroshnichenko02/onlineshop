package com.shop.menu.impl;

import com.shop.configs.ApplicationContext;
import com.shop.enteties.User;
import com.shop.menu.Menu;
import com.shop.services.UserManagementService;
import com.shop.services.impl.DefaultUserManagementService;

import java.util.List;

public class CustomerListMenu implements Menu {

    private ApplicationContext context;
    private UserManagementService userManagementService;

    {
        userManagementService = DefaultUserManagementService.getInstance();
        context = ApplicationContext.getInstance();
    }

    @Override
    public void start() {
        printMenuHeader();
        List<User> users = userManagementService.getUsers();

        if (users.size() == 0) {
            System.out.println("Unfortunately, there are no customers.");
        } else {
            for (User user : users) {
                System.out.println(user);
            }
        }
    }

    @Override
    public void printMenuHeader() {
        System.out.println("***** USERS *****");
    }

}