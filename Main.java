/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netass1;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static netass1.NetAss1.Alter;
import static netass1.NetAss1.Generator;
import static netass1.NetAss1.LongDiv;
import static netass1.NetAss1.Verifier;
import sun.applet.Main;
public class NetAss1 {
 //////////////////////Hanaa-Adel////////////////////////////////
   private static String readFile(File fileName,String filename) throws IOException {
        
        BufferedReader br = new BufferedReader(new FileReader(new File (filename)));
          
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
            return sb.toString();
        } finally {
            br.close();
        }
    }
    
     public static void Generator(String message, String func) throws IOException 
   {
        String messagetemp=message;
        for (int i = 0; i < func.length()-1; i++)   messagetemp+="0";
        String m = LongDiv(messagetemp,func);
        for (int i = 0; i < func.length()-1-m.length(); i++)        message+="0";
          
        
        ArrayList<String> list = new ArrayList();
        list.add(message+m);
        list.add(func);
        PrintWriter out = null;
        FileOutputStream outFile = null;
        try{
            outFile = new FileOutputStream("output.txt");
            out = new PrintWriter(outFile);
           for(String s:list){
               out.println(s);
           }
        }
        catch(IOException ex){
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE,null,ex);
        }
        finally{
            out.close();
            outFile.close();
        }
   }
    
/////////////////////Marina-Saad////////////////////////    
    
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
}
