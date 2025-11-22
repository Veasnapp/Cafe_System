package dao;

import javax.swing.JOptionPane;
import java.sql.*;
import java.util.ArrayList;
import model.Bill;

public class BillDao {

    public static String getId() {
        int id = 1;
        try {
            ResultSet rs = Dboperations.getData("SELECT MAX(id) FROM bill");
            if (rs.next()) {
                id = rs.getInt(1) + 1;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return String.valueOf(id);
    }

    public static void save(Bill bill) {
        try {
            String query = "INSERT INTO bill (`id`, `subtotal`, `pay`, `Exchange`, `createdBy`, `date`, `time`) "
                    + "VALUES ('" + bill.getId() + "', '" + bill.getTotal() + "', '" + bill.getPay() + "', '" 
                    + bill.getBalance() + "', '" + bill.getCreatedBy() + "', '" + bill.getDate() + "', '" 
                    + bill.getTime() + "')";

            Dboperations.setDataOrDelete(query, "Bill Details Added Successfully");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public static ArrayList<Bill> getAllRecordsByInc(String date) {
        ArrayList<Bill> list = new ArrayList<>();
        try {
            ResultSet rs = Dboperations.getData("SELECT * FROM bill WHERE date LIKE '%" + date + "%'");
            while (rs.next()) {
                Bill bill = new Bill();
                bill.setId(rs.getInt("id"));
                bill.setDate(rs.getString("date"));
                bill.setTime(rs.getString("time"));
                bill.setTotal(rs.getString("subtotal"));
                bill.setPay(rs.getString("pay"));
                bill.setBalance(rs.getString("Exchange")); // FIXED
                bill.setCreatedBy(rs.getString("createdBy"));
                list.add(bill);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }

    public static ArrayList<Bill> getAllRecordsByDesc(String date) {
        ArrayList<Bill> list = new ArrayList<>();
        try {
            ResultSet rs = Dboperations.getData("SELECT * FROM bill WHERE date LIKE '%" + date + "%' ORDER BY id DESC");
            while (rs.next()) {
                Bill bill = new Bill();
                bill.setId(rs.getInt("id"));
                bill.setDate(rs.getString("date"));
                bill.setTime(rs.getString("time"));
                bill.setTotal(rs.getString("subtotal"));
                bill.setPay(rs.getString("pay"));
                bill.setBalance(rs.getString("Exchange")); // FIXED
                bill.setCreatedBy(rs.getString("createdBy"));
                list.add(bill);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return list;
    }
}
