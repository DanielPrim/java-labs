package model;

import model.products.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Warehouse {

    public static ArrayList<Product> productList = new ArrayList<>();
    public static HashMap<Integer, Product> productHashMap = new HashMap<>();

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Product> productList) {
        Warehouse.productList = productList;
    }

    public HashMap<Integer, Product> getProductHashMap() {
        return productHashMap;
    }

    public void setProductHashMap(HashMap<Integer, Product> productHashMap) {
        Warehouse.productHashMap = productHashMap;
    }

    public static void appendList(Product product) {
        productList.add(product);
    }

    public static void appendHashMap(Integer i, Product product) {
        productHashMap.put(i, product);
    }

    public static Warehouse randomList(int n) {
        Warehouse warehouse = new Warehouse();
        while (n > 0) {
            appendList(RandomProduct.generate());
            n--;
        }
        return warehouse;
    }

    public static Warehouse randomHashMap(int n) {
        Warehouse warehouse = new Warehouse();
        for (int i = 0; i < n; n++) {
            appendHashMap(i, RandomProduct.generate());
        }
        return warehouse;
    }
}

