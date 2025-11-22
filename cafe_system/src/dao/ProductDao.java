package dao;

import model.Product;
import java.util.ArrayList;
import java.sql.*;
import javax.swing.JOptionPane;

public class ProductDao {

    public static void save(Product product) {
        String query = "INSRET INTO product (name,category,price) VALUES('" + product.getName() + "','" + product.getCategory() + "','" + product.getPrice() + "') ";
        Dboperations.setDataOrDelete(query, "Product Added Successfully");
    }

    public static ArrayList<Product> getAllRecords() {
        ArrayList<Product> arrayList = new ArrayList<>();
        try {
            ResultSet rs = Dboperations.getData("SELECT * FROM product");
            while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setCategory(rs.getString("category"));
                product.setPrice(rs.getString("price"));
                arrayList.add(product);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;

    }

    public static void update(Product product) {
        String query = "UPDATE product SET name ='" + product.getName() + "',category ='" + product.getCategory() + "', price = '" + product.getPrice() + "' WHERE id = '" + product.getId() + "'";
        Dboperations.setDataOrDelete(query, "Product Updated Successfully");
    }

    public static void delete(String id) {
        String query = "DELETE FROM product WHERE id = '" + id + "'";
        Dboperations.setDataOrDelete(query, "Product Deleted Successfully");

    }

    public static ArrayList<Product> getAllRecordsByCategory(String category) {
        ArrayList<Product> arrayList = new ArrayList<>();
        try {
            ResultSet rs = Dboperations.getData("SELECT * FROM product WHERE category ='" + category + "'");
            while (rs.next()) {
                Product product = new Product();
                product.setName(rs.getString("name"));
                arrayList.add(product);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }

    public static ArrayList<Product> filterProductByname(String name, String category) {
        ArrayList<Product> arrayList = new ArrayList<>();
        try {
            ResultSet rs = Dboperations.getData("SELECT * FROM product WHERE name like '%" + name + "%' AND category = '" + category + "'");
            while (rs.next()) {
                Product product = new Product();
                product.setName(rs.getString("name"));
                arrayList.add(product);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }

    public static Product getProductByname(String name) {
        Product product = new Product();
        try {
            ResultSet rs = Dboperations.getData("SELECT * FROM product WHERE name ='" + name + "'");
            while (rs.next()) {
                product.setName(rs.getString(2));
                product.setCategory(rs.getString(3));
                product.setPrice(rs.getString(4));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return product;
    }

}
