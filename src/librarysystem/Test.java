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
import java.util.List;

/**
 *
 * @author Saarah Packeer
 */
public class Test  {
    
    private static TestCode test = new TestCode();

    
    public static void clearAll(String textfile) throws IOException {
            File file = new File(textfile);  
            if (file.exists()) {
            file.delete(); 
            }
            file.createNewFile();
            FileOutputStream fileOutput = new FileOutputStream(file);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fileOutput));
        }
    
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        clearAll("books.txt");
        clearAll("students.txt");
        clearAll("librarians.txt");
        clearAll("reservedbooksreport.txt");
        test.testCode();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new LibrarySystemLogin().setVisible(true);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
       
        
    }
    

    
}
