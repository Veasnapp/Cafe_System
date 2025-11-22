package dao;

import javax.swing.JOptionPane;
import model.User;
import java.sql.*;
import java.util.ArrayList;

public class Userdao {

    public static void save(User user) {
        String query = "INSERT INTO user(name, email, mobileNumber, address, password, securityQuestion, answer, status) VALUES('"
                + user.getName() + "','" + user.getEmail() + "','" + user.getMobileNumber() + "','" + user.getAddress() + "','" + user.getPassword() + "',"
                + "'" + user.getSecurityQuestion() + "','" + user.getAnswer() + "','false')";
        Dboperations.setDataOrDelete(query, "Registered Successfully ! Wait for Admin Approval!");
    }

    public static User login(String email, String password) {
        User user = null;
        try {
            ResultSet rs = Dboperations.getData("SELECT * FROM user WHERE email ='" + email + "'AND password ='" + password + "'");
            while (rs.next()) {
                user = new User();
                user.setStatus(rs.getString("status"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return user;
    }

    public static String getUserName(String email){
        String name="";
        try {
            ResultSet rs = Dboperations.getData("SELECT name FROM user WHERE email like '%" + email + "%'");
            while (rs.next()) {
                name=rs.getString("name");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return name;
    }
    
    public static User getSecurityQuestion(String email) {
        User user = null;
        try {
            ResultSet rs = Dboperations.getData("SELECT * FROM user where email = '" + email + "'");
            while (rs.next()) {
                user = new User();
                user.setSecurityQuestion(rs.getString("securityQuestion"));
                user.setAnswer(rs.getString("answer"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return user;
    }

    public static void update(String email, String newPassword) {
        String query = "UPDATE user SET password = '" + newPassword + "' WHERE email = '" + email + "'";
        Dboperations.setDataOrDelete(query, " Password Changed Successfully ");
    }

    public static ArrayList<User> getAllRecords(String email) {
        ArrayList<User> arrayList = new ArrayList<>();
        try {
            ResultSet rs = Dboperations.getData("SELECT * FROM user WHERE email like '%" + email + "%'");
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setMobileNumber(rs.getString("mobileNumber"));
                user.setAddress(rs.getString("address"));
                user.setSecurityQuestion(rs.getString("securityQuestion"));
                user.setStatus(rs.getString("status"));
                arrayList.add(user);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }

    public static void changeStatus(String email, String status) {
        String query = "UPDATE user SET status ='" + status + "' WHERE email ='" + email + "'";
        Dboperations.setDataOrDelete(query, " Status Changed Successfully");
    }
}
