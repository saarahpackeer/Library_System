/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysystem;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Saarah Packeer
 */
public class Librarian extends User{
    
    private List<Book> bookcollection;
    private List<Book> studentreservedbooks;
    private HashMap<String, String>users = new HashMap<String, String>();
    String[] values = null;
    String line= null;
    String grade, stud, mark;
    List<Book> bookdatabase = new ArrayList<Book>();
    List<String> books = new ArrayList<String>();
    
    // load variables from superclass and declare bookcollection as an arraylist of books
    
    public Librarian(String fullname, String username, String password, String user_type){
        super(fullname, username, password, user_type);
        bookcollection = new ArrayList<Book>();
    }
    
    // returns arraylist
    public List<Book> getBookCollection() {
        return bookcollection;
    }

    
    public void addUser(User u){
        users.put(u.getUsername(), u.getPassword());
    }
    

    
    public HashMap<String, String> getUsersMap() {
        return users;
    }
    
    
    // add book to bookcollection based on entered book and saves into text file
    
    public void addBook(Book book, List<Book> bookdatabase) throws IOException {
        
        bookdatabase.add(book);
        
        
        FileWriter file = new FileWriter("books.txt", true);
        BufferedWriter writer = new BufferedWriter(file);
        
        writer.write(book.getISBN());
        writer.write(",");
        writer.write(book.getTitle());
        writer.write(",");
        writer.write(book.getAuthor());
        writer.write(",");
        writer.write(book.getEdition());
        writer.write(",");
        writer.write(book.getPubdate());
        writer.write(",");
        writer.write(book.getTerms());
        writer.write(",");
        writer.write(book.getLocation());
        writer.write(",");
        writer.write(book.getStatus());
        writer.write("\n");
        writer.flush();
        writer.close();       
        
        
    }
    
    // takes values from the local database and makes a new text file for books.txt after deleting / reserving a record
    
