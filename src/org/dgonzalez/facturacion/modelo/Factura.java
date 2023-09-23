package org.dgonzalez.facturacion.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Factura {
    private int folio;
    private Cliente cliente;
    private DetalleFactura[] detalleFactura;
    private int indice;
    private String descripcion;
    private Date fecha;
    public static final int totalDetalle = 10;
    private static int ultimoFolio;

    public Factura(String descripcion, Cliente cliente){
        this.descripcion = descripcion;
        this.cliente = cliente;
        this.detalleFactura = new DetalleFactura[totalDetalle];
        this.folio = ++ultimoFolio;
        this.fecha = new Date();
    }

    public int getFolio(){
        return folio;
    }

    public Cliente getCliente(){
        return cliente;
    }

    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }

    public DetalleFactura[] getDetalleFactura(){
        return detalleFactura;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }

    public Date getFecha(){
        return fecha;
    }

    public void addDetalleFactura(DetalleFactura detalle){
        if(indice < totalDetalle) {
            this.detalleFactura[indice++] = detalle;
        }
    }

    public float calcularTotal(){
        float total = 0.0f;

        for(DetalleFactura detalle : this.detalleFactura){
            if(detalle == null){
                continue;
            }
            total += detalle.calcularImporte();
        }

        return total;
    }

    public String generarDetalle(){
        StringBuilder sb = new StringBuilder("Factura N°: ");
              sb.append(folio)
                .append("\n RFC: ")
                .append(this.cliente.getRfc())
                .append("\n Nombre Cliente: ")
                .append(this.cliente.getNombre())
                .append("\n Detalle: ")
                .append(this.descripcion).append("\n");

        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        sb.append("Fecha de Emisión: ")
                .append(df.format(this.fecha))
                .append("\n")
                .append("\n#\tNombre\t$\tCant.\tTotal\n");

        for(DetalleFactura item : this.detalleFactura){
            if(item == null){
                continue;
            }
            sb.append(item.getProducto().getId())
                    .append("\t")
                    .append(item.getProducto().getNombre())
                    .append("\t")
                    .append(item.getProducto().getPrecio())
                    .append("\t")
                    .append(item.getCantidad())
                    .append("\t")
                    .append(item.calcularImporte())
                    .append("\n");
        }

        sb.append("\nGran Total: ")
                .append(calcularTotal());

        return sb.toString();
    }

}
