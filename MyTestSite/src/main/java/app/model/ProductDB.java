package app.model;

import app.entities.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class ProductDB extends ConnectingDB {
    /*public static ArrayList<Product> select() {
        ArrayList<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM PRODUCTS";
        Statement statement = null;
        try {
            statement = getDbConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int idproducts = resultSet.getInt("idproducts");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                String image = resultSet.getString("image");
                Product product = new Product(idproducts, name, price, image);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return products;
    }*/ //Добавление товаров из БД в ArrayList
    public static Map<Integer, Product> select() {
        Map<Integer, Product> products = new HashMap<>();
        String sql = "SELECT * FROM PRODUCTS";
        Statement statement = null;
        try {
            statement = getDbConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                int idproducts = resultSet.getInt("idproducts");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                String image = resultSet.getString("image");
                Product product = new Product(name, price, image);
                products.put(idproducts, product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return products;
    }


}
