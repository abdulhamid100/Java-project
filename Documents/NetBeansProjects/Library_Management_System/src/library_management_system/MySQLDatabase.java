
package library_management_system;


import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Scanner;

public class MySQLDatabase {
  
   private Connection connect = null; 
   private Statement statement = null; 
   private PreparedStatement preparedstatement = null; 
   private ResultSet result = null; 
   Scanner sc = null;
    
  void readData(){
          
         try { 
           connect = ApClient.getInstance();
          // sc = new Scanner(System.in);
         statement = connect.createStatement();
         result = statement.executeQuery("SELECT *FROM library_management_system.add_book");
          
         //preparedstatement = connect.prepareStatement("SELECT name,id,cell FROM donor_info WHERE student_id - ?");
         //preparedstatement.setString(1,sc.next());
         //preparedstatement.executeQuery();
         while(result.next())
         {
             System.out.println("book Id: "+result.getString("book_id")+" book name: "+result.getString("book_name"));
           //  System.out.println("id: " +result.getString("id"));
            // System.out.println("cell: "+result.getString("cell"));
         }
  
         }
         
         catch(ClassNotFoundException | SQLException e){
             
         }
         finally{
                    ApClient.close();
         }
  }
  void addbook(){
          
         try { 
           connect = ApClient.getInstance();
           sc = new Scanner(System.in);

             System.out.println("\nPlease Enter The Book Name That You Want to Add in The Library");
             final String name = sc.nextLine();
             preparedstatement = connect.prepareStatement("INSERT INTO add_book(book_name)values('"+name+"')");
             preparedstatement.executeUpdate();
             System.out.println("completed");
       
         }
         
         catch(ClassNotFoundException | SQLException e){
             
         }
         finally{
                    ApClient.close();
         }
  }
  
  
  void searchbook(){
          
         try { 
           connect = ApClient.getInstance();
           sc = new Scanner(System.in);
          
         preparedstatement = connect.prepareStatement("SELECT book_id FROM add_book WHERE book_name = ?;");
         System.out.print("Enter the book name, thar you are looking for: ");
         preparedstatement.setString(1,sc.nextLine());
         result = preparedstatement.executeQuery();
         while(result.next())
         {
             System.out.println("book Id is: "+result.getString("book_id"));
           
         }
  
         }
         
         catch(ClassNotFoundException | SQLException e){
             
         }
         finally{
                    ApClient.close();
         }
  }
  void editbook(){
          
         try { 
           connect = ApClient.getInstance();
           sc = new Scanner(System.in);
         
         preparedstatement = connect.prepareStatement("UPDATE add_book SET book_name = ? WHERE book_id = ?");
         System.out.print("Enter the new book name: ");
         preparedstatement.setString(1,sc.nextLine());
         System.out.print("\nEnter the existing Id: ");
         preparedstatement.setString(2,sc.nextLine());
         preparedstatement.executeUpdate();
  
         }
         
         catch(ClassNotFoundException | SQLException e){
             
         }
         finally{
                    ApClient.close();
         }
  }  
  void deletebook(){
          
         try { 
           connect = ApClient.getInstance();
           sc = new Scanner(System.in);
         
         preparedstatement = connect.prepareStatement("DELETE FROM add_book WHERE book_id = ?");
         System.out.print("Enter the book id to delete the book from library management system ");
         preparedstatement.setString(1,sc.nextLine());
         preparedstatement.executeUpdate();
  
         }
         
         catch(ClassNotFoundException | SQLException e){
             
         }
         finally{
                    ApClient.close();
         }
  }
  
   void showissuebooks(){
          
         try { 
           connect = ApClient.getInstance();
         statement = connect.createStatement();
         result = statement.executeQuery("SELECT *FROM library_management_system.issue_book");
          
       
         while(result.next())
         {
             System.out.println("Student Id: "+result.getString("student_id")+"  Book Id: "+result.getString("book_id")+"  Start Date: "+result.getString("start_date")+"  Last Date: "+result.getString("last_date"));
        
         }
  
         }
         
         catch(ClassNotFoundException | SQLException e){
             
         }
         finally{
                    ApClient.close();
         }
  }
   
   void addissuebook(){
          
         try { 
           connect = ApClient.getInstance();
           sc = new Scanner(System.in);
             preparedstatement = connect.prepareStatement("INSERT INTO issue_book values(?,?,?,?)");
             //System.out.print("\nStudent Id: ");
             int id = sc.nextInt();
             preparedstatement.setInt(1, id);
             //System.out.print("\nBook Id: ");
             int idd = sc.nextInt();
              preparedstatement.setInt(2,idd);
             //System.out.print("\nStarting Date: ");
             //final String sss = sc.nextLine();
              preparedstatement.setString(3,"1 january");
             //System.out.print("\nFinish Date: ");
              String name1 = sc.nextLine();
              preparedstatement.setString(4, name1);

             preparedstatement.executeUpdate();
       
         }
         
         catch(ClassNotFoundException | SQLException e){
             
         }
         finally{
                    ApClient.close();
         }
  }
   void removeissuebook(){
          
         try { 
           connect = ApClient.getInstance();
           sc = new Scanner(System.in);
         
         preparedstatement = connect.prepareStatement("DELETE FROM issue_book WHERE book_id = ?");
         System.out.print("Enter the book id to delete the book from issue system");
         preparedstatement.setString(1,sc.nextLine());
         preparedstatement.executeUpdate();
  
         }
         
         catch(ClassNotFoundException | SQLException e){
             
         }
         finally{
                    ApClient.close();
         }
  }
 
}