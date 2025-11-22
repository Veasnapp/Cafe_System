package dao;

import javax.swing.JOptionPane;

public class tables {

    public static void main(String[] args) {
        try {
            String userTable = "CREATE TABLE user (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(200), email VARCHAR(200) UNIQUE, mobileNumber VARCHAR(10), address VARCHAR(200), password VARCHAR(200), securityQuestion VARCHAR(200), answer VARCHAR(200), status VARCHAR(20))";
            String adminDetails = "INSERT INTO user (name, email, mobileNumber, address, password, securityQuestion, answer, status) VALUES ('Admin', 'admin@gmail.com', '0234561239', 'Cambodia', 'admin', 'Your first school name?', 'ETEC', 'true')";
            String categoryTable = "CREATE TABLE category (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(200))";
            String productTable = "CREATE TABLE product (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(200), category VARCHAR(200), price VARCHAR(200))";
            String billTable = "CREATE TABLE bill (id INT PRIMARY KEY, date VARCHAR(50), time VARCHAR(50), total VARCHAR(200), pay VARCHAR(200), balance VARCHAR(200), createdBy VARCHAR(200))";
            Dboperations.setDataOrDelete(userTable, "User Table Created Successfully");
            Dboperations.setDataOrDelete(adminDetails, "Admin Details Added Successfully");
            Dboperations.setDataOrDelete(categoryTable, "Category Table Created Successfully");
            Dboperations.setDataOrDelete(productTable, "Product Table Created Successfully");
            Dboperations.setDataOrDelete(billTable, "Bill Table Created Successfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
