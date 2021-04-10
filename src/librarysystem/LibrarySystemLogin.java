/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysystem;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Saarah Packeer
 */
public class LibrarySystemLogin extends javax.swing.JFrame {


    // vars ////

    // * User objects to initialize arraylists

    Librarian l = new Librarian("jack", "Jack Will", "pass", "Librarian");
    Admin a = new Admin("Jack Williams", "Jack", "Librarian");

    // * local database to store users

    List<Student> studentdatabase = new ArrayList<Student>();
    List<Librarian> lib_db = new ArrayList<Librarian>();
    List<Admin> admin_db = new ArrayList<Admin>();
    List<Book> bookdatabase = new ArrayList<Book>();
    HashMap<String, String> usermap = new HashMap<String, String>();

    /**
     * Creates new form LibrarySystemLogin
     */
    public LibrarySystemLogin() throws IOException {

        initComponents();

        //load db
        l.loadBooks(bookdatabase);
        a.loadStudents(studentdatabase);
        a.loadLibrarians(lib_db);

        printInfo();
        //a.addLibrarian(new Librarian("Matt Lewis", "ml009", "password", "Librarian"), lib_db);
        //printInfo();

        for(Librarian l: lib_db) {
            usermap.put(l.getUsername(), l.getPassword());
        }
        for(Student s: studentdatabase) {
            usermap.put(s.getUsername(), s.getPassword());
        }

        // 2. For-each loop
        System.out.println("All users:");
        for (String key: usermap.keySet()) {
            System.out.println(key);
        }


    }

    public void printInfo() throws IOException {
        //prnt onto console current system state (books + users)
        System.out.println();
        System.out.println("* Current books in the database.\n");
        for(Book book :bookdatabase){
            System.out.println(book.getTitle());
        }
        System.out.println();
        System.out.println("* Current students in the database.\n");
        for(Student student :studentdatabase){
            System.out.println(student.getUsername());
        }
        System.out.println();
        System.out.println("* Current librarians in the database.\n");
        for(Librarian l :lib_db){
            System.out.println(l.getUsername());
        }



    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        studB1 = new javax.swing.JButton();
        libB1 = new javax.swing.JButton();
        adminB1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        studB1.setText("Student");
        studB1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studB1MouseClicked(evt);
            }
        });

        libB1.setText("Librarian");
        libB1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                libB1MouseClicked(evt);
            }
        });

        adminB1.setText("Admin");
        adminB1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                adminB1MouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 99, 72));
        jLabel8.setText("Library System Home");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(adminB1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(libB1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(studB1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(142, 142, 142))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(118, 118, 118)
                .addComponent(jLabel8)
                .addContainerGap(115, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel8)
                .addGap(33, 33, 33)
                .addComponent(studB1)
                .addGap(18, 18, 18)
                .addComponent(libB1)
                .addGap(18, 18, 18)
                .addComponent(adminB1)
                .addContainerGap(51, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void studB1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studB1MouseClicked
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentLoginRegister().setVisible(true);
            }
        });
    }//GEN-LAST:event_studB1MouseClicked

    private void libB1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_libB1MouseClicked
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LibrarianLoginRegister().setVisible(true);
            }
        });
    }//GEN-LAST:event_libB1MouseClicked

    private void adminB1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_adminB1MouseClicked
        // TODO add your handling code here:
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminLoginRegister().setVisible(true);
            }
        });
    }//GEN-LAST:event_adminB1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LibrarySystemLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LibrarySystemLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LibrarySystemLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LibrarySystemLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adminB1;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton libB1;
    private javax.swing.JButton studB1;
    // End of variables declaration//GEN-END:variables
}