package org.dgonzalez.facturacion.modelo;

public class Producto {
    private int id;
    private String nombre;
    private float precio;
    private static int ultimoId;

    public Producto(){
        this.id = ++ultimoId;
    }

    public int getId(){
        return id;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public double getPrecio(){
        return precio;
    }

    public void setPrecio(float precio){
        this.precio = precio;
    }
}
