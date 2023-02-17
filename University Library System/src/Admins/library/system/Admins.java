/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Admins.library.system;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class Admins {
    private static int ch2;
    int aid;
    String aname;
    String apassword;
    static JFrame f1, f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12,f13,f14,f15,f16,f17,f18,f19,f20,f21;
    static JButton register,Viewi,View,search,issue,returnb,deletebook,read,coding,insertbook,deletead,deletelib,deletestd,insertad,insertlib,insert,admin,librarian,login,ad1,ad2,ad3,ad4,ad5,ad6,lib1,lib2,lib3,lib4,lib5,lib6,lib7,lib8,lib9,lib10;
    

    public Admins() {
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public void setApassword(String apassword) {
        this.apassword = apassword;
    }

    public int getAid() {
        return aid;
    }

    public String getAname() {
        return aname;
    }

    public String getApassword() {
        return apassword;
    }

    //Objects

    
    student s2= new student();
    Scanner s1=new Scanner(System.in);
    Scanner s=new Scanner(System.in);
    Librarians l=new Librarians();

    //Add Student
    public void add_student(String n,String id1,String birth,String mobile,String email) throws IOException{

        System.out.print("Enter student name: ");
        
        s2.setName(n);
        if(n.matches("[a-zA-Z]+")){
            System.out.print("Enter student ID: ");
            int id=Integer.parseInt(id1);
            s2.setId(id);
            
            if(!(search_student_id("C:\\Users\\Lapshop\\Desktop\\student.txt", Integer.toString(id)))){
                System.out.print("Enter student mobile: ");
                
                s2.setMobile(mobile);
                if(mobile.matches("[0-9]+")){
                    System.out.print("Enter student birthday: ");
                    
                    s2.setBirthday(birth);
                    System.out.print("Enter student email: ");
                   
                    s2.setEmail(email);
                    try{  
                        Writer output;
                        output = new BufferedWriter(new FileWriter("C:\\Users\\Lapshop\\Desktop\\student.txt",true));  //clears file every time
                        output.append(s2.getName()+" "+s2.getId()+" "+s2.getBirthday()+" "+s2.getMobile()+" "+s2.getEmail()+"\n");
                        output.close();
                        //fw.close();    
                    }catch(Exception e){System.out.println(e);}
                }
                else{
                    System.out.println("The student mobile number is not a number!");
                }
                
            }
            else{
                System.out.println("ID already exists!\n");
            }
        }
        else{
            System.out.println("The name doesn't conatin only characters!");
        }
        
        
    }

    //Search Student ID

    public boolean search_student_id(String path, String object) throws IOException{
        
        String filecontents = "";
        
        try{

            FileInputStream fstream = new FileInputStream(path);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader sc = new BufferedReader(new InputStreamReader(in));

            while((filecontents = sc.readLine()) != null){
                String[] tokens = filecontents.split(" ");
                
                if(tokens[1].contains(object)){
                    return true;
                }
            }
            sc.close();
            
        }
        catch(FileNotFoundException e){
            System.out.println(e);

        }
        return false;

    }

    //Remove Student

    public static void remove(String filepath, String removeterm,int position,String delimiter) throws IOException{
        int position2= position-1;
        String tempfile="temp.txt";
        File oldFile= new File(filepath);
        File newFile= new File(tempfile);
        
        String currentline;
        String data[];
        try{
            FileWriter fw=new FileWriter(tempfile,true);
            BufferedWriter bw=new BufferedWriter(fw);
            PrintWriter pw= new PrintWriter(bw);
            
            FileReader fr= new FileReader(filepath);
            BufferedReader br= new BufferedReader(fr);
            while((currentline= br.readLine())!= null){
                data= currentline.split(" ");
                if (!(data[position2].equalsIgnoreCase(removeterm))){
                    pw.println(currentline);
                }
            }
            pw.flush();
            pw.close();
            fr.close();
            br.close();
            bw.close();
            fw.close();  
            oldFile.delete();
            File dump = new File(filepath);
            newFile.renameTo(dump);
        }
        catch(Exception e){
            
        }
    }

    //Remove Sutdent ------------------
    public void remove_student(String i) throws IOException{
        int ID=Integer.parseInt(i);
        String id2=Integer.toString(ID);
        remove("C:\\Users\\Lapshop\\Desktop\\student.txt",id2,2," ");
        System.out.print("Done"+'\n');
    }
    
    //Add Libarian -------------------------

    public void add_libarian(String n, String i, String p) throws IOException{
        
        l.setName(n);
        if(n.matches("[a-zA-Z]+")){
            int idl=Integer.parseInt(i);
            l.setId(idl);
           

            if(!(search_student_id("C:\\Users\\Lapshop\\Desktop\\librarian.txt", Integer.toString(idl)))){
               
                l.setPassword(p);
                try{  
                    Writer outputt;
                    outputt = new BufferedWriter(new FileWriter("C:\\Users\\Lapshop\\Desktop\\librarian.txt",true));  //clears file every time
                    outputt.append(l.getName()+" "+l.getId()+" "+l.getPassword()+'\n');
                    // output.append("\n");
                    outputt.close();
                //fw.close();    
                }catch(Exception e){System.out.println(e);} 
            }
            else{
                System.out.println("ID already exists!\n");
            }
        }
        System.out.println("The name doesn't conatin only characters!");
        
        
    }
    
    public void remove_libarian(String i) throws IOException{
        int IDl=Integer.parseInt(i);
        String id3=Integer.toString(IDl);
        remove("C:\\Users\\Lapshop\\Desktop\\librarian.txt",id3,2," ");
        System.out.print("Done"+'\n');
        
    }
    
    //Add Admins
    public void add_admin(String n, String i, String pass) throws IOException{
       
       
        setAname(n);
        if(n.matches("[a-zA-Z]+")){
            int ida=Integer.parseInt(i);
            setAid(ida);
        
            if(!(search_student_id("C:\\Users\\Lapshop\\Desktop\\admin.txt", Integer.toString(ida)))){
 
                setApassword(pass);
                try{  
                    Writer ot;
                    ot = new BufferedWriter(new FileWriter("C:\\Users\\Lapshop\\Desktop\\admin.txt",true));  //clears file every time
                    ot.append(getAname()+" "+getAid()+" "+getApassword()+'\n');
                    // output.append("\n");
                    ot.close();
                    //fw.close();    
                }catch(Exception e){System.out.println(e);} 
            }
            else{
                System.out.println("ID already exists\n!");
            }
        }
        System.out.println("The name doesn't conatin only characters!");
        
        
    }
    
    //Remove Admins

    public void remove_admins(String i) throws IOException{
        int IDa=Integer.parseInt(i);
        String id4=Integer.toString(IDa);
        remove("C:\\Users\\Lapshop\\Desktop\\admin.txt",id4,2," ");
        System.out.print("Done"+'\n');
                   
    }

    
        

public static void main(String[]args) throws IOException{
       createframes2();
       createframes1(); 
       createframesad();
       createframeslib();
       createframesinstd();
       createframesinlib();
       createframesinad();
       createframesdelstd();
       createframesdellib();
       createframesdelad();
       createframesinbook();
       createframescoding();
       createframesreadcoding();
       createframesdelbook();
       createframesdelsearch();
       createframesissue();
       createframesreturn();
       createframesviewbook();
       createframesviewissuebook();
       createframes3();
       createbutton();
       activatebuttons();
        employee e=new employee();
        try{
            e.read_data();
        }catch(Exception e1){
            System.out.println(e1);
        }
        lib l=new lib();
        try{
            l.read_data();
        }catch(Exception e1){
            System.out.println(e1);
        }
        ad a=new ad();
        try{
            a.read_data();
        }catch(Exception e1){
            System.out.println(e1);
        }
        boo b=new boo();
        try{
            b.read_data();
        }catch(Exception e1){
            System.out.println(e1);
        }
        iss i=new iss();
        try{
            i.read_data();
        }catch(Exception e1){
            System.out.println(e1);
        }

}
    private static void createframes1(){
    f1=new JFrame("NU LIBRARY");//creating instance of JFrame
    f1.setSize(500,500);
    JLabel l1 = new JLabel("Welcome TO Our Library");
    l1.setBounds(100,15, 300,30);
    f1.add(l1);
    f1.setSize(400,300);//400 width and 500 height  
    f1.setLayout(null);//using no layout managers  
    f1.setVisible(true);//making the frame visible 
    f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f1.setLocationRelativeTo(null);

} 
        private static void createframesad(){
    f3=new JFrame("Admin View");//creating instance of JFrame
    f3.setSize(500,500);
    f3.setSize(600,300);//400 width and 500 height  
    f3.setLayout(null);//using no layout managers  
    f3.setVisible(false);//making the frame visible 
    f3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f3.setLocationRelativeTo(null);

} 
    private static void createframeslib(){
    f4=new JFrame("Librarian View");//creating instance of JFrame
    f4.setSize(500,500);
    f4.setSize(600,300);//400 width and 500 height  
    f4.setLayout(null);//using no layout managers  
    f4.setVisible(false);//making the frame visible 
    f4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f4.setLocationRelativeTo(null);

} 
    
    private static void createframes2(){
             Librarians li= new Librarians();

    f2=new JFrame("Login");//creating instance of JFrame
    f2.setSize(500,500);
    JLabel l1,l2;  
    l1=new JLabel("Username");  //Create label Username
    l1.setBounds(30,15, 100,30); //x axis, y axis, width, height 
     
    l2=new JLabel("Password");  //Create label Password
    l2.setBounds(30,50, 100,30);    
     
    JTextField F_user = new JTextField(); //Create text field for username
    F_user.setBounds(110, 15, 200, 30);
         
    JPasswordField F_pass=new JPasswordField(); //Create text field for password
    F_pass.setBounds(110, 50, 200, 30);
    
    login=new JButton("Login");//creating instance of JButton for Login Button
    login.setBounds(130,90,80,25);
    f2.add(login);//adding button in JFrame  
    login.addActionListener((ActionEvent e)->{
            try {
                li.log_in(F_user.getText(), F_pass.getText());
                if(li.log_in(F_user.getText(), F_pass.getText())==true){
                f1.setVisible(false);
                f2.setVisible(false);
                f3.setVisible(false);
                f4.setVisible(true);}
                else{f1.setVisible(false);
                f2.setVisible(false);
                f3.setVisible(false);
                f4.setVisible(false);
                f21.setVisible(true);}
            } catch (IOException ex) {
                Logger.getLogger(Admins.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    });
    
      
   f2.add(F_pass); //add password
    f2.add(F_user);  //add user
    f2.add(l1);  // add label1 i.e. for username
    f2.add(l2); // add label2 i.e. for password
     
    f2.setSize(400,180);//400 width and 500 height  
    f2.setLayout(null);//using no layout managers  
    f2.setVisible(false);//making the frame visible 
    f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f2.setLocationRelativeTo(null);

    
} 
    
  private static void createframes3(){
             Librarians li= new Librarians();

    f21=new JFrame("Register");//creating instance of JFrame
    f21.setSize(500,500);
    JLabel l1,l2;  
    l1=new JLabel("Username");  //Create label Username
    l1.setBounds(30,15, 100,30); //x axis, y axis, width, height 
     
    l2=new JLabel("Password");  //Create label Password
    l2.setBounds(30,50, 100,30);    
     
    JTextField F_user = new JTextField(); //Create text field for username
    F_user.setBounds(110, 15, 200, 30);
         
    JPasswordField F_pass=new JPasswordField(); //Create text field for password
    F_pass.setBounds(110, 50, 200, 30);
    
    register=new JButton("Register");//creating instance of JButton for Login Button
    register.setBounds(130,90,100,25);
    f21.add(register);//adding button in JFrame  
    register.addActionListener((ActionEvent e)->{
            try {
                li.register(F_user.getText(),F_pass.getText());
                f2.setVisible(true);
               
            } catch (IOException ex) {
                Logger.getLogger(Admins.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    });
    
      
   f21.add(F_pass); //add password
    f21.add(F_user);  //add user
    f21.add(l1);  // add label1 i.e. for username
    f21.add(l2); // add label2 i.e. for password
     
    f21.setSize(400,180);//400 width and 500 height  
    f21.setLayout(null);//using no layout managers  
    f21.setVisible(false);//making the frame visible 
    f21.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f21.setLocationRelativeTo(null);

    
}  
    
    
    
    
    
    
    
    
    
    
    
    private static void createframesinstd(){
        Admins a=new Admins();
    f5=new JFrame("insert student");//creating instance of JFrame
    f5.setSize(500,500);
    JLabel l1,l2,l3,l4,l5;  
    l1=new JLabel("Username");  //Create label Username
    l1.setBounds(30,15, 100,30); //x axis, y axis, width, height 
     
    l2=new JLabel("ID");  //Create label Password
    l2.setBounds(30,50, 100,30);   
    
    l3=new JLabel("mobile");  //Create label Password
    l3.setBounds(30,100, 100,30); 
        l4=new JLabel("birthday");  //Create label Password
    l4.setBounds(30,200, 100,30); 
        l5=new JLabel("email");  //Create label Password
    l5.setBounds(30,300, 100,30); 

    JTextField F_user = new JTextField(); //Create text field for username
    F_user.setBounds(110, 15, 200, 30);
 
    JTextField F_id = new JTextField(); //Create text field for password
    F_id.setBounds(110, 50, 200, 30);
    
     JTextField F_mobile = new JTextField(); //Create text field for username
    F_mobile.setBounds(110, 100, 200, 30);
    
        JTextField F_birth = new JTextField(); //Create text field for username
    F_birth.setBounds(110, 200, 200, 30);
    
        JTextField F_email = new JTextField(); //Create text field for username
    F_email.setBounds(110, 300, 200, 30);
    
    insert=new JButton("insert");//creating instance of JButton for Login Button
    insert.setBounds(300,400,100,25);
    f5.add(insert);//adding button in JFrame
    insert.addActionListener((ActionEvent e)->{
            try {
                a.add_student(F_user.getText(),F_id.getText(), F_birth.getText(), F_mobile.getText(), F_mobile.getText());
                 JFrame f=new JFrame();  
    JOptionPane.showMessageDialog(f,"Success Inserting Student");  
            } catch (IOException ex) {
                Logger.getLogger(Admins.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    });
    
    JButton back=new JButton("back");
    back.setBounds(100,400,90,25);
    f5.add(back);//adding button in JFrame
    back.addActionListener((ActionEvent e)->{
        f3.setVisible(true);
        f5.setVisible(false);
    });
   
    
    
    
    f5.add(F_id); //add password
    f5.add(F_mobile); //add password
    f5.add(F_birth); //add password
    f5.add(F_email); //add password
    f5.add(F_user);  //add user
    f5.add(l1);  // add label1 i.e. for username
    f5.add(l2); // add label2 i.e. for password
    f5.add(l3);
    f5.add(l4);
    f5.add(l5);

   // f5.setSize(400,180);//400 width and 500 height  
    f5.setLayout(null);//using no layout managers  
    f5.setVisible(false);//making the frame visible 
    f5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f5.setLocationRelativeTo(null);

    
    
    
    
    
    
    
    
} 
        private static void createframesinlib(){
          Admins a=new Admins();  
    f7=new JFrame("insert Librarian");//creating instance of JFrame
    f7.setSize(500,500);
    JLabel l1,l2,l3,l4,l5;  
    l1=new JLabel("Username");  //Create label Username
    l1.setBounds(30,15, 100,30); //x axis, y axis, width, height 
     
    l2=new JLabel("ID");  //Create label Password
    l2.setBounds(30,50, 100,30);   
    
    l3=new JLabel("password");  //Create label Password
    l3.setBounds(30,100, 100,30); 
        

    JTextField F_user = new JTextField(); //Create text field for username
    F_user.setBounds(110, 15, 200, 30);
 
    JTextField F_id = new JTextField(); //Create text field for password
    F_id.setBounds(110, 50, 200, 30);
    
     JTextField F_pass = new JTextField(); //Create text field for username
    F_pass.setBounds(110, 100, 200, 30);
    
    insertlib=new JButton("insert");//creating instance of JButton for Login Button
    insertlib.setBounds(300,400,100,25);
    f7.add(insertlib);
    insertlib.addActionListener((ActionEvent e)->{
            try {
               a.add_libarian(F_user.getText(),F_id.getText(), F_pass.getText());
               JFrame f=new JFrame();  
    JOptionPane.showMessageDialog(f,"Success Inserting Librarian");  
            } catch (IOException ex) {
                Logger.getLogger(Admins.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }); 
    JButton back=new JButton("back");
    back.setBounds(100,400,90,25);
    f7.add(back);//adding button in JFrame
    back.addActionListener((ActionEvent e)->{
        f3.setVisible(true);
        f7.setVisible(false);
    });
    
    
    f7.add(F_id); //add password
    f7.add(F_pass); //add password
    f7.add(F_user);  //add user
    f7.add(l1);  // add label1 i.e. for username
    f7.add(l2); // add label2 i.e. for password
    f7.add(l3);
   
    

   // f5.setSize(400,180);//400 width and 500 height  
    f7.setLayout(null);//using no layout managers  
    f7.setVisible(false);//making the frame visible 
    f7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f7.setLocationRelativeTo(null);

    
} 
 private static void createframesinad(){
     Admins a=new Admins();
    f6=new JFrame("insert Admin");//creating instance of JFrame
    f6.setSize(500,500);
    JLabel l1,l2,l3,l4,l5;  
    l1=new JLabel("Username");  //Create label Username
    l1.setBounds(30,15, 100,30); //x axis, y axis, width, height 
     
    l2=new JLabel("ID");  //Create label Password
    l2.setBounds(30,50, 100,30);   
    
    l3=new JLabel("password");  //Create label Password
    l3.setBounds(30,100, 100,30); 
        

    JTextField F_user = new JTextField(); //Create text field for username
    F_user.setBounds(110, 15, 200, 30);
 
    JTextField F_id = new JTextField(); //Create text field for password
    F_id.setBounds(110, 50, 200, 30);
    
     JTextField F_pass = new JTextField(); //Create text field for username
    F_pass.setBounds(110, 100, 200, 30);
    
    insertad=new JButton("insert");//creating instance of JButton for Login Button
    insertad.setBounds(300,400,100,25);
    f6.add(insertad);
    f6.add(insertad);
    insertad.addActionListener((ActionEvent e)->{
            try {
               a.add_admin(F_user.getText(),F_id.getText(), F_pass.getText());
               JFrame f=new JFrame();  
    JOptionPane.showMessageDialog(f,"Success Inserting Admin");  
            } catch (IOException ex) {
                Logger.getLogger(Admins.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }); 
    JButton back=new JButton("back");
    back.setBounds(100,400,90,25);
    f6.add(back);//adding button in JFrame
    back.addActionListener((ActionEvent e)->{
        f3.setVisible(true);
        f6.setVisible(false);
    });
       
     
    f6.add(F_id); //add password
    f6.add(F_pass); //add password
    f6.add(F_user);  //add user
    f6.add(l1);  // add label1 i.e. for username
    f6.add(l2); // add label2 i.e. for password
    f6.add(l3);
   

   // f5.setSize(400,180);//400 width and 500 height  
    f6.setLayout(null);//using no layout managers  
    f6.setVisible(false);//making the frame visible 
    f6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f6.setLocationRelativeTo(null);

    
} 
 
 private static void createframesinbook(){
     Librarians li= new Librarians();
    f11=new JFrame("insert book");//creating instance of JFrame
    f11.setSize(500,500);
    JLabel l1,l2,l3,l4,l5;  
    l1=new JLabel("Name");  //Create label Username
    l1.setBounds(30,15, 100,30); //x axis, y axis, width, height 
     
    l2=new JLabel("ID");  //Create label Password
    l2.setBounds(30,50, 100,30);   
    
    l3=new JLabel("Author");  //Create label Password
    l3.setBounds(30,100, 100,30); 
        l4=new JLabel("Available");  //Create label Password
    l4.setBounds(30,200, 100,30); 
        l5=new JLabel("Issue");  //Create label Password
    l5.setBounds(30,300, 100,30); 

    JTextField F_user = new JTextField(); //Create text field for username
    F_user.setBounds(110, 15, 200, 30);
 
    JTextField F_id = new JTextField(); //Create text field for password
    F_id.setBounds(110, 50, 200, 30);
    
     JTextField F_author = new JTextField(); //Create text field for username
    F_author.setBounds(110, 100, 200, 30);
    
        JTextField F_avaib = new JTextField(); //Create text field for username
    F_avaib.setBounds(110, 200, 200, 30);
    
        JTextField F_issue = new JTextField(); //Create text field for username
    F_issue.setBounds(110, 300, 200, 30);
    
    
    insertbook=new JButton("insert");//creating instance of JButton for Login Button
    insertbook.setBounds(300,400,100,25);
    f11.add(insertbook);
    f11.add(insertbook);
    insertbook.addActionListener((ActionEvent e)->{
            try {
               li.insert_book(F_user.getText(),F_id.getText(), F_author.getText(),F_avaib.getText(),F_issue.getText());
               JFrame f=new JFrame();  
    JOptionPane.showMessageDialog(f,"Success Inserting Book");  
            } catch (IOException ex) {
                Logger.getLogger(Admins.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }); 
    JButton back=new JButton("back");
    back.setBounds(100,400,90,25);
    f11.add(back);//adding button in JFrame
    back.addActionListener((ActionEvent e)->{
        f4.setVisible(true);
        f11.setVisible(false);
    });
    
    
     
    f11.add(F_id); //add password
    f11.add(F_issue); //add password
    f11.add(F_avaib); //add password
    f11.add(F_author); //add password
    f11.add(F_user);  //add user
    f11.add(l1);  // add label1 i.e. for username
    f11.add(l2); // add label2 i.e. for password
    f11.add(l3);
    f11.add(l4);
    f11.add(l5);

   // f5.setSize(400,180);//400 width and 500 height  
    f11.setLayout(null);//using no layout managers  
    f11.setVisible(false);//making the frame visible 
    f11.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f11.setLocationRelativeTo(null);

    
} 
 
   private static void createframescoding(){
       Librarians li= new Librarians();
    f12=new JFrame("Coding the book");//creating instance of JFrame
    f12.setSize(500,500);
    JLabel l1,l2,l3,l4,l5;  
    l1=new JLabel("Name of the book");  //Create label Username
    l1.setBounds(30,15, 100,30); //x axis, y axis, width, height 

    JTextField F_user = new JTextField(); //Create text field for username
    F_user.setBounds(140, 15, 200, 30);
    
    coding=new JButton("Coding");//creating instance of JButton for Login Button
    coding.setBounds(300,400,100,25);
    f12.add(coding);//
    coding.addActionListener((ActionEvent e)->{
        li.create_barcode(F_user.getText());
        JFrame f=new JFrame();  
    JOptionPane.showMessageDialog(f,"The Barcode Is Ready !!");  
        
    }); 
    JButton back=new JButton("back");
    back.setBounds(100,400,90,25);
    f12.add(back);//adding button in JFrame
    back.addActionListener((ActionEvent e)->{
        f4.setVisible(true);
        f12.setVisible(false);
    });
    
    
    f12.add(F_user);  //add user
    f12.add(l1);  // add label1 i.e. for username
   

   // f5.setSize(400,180);//400 width and 500 height  
    f12.setLayout(null);//using no layout managers  
    f12.setVisible(false);//making the frame visible 
    f12.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f12.setLocationRelativeTo(null);

    
} 
   private static void createframesreadcoding(){
       Librarians li= new Librarians();
    f13=new JFrame("Reading the Code of the book");//creating instance of JFrame
    f13.setSize(500,500);
    JLabel l1,l3,l4,l5;  
    l1=new JLabel("Path of the code");  //Create label Username
    l1.setBounds(30,15, 100,30); //x axis, y axis, width, height 

    JTextField F_user = new JTextField(); //Create text field for username
    F_user.setBounds(140, 15, 200, 30);
    
    read=new JButton("Read");//creating instance of JButton for Login Button
    read.setBounds(300,400,100,25);
    f13.add(read);// 
    JLabel l2=new JLabel();  l2.setBounds(50,100, 250,20); 
    read.addActionListener((ActionEvent e)->{
         
        
      l2.setText(li.Read_barcode(F_user.getText())); 
      
    }); 
    JButton back=new JButton("back");
    back.setBounds(100,400,90,25);
    f13.add(back);//adding button in JFrame
    back.addActionListener((ActionEvent e)->{
        f4.setVisible(true);
        f13.setVisible(false);
    });
    
    
    
    f13.add(F_user);  //add user
    f13.add(l1);  // add label1 i.e. for username
   f13.add(l2);

   // f5.setSize(400,180);//400 width and 500 height  
    f13.setLayout(null);//using no layout managers  
    f13.setVisible(false);//making the frame visible 
    f13.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f13.setLocationRelativeTo(null);

    
} 
 
 
 
 
 
 
 
 
        
        
        
 //--------------------------------------------------------------------------
    private static void createbutton(){
     admin=new JButton("ADMIN");//creating instance of JButton for Login Button
    admin.setSize(100,50);
    admin.setLocation(200,100);
     librarian=new JButton("LIBRARIAN");//creating instance of JButton for Login Button
    librarian.setSize(100,50);
    librarian.setLocation(60,100);
    f1.add(admin);//adding button in JFrame  
    f1.add(librarian);//adding button in JFrame 
    
    
     login=new JButton("Login");//creating instance of JButton for Login Button
    login.setBounds(130,90,80,25);
    f2.add(login);//adding button in JFrame  
    
    
    
    ad1=new JButton("insert student");//creating instance of JButton to view books
    ad1.setBounds(20,20,120,25);//x axis,
    ad2=new JButton("Delete student");//creating instance of JButton to view users
    ad2.setBounds(150,20,120,25);
    ad3=new JButton("insert librarian");//creating instance of JButton to view the issued books
    ad3.setBounds(280,20,160,25);
     ad4=new JButton("Delete librarian"); //creating instance of JButton to add users
    ad4.setBounds(20,60,120,25);
    ad5=new JButton("insert Admin"); //creating instance of JButton for adding books
    ad5.setBounds(150,60,120,25); 
    ad6=new JButton("Delete Admin"); //creating instance of JButton to issue books
    ad6.setBounds(450,20,120,25); 
    
    f3.add(ad1);
    f3.add(ad2);
    f3.add(ad3);
    f3.add(ad4);
    f3.add(ad5);
    f3.add(ad6);

    lib1=new JButton("insert book");//creating instance of JButton to view books
    lib1.setBounds(20,20,120,25);//x axis,
    lib2=new JButton("Coding the book");//creating instance of JButton to view users
    lib2.setBounds(150,20,120,25);
    lib3=new JButton("Read the code");//creating instance of JButton to view the issued books
    lib3.setBounds(280,20,160,25);
    lib4=new JButton("Delete book"); //creating instance of JButton to add users
    lib4.setBounds(20,60,120,25);
    lib5=new JButton("issue book"); //creating instance of JButton for adding books
    lib5.setBounds(150,60,120,25); 
    lib6=new JButton("return book"); //creating instance of JButton to issue books
    lib6.setBounds(300,60,120,25); 
    lib7=new JButton("view books"); //creating instance of JButton to issue books
    lib7.setBounds(450,60,120,25); 
    lib8=new JButton("view issued books"); //creating instance of JButton to issue books
    lib8.setBounds(150,100,120,25);  
    lib9=new JButton("log out"); //creating instance of JButton to issue books
    lib9.setBounds(20,100,120,25);
    lib10=new JButton("Search for book"); //creating instance of JButton to issue books
    lib10.setBounds(450,20,120,25); 
    
    f4.add(lib1);
    f4.add(lib2);
    f4.add(lib3);
    f4.add(lib4);
    f4.add(lib5);
    f4.add(lib6);
    f4.add(lib7);
    f4.add(lib8);
    f4.add(lib9);
    f4.add(lib10);

    insert=new JButton("insert");//creating instance of JButton for Login Button
    insert.setBounds(300,400,100,25);
    f5.add(insert);//adding button in JFrame 
    
    insertlib=new JButton("insert");//creating instance of JButton for Login Button
    insertlib.setBounds(300,400,100,25);
    f7.add(insertlib);//
   
    insertad=new JButton("insert");//creating instance of JButton for Login Button
    insertad.setBounds(300,400,100,25);
    f6.add(insertad);//

    
    deletestd=new JButton("Delete");//creating instance of JButton for Login Button
    deletestd.setBounds(300,400,100,25);
    f8.add(deletestd);//
    
    deletelib=new JButton("Delete");//creating instance of JButton for Login Button
    deletelib.setBounds(300,400,100,25);
    f9.add(deletelib);//\
   
    deletead=new JButton("Delete");//creating instance of JButton for Login Button
    deletead.setBounds(300,400,100,25);
    f10.add(deletead);//
    
    insertbook=new JButton("insert");//creating instance of JButton for Login Button
    insertbook.setBounds(300,400,100,25);
    f11.add(insertbook);//
    
    coding=new JButton("Coding");//creating instance of JButton for Login Button
    coding.setBounds(300,400,100,25);
    f12.add(coding);//
    
    read=new JButton("Read");//creating instance of JButton for Login Button
    read.setBounds(300,400,100,25);
    f13.add(read);//
    
    deletebook=new JButton("Delete");//creating instance of JButton for Login Button
    deletebook.setBounds(300,400,100,25);
    f14.add(deletebook);//
    
     issue=new JButton("issue");//creating instance of JButton for Login Button
    issue.setBounds(300,400,100,25);
    f15.add(issue);//
    
    returnb=new JButton("return");//creating instance of JButton for Login Button
    returnb.setBounds(300,400,100,25);
    f16.add(returnb);//
    
    search=new JButton("search");//creating instance of JButton for Login Button
    search.setBounds(300,400,100,25);
    f19.add(search);//
    
}
   private static void createframesdelstd(){
       Admins a=new Admins();
    f8=new JFrame("delete Student");//creating instance of JFrame
    f8.setSize(500,500);
    JLabel l1,l2,l3,l4,l5;  
    l1=new JLabel("ID of the Student");  //Create label Username
    l1.setBounds(30,15, 100,30); //x axis, y axis, width, height 

    JTextField F_user = new JTextField(); //Create text field for username
    F_user.setBounds(140, 15, 200, 30);
    
    deletestd=new JButton("Delete");//creating instance of JButton for Login Button
    deletestd.setBounds(300,400,100,25);
    f8.add(deletestd);//
    deletestd.addActionListener((ActionEvent e)->{
            try {
               a.remove_student(F_user.getText());
               JFrame f=new JFrame();  
    JOptionPane.showMessageDialog(f,"Success Deleting");  
            } catch (IOException ex) {
                Logger.getLogger(Admins.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }); 
    JButton back=new JButton("back");
    back.setBounds(100,400,90,25);
    f8.add(back);//adding button in JFrame
    back.addActionListener((ActionEvent e)->{
        f3.setVisible(true);
        f8.setVisible(false);
    });
    
    
    
    
    
    
    f8.add(F_user);  //add user
    f8.add(l1);  // add label1 i.e. for username
   

   // f5.setSize(400,180);//400 width and 500 height  
    f8.setLayout(null);//using no layout managers  
    f8.setVisible(false);//making the frame visible 
    f8.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f8.setLocationRelativeTo(null);

    
} 
   
   
   private static void createframesdellib(){
       Admins a=new Admins();
    f9=new JFrame("delete Librarian");//creating instance of JFrame
    f9.setSize(500,500);
    JLabel l1,l2,l3,l4,l5;  
    l1=new JLabel("ID of the Librarian");  //Create label Username
    l1.setBounds(30,15, 100,30); //x axis, y axis, width, height 

    JTextField F_user = new JTextField(); //Create text field for username
    F_user.setBounds(140, 15, 200, 30);
    deletelib=new JButton("Delete");//creating instance of JButton for Login Button
    deletelib.setBounds(300,400,100,25);
    f9.add(deletelib);
    deletelib.addActionListener((ActionEvent e)->{
            try {
               a.remove_libarian(F_user.getText());
                JFrame f=new JFrame();  
    JOptionPane.showMessageDialog(f,"Success Deleting");  
            } catch (IOException ex) {
                Logger.getLogger(Admins.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }); 
    JButton back=new JButton("back");
    back.setBounds(100,400,90,25);
    f9.add(back);//adding button in JFrame
    back.addActionListener((ActionEvent e)->{
        f3.setVisible(true);
        f9.setVisible(false);
    });
    
    
    f9.add(F_user);  //add user
    f9.add(l1);  // add label1 i.e. for username
   

   // f5.setSize(400,180);//400 width and 500 height  
    f9.setLayout(null);//using no layout managers  
    f9.setVisible(false);//making the frame visible 
    f9.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f9.setLocationRelativeTo(null);

    
} 
   
   private static void createframesdelad(){
       Admins a=new Admins();
    f10=new JFrame("delete Admin");//creating instance of JFrame
    f10.setSize(500,500);
    JLabel l1,l2,l3,l4,l5;  
    l1=new JLabel("ID of the Librarian");  //Create label Username
    l1.setBounds(30,15, 100,30); //x axis, y axis, width, height 

    JTextField F_user = new JTextField(); //Create text field for username
    F_user.setBounds(140, 15, 200, 30);
    deletead=new JButton("Delete");//creating instance of JButton for Login Button
    deletead.setBounds(300,400,100,25);
    f10.add(deletead);//
    deletead.addActionListener((ActionEvent e)->{
            try {
               a.remove_admins(F_user.getText());
               JFrame f=new JFrame();  
    JOptionPane.showMessageDialog(f,"Success Deleting");  
            } catch (IOException ex) {
                Logger.getLogger(Admins.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }); 
    JButton back=new JButton("back");
    back.setBounds(100,400,90,25);
    f10.add(back);//adding button in JFrame
    back.addActionListener((ActionEvent e)->{
        f3.setVisible(true);
        f10.setVisible(false);
    });
   
    f10.add(F_user);  //add user
    f10.add(l1);  // add label1 i.e. for username
   

   // f5.setSize(400,180);//400 width and 500 height  
    f10.setLayout(null);//using no layout managers  
    f10.setVisible(false);//making the frame visible 
    f10.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f10.setLocationRelativeTo(null);

    
} 
   private static void createframesdelbook(){
               Librarians li= new Librarians();

    f14=new JFrame("delete Book");//creating instance of JFrame
    f14.setSize(500,500);
    JLabel l1,l2,l3,l4,l5;  
    l1=new JLabel("ID of the Book");  //Create label Username
    l1.setBounds(30,15, 100,30); //x axis, y axis, width, height 

    JTextField F_user = new JTextField(); //Create text field for username
    F_user.setBounds(140, 15, 200, 30);
    
    deletebook=new JButton("Delete");//creating instance of JButton for Login Button
    deletebook.setBounds(300,400,100,25);
    f14.add(deletebook);//
    deletebook.addActionListener((ActionEvent e)->{
            try {
               li.delete_book(F_user.getText());
               JFrame f=new JFrame();  
    JOptionPane.showMessageDialog(f,"Success Deleting");  
            } catch (IOException ex) {
                Logger.getLogger(Admins.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }); 
    JButton back=new JButton("back");
    back.setBounds(100,400,90,25);
    f14.add(back);//adding button in JFrame
    back.addActionListener((ActionEvent e)->{
        f4.setVisible(true);
        f14.setVisible(false);
    });
    
    
    f14.add(F_user);  //add user
    f14.add(l1);  // add label1 i.e. for username
   

   // f5.setSize(400,180);//400 width and 500 height  
    f14.setLayout(null);//using no layout managers  
    f14.setVisible(false);//making the frame visible 
    f14.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f14.setLocationRelativeTo(null);

    
} 
   private static void createframesdelsearch(){
                      Librarians li= new Librarians();

    f19=new JFrame("Search Book");//creating instance of JFrame
    f19.setSize(500,500);
    JLabel l1,l3,l4,l5;  
    l1=new JLabel("ID of the Book");  //Create label Username
    l1.setBounds(30,15, 100,30); //x axis, y axis, width, height 

    JTextField F_user = new JTextField(); //Create text field for username
    F_user.setBounds(140, 15, 200, 30);
    search=new JButton("search");//creating instance of JButton for Login Button
    search.setBounds(300,400,100,25);
    f19.add(search);//
    JLabel l2=new JLabel();  l2.setBounds(50,100, 250,20); 
    search.addActionListener((ActionEvent e)->{
            try {
               l2.setText(li.search_book_by_id(F_user.getText()));
            } catch (IOException ex) {
                Logger.getLogger(Admins.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }); 
    JButton back=new JButton("back");
    back.setBounds(100,400,90,25);
    f19.add(back);//adding button in JFrame
    back.addActionListener((ActionEvent e)->{
        f4.setVisible(true);
        f19.setVisible(false);
    });
    
    
    f19.add(F_user);  //add user
    f19.add(l1); 
    f19.add(l2);// add label1 i.e. for username
   

   // f5.setSize(400,180);//400 width and 500 height  
    f19.setLayout(null);//using no layout managers  
    f19.setVisible(false);//making the frame visible 
    f19.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f19.setLocationRelativeTo(null);

    
} 
    private static void createframesissue(){
        Librarians li= new Librarians();
    f15=new JFrame("issue Book");//creating instance of JFrame
    f15.setSize(500,500);
    JLabel l1,l2,l3,l4,l5;  
       l1=new JLabel("Name of the Student");  //Create label Username
    l1.setBounds(30,15, 200,30); //x axis, y axis, width, height 
     
    l2=new JLabel("ID of the book");  //Create label Password
    l2.setBounds(30,50, 100,30);   
    
    l3=new JLabel("ID of the Student");  //Create label Password
    l3.setBounds(30,100, 100,30);

    
    JTextField F_user = new JTextField(); //Create text field for username
    F_user.setBounds(150, 15, 200, 30);
 
    JTextField F_id = new JTextField(); //Create text field for password
    F_id.setBounds(130, 50, 200, 30);
    
    
    JTextField F_id2 = new JTextField(); //Create text field for username
    F_id2.setBounds(130, 100, 200, 30);
    
         issue=new JButton("issue");//creating instance of JButton for Login Button
    issue.setBounds(300,400,100,25);
    f15.add(issue);//
    issue.addActionListener((ActionEvent e)->{
            try {
               li.issue(F_user.getText(),F_id.getText(),F_id2.getText());
               JFrame f=new JFrame();  
    JOptionPane.showMessageDialog(f,"issue is Done");  
            } catch (IOException ex) {
                Logger.getLogger(Admins.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }); 
    JButton back=new JButton("back");
    back.setBounds(100,400,90,25);
    f15.add(back);//adding button in JFrame
    back.addActionListener((ActionEvent e)->{
        f4.setVisible(true);
        f15.setVisible(false);
    });
    
    f15.add(F_user); 
    f15.add(F_id);
    f15.add(F_id2);
    f15.add(l3);
    f15.add(l1);
    f15.add(l2);// add label1 i.e. for username
   

   // f5.setSize(400,180);//400 width and 500 height  
    f15.setLayout(null);//using no layout managers  
    f15.setVisible(false);//making the frame visible 
    f15.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f15.setLocationRelativeTo(null);

    
} 
     private static void createframesreturn(){
         Librarians li= new Librarians();
    f16=new JFrame("return Book");//creating instance of JFrame
    f16.setSize(500,500);
    JLabel l1,l2,l3,l4,l5;  
   l1=new JLabel("Name of the Student");  //Create label Username
    l1.setBounds(30,15, 200,30); //x axis, y axis, width, height 
     
    l2=new JLabel("ID of the book");  //Create label Password
    l2.setBounds(30,50, 100,30);   

    l3=new JLabel("ID of the Student");  //Create label Password
    l3.setBounds(30,100, 100,30);
    
    JTextField F_user = new JTextField(); //Create text field for username
    F_user.setBounds(150, 15, 200, 30);
 
    JTextField F_id = new JTextField(); //Create text field for password
    F_id.setBounds(130, 50, 200, 30);
    
    JTextField F_id2 = new JTextField(); //Create text field for username
    F_id2.setBounds(130, 100, 200, 30);
    
    returnb=new JButton("return");//creating instance of JButton for Login Button
    returnb.setBounds(300,400,100,25);
    f16.add(returnb);//
    returnb.addActionListener((ActionEvent e)->{
            try {
               li.return_book(F_user.getText(),F_id.getText(),F_id2.getText());
               JFrame f=new JFrame();  
    JOptionPane.showMessageDialog(f,"Return is Done");  
            } catch (IOException ex) {
                Logger.getLogger(Admins.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    });
    JButton back=new JButton("back");
    back.setBounds(100,400,90,25);
    f16.add(back);//adding button in JFrame
    back.addActionListener((ActionEvent e)->{
        f4.setVisible(true);
        f16.setVisible(false);
    });
    
    f16.add(F_user); 
    f16.add(F_id);
    f16.add(F_id2);
    f16.add(l3);
    f16.add(l1);
    f16.add(l2);// add label1 i.e. for username

   // f5.setSize(400,180);//400 width and 500 height  
    f16.setLayout(null);//using no layout managers  
    f16.setVisible(false);//making the frame visible 
    f16.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f16.setLocationRelativeTo(null);

    
} 
     private static void createframesviewbook(){
     /*JLabel l1,l2,l3,l4,l5;  
    f17=new JFrame("view Book");//creating instance of JFrame
    f17.setSize(500,500);
     
   View=new JButton("View");//creating instance of JButton for Login Button
    View.setBounds(100,15, 300,30);
    f17.add(View);//
    View.addActionListener((ActionEvent e)->{
       li.view_book();
        
    }); 

   // f5.setSize(400,180);//400 width and 500 height  
    f17.setLayout(null);//using no layout managers  
    f17.setVisible(false);//making the frame visible 
    f17.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f17.setLocationRelativeTo(null);*/
     
     final JTextArea edit = new JTextArea(10, 60);
      
        View = new JButton("Read");
        View.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    FileReader reader = new FileReader( "C:\\Users\\Lapshop\\Desktop\\book.txt" );
                    BufferedReader br = new BufferedReader(reader);
                    edit.read( br, null );
                    br.close();
                    edit.requestFocus();
                }
                catch(Exception e2) { System.out.println(e2); }
            }
        });
        
        

       
        f17= new JFrame("TextArea Load");
        f17.getContentPane().add( new JScrollPane(edit), BorderLayout.NORTH );
        f17.getContentPane().add(View, BorderLayout.WEST);
        f17.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f17.pack();
        f17.setLocationRelativeTo( null );
     }


    
 
     
     private static void createframesviewissuebook(){
                 /* Librarians li= new Librarians();

    f18=new JFrame("view issue Book");//creating instance of JFrame
    f18.setSize(500,500);
    Viewi=new JButton("View");//creating instance of JButton for Login Button
    Viewi.setBounds(100,15, 300,30);
    f18.add(Viewi);//
    Viewi.addActionListener((ActionEvent e)->{
        li.view_issuebook();
        
    });     
   

   // f5.setSize(400,180);//400 width and 500 height  
    f18.setLayout(null);//using no layout managers  
    f18.setVisible(false);//making the frame visible 
    f18.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f18.setLocationRelativeTo(null);*/
                 
    
     final JTextArea edit = new JTextArea(10, 60);
      
         Viewi = new JButton("Read");
        Viewi.addActionListener( new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try
                {
                    FileReader reader = new FileReader( "C:\\Users\\Lapshop\\Desktop\\issuebook.txt" );
                    BufferedReader br = new BufferedReader(reader);
                    edit.read( br, null );
                    br.close();
                    edit.requestFocus();
                }
                catch(Exception e2) { System.out.println(e2); }
            }
        });

       
        f18= new JFrame("TextArea Load");
        f18.getContentPane().add( new JScrollPane(edit), BorderLayout.NORTH );
        f18.getContentPane().add(Viewi, BorderLayout.WEST);
        f18.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f18.pack();
        f18.setLocationRelativeTo( null );
     }

    

    
    
    
    //---------------------------------------------------
    private static void activatebuttons(){
    librarian.addActionListener((ActionEvent e)->{
        f1.setVisible(false);
        f2.setVisible(true);

});
    admin.addActionListener((ActionEvent e)->{
        f1.setVisible(false);
        f2.setVisible(false);
        f3.setVisible(true);
        
          
    
});
        login.addActionListener((ActionEvent e)->{
        f1.setVisible(false);
        f2.setVisible(false);
        f3.setVisible(false);
        f4.setVisible(true);
        
          
    
});

    ad1.addActionListener((ActionEvent e)->{
        f1.setVisible(false);
        f2.setVisible(false);
        f3.setVisible(false);
        f4.setVisible(false);
        f5.setVisible(true);
        
        
          
    
});
    ad3.addActionListener((ActionEvent e)->{
        f1.setVisible(false);
        f2.setVisible(false);
        f3.setVisible(false);
        f4.setVisible(false);
        f5.setVisible(false);
        f7.setVisible(true);
        
          
    
});
    ad5.addActionListener((ActionEvent e)->{
        f1.setVisible(false);
        f2.setVisible(false);
        f3.setVisible(false);
        f4.setVisible(false);
        f5.setVisible(false);
        f7.setVisible(false);
        f6.setVisible(true);
        
          
    
});
    ad2.addActionListener((ActionEvent e)->{
        f1.setVisible(false);
        f2.setVisible(false);
        f3.setVisible(false);
        f4.setVisible(false);
        f5.setVisible(false);
        f7.setVisible(false);
        f6.setVisible(false);
        f8.setVisible(true);
          
    
});
    ad4.addActionListener((ActionEvent e)->{
        f1.setVisible(false);
        f2.setVisible(false);
        f3.setVisible(false);
        f4.setVisible(false);
        f5.setVisible(false);
        f7.setVisible(false);
        f6.setVisible(false);
        f8.setVisible(false);
        f9.setVisible(true);
          
    
});
    ad6.addActionListener((ActionEvent e)->{
        f1.setVisible(false);
        f2.setVisible(false);
        f3.setVisible(false);
        f4.setVisible(false);
        f5.setVisible(false);
        f7.setVisible(false);
        f6.setVisible(false);
        f8.setVisible(false);
        f9.setVisible(false);
        f10.setVisible(true);
   }); 
        
     lib1.addActionListener((ActionEvent e)->{
        f1.setVisible(false);
        f2.setVisible(false);
        f3.setVisible(false);
        f4.setVisible(false);
        f5.setVisible(false);
        f7.setVisible(false);
        f6.setVisible(false);
        f8.setVisible(false);
        f9.setVisible(false);
        f10.setVisible(false);
        f11.setVisible(true);
          
    
});
    
lib2.addActionListener((ActionEvent e)->{
        f1.setVisible(false);
        f2.setVisible(false);
        f3.setVisible(false);
        f4.setVisible(false);
        f5.setVisible(false);
        f7.setVisible(false);
        f6.setVisible(false);
        f8.setVisible(false);
        f9.setVisible(false);
        f10.setVisible(false);
        f11.setVisible(false);
        f12.setVisible(true);
          
    
});
lib3.addActionListener((ActionEvent e)->{
        f1.setVisible(false);
        f2.setVisible(false);
        f3.setVisible(false);
        f4.setVisible(false);
        f5.setVisible(false);
        f7.setVisible(false);
        f6.setVisible(false);
        f8.setVisible(false);
        f9.setVisible(false);
        f10.setVisible(false);
        f11.setVisible(false);
        f12.setVisible(false);
        f13.setVisible(true);
          
    
});
    lib4.addActionListener((ActionEvent e)->{
        f1.setVisible(false);
        f2.setVisible(false);
        f3.setVisible(false);
        f4.setVisible(false);
        f5.setVisible(false);
        f7.setVisible(false);
        f6.setVisible(false);
        f8.setVisible(false);
        f9.setVisible(false);
        f10.setVisible(false);
        f11.setVisible(false);
        f12.setVisible(false);
        f13.setVisible(false);
        f14.setVisible(true);
          
    
});    
        
      lib5.addActionListener((ActionEvent e)->{
        f1.setVisible(false);
        f2.setVisible(false);
        f3.setVisible(false);
        f4.setVisible(false);
        f5.setVisible(false);
        f7.setVisible(false);
        f6.setVisible(false);
        f8.setVisible(false);
        f9.setVisible(false);
        f10.setVisible(false);
        f11.setVisible(false);
        f12.setVisible(false);
        f13.setVisible(false);
        f15.setVisible(true);
        
          
    
});        
    
       lib6.addActionListener((ActionEvent e)->{
        f1.setVisible(false);
        f2.setVisible(false);
        f3.setVisible(false);
        f4.setVisible(false);
        f5.setVisible(false);
        f7.setVisible(false);
        f6.setVisible(false);
        f8.setVisible(false);
        f9.setVisible(false);
        f10.setVisible(false);
        f11.setVisible(false);
        f12.setVisible(false);
        f13.setVisible(false);
        f15.setVisible(false);
        f16.setVisible(true);
          
    
});     
lib7.addActionListener((ActionEvent e)->{
        f1.setVisible(false);
        f2.setVisible(false);
        f3.setVisible(false);
        f4.setVisible(false);
        f5.setVisible(false);
        f7.setVisible(false);
        f6.setVisible(false);
        f8.setVisible(false);
        f9.setVisible(false);
        f10.setVisible(false);
        f11.setVisible(false);
        f12.setVisible(false);
        f13.setVisible(false);
        f15.setVisible(false);
        f16.setVisible(false);
        f17.setVisible(true);
          
    
});     
lib8.addActionListener((ActionEvent e)->{
        f1.setVisible(false);
        f2.setVisible(false);
        f3.setVisible(false);
        f4.setVisible(false);
        f5.setVisible(false);
        f7.setVisible(false);
        f6.setVisible(false);
        f8.setVisible(false);
        f9.setVisible(false);
        f10.setVisible(false);
        f11.setVisible(false);
        f12.setVisible(false);
        f13.setVisible(false);
        f15.setVisible(false);
        f16.setVisible(false);
        f18.setVisible(true);
          
    
});     
lib9.addActionListener((ActionEvent e)->{
        f1.setVisible(true);
        f2.setVisible(false);
        f3.setVisible(false);
        f4.setVisible(false);
        f5.setVisible(false);
        f7.setVisible(false);
        f6.setVisible(false);
        f8.setVisible(false);
        f9.setVisible(false);
        f10.setVisible(false);
        f11.setVisible(false);
        f12.setVisible(false);
        f13.setVisible(false);
        f15.setVisible(false);
        f16.setVisible(false);
          
    
});     
lib10.addActionListener((ActionEvent e)->{
        f1.setVisible(false);
        f2.setVisible(false);
        f3.setVisible(false);
        f4.setVisible(false);
        f5.setVisible(false);
        f7.setVisible(false);
        f6.setVisible(false);
        f8.setVisible(false);
        f9.setVisible(false);
        f10.setVisible(false);
        f11.setVisible(false);
        f12.setVisible(false);
        f13.setVisible(false);
        f15.setVisible(false);
        f19.setVisible(true);
          
});    

    

   
    
}

    
}
class employee { // employee = student 

    /**
     * @param args the command line arguments
     */
    
    private String name;
    private int id;
    private String birth;
    private int mobile;
    private String email;

    public void read_data(){
       try(Scanner input= new Scanner (new File("C:\\Users\\Lapshop\\Desktop\\student.txt"))){
         while (input.hasNextLine())  {
             name="";
             birth="";
             email="";
             String line;
             line=input.nextLine();
             try(Scanner data =new Scanner(line)){
                 while(!data.hasNextInt()){
                     name+=data.next()+" ";
                     
                 }
                 name=name.trim();
                 
                 if(data.hasNextInt()){
                     id=data.nextInt();
                 }
                while(!data.hasNextInt()){
                     birth+=data.next()+" ";
                 }
                 birth=birth.trim();
                 if(data.hasNextInt()){
                     mobile=data.nextInt();
                 }
                
                 while(data.hasNext()){
                     email+=data.next()+" ";
                 }
                 email=email.trim();
                  
             }
            // System.out.println(name+"\t"+salary+"\t"+id);
           savedata();
         }
       }catch(IOException e){
           System.out.println(e);
       }
    }

public void savedata(){
        try(Connection conn=connect();
                PreparedStatement pstat=conn.prepareStatement("INSERT INTO student VALUES(?, ?, ?, ?, ?)")){
                   
            pstat.setString(1, name);
            pstat.setInt(2, id);
            pstat.setString(3, birth);
            pstat.setInt(4, mobile);
            pstat.setString(5, email);
            
            pstat.executeUpdate();
            
            
    }catch(SQLException e3){
     System.out.println(e3);
 }
 }
private Connection connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost/student", "root", "zamalek100");
        }catch(SQLException | ClassNotFoundException e2){
            System.out.println(e2);
            return null;
        }
    }
}

class lib {

    /**
     * @param args the command line arguments
     */
    
    private String name;
    private int id;
    private String pass;
   

    public void read_data(){
       try(Scanner input= new Scanner (new File("C:\\Users\\Lapshop\\Desktop\\librarian.txt"))){
         while (input.hasNextLine())  {
             name="";
             pass="";
             
             String line;
             line=input.nextLine();
             try(Scanner data =new Scanner(line)){
                 while(!data.hasNextInt()){
                     name+=data.next()+" ";
                     
                 }
                 name=name.trim();
                 
                 if(data.hasNextInt()){
                     id=data.nextInt();
                 }
                while(data.hasNext()){
                     pass+=data.next()+" ";
                 }
                 pass=pass.trim();
                  
             }
            // System.out.println(name+"\t"+salary+"\t"+id);
           savedata();
         }
       }catch(IOException e){
           System.out.println(e);
       }
    }

public void savedata(){
        try(Connection conn=connect();
                PreparedStatement pstat=conn.prepareStatement("INSERT INTO librarian VALUES(?, ?, ?)")){
                   
            pstat.setString(1, name);
            pstat.setInt(2, id);
            pstat.setString(3, pass);
           
            
            pstat.executeUpdate();
            
            
    }catch(SQLException e3){
     System.out.println(e3);
 }
 }
private Connection connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost/librarian", "root", "zamalek100");
        }catch(SQLException | ClassNotFoundException e2){
            System.out.println(e2);
            return null;
        }
    }
}
   class ad {

    /**
     * @param args the command line arguments
     */
    
    private String name;
    private int id;
    private String pass;
   

    public void read_data(){
       try(Scanner input= new Scanner (new File("C:\\Users\\Lapshop\\Desktop\\admin.txt"))){
         while (input.hasNextLine())  {
             name="";
             pass="";
             
             String line;
             line=input.nextLine();
             try(Scanner data =new Scanner(line)){
                 while(!data.hasNextInt()){
                     name+=data.next()+" ";
                     
                 }
                 name=name.trim();
                 
                 if(data.hasNextInt()){
                     id=data.nextInt();
                 }
                while(data.hasNext()){
                     pass+=data.next()+" ";
                 }
                 pass=pass.trim();
                  
             }
            // System.out.println(name+"\t"+salary+"\t"+id);
           savedata();
         }
       }catch(IOException e){
           System.out.println(e);
       }
    }

public void savedata(){
        try(Connection conn=connect();
                PreparedStatement pstat=conn.prepareStatement("INSERT INTO admin VALUES(?, ?, ?)")){
                   
            pstat.setString(1, name);
            pstat.setInt(2, id);
            pstat.setString(3, pass);
           
            
            pstat.executeUpdate();
            
            
    }catch(SQLException e3){
     System.out.println(e3);
 }
 }
private Connection connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost/admin", "root", "zamalek100");
        }catch(SQLException | ClassNotFoundException e2){
            System.out.println(e2);
            return null;
        }
    }
}

class boo {

    /**
     * @param args the command line arguments
     */
    
    private String name;
    private int id;
    private String author;
    private int avaib;
    private int issue;

    public void read_data(){
       try(Scanner input= new Scanner (new File("C:\\Users\\Lapshop\\Desktop\\book.txt"))){
         while (input.hasNextLine())  {
             name="";
             author="";
             String line;
             line=input.nextLine();
             try(Scanner data =new Scanner(line)){
                 while(!data.hasNextInt()){
                     name+=data.next()+" ";
                     
                 }
                 name=name.trim();
                 
                 if(data.hasNextInt()){
                     id=data.nextInt();
                 }
                while(!data.hasNextInt()){
                     author+=data.next()+" ";
                 }
                 author=author.trim();
                 if(data.hasNextInt()){
                     avaib=data.nextInt();
                 }
                 if(data.hasNextInt()){
                     issue=data.nextInt();
                 }
                  
             }
            // System.out.println(name+"\t"+salary+"\t"+id);
           savedata();
         }
       }catch(IOException e){
           System.out.println(e);
       }
    }
public void savedata(){
        try(Connection conn=connect();
                PreparedStatement pstat=conn.prepareStatement("INSERT INTO book VALUES(?, ?, ?, ?, ?)")){
                   
            pstat.setString(1, name);
            pstat.setInt(2, id);
            pstat.setString(3, author);
           pstat.setInt(4, avaib);
           pstat.setInt(5, issue);
            
            pstat.executeUpdate();
            
            
    }catch(SQLException e3){
     System.out.println(e3);
 }
 }
private Connection connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost/book", "root", "zamalek100");
        }catch(SQLException | ClassNotFoundException e2){
            System.out.println(e2);
            return null;
        }
    }
}
class iss {

    /**
     * @param args the command line arguments
     */
    
    private int procedureid;
    private int bookid;
    private int stdid;
    private String returned;
    

    public void read_data(){
       try(Scanner input= new Scanner (new File("C:\\Users\\Lapshop\\Desktop\\issuebook.txt"))){
         while (input.hasNextLine())  {
             returned="";
             String line;
             line=input.nextLine();
             try(Scanner data =new Scanner(line)){
                 
                 if(data.hasNextInt()){
                     procedureid=data.nextInt();
                 }
                
                 if(data.hasNextInt()){
                     bookid=data.nextInt();
                 }
                 if(data.hasNextInt()){
                     stdid=data.nextInt();
                 }
                  while(data.hasNext()){
                     returned+=data.next()+" ";
                     
                 }
                 returned=returned.trim();
             }
            // System.out.println(name+"\t"+salary+"\t"+id);
           savedata();
         }
       }catch(IOException e){
           System.out.println(e);
       }
    }
public void savedata(){
        try(Connection conn=connect();
                PreparedStatement pstat=conn.prepareStatement("INSERT INTO issuebook VALUES(?, ?, ?, ?)")){
                   
            pstat.setInt(1, procedureid);
            pstat.setInt(2, bookid);
            pstat.setInt(3, stdid);
           pstat.setString(4, returned);
            
            pstat.executeUpdate();
            
            
    }catch(SQLException e3){
     System.out.println(e3);
 }
 }
private Connection connect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost/issuebook", "root", "zamalek100");
        }catch(SQLException | ClassNotFoundException e2){
            System.out.println(e2);
            return null;
        }
    }
}






