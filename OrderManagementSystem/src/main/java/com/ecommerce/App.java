package com.ecommerce;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        OrderDAO dao = new OrderDAO();

        dao.displayTotalOrderValue();

        System.out.print("Enter Order ID to delete: ");
        int id = sc.nextInt();

        dao.deleteCancelledOrder(id);

        sc.close();
    }
}