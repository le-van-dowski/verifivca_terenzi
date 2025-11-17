package it.terenzi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException{
        ServerSocket myss = new ServerSocket(3000);
        

        do{
            Socket s = myss.accept();

            MyThread t =new MyThread(s);
            t.start();

        }while(true);
    }
}