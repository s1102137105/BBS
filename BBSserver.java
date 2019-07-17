/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbs;
import java.io.*;
import java.net.*;

/**
 *
 * @author user01
 */
public class BBS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        ServerSocket s = new ServerSocket(23); 
        while(true){
            Socket incoming = s.accept();
            new ClientHandler(incoming).start();
        }
        }
    }
