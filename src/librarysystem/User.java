/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysystem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Saarah Packeer
 */
public class User {
    
    // declare variables
    
    protected String fullname, username, password, user_type;
    protected List<User> getuser;
    
    public User(String fullname, String username, String password, String user_type) {
        this.fullname = fullname;
        this.username = username;
        this.password = password;
        this.user_type = user_type;
    }
    
    // getter setter encapsulation methods
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    
    public String getFullname() {
        return fullname;
    }
    
    public void setUserType(String password) {
        this.user_type = user_type;
    }
    
    public String getUserType() {
        return user_type;
    }   
    
    
    public void setCourse(String course) {
        
    }
    
    public String getCourse(){
        return null;
    }
    
    
    public User getUser(String username) {
        User founduser = null;
        for (User u : getuser) {
            if (username.equals(u.getUsername())) {
                founduser = u;
            }
        }
        return founduser;
    }
    
    @Override
    public String toString(){
        return "\nUsername: " + username + "\nFull Name: " + fullname +"\nUser account: "+user_type+"\n";
    }
    


}
