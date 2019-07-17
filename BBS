/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bbs;
import java.io.*;
import java.net.*;
import java.util.*;
import java.io.*;
import java.sql.*;
/**
 *
 * @author user01
 */
public class ClientHandler extends Thread{
    
    protected Socket incoming;
    
    public ClientHandler(Socket incoming){
        this.incoming=incoming;
    }
    public void run(){
        try{
            BufferedReader in=new BufferedReader(new InputStreamReader(incoming.getInputStream(),"BIG5"));
            PrintWriter out=new PrintWriter(new OutputStreamWriter(incoming.getOutputStream(),"BIG5")); 
            out.print("hi"); out.flush(); 
            ResultSet rs;
            while(true){
            /*    String str = in.readLine();
                if (str == null){
                    break;
                }*/
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = (Connection)DriverManager.getConnection("jdbc:mysql://db.mis.kuas.edu.tw/s1102137105","s1102137105","yoga123");
                Statement aStatement = conn.createStatement();
                out.print("輸入1 登入 2 註冊 3 刪除 4 離開"); out.flush(); 
                
                String login=in.readLine();
                if(login.equals("1")){     //輸入帳號
                    out.print("輸入帳號:");out.flush();
                    String ID=in.readLine();
                    out.print("輸入密碼:");out.flush();
                    String pass=in.readLine();
                    rs = aStatement.executeQuery("SELECT `ID`,`pass` FROM `BBS` WHERE ID ='"+ID+"'&& pass ='"+pass+"'");
                    while(rs.next()){
                    while(true){    
                        out.println();out.flush();
                        out.println("輸入論壇編號進入論壇:");out.flush();
                            rs = aStatement.executeQuery("SELECT * FROM `Forum`");
                            ResultSetMetaData rsmeta=rs.getMetaData();
                            int cols=rsmeta.getColumnCount();
                            
                            while(rs.next()){
                                for(int i=1; i<=cols; i++){
                                    if (i > 1){
                                        out.print("\t");out.flush();
                                    } 
                                        out.print(rs.getString(i));out.flush();
                                }
                                out.println();out.flush();
                            }
                            out.println();out.flush();
                            
                            out.println("n 新增論壇 d 刪除論壇 q 離開:");out.flush();
                            String k=in.readLine();
                            rs=aStatement.executeQuery("SELECT `ID` FROM `Forum` WHERE ID='"+k+"'");
                            if(rs.next()){      //新增刪除文章
                                out.println();out.flush();
                                rs = aStatement.executeQuery("SELECT `a_ID`, `title`, `Content` FROM `Article` WHERE ID='"+k+"'");
                                while(rs.next()){
                                for(int i=1; i<=cols; i++){
                                    if (i > 1){
                                        out.print("\t");out.flush();
                                    } 
                                        out.print(rs.getString(i));out.flush();
                                }
                                out.println();out.flush();
                            }
                                
                            out.println();out.flush();
                                out.print("n 新增文章 d 刪除文章:");out.flush();
                                String t=in.readLine();
                                if(t.equals("n")){
                                    out.print("新增文章標題:");out.flush();
                                    String art=in.readLine();
                                    out.print("新增內容:");out.flush();
                                    String content=in.readLine();
                                    int sum=1;
                                    rs = aStatement.executeQuery("SELECT * FROM `Article`");
                                    while(rs.next()){
                                        sum++;
                                    }
                                    rs = aStatement.executeQuery("SELECT `ID` FROM `Article` WHERE a_ID='"+sum+"'");
                                    while(rs.next()){
                                        sum++;
                                    }
                                    aStatement.executeUpdate("INSERT INTO `Article`(`ID`, `a_ID`, `title`, `Content`) VALUES ('"+k+"','"+sum+"','"+art+"','"+content+"')");
                                //    break;
                                }
                                if(t.equals("d")){
                                    out.print("刪除文章:");out.flush();
                                    String art=in.readLine();
                                    aStatement.executeUpdate("DELETE FROM `Article` WHERE title='"+art+"'");
                                //    break;
                                }
                            }
                            if(k.equals("q")){
                                break;
                            }
                            if(k.equals("n")){        //新增論壇
                                out.print("新增論壇標題:");out.flush();
                                String forum=in.readLine();
                                rs = aStatement.executeQuery("SELECT `text` FROM `Forum` WHERE text='"+forum+"'");
                                if(rs.next()){
                                    out.println("論壇名稱重複");out.flush();
                                }
                                else{
                                    int sum=1;;
                                    rs = aStatement.executeQuery("SELECT * FROM `Forum`");
                                    while(rs.next()){
                                        sum++;
                                    }
                                    rs = aStatement.executeQuery("SELECT `ID` FROM `Forum` WHERE ID='"+sum+"'");
                                    while(rs.next()){
                                        sum++;
                                    }
                                    aStatement.executeUpdate("INSERT INTO `Forum`(`ID`,`text`) VALUES ('"+sum+"','"+forum+"')");
                                    out.print("新增成功");out.flush();
                                //    break;
                                }
                            }
                            if(k.equals("d")){        //刪除論壇
                                out.print("刪除論壇:");out.flush();
                                String forum=in.readLine();
                                aStatement.executeUpdate("DELETE FROM `Forum` WHERE (text='"+forum+"')");
                            //    break;
                            }
                            }
                    }
                }
                if(login.equals("2")){        //新增帳號
                    while(true){    
                        out.print("新增帳號:");out.flush();
                        String ID=in.readLine();
                        rs = aStatement.executeQuery("SELECT `ID` FROM `BBS` WHERE ID ='"+ID+"'");
                        if(rs.next()){
                            out.println("帳號已有人使用");out.flush();
                        }
                        else{
                            out.print("新增密碼:");out.flush();
                            String pass=in.readLine();
                            aStatement.executeUpdate("INSERT INTO `BBS`(`ID`, `pass`) VALUES ('"+ID+"','"+pass+"')");
                            out.println("新增成功");out.flush();
                            break;
                        }
                    }   
                }
                if(login.equals("3")){        //刪除帳號
                    out.print("刪除帳號:");out.flush();
                    String ID=in.readLine();
                    out.print("刪除密碼:");out.flush();
                    String pass=in.readLine();
                    aStatement.executeUpdate("DELETE FROM BBS WHERE ID='"+ID+"'&& pass='"+pass+"'");
                }   
                if(login.equals("4")){
                    break;
                }
                else{
                    out.println("重新登入");
                }
                    //rs.close();
                    aStatement.close();
                    conn.close();
            }
            in.close();
            out.close();
            incoming.close();
 } catch (Exception e) {} 
        
    }
}