    public void writeFile(List<Book> bookdatabase) throws IOException {
    
    //delets file contents
    
    File file = new File("books.txt");  
    if (file.exists()) {
        file.delete(); 
    }
    file.createNewFile();
    FileOutputStream fileOutput = new FileOutputStream(file);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fileOutput));
    
    List<Book> stringdatabase = new ArrayList<>();
    
        for (Book b: bookdatabase) {
            stringdatabase.add(b);
        }
        
        StringBuilder builder = new StringBuilder();
        for (Book val : stringdatabase) {
            builder.append(val+",");
        }
        String text = builder.toString();
        
        
        String[] row = text.split(",");
        
        for (int i = 0; i<row.length; i++) {
        FileWriter fille = new FileWriter("books.txt", true);
        
                String[] line = row[i].split(";");
        
                BufferedWriter writer = new BufferedWriter(fille);
                
                
                String readisbn = line[0];
                String readtitle = line[1];
                String readauthor = line[2];
                String readedition = line[3];
                String readpubdate = line[4];
                String readterms = line[5];
                String readlocation = line[6];
                String readstatus = line[7];
                
                Book book = new Book(readisbn, readtitle, readauthor, readedition, readpubdate, readterms, readlocation, readstatus);                
                               
                
                writer.write(readisbn);                
                writer.write(",");
                writer.write(readtitle);                
                writer.write(",");
                writer.write(readauthor);                
                writer.write(",");
                writer.write(readedition);                
                writer.write(",");
                writer.write(readpubdate);                
                writer.write(",");
                writer.write(readterms);                
                writer.write(",");
                writer.write(readlocation);                
                writer.write(",");
                writer.write(readstatus);   
                writer.write("\n");
                writer.flush();
                writer.close();
                }
        
    }
    
    
    
    public void loadBooks(List<Book> bookdatabase) {
        bookdatabase.clear();
        
        // read the file and store values to local database
        try {  
            BufferedReader br = new BufferedReader(new FileReader("books.txt"));
            Object[] Lines=br.lines().toArray();
            for(int i=0; i<Lines.length; i++) {
                
                
                String line = Lines[i].toString().trim();
                String[] row = line.split(",");
                
                String readisbn = row[0];
                String readtitle = row[1];
                String readauthor = row[2];
                String readedition = row[3];
                String readpubdate = row[4];
                String readterms = row[5];
                String readlocation = row[6];
                String readstatus = row[7];
                
                Book book = new Book(readisbn, readtitle, readauthor, readedition, readpubdate, readterms, readlocation, readstatus);                
                
                bookdatabase.add(book);
                
                
                
            }
                
            
        } catch (Exception ex) {
            System.out.printf("ERROR: %s\n", ex);
        }
    }
    
    
    
    
    
    public List<Book> deleteStuff(String isbn, List<Book> bookdatabase ) throws IOException {
        
        
        for (Iterator<Book> iterator = bookdatabase.iterator(); iterator.hasNext(); ) {
            
                       
            Book value = iterator.next();
            if (isbn.equals(value.getISBN())) {
                iterator.remove();         
            } 
                        
        }
        return bookdatabase;
    }
    
    
    // reserves a book based on selection
    
    public List<Book> reserveBook(String isbn, List<Book> bookdatabase, String user) throws IOException {
        
        List<Book> stringdatabase = new ArrayList<>();
        
        for (Book b : bookdatabase) {

            if (isbn.equals(b.getISBN())  &&  b.getStatus().equals("Available")) {
                b.setStatus("Reserved");         
                                
                stringdatabase.add(b);       
                
                FileWriter file = new FileWriter("reservedbooksreport.txt", true);
                BufferedWriter writer = new BufferedWriter(file);
                writer.write("The book ");
                writer.write(b.getTitle());
                writer.write(", ISBN Number ");
                writer.write(b.getISBN());
                writer.write(", was reserved by user ");
                writer.write(user);
                writer.write(".");
                writer.write("\n");
                writer.flush();
                writer.close();

                System.out.println("The book " + b.getTitle() + ", ISBN " + b.getISBN()  +" was reserved by user " + user +".\n");
                JOptionPane.showMessageDialog(new JFrame(), "Book successfully reserved!");
                break;
            } else if (isbn.equals(b.getISBN())  && b.getStatus().equals("Reserved")){
                System.out.println("Sorry, but " + b.getTitle() + " is currently reserved.");
                JOptionPane.showMessageDialog(new JFrame(), "Sorry, but " + b.getTitle() + " is currently reserved.");
                break;
            } else {
                System.out.println("Sorry, but this book does not exist in our database");
                JOptionPane.showMessageDialog(new JFrame(), "Sorry, but this book does not exist in our database.");
                break;
            }
        }
        return bookdatabase;
    }
    
    
    
    public List<String> loadReservedBooks(List<String> reservedbookdatabase) {
        reservedbookdatabase.clear();
        
        // read the file and store values
        try {  
            BufferedReader br = new BufferedReader(new FileReader("reservedbooksreport.txt"));
            Object[] Lines=br.lines().toArray();
            for(int i=0; i<Lines.length; i++) {
                
                
                String line = Lines[i].toString().trim();
                                
                
                reservedbookdatabase.add(line);              
                
            }
                
            
        } catch (Exception ex) {
            System.out.printf("ERROR: %s\n", ex);
        }
        
        return reservedbookdatabase;
    }
    
    
    
    
    public List<Book> editBook(String isbn, List<Book> bookdatabase, String  newisbn,String  newtitle,String  newauthor,String  newedition,String  newpubdate,String  newterms,String  newlocation,String  newstatus ) throws IOException {
        
        
        for (Book b: bookdatabase) {
            
            if (isbn.equals(b.getISBN())) { 
                b.setISBN(newisbn);
                b.setTitle(newtitle);
                b.setAuthor(newauthor);
                b.setEdition(newedition);
                b.setPubdate(newpubdate);
                b.setTerms(newterms);
                b.setLocation(newlocation);
                b.setStatus(newstatus);
            } 
                        
        }
        return bookdatabase;
    }
    
    
    
    
 
    
    
    @Override
    public String toString(){
        return fullname+";"+username+";"+password+";"+user_type;
    }
    
    

    
} // end of Librarian class
