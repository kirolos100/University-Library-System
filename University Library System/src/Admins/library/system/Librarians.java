/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Admins.library.system;

/**
 *
 * @author Lapshop
 */
import com.google.zxing.BarcodeFormat;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Writer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;

import javax.imageio.ImageIO;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;

import javax.imageio.ImageIO;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.oned.Code128Writer;
import java.nio.file.Paths;


public class Librarians extends books {
    static int procedure = 0;
    int id;
    String name;
    String password;

    public Librarians() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
    
    Scanner input = new Scanner(System.in);
    Scanner s = new Scanner(System.in);
    Scanner s1=new Scanner(System.in);

    //Add book
    public void insert_book(String n,String i,String au, String av, String iss) throws IOException{
        
        setBookname(n);
        int bid= Integer.parseInt(i);
        setIdb(bid);
        if(!(search_book_id("C:\\Users\\Lapshop\\Desktop\\book.txt", Integer.toString(bid)))){
            System.out.print("Enter Author name: ");
          
            setAuthorname(au);
            if(au.matches("[a-zA-Z]+")){
                int avail= Integer.parseInt(av);
                setAvailable(avail);
                
                int isuue=Integer.parseInt(iss);
                setIssue(isuue);
        
                try{  
                    Writer output4;
                    output4 = new BufferedWriter(new FileWriter("C:\\Users\\Lapshop\\Desktop\\book.txt",true));  //clears file every time
                    output4.append(getBookname()+" "+getIdb()+" "+getAuthorname()+" "+getAvailable()+" "+getIssue()+"\n");
                    output4.close();
                    //fw.close();    
                }catch(Exception e){System.out.println(e);}
            }
            else{
                System.out.println("The author name doesn't conatin only characters!");
            }
            
        }
        else{
            System.out.println("ID already exists\n!");
        }
        
    }

    //remove fun
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

    //Delete book

    public void delete_book(String i) throws IOException{ //Logic error if first line 
        int IDb= Integer.parseInt(i);
        String id5=Integer.toString(IDb);
        remove("C:\\Users\\Lapshop\\Desktop\\book.txt",id5,2," ");
        System.out.print("Done"+'\n');
                   
    }


