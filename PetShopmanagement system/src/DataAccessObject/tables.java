/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessObject;

import javax.swing.JOptionPane;


public class tables {
    public static void main(String[] args){
        try{
        String userTable="create table user(id int AUTO_INCREMENT primary key,name varchar(200),email varchar(200),mobileNumber varchar(10),address varchar(200),password varchar(200),securityQuestion varchar(200),answer varchar(200),status varchar(20),UNIQUE(email))";
        String adminDetails="insert into user(name,email,mobileNumber,address,password,securityQuestion,answer,status) values('Admin','admin@gmail.com','0123456789','India','admin','developed by?','uzaifnihal','true')";
        String categoryTable = "create table category(id int AUTO_INCREMENT primary key,name varchar (200))";
        String productTable = "create table product(id int AUTO_INCREMENT primary key,name varchar(50),brand varchar(200),quantity varchar(10),qType varchar(50),mrp varchar(50),pp varchar(50))";
        String returnProductTable = "create table returnProduct(id int AUTO_INCREMENT primary key,name varchar(50),brand varchar(200),quantity varchar(10),mrp varchar(50),pp varchar(50))";
        String billTable="create table bill(id int primary key,name varchar(200),mobileNo varchar(200),email varchar(200),date varchar(50),total varchar(200),createdBy varchar(200))";
        //DbOperations.setDataOrDelete(billTable,"Bill Table Created Successfully");
        //DbOperations.setDataOrDelete(userTable, "User Table Created Successfuly!");
        //DbOperations.setDataOrDelete(adminDetails, "Admin Details Added Successfully!");
       // DbOperations.setDataOrDelete(categoryTable, "Category Table Created Successfully!");
        DbOperations.setDataOrDelete(productTable, "Product Table Created Successfully!");
       // DbOperations.setDataOrDelete(returnProductTable, "Return Product Table Created Successfully!");
        

        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        
        }
    }
}
