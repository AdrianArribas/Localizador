package Javabeans;

/**
 * Created by Adrian on 19/04/2017.
 */

public class Objeto {
    private String nombre;
    private double longitud;
    private double latitud;

    public Objeto(String nombre, double longitud, double latitud) {
        this.nombre = nombre;
        this.longitud = longitud;
        this.latitud = latitud;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }
    public String toString(){
        return nombre+" | "+longitud+" | "+latitud;
    }
}