    //Issue book
    public void issue(String n, String i,String i2) throws IOException{
        FileInputStream fstream = new FileInputStream("C:\\Users\\Lapshop\\Desktop\\book.txt");
        DataInputStream in = new DataInputStream(fstream);
        String id10;
        String student_name;
        
  
        id10 = i;
        
   
        student_name = n;

        try (BufferedReader sc = new BufferedReader(new InputStreamReader(in))) {
            String filecontentss;  
                while((filecontentss = sc.readLine()) != null){
                    String[] tokens1 = filecontentss.split(" ");

                    if(tokens1[1].contains(id10)){
                                        
                        String[] tokens = filecontentss.split(" ");
                        
                        setBookname(tokens[0]);
                        setIdb(Integer.parseInt(tokens[1]));
                        setAuthorname(tokens[2]);
                        setAvailable(Integer.parseInt(tokens[3])-1);
                        setIssue(Integer.parseInt(tokens[4])+1);      
                        
                        
                        }
                                    
                }
        } catch (NumberFormatException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
            
        
        

        try{
            Writer output100;
            remove("C:\\Users\\Lapshop\\Desktop\\book.txt", id10, 2, " ");
            output100 = new BufferedWriter(new FileWriter("C:\\Users\\Lapshop\\Desktop\\book.txt", true));  //clears file every time
            output100.append(getBookname()+" "+getIdb()+" "+getAuthorname()+" "+getAvailable()+" "+getIssue() +"\n");
            output100.close();
                    Librarians se=new Librarians();
                    
                    int ids=Integer.parseInt(i2);
                    se.setStudentid(ids);
                    
                    se.setBookid(Integer.parseInt(id10));
                    se.setReturned(false);
                    se.setProcedureid(procedureid);
                    procedureid ++;

                    Writer output110;
                    output110 = new BufferedWriter(new FileWriter("C:\\Users\\Lapshop\\Desktop\\issuebook.txt", true));  //clears file every time
                    output110.append(se.getProcedureid()+" "+se.getStudentid()+" "+se.getBookid()+" "+se.isReturned()+"\n");
                    output110.close();
                            //fw.close();
            }catch(Exception e){System.out.println(e);}
    }

    //return_book --------------------------------------------------------------------------------------------

    public void return_book(String n, String i,String i2) throws IOException{
        FileInputStream fstream = new FileInputStream("C:\\Users\\Lapshop\\Desktop\\book.txt");
        DataInputStream in = new DataInputStream(fstream);
        String id10;
        String student_name;
        
        
        id10 = i;
        
        student_name = n;

        try (BufferedReader sc = new BufferedReader(new InputStreamReader(in))) {
            String filecontentss;  
                while((filecontentss = sc.readLine()) != null){
                    String[] tokens1 = filecontentss.split(" ");

                    if(tokens1[1].contains(id10)){
                                        
                        String[] tokens = filecontentss.split(" ");
                        
                        setBookname(tokens[0]);
                        setIdb(Integer.parseInt(tokens[1]));
                        setAuthorname(tokens[2]);
                        setAvailable(Integer.parseInt(tokens[3])+1);
                        setIssue(Integer.parseInt(tokens[4])-1);      
                        
                        
                        }
                                    
                }
        } catch (NumberFormatException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
            
        
        

        try{
            Writer output10;
            remove("C:\\Users\\Lapshop\\Desktop\\book.txt", id10, 2, " ");
            output10 = new BufferedWriter(new FileWriter("C:\\Users\\Lapshop\\Desktop\\book.txt", true));  //clears file every time
            output10.append(getBookname()+" "+getIdb()+" "+getAuthorname()+" "+getAvailable()+" "+getIssue() +"\n");
            output10.close();
                    Librarians se=new Librarians();
                    
                    int ids=Integer.parseInt(i2);
                    se.setStudentid(ids);
                    
                    se.setBookid(Integer.parseInt(id10));
                    se.setReturned(true);
                    se.setProcedureid(procedureid);
                    procedureid ++;

                    Writer output11;
                    output11 = new BufferedWriter(new FileWriter("C:\\Users\\Lapshop\\Desktop\\issuebook.txt", true));  //clears file every time
                    output11.append(se.getProcedureid()+" "+se.getStudentid()+" "+se.getBookid()+" "+se.isReturned()+"\n");
                    output11.close();
                            //fw.close();
            }catch(Exception e){System.out.println(e);}
    }

    //Search_student_name -----------------------------------------------------------------------------------------------------------------------------------------


    public boolean search_student_name(String path, String object) throws IOException{
        
        String filecontents = "";
        
        try{

            FileInputStream fstream = new FileInputStream(path);
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader sc = new BufferedReader(new InputStreamReader(in));

            while((filecontents = sc.readLine()) != null){
                String[] tokens = filecontents.split(" ");
                
                if(tokens[0].contains(object)){
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

    //View book ------------------------------------------------------------------------------------------------------------------


    public void view_book(){
        String line = null;
        try
        {
            FileReader fileReader = new FileReader("C:\\Users\\Lapshop\\Desktop\\book.txt");
            
            // always wrap the FileReader in BufferedReader
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            while((line = bufferedReader.readLine()) != null)
            {
                System.out.println(line);
            }
            
            // always close the file after its use
            bufferedReader.close();
        }
        catch(IOException ex)
        {
            System.out.println("\n Error!!!!!!!!!");
            System.out.println("Exception: " +ex);
        }
    }
    
    // view issuebook--------------------------------------------------------------------------------------------------------------------------------------
    
    public void view_issuebook(){
        String line = null;
        try
        {
            FileReader fileReader = new FileReader("C:\\Users\\Lapshop\\Desktop\\issuebook.txt");
            
            // always wrap the FileReader in BufferedReader
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            while((line = bufferedReader.readLine()) != null)
            {
                System.out.println(line);
            }
            
            // always close the file after its use
            bufferedReader.close();
        }
        catch(IOException ex)
        {
            System.out.println("\n Error!!!!!!!!!");
            System.out.println("Exception: " +ex);
        }
    }

    //USER INFO FUNCTIONS -------------------------------------------------------------------------------------------------------------

    //Register function

    public void register(String n, String p) throws IOException{

        
            String username;
            String password;

            username = n;
            password = p;

            if(!(search_username("C:\\Users\\Lapshop\\Desktop\\userinfo.txt", username, password))){
                try{
                    Writer output11;
                    output11 = new BufferedWriter(new FileWriter("C:\\Users\\Lapshop\\Desktop\\userinfo.txt", true));  //clears file every time
                    output11.append(username+" "+password+" "+"\n");
                    output11.close();
                                    //fw.close();
                    
                
                }catch(Exception e){System.out.println(e);}
            }
            else{
                System.out.println("Username or password already exists!");
            }
        
        
    
    }

    //Search password and username
    public boolean search_username (String path, String object, String object2) throws IOException{
        
        String filecontents = "";
        
        try{

            FileInputStream fstream = new FileInputStream(path);
            DataInputStream in = new DataInputStream(fstream);
            try (BufferedReader sc = new BufferedReader(new InputStreamReader(in))) {
                while((filecontents = sc.readLine()) != null){
                    String[] tokens = filecontents.split(" ");
                    
                    if(tokens[0].contains(object) & tokens[1].contains(object2)){
                        return true;
                    }
                }
                sc.close();
            }
            
        }
        catch(FileNotFoundException e){
            System.out.println(e);

        }
        return false;

    }

    //User login functions
    public boolean log_in(String u, String p) throws IOException{
        
            String username;
            String password;

            username = u;
            password = p;

            if((search_username("C:\\Users\\Lapshop\\Desktop\\userinfo.txt", username, password))){
            
                return true;
            }
            else{
                System.out.println("Wrong username or password!");
                return false;
            }
        


    }

    public String search_book_by_id(String i) throws IOException{
        String filecontents = "";
        String id;
        id = i;

        try{

            FileInputStream fstream = new FileInputStream("C:\\Users\\Lapshop\\Desktop\\book.txt");
            DataInputStream in = new DataInputStream(fstream);
            try (BufferedReader sc = new BufferedReader(new InputStreamReader(in))) {
                while((filecontents = sc.readLine()) != null){
                    String[] tokens = filecontents.split(" ");
                    
                    if(tokens[1].contains(id) ){
                       return (tokens[0]+" "+tokens[1]+" "+tokens[2]+" "+tokens[3]+" "+tokens[4]+"\n");
                    }
                    
                }
                sc.close();
            }
            
        }
        catch(FileNotFoundException e){
            System.out.println(e);

        } 
            return null;
    }

    public void search_book_by_name() throws IOException{
        String filecontents = "";
        String name;
        System.out.println("Enter the book Name:");
        name = s.next();
        try{

            FileInputStream fstream = new FileInputStream("C:\\Users\\Lapshop\\Desktop\\book.txt");
            DataInputStream in = new DataInputStream(fstream);
            try (BufferedReader sc = new BufferedReader(new InputStreamReader(in))) {
                while((filecontents = sc.readLine()) != null){
                    String[] tokens = filecontents.split(" ");
                    
                    if(tokens[0].contains(name) ){
                        System.out.println(tokens[0]+" "+tokens[1]+" "+tokens[2]+" "+tokens[3]+" "+tokens[4]+"\n");
                    }
                    
                }
                sc.close();
            }
            
        }
        catch(FileNotFoundException e){
            System.out.println(e);

        } 

    }


    //search book ID
    public boolean search_book_id(String path, String object) throws IOException{
        
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
    public void create_barcode(String n){
        try {
			
                       
			String text = n;
			String path = "C:\\Users\\Lapshop\\Desktop\\"+n+".jpg";
			
			Code128Writer writer = new Code128Writer();
			BitMatrix matrix = writer.encode(text, BarcodeFormat.CODE_128, 500, 300);
			
			MatrixToImageWriter.writeToPath(matrix, "jpg", Paths.get(path));
			
			System.out.println("Barcode created...");
			
		} catch(Exception e) {
			System.out.println("Error while creating barcode");
		}
	}
    public String Read_barcode(String n){
        try {

			String path = n;
			
			BufferedImage bf = ImageIO.read(new FileInputStream(path));
			
			BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(
					new BufferedImageLuminanceSource(bf)));
			
			Result result = new MultiFormatReader().decode(bitmap);
			
                                return result.getText();
		} catch(Exception e) {
			System.out.println("Error while reading barcode " + e.getMessage());
		}
        return null;
	}
}

    
    

