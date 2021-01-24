/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccessObject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author eliasc
 */
public class Dao {
    
    private Connection connection;
    private Statement statement;
    
    
    public void openDatabase() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/thickclientdb", "admin","admin");
        statement = connection.createStatement();
    }
    
    public void closeDatabase() throws SQLException{
        statement.close();
        connection.close();
    }   
    
    public int registerStudent(Student student, Address address) throws SQLException{
        int pass = 0;
        String sql = "insert into tblstudent(studentNo, name, surname, gender) values('"+student.getStudentNo()+"', '"+student.getName()+"', '"+student.getSurname()+"','"+student.getGender()+"')";
        pass += statement.executeUpdate(sql);        
        if(pass == 1){
            int theStudentNo = getMax(); 
            pass += statement.executeUpdate("insert into tbladdress(studentNo, houseNo, streetName, city, postalCode) values('"+theStudentNo+"', '"+address.getHouseNo()+"', '"+address.getStreetName()+"', , '"+address.getCity()+"', , '"+address.getPostalCode()+"')");
        }
        return pass;
    }
    
    public int getMax() throws SQLException{
        int studentNo = -1;
        String sql = "select max(studentNo) from tblstudent";
        ResultSet rs = statement.executeQuery(sql);
        if(rs.next()){
            studentNo = rs.getInt(1);
        }
        return studentNo;
    }
    //Should return 2
    public int delete(int studentNo) throws SQLException{
        int pass = 0;
        String sql = "delete from tblstudent where studentNo = "+studentNo;        
        pass += statement.executeUpdate(sql);
        if(pass > 0){
            String sql2 = "delete from tbladdress where studentNo = "+studentNo;
            pass += statement.executeUpdate(sql2);
        }
        return pass;
    }
    
    public ArrayList<Object> search(int studentNo) throws SQLException{
        ArrayList<Object> objList = new ArrayList<>();
        String sql = "select studentID, studentNo, name, surname, gender from tblstudent where studentNo = " + studentNo;       
        ResultSet rs = statement.executeQuery(sql);
        Student student = null;
        if(rs.next()){           
            student = new Student(rs.getInt(1),rs.getInt(2), rs.getString(3), rs.getString(4),rs.getString(5));
        }
        Address address = getAddress(studentNo);   
        objList.add(student);
        objList.add(address);
        return objList;
    }
    
    public Address getAddress(int studentNo) throws SQLException{
        Address address = null;
        String sql = "select addressID, studentNo, houseNo, streetName, city, postalCode from tbladdress where studentNo = " + studentNo;
        ResultSet rs = statement.executeQuery(sql);
        if(rs.next()){
            address = new Address(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6));
        }        
        return address;
    }
    
    //Should return 2
    public int update(Student student, Address address) throws SQLException{    
        int pass = 0;    
        String sql = "update tblstudent set name = '"+student.getName()+"', surname = '"+student.getSurname()+"', gender = '"+student.getGender()+"'  where studentNo = " + student.getStudentNo();
        pass += statement.executeUpdate(sql);
        if(pass > 0){
            pass += statement.executeUpdate("update tbladdress set houseNo = '"+address.getHouseNo()+"',  streetName = '"+address.getStreetName()+"', city = '"+address.getCity()+"', postalCode = '"+address.getPostalCode()+"' where  studentNo = '"+student.getStudentNo()+"'");
        }        
        return pass;
    }
    
    public ArrayList<Object> retrieveAll() throws SQLException{
        ArrayList<Object> objList = new ArrayList<>();
        String sql = "select studentID, studentNo, name, surname, gender from tblstudent";        
        ResultSet rs = statement.executeQuery(sql);
        Student student = null;
        while(rs.next()){           
            student = new Student(rs.getInt(1),rs.getInt(2), rs.getString(3), rs.getString(4),rs.getString(5));
            objList.add(student);
        }
        getAddresses(objList);                
        return objList;
    }
    
    public void getAddresses(ArrayList<Object> theList) throws SQLException{
        String sql = "select addressID, studentNo, houseNo, streetName, city, postalCode from tbladdress";
        ResultSet rs = statement.executeQuery(sql);
        Address address = null;
        while(rs.next()){           
            address = new Address(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6));
            theList.add(address);
        }
    }
    
    
    
     
}
