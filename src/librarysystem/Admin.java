package librarysystem;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Saarah Packeer
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;
  
class Admin{ 
    
    // variables
    private List<User> allusers = new ArrayList<>();
    private List<Student> students = new ArrayList<>();
    private List<Librarian> librarians = new ArrayList<>();
    private List<Admin> admins = new ArrayList<>();
    private String fullname, username, password, user_type;
    //List<User> userdatabase = new ArrayList<User>();
    protected HashMap<String, String> users = new HashMap<String, String>();

    // methods
    
    public Admin(String fullname, String username, String user_type){
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        this.user_type = user_type;
        loadLibrarians(librarians);
    }
    
    
    public void setAdminName(String fullname){
        this.fullname = fullname;
    }
    
    public void setAdminUsername(String username){
        this.username = username;
    }
    
    public void setAdminPassword(String password ){
        this.password = password;
    }
    
    public void setAdminUsertype(){
        this.user_type = "Admin";
    }
    
    public void createAd(Admin a) {
        admins.add(a);                
    }
    
    
    // adds user onto list and prints on text file

    public void addStudent(Student stud, List<Student> studentdatabase) throws IOException{
        //allusers.add(user);
        students.add(stud);
        
        FileWriter file = new FileWriter("students.txt", true);
        BufferedWriter writer = new BufferedWriter(file);
        
        writer.write(stud.getFullname());
        writer.write(",");
        writer.write(stud.getUsername());
        writer.write(",");
        writer.write(stud.getPassword());
        writer.write(",");        
        writer.write(stud.getUserType());
        writer.write(",");
        writer.write(stud.getCourse());
        writer.write("\n");
        writer.flush();
        writer.close();   
        
    }
    
    
    public void writeStudentsFile(List<Student> studentdatabase) throws IOException {
        
    File file = new File("students.txt");
    if (file.exists()) {
     file.delete(); 
     }
    file.createNewFile();
    FileOutputStream fileOutput = new FileOutputStream(file);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fileOutput));
    
    List<Student> stringdatabase = new ArrayList<>();
    
        for (Student s: studentdatabase) {
            stringdatabase.add(s);
        }
        
        StringBuilder builder = new StringBuilder();
        for (Student val : stringdatabase) {
            builder.append(val+",");
        }
        String text = builder.toString();
        
        
        String[] row = text.split(",");
        
        for (int i = 0; i<row.length; i++) {
        FileWriter fille = new FileWriter("students.txt", true);
        
                String[] line = row[i].split(";");
        
                BufferedWriter writer = new BufferedWriter(fille);
                
                String readfullname = line[0];
                String readusername = line[1];
                String readpassword = line[2];
                String readusertype = line[3];                
                String course = line[4];
                    
                writer.write(readfullname);                
                writer.write(",");
                writer.write(readusername);                
                writer.write(",");
                writer.write(readpassword);                
                writer.write(",");
                writer.write(readusertype);                
                writer.write(",");
                writer.write(course);   
                writer.write("\n");
                writer.flush();
                writer.close();                              
                            
                
                }
        
    }
    
    
    public void loadStudents(List<Student> studentdatabase) {
        studentdatabase.clear();
        
        // read the file and store values into local database
        try {  
            BufferedReader br = new BufferedReader(new FileReader("students.txt"));
            Object[] Lines=br.lines().toArray();
            for(int i=0; i<Lines.length; i++) {
                
                
                String line = Lines[i].toString().trim();
                String[] row = line.split(",");
                
                String readfullname = row[0];
                String readusername = row[1];
                String readpassword = row[2];
                String readusertype = row[3];
                String readcourse = row[4];
                Student stud = new Student(readfullname, readusername, readpassword, readusertype, readcourse);   
                studentdatabase.add(stud);
                
                }
                
            
        } catch (Exception ex) {
            System.out.printf("ERROR: %s\n", ex);
        }
    }
    
    public List<Student> editStudent(String username, List<Student> studentdatabase, String  newname,String  newusername,String  newpassword,String  newcourse ) throws IOException {
        
        
        for (Student s: studentdatabase) {
            
            if (username.equals(s.getUsername())) { 
                s.setFullname(newname);
                s.setUsername(newusername);
                s.setPassword(newpassword);
                s.setCourse(newcourse);
            } 
                        
        }
        return studentdatabase;
    }
    
    
    
    public List<Student> deleteStudent(String username, List<Student> studentdatabase ) throws IOException {
        
        
        for (Iterator<Student> iterator = studentdatabase.iterator(); iterator.hasNext(); ) {           
                       
            Student value = iterator.next();
            if (username.equals(value.getUsername())) {
                iterator.remove();         
            } 
                        
        }
        return studentdatabase;
    }
    
    
    
    
    
    public void addLibrarian(Librarian lib, List<Librarian> librariandatabase) throws IOException{

        int result = bsLibrarian(lib.getUsername());

        if (result == -1) {
            System.out.println("User does not exist, registration successful.");
            librarians.add(lib);

            FileWriter file = new FileWriter("librarians.txt", true);
            BufferedWriter writer = new BufferedWriter(file);


            writer.write(lib.getFullname());
            writer.write(",");
            writer.write(lib.getUsername());
            writer.write(",");
            writer.write(lib.getPassword());
            writer.write(",");
            writer.write(lib.getUserType());
            writer.write("\n");
            writer.flush();
            writer.close();
        }
        else{
            System.out.println("This username is already taken, please try another one.");
            System.out.println("Element found at "
                    + "index " + result);
        }

    }
    
    public void writeLibrariansFile(List<Librarian> librariandatabase) throws IOException {
        
    File file = new File("librarians.txt"); 
    if (file.exists()) {
     file.delete();
     }
    file.createNewFile();
    FileOutputStream fileOutput = new FileOutputStream(file);
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fileOutput));
    
    List<Librarian> stringdatabase = new ArrayList<>();
    
        for (Librarian l: librariandatabase) {
            stringdatabase.add(l);
        }
        
        StringBuilder builder = new StringBuilder();
        for (Librarian val : stringdatabase) {
            builder.append(val+",");
        }
        String text = builder.toString();
        
        
        String[] row = text.split(",");
        
        for (int i = 0; i<row.length; i++) {
        FileWriter fille = new FileWriter("librarians.txt", true);
        
                
                String[] line = row[i].split(";");
                
                BufferedWriter writer = new BufferedWriter(fille);
                
                String readfullname = line[0];
                String readusername = line[1];
                String readpassword = line[2];
                String readusertype = line[3];
                User user = new User( readfullname,readusername, readpassword,readusertype);
                 
                writer.write(readfullname);                
                writer.write(",");
                writer.write(readusername);                
                writer.write(",");
                writer.write(readpassword);                
                writer.write(",");                
                writer.write(readusertype);  
                writer.write("\n");
                writer.flush();
                writer.close();                              
                           
                
                }
        
    }
    
    
    public void loadLibrarians(List<Librarian> librariandatabase) {
        librariandatabase.clear();
        
        // read the file and store values ingo into local database
        try {  
            BufferedReader br = new BufferedReader(new FileReader("librarians.txt"));
            Object[] Lines=br.lines().toArray();
            for(int i=0; i<Lines.length; i++) {
                
                
                String line = Lines[i].toString().trim();
                String[] row = line.split(",");
                
                String readfullname = row[0];
                String readusername = row[1];
                String readpassword = row[2];                
                String readusertype = row[3];
                Librarian lib = new Librarian(readfullname,readusername, readpassword, readusertype);   
                librariandatabase.add(lib);
                
                }
                
            
        } catch (Exception ex) {
            System.out.printf("ERROR: %s\n", ex);
        }
    }
    
    
    public List<Librarian> editLibrarian(String username, List<Librarian> librariandatabase, String  newname,String  newusername,String  newpassword) throws IOException {
        
        
        for (Librarian l: librariandatabase) {
            
            if (username.equals(l.getUsername())) { 
                l.setFullname(newname);
                l.setUsername(newusername);
                l.setPassword(newpassword);                
            } 
                        
        }
        return librariandatabase;
    }
    
    
    
    public List<Librarian> deleteLibrarian(String username, List<Librarian> librariandatabase ) throws IOException {
        
        
        for (Iterator<Librarian> iterator = librariandatabase.iterator(); iterator.hasNext(); ) {           
                       
            Librarian value = iterator.next();
            if (username.equals(value.getUsername())) {
                iterator.remove();         
            } 
                        
        }
        return librariandatabase;
    }
    
    
    
    
    
    public User getUser(String username) {
        User founduser = null;
        for (User u : allusers) {
            if (username.equals(u.getUsername())) {
                founduser = u;
            }
        }
        return founduser;
    }    
    
    public void deleteUser(String username) {
        for (User u : allusers) {
            if (username.equals(u.getUsername())) {
                allusers.remove(u);
            }
        }
    }    
    
    
    public HashMap<String, String> getUsersMap(){
        return users;
    }
    
    
    
    
    public void createLib(Librarian l) {
        librarians.add(l);                
    }
    
    public void createStud(Student s) {
        students.add(s);
    }
    
    public void editLib(Librarian l, String username, String password, String fullname) {
        l.setUsername(username);
        l.setPassword(password);
        l.setFullname(fullname);
    }
    
    public void editStud(Student s, String username, String password, String fullname, String course) {
        s.setUsername(username);
        s.setPassword(password);
        s.setFullname(fullname);
        s.setCourse(course);
    }


    public int bsLibrarian(String elementToSearch) {


        // sort
        ArrayList<String> libs = new ArrayList<>();
        for(Librarian l : librarians){
            libs.add(l.getUsername());
        }
        Collections.sort(libs);
        System.out.println("\nSorted librarians:");
        for(String s : libs ) {
            System.out.println(s);
        }

        int l = 0, r = libs.size() - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;

            int res = elementToSearch.compareTo(libs.get(m));

            // Check if x is present at mid
            if (res == 0)
                return m;

            // If x greater, ignore left half
            if (res > 0)
                l = m + 1;

                // If x is smaller, ignore right half
            else
                r = m - 1;
        }

        return -1;

    }


    public ArrayList<Librarian> searchLib(String username) {
        ArrayList<Librarian> librariansfound = new ArrayList<Librarian>();
        for (Librarian l : librarians) {
            if (username.equals(l.getUsername())) {
                librariansfound.add(l);
            }
        }
        return librariansfound;
    }
    
    
    public ArrayList<Student> searchStudent(String username) {
        ArrayList<Student> studentsfound = new ArrayList<Student>();
        for (Student s : students) {
            if (username.equals(s.getUsername())) {
                studentsfound.add(s);
            }
        }
        return studentsfound;
    }
    
   

    
    public void deleteLib(String username) {
        for (Librarian l : librarians) {
            if (username.equals(l.getUsername())) {
                librarians.remove(l);
            }
        }
    }
    
    public void deleteLibrarian(String username) {
        Librarian result = null;
        for (Librarian lib : librarians) {
            if (username.equals(lib.getUsername())) {
                result = lib;
                librarians.remove(lib);
            }
        }
        //return result;
    }
    
    
    
    public void deleteStud(String username) {
        for (Student s : students) {
            if (username.equals(s.getUsername())) {
                students.remove(s);
            }
        }
    }
    
    
        

    public String returnLibrarians() {
        String total = "\n";
        
        for (int i = 0; i<librarians.size(); i++) {
            Librarian l = librarians.get(i); // gets book at position i
            total = total + l;
        } 
        
        
        return total;
               
    }


    public String returnStudents() {
        String total = "\n";
        
        for (int i = 0; i<students.size(); i++) {
            Student l = students.get(i); // gets book at position i
            total = total + l;
        } 
        
        
        return total;
               
    }
    
    
    
    @Override
    public String toString(){
        return fullname+","+username+","+user_type+"\n";
    }
        
    
    
  

} 