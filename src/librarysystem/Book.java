/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysystem;

/**
 *
 * @author Saarah Packeer
 */
public class Book {
    private String title, author, edition, terms, pubdate, location, status;
    private String isbn;
    
    public Book(String isbn, String title, String author, String edition, String pubdate, String terms, String location, String status) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.edition = edition;
        this.pubdate = pubdate;
        this.terms = terms;
        this.location = location;
        this.status = status;
    }
    
    public void setISBN(String isbn){
       this.isbn = isbn;
    }
    
    public String getISBN(){
        return isbn;
    }
    
    public void setTitle(String title){
       this.title = title;
    }
    
    public String getTitle(){
        return title;
    }
    
    public void setAuthor(String author){
       this.author = author;
    }
    
    public String getAuthor(){
        return author;
    }
    
    public void setEdition(String edition){
       this.edition = edition;
    }
    
    public String getEdition(){
        return edition;
    }
    
    public void setPubdate(String pubdate){
       this.pubdate = pubdate;
    }
    
    public String getPubdate(){
        return pubdate;
    }
    
    public void setTerms(String terms){
       this.terms = terms;
    }
    
    public String getTerms(){
        return terms;
    }   
    
    public void setLocation(String location){
       this.location = location;
    }
    
    public String getLocation(){
        return location;
    }  
        
    public void setStatus(String status){
       this.status = status;
    }
    
    public String getStatus(){
        return status;
    }  
    
    @Override
    public String toString(){
        return isbn+ ";" + title + ";" + author + ";"  + edition + ";" +  pubdate + ";" + terms + ";" + location+ ";" + status;
    }
}
