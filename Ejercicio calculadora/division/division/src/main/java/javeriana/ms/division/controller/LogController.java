package javeriana.ms.division.controller;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;


public class LogController {

    private String fecha;
    private String usuario;


    public void writeLog(String name){

        try {
            Date fecha = new Date();
            fecha.getTime();


            File Obj = new File("divlogs.txt");
            if (Obj.createNewFile()) {
                FileWriter writer = new FileWriter("divlogs.txt");
                BufferedWriter bw = new BufferedWriter(writer);
                bw.append( "usuario; "+ name+ ", fecha; "+ fecha);
                bw.close();
            }
            else {
                FileWriter writer = new FileWriter("divlogs.txt",true);
                BufferedWriter bw = new BufferedWriter(writer);
                bw.newLine();
                bw.append( "usuario; "+ name+ ", fecha; "+ fecha);
                bw.close();
            }

        }
        catch (IOException e) {
            System.out.println("Ocurrio un error.");
            e.printStackTrace();
        }
    }

    public ArrayList<LogController> readLogs(){

        try {
            ArrayList<LogController> access = new ArrayList();
            File Obj = new File("divlogs.txt");
            Scanner Reader = new Scanner(Obj);

            while (Reader.hasNextLine()) {
                String data = Reader.nextLine();
                LogController user = new LogController();
                StringTokenizer tokenizer = new StringTokenizer(data, ",");

                while (tokenizer.hasMoreTokens()) {
                    String token = tokenizer.nextToken();
                    StringTokenizer tokenizer1 = new StringTokenizer(token, ";");

                    while (tokenizer1.hasMoreTokens()) {
                        String token1 = tokenizer1.nextToken();

                        if (token1.contains("usuario")){
                            String tokenUs = tokenizer1.nextToken();
                            if (token1 !=null)
                            user.setUsuario(tokenUs);
                        } else if (token1.contains("fecha")) {
                            String tokenFe = tokenizer1.nextToken();
                            if (tokenFe != null)
                            user.setFecha(tokenFe);
                        }
                    }
                }
                    access.add(user);
            }
            Reader.close();

            return access;
        }
        catch (FileNotFoundException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
            return null;
        }

    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
