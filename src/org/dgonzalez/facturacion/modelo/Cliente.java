package org.dgonzalez.facturacion.modelo;

public class Cliente {
    private String rfc;
    private String nombre;

    public String getRfc(){
        return rfc;
    }

    public void setRfc(String rfc){
        this.rfc = rfc;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

}
