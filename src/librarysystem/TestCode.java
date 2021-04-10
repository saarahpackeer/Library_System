/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysystem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Saarah Packeer
 */
public class TestCode {
    
        
    
    
        public void testCode() throws IOException{
            
        String[] values = new String[7];
        List<Book> bookdatabase = new ArrayList<Book>();
        List<User> userdatabase = new ArrayList<User>(); 
        List<Student> studentdatabase = new ArrayList<Student>();
        List<Librarian> librariandatabase = new ArrayList<Librarian>();
        List<String> books = new ArrayList<String>();
        List<String> wordList = new ArrayList<String>();  
        
        // admin obj
        Admin ad = new Admin("Jack Williams", "Jack", "Admin");
        
        // librarian obj
        Librarian l1 = new Librarian("Edwin Santana", "ed282","pass",  "librarian");
        Librarian l2 = new Librarian("Kristin Masons", "kmanson22","pass", "librarian");
        Librarian l3 = new Librarian("Reiss Rodrigues", "reis992","pass", "librarian");
        Librarian l4 = new Librarian("Hugh Rodgers", "hr544","pass", "librarian");
        Librarian l5 = new Librarian("Daisy Sherman", "daisy98","pass", "librarian");
        Librarian l6 = new Librarian("Camille Goldsmith", "cgoldsmith54","pass", "librarian");
        Librarian l7 = new Librarian("Marvin Wheeler", "marvin8","pass", "librarian");
        
        ad.addLibrarian(l1, librariandatabase);
        ad.addLibrarian(l2, librariandatabase);
        ad.addLibrarian(l3, librariandatabase);
        ad.addLibrarian(l4, librariandatabase);
        ad.addLibrarian(l5, librariandatabase);
        ad.addLibrarian(l6, librariandatabase);
        ad.addLibrarian(l7, librariandatabase); 
        
        
        // student obj
        
        Student s1 = new Student("Scott Hutchinson", "scotth322","pass", "Student", "Computer Science");
        Student s2 = new Student("Tamera Cross", "tcross3","pass", "Student", "Commerce");
        Student s3 = new Student("Ed Ellwood", "ed212","pass", "Student", "Civil Engineering");
        Student s4 = new Student("Daniela Prince", "danielap3","pass", "Student", "Electrical Engineering");
        Student s5 = new Student("Lydia Joseph", "lydia9","pass", "Student", "Accounting");
        Student s6 = new Student("Liyana Hayward", "lhayward93","pass", "Student", "Law");
        Student s7 = new Student("Maxim Mcpherson", "maxim3","pass", "Student", "Computer Science");
        
        
        ad.addStudent(s1, studentdatabase);
        ad.addStudent(s2, studentdatabase);
        ad.addStudent(s3, studentdatabase);
        ad.addStudent(s4, studentdatabase);
        ad.addStudent(s5, studentdatabase);
        ad.addStudent(s6, studentdatabase);
        ad.addStudent(s7, studentdatabase);
        
       
        //book objs
        Book b1 = new Book("0812994523", "Just Mercy: A Story of Justice and Redemption", "Bryan Stevenson", "Spiegal & Grau", "2014", "Nonfiction>Memoir>Social Justice>Politics>Law", "Wollongong Level 1", "Available");
        Book b2 = new Book("0425284689", "Before We Were Yours", "Lisa Wingate", "Ballantine Books", "2017", "Historical Fiction","Wollongong Level 1","Reserved");
        Book b3 = new Book("9780143035695", "In the Miso Soup", "Ryo Murakami", "Penguin", "2006", "Fiction>Horror>Cultural>Japan>Asian Literature>Thriller>Mystery>Crime", "Wollongong Level 2", "Available");
        Book b4 = new Book("1570620199 ", "The Sound of Water Haiku", "Sam Hamill", "Shambhala", "2006", "Poetry>Cultural>Japan>Japanese Literature", "Wollongong Level 2", "Reserved");
        Book b5 = new Book("1933633778", "The Lake", "Banana Yoshimoto", "Melville House", "2011", "Fiction>Cultural>Asian Literature", "Wollongong Level 2", "Available");
        Book b6 = new Book("0143058142", "Crime and Punishment", "Fyodor Dostoyevsky", "Penguin", "2002", "Classics>Fiction>Cultural>Russian Literature", "Wollongong Level 2", "Reserved");
        Book b7 = new Book("0770436420", "The Constellation of Vital Phenomena", "Anthony Marra", "Hogarth", "2014", "Fiction>Historical Fiction>War>Russia", "Wollongong Level 2", "Reserved");
        
        //librarian object uses librarian methods to add books onto bookcollection
        l1.addBook(b1, bookdatabase);
        l1.addBook(b2, bookdatabase);
        l1.addBook(b3, bookdatabase);
        l1.addBook(b4, bookdatabase);
        l1.addBook(b5, bookdatabase);
        l1.addBook(b6, bookdatabase);
        l1.addBook(b7, bookdatabase);
       

    }
    
}
