package it.terenzi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Scanner scanner = new Scanner(System.in);
        String ip = "";
        int port =0;

        // connessione server
        
        ip = scanner.nextLine();
        port = Integer.parseInt(scanner.nextLine());
        Socket s = new Socket(ip, port);

        // creo un modo per ascoltare e parlare
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);

        String response;
        String message="";

        do {
             response = in.readLine();
             if(response.equals("WELCOME")){
                message = scanner.nextLine();
                out.println(message);
             }


        } while (!response.equals("BYE"));


    }
}