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
 /////////////////////Verina-Alber//////////////////////// 
 
  public static String LongDiv( String message, String func ){
        String m ="";    int mint;
        for(char x:message.toCharArray()){
            m=m+x;
            if(m.length()==func.length()){
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i < func.length(); i++)
                sb.append((func.charAt(i) ^ m.charAt(i)));
                m = sb.toString(); 
                mint=Integer.parseInt(m); 
                m=Integer.toString(mint);
                if(m.equals("0")) m="";
            }    
        }
    
        return m;
    }
 
 
 
 
 
/////////////////////Marina-Saad////////////////////////   
 public static StringBuilder Alter(String message,int index) {      
        StringBuilder d = new StringBuilder(message);  
        if(message.charAt(index)=='0')         d.setCharAt(4,'1');
        else                      d.setCharAt(4,'0');
            
        return(d);
    
    }
    

      public static void main(String[] args) throws IOException {
        String TorF;
        System.out.println("Generator < File | Verifier");
        String inputText;
        inputText = readFile(new File ("src\\\\input.txt"),"input.txt");
        String LinesofG[] = inputText.split("\\r?\\n");
        Generator(LinesofG[0],LinesofG[1]);
        
        String outputText;
        outputText = readFile(new File ("src\\\\output.txt"),"output.txt");
        String LinesofV[] = outputText.split("\\r?\\n");
        TorF = Verifier(LinesofV[0],LinesofV[1]);
        System.out.println(TorF);
        
        
        System.out.println("Generator < File | Alter 4 | Verifier");
        StringBuilder test = Alter(LinesofV[0],4);
        String t =test.toString();
        TorF = Verifier(t,LinesofV[1]);
        System.out.println(TorF);
        
        System.out.println("press space to exit");
        Scanner var = new Scanner(System.in);
        String s=var.nextLine(); 
    }
    

}
