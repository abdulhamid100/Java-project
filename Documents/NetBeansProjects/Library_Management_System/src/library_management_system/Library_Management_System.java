
package library_management_system;

import java.util.Scanner;

public class Library_Management_System {

  
    public static void main(String[] args) {
        
         welcomepanel();
           
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        switch(input){
            case 1 -> {
               
               logadminpanel(); 
                break;
            }
            case 2 -> {
               logstudentpanel();
                break;
            }
            default -> 
            {
                System.out.println("    Please Enter the right input");
                break;
            }
       
          }
        

        
    }
    
    
    static void welcomepanel(){
        
         System.out.println("          Welcome to Login Panel         \n");
        System.out.println("               Login As  ");
        System.out.println("");
        System.out.println("               1.Admin");
        System.out.println("               2.Student\n\n");
        
    }
    static void logadminpanel(){
                Scanner sc = new Scanner(System.in);

        System.out.println("\n\n");
                System.out.println("         Welcome Admin");
                System.out.println("");
                System.out.println("Please Enter The Username and Password");
                System.out.println("");
                
                System.out.print("   Username: ");
                String userad = sc.next();
                System.out.println("");
                System.out.print("   Password: ");
                String passad = sc.next();
              
                if("hamid".equals(userad) && "hamid".equals(passad))
                {
                    AdminPanel();
                }
                else{
                    System.out.println("\n\nWrong Username or Password");
              
                   
                }
    }
    static void logstudentpanel(){
                Scanner sc = new Scanner(System.in);

        System.out.println("\n\n");
                System.out.println("         Welcome Student");
                System.out.println("");
                System.out.println("Please Enter The Username and Password");
                System.out.println("");
                
                System.out.print("   Username: ");
                String userad = sc.next();
                System.out.println("");
                System.out.print("   Password: ");
                String passad = sc.next();
              
                if("hamid".equals(userad) && "hamid".equals(passad))
                {
                    StudentPanel();
                }
                else{
                    System.out.println("\n\nWrong Username or Password");

                }
    }

    static void AdminPanel() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\nPlease Select a Option\n");
        System.out.println("1.Show Books by Id With Name");
        System.out.println("2.Add Book");
        System.out.println("3.Remove Book");
        System.out.println("4.Edit Book");
        System.out.println("5.Search Book");
        System.out.println("6.Issue Book");
        
        int x = sc.nextInt();
        switch(x){
            case 1 ->{
                show();
            
                break;
            }
            case 2 -> {
               add_book();
           

               break;
            }
            case 3 ->{
                remove_book();
       

                break;
            }
            case 4 ->{
                edit_book();
               

                break;
            }
            case 5 ->{
                search_book();
              

                break;
            }
            case 6 ->{
                issue_book();
                

                break;
            }
            default ->{
                System.out.println("Please Enter Right input");

                break;
            }
            
            
        }
    }

    static void StudentPanel() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n\nPlease Select a Option\n");
        System.out.println("1.Show Books by Id With Name");
        System.out.println("2.Search book");
        int x = sc.nextInt();
        switch(x)
        {
            case 1 ->{
                show();

                break;
            }
            case 2 ->{
                search_book();

                break;
            }         
            default ->{
                System.out.println("Please Enter Right Input");
         
                break;
            }
        }
        
    }
    
    static void show() {
       MySQLDatabase db = new MySQLDatabase();  //Create a object of MySQLDatabase
       db.readData();
    }

    static void add_book() {
      MySQLDatabase db = new MySQLDatabase();
      db.addbook();
    }
    static void remove_book() {
         MySQLDatabase db = new MySQLDatabase();
         db.deletebook();
    }
    static void edit_book() {
         MySQLDatabase db = new MySQLDatabase();
         db.editbook();
    }
    static void search_book() {
        MySQLDatabase db = new MySQLDatabase();
        db.searchbook();
    }
    static void issue_book() {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("1.Show issue books");
        System.out.println("2.Add issue books");
        System.out.println("3.Romove issue book");
        int x = sc.nextInt();
        switch(x)
        {
            case 1 ->{
                showissuebooks();
                break;
            }
            case 2 ->{
                addissuebooks();
                break;
            }
            case 3 ->{
                removeissuebook();
                break;
            }
            default ->
            {
                System.out.println("Enter the right input");
                break;
            }
        }
        
    }
    
    static void showissuebooks()
    {
         MySQLDatabase db = new MySQLDatabase();
         db.showissuebooks();
    }
    static void addissuebooks()
    {
        MySQLDatabase db = new MySQLDatabase();
        db.addissuebook();

    }
    static void removeissuebook()
    {
        MySQLDatabase db = new MySQLDatabase();
        db.removeissuebook();
    }
}
