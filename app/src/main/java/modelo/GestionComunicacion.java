package modelo;
import java.io.PrintStream;
import java.net.Socket;
import Javabeans.Objeto;

public class GestionComunicacion {
    String host="192.168.1.33";
    int puerto=9000;

    public void recuperarLugares(Objeto LOC){
        try{
            int cli1=1;
            Socket sc = new Socket(host, puerto);
            PrintStream salida = new PrintStream(sc.getOutputStream());
            salida.println(LOC);
            sc.close();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }

}

