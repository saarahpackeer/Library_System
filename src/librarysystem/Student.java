/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysystem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 *
 * @author Saarah Packeer
 */

/* Student extends User */

public class Student extends User{

    private String course;
    //private HashMap<String, String>students = new HashMap<String, String>();
    
    public Student(String fullname, String username, String password, String user_type, String course){
        super(fullname, username, password, user_type);
        this.course = course;

    }
    
    @Override
    public String getCourse(){
        return course;
    }
    @Override
    public void setCourse(String course){
        this.course = course;
    }
    
    @Override
    public String toString(){
        return fullname+";"+username+";"+password+";"+user_type+";"+course;   //+"\n";
    }
    

}
