package dao;
import java.util.ArrayList;
import model.Category;
import java.sql.*;
import javax.swing.JOptionPane;

public class CategoryDao {
    public static void save(Category category){
        String query = "INSERT INTO category (name) VALUES ('"+category.getName()+"')";
        Dboperations.setDataOrDelete(query, "Category Added Successfully");       
    }
    
    public static ArrayList<Category> getAllRecorded(){
        ArrayList<Category> arrayList = new ArrayList<>();
        try{
            ResultSet rs = Dboperations.getData("SELECT * FROM category");
            while(rs.next()){
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                arrayList.add(category);               
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);           
        }
        return arrayList;       
    }
    
    public static void delete(String id){
        String query = "DELETE FROM category WHERE id ='"+id+"' ";
        Dboperations.setDataOrDelete(query, "Category Deleted Successfully");
        
    }
    
    
    
}
