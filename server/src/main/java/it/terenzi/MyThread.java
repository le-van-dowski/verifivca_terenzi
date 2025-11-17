package it.terenzi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MyThread extends Thread{
    Socket socket;

    public MyThread(Socket s){
        Socket s = socket;

    }

    public void run(){
        
        
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            List<Task> tasks = new ArrayList<>();
            String [] parts;
            
            boolean end =false;

            out.println("WELCOME");
            String response;
            String username="";
            String stato;
            boolean e=false;
            
            do{
                response = in.readLine();
                parts = response.split(" ", 2);
                do {
                    if(parts[0].equals("LOGIN")){
                        out.println("OK");
                        username=parts[1];
                    }else{
                        out.println("ERR LOGINREQUIRED");
                    }
                } while (!(parts[0].equals("LOGIN")));

                do {
                    String [] part;
                    e=false;
                    response = in.readLine();
                    part =response.split(" ", 4 ); //split in 4 il resto rimane null

                    if(part[0].equals("LIST")){
                        out.println("TASKS : \n" );
                        // + foreach printout tasks);
                        out.println("END");

                    }else if(part[0].equals("FILTER")){
                        stato = part[1];
                        if(!(stato == "TODO" || stato=="DOING" || stato=="DONE")){
                            e=true;//errore
                            out.println("ERR STATE");
                        }else{

                            out.println("TASKS : \n" );
                            // + foreach printout tasks con stesso stato);
                            out.println("END");
                        }
                    }else if(part[0].equals("MINE")){
                        if(!part[1].equals(null)){
                            e=true;
                            out.println("ERR SYNTAX");
                        }else{

                            out.println("TASKS : \n" );
                            // + foreach printout tasks con stesso autore);
                            out.println("END");
                        }
                    }else if(part[0].equals("SET")){
                        //se part[1] equals getid && (part[2] == "TODO" || part[2]=="DOING" || part[2]=="DONE");
                        //setStato(part[2]);
                    }else if(part[0].equals("DEL")){
                        // if(part[0].equals(.getid())){
                        //     tasks.remove(tasks[])
                        // }
                    }else if(part[0].equals("QUIT")){
                        end=true;
                    }else{
                        e=true;
                    }
                } while (e);

                response = in.readLine();
                parts =response.split(" ", 4 );
                do {
                    //controllo caps

                } while (!e);
                stato="";
                tasks.add(new Task( parts[1], parts[2],stato,parts[3], username));

            }while(!end);
            

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
