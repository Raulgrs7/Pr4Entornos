package com.garcia.pr4entornos.pr4entornos;

import java.util.ArrayList;
public class Cajero {

    private static final double IVA_PORCENTAJE = 0.21;

    private String nomCajero;
    private int contTickets;
    private double totalFacturado;
    private ArrayList<Producto> listaProductos;

    public Cajero(String nombreCajero) {
        this.nomCajero = nomCajero;
        this.contTickets = 0;
        this.totalFacturado = 0;
        this.listaProductos = new ArrayList<>();
    }

    public void ANADIRPRODUCTO(Producto producto) {
        anadirProducto(producto);
    }

    public void eliminarProDUCTO(Producto producto) {
        eliminarProducto(producto);
    }
 
    public void anadirProducto(Producto producto) {
        listaProductos.add(producto);
    }

    public void eliminarProducto(Producto producto) {
        listaProductos.remove(producto);
    }

    public void cobrar() {
        double subtotal = calcularSubtotal();
        double iva = subtotal * IVA_PORCENTAJE;
        double totalTicket = subtotal + iva;

        imprimirTicket(subtotal, iva, totalTicket);

        actualizarTotalesYLimpiar(totalTicket);
    }
 

    private double calcularSubtotal() {
        double subtotalAcumulado = 0;
        for (Producto p : listaProductos) {
            subtotalAcumulado = subtotalAcumulado + p.calcularImporte();
        }
        return subtotalAcumulado;
    }

    private void imprimirTicket(double subtotal, double iva, double totalTicket) {
        System.out.println("===== TICKET =====");
        System.out.println("Cajero: " + nomCajero);
        for (Producto p : listaProductos) {
            System.out.println(p.getNombre() + " x" + p.getCantidad()
                    + " = " + String.format("%.2f", p.calcularImporte()) + " EUR");
        }
        System.out.println("------------------");
        System.out.println("Subtotal: " + String.format("%.2f", subtotal) + " EUR");
        System.out.println("IVA (21%): " + String.format("%.2f", iva) + " EUR");
        System.out.println("TOTAL: " + String.format("%.2f", totalTicket) + " EUR");
        System.out.println("==================");
    }

    private void actualizarTotalesYLimpiar(double totalTicket) {
        contTickets = contTickets + 1;
        totalFacturado = totalFacturado + totalTicket;
        listaProductos.clear();
    }

    public void cierreCaja() {
        double ivaRecaudado = totalFacturado - (totalFacturado / (1 + IVA_PORCENTAJE));
        
        System.out.println("===== CIERRE DE CAJA =====");
        System.out.println("Cajero: " + nomCajero);
        System.out.println("--------------------------");
        System.out.println("Tickets emitidos: " + contTickets);
        System.out.println("Total facturado: " + String.format("%.2f", totalFacturado) + " EUR");
        System.out.println("IVA recaudado: " + String.format("%.2f", ivaRecaudado) + " EUR");
        System.out.println("==========================");
    }

    public boolean ticketVacio() {
        return listaProductos.isEmpty();
    }

    public int getTicketsEmitidos() {
        return contTickets;
    }

    public double getTotalDia() {
        return totalFacturado;
    }
}
