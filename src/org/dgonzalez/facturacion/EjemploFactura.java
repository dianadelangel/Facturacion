package org.dgonzalez.facturacion;

import org.dgonzalez.facturacion.modelo.*;

import java.util.Scanner;

public class EjemploFactura {
    public static void main(String[] args) {

        Cliente cliente1 = new Cliente();
        cliente1.setRfc("GOAD000112HQ8");
        cliente1.setNombre("Diana");

        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la descripción de la factura: ");
        String desc = sc.nextLine();

        Factura factura = new Factura(desc,cliente1);

        Producto producto;

        System.out.println();

        for(int i = 0; i< 5; i++){
            producto = new Producto();
            System.out.print("Ingrese producto n° " + producto.getId() + ": ");
            producto.setNombre(sc.nextLine());

            System.out.print("Ingrese el precio: ");
            producto.setPrecio(sc.nextFloat());

            System.out.print("Ingrese la cantidad: ");

            factura.addDetalleFactura(new DetalleFactura(producto, sc.nextInt()));

            System.out.println();
            sc.nextLine();
        }

        System.out.println(factura.generarDetalle());
    }
}
