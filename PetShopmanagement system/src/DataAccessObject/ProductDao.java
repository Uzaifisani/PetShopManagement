/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessObject;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Product;
import model.Category;


public class ProductDao {
     public static void save(Product product){
         String query= "insert into product(name,brand,quantity,qType,mrp,pp) values ('"+product.getName()+"','"+product.getBrand()+"','"+product.getQuantity()+"','"+product.getqType()+"','"+product.getMrp()+"','"+product.getPp()+"')";
         DbOperations.setDataOrDelete(query,"Product Added Successfully");
     }
     public static ArrayList<Product> getAllRecords(){
         ArrayList<Product> arrayList= new ArrayList<>();
         try{
         ResultSet rs = DbOperations.getData("select * from product");
         while(rs.next()){
         Product product = new Product();
         product.setId(rs.getInt("id"));
         product.setName(rs.getString("name"));
         product.setBrand(rs.getString("brand"));
         product.setQuantity(rs.getString("quantity"));
         product.setqType(rs.getString("qType"));
         product.setMrp(rs.getString("mrp"));
         product.setPp(rs.getString("pp"));
         arrayList.add(product);

         }
                 }
         catch(Exception e){
         JOptionPane.showMessageDialog(null,e);
         }
         return arrayList;
     
     }
    public static void update(Product product){
    String query="update product set name='"+product.getName()+"',brand='"+product.getBrand()+"',quantity='"+product.getQuantity()+"','"+product.getqType()+"',mrp='"+product.getMrp()+"',pp='"+product.getPp()+"' where id='"+product.getId()+"'";
    DbOperations.setDataOrDelete(query,"Product Updated Successfully");

    }
    public static void updateProduct(String articleNo,String quantity){
    String query=" update product set quantity='"+quantity+"' where name='"+articleNo+"';";
    DbOperations.setDataOrDelete(query,"Stock Updated Successfully");
    }
    
    public static void delete(String id){
    String query2="Insert into returnProduct Select * from product where id ='"+id+"'";
    DbOperations.setDataOrDelete(query2,"Product Added marked As Returned");
    String query ="delete from product  where id ='"+id+"'";
    DbOperations.setDataOrDelete(query,"Product Deleted Successfully");

    }
    public static void deleteStock(String id){
    String query ="delete from product  where id ='"+id+"'";
    DbOperations.setDataOrDelete(query,"Product Deleted Successfully");
    }
    public static ArrayList<Product> getAllRecordsByCategory(String category){
        ArrayList<Product> arrayList = new ArrayList<>();
        try{
        ResultSet rs = DbOperations.getData("select * from product where brand='"+category+"'");
        while(rs.next()){
        Product product = new Product();
        product.setName(rs.getString("name"));
        arrayList.add(product);
        }
        }
        catch(Exception e){
        JOptionPane.showMessageDialog(null,e);
        }
        return arrayList;
    
    }
        public static ArrayList<Product> filterProductByname(String name,String category){
        ArrayList<Product> arrayList = new ArrayList<>();
        try{
        ResultSet rs = DbOperations.getData("select * from product where name like '%"+name+"%' and brand='"+category+"'");
        while(rs.next()){
        Product product = new Product();
        product.setName(rs.getString("name"));
        arrayList.add(product);
        }
        }
        catch(Exception e){
        JOptionPane.showMessageDialog(null,e);
        }
        return arrayList;
    
    }
     public static Product getProductByname(String name){
         Product product = new Product();
         try{
         ResultSet rs = DbOperations.getData("select * from product where name='"+name+"'");
         while(rs.next()){
         product.setName(rs.getString(2));
         product.setBrand(rs.getString(3));
         product.setMrp(rs.getString(6));
         product.setQuantity(rs.getString(4));
         product.setqType(rs.getString(5));
         
         }
         }
         catch(Exception e){
         JOptionPane.showMessageDialog(null, e);
         }
     return product;
     }
     public static Product getProductByQuantity(String name){
         Product product = new Product();
         try{
         ResultSet rs = DbOperations.getData("select * from product where name='"+name+"'");
         while(rs.next()){
         product.setId(rs.getInt(1));
         product.setName(rs.getString(2));
         product.setQuantity(rs.getString(4));
         
         }
         }
         catch(Exception e){
         JOptionPane.showMessageDialog(null, e);
         }
     return product;
     }
     
     public static ArrayList<Product> getQtype(){
        ArrayList<Product> arrayList = new ArrayList<>();
        try{
            ResultSet rs = DbOperations.getData("select * from product");
            while(rs.next()){
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setqType(rs.getString("qType"));
                arrayList.add(product);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }
}
