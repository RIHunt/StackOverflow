/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stackoverflow.ans;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;

public class Main {


            public static void main(String[] args) throws IOException {
                     BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\user\\Desktop\\in.txt"));
                     PrintWriter out = new PrintWriter(new FileWriter("C:\\Users\\user\\Desktop\\result.txt"), true);
                     String User;
                     
                     while ((User = br.readLine()) != null){
                         
                    URL url = new URL("http://gagqga.gq/r/migrate.php?name="+User);
                    URLConnection connection = url.openConnection();
                   // BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                    InputStreamReader reader=new InputStreamReader(connection.getInputStream());
                 
                    boolean result = Boolean.valueOf(reader.ready());

                    String str = Boolean.toString(result);
                    System.out.println(User+" is "+str);
                     out.write(User+" is "+str);
                  out.write("\r\n");               
                     }


            }
    }