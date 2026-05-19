/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.garcia.pr4entornos.pr4entornos;

import java.util.ArrayList;

/**
 * Representa el cajero de un supermercado.
 * <p>
 * Se encarga de gestionar los tickets de compra de los clientes,
 * acumulando el número de tickets emitidos y el total facturado
 * durante el día.
 * </p>
 * 
 * Cada ticket está formado por una lista de productos que el cajero
 * va añadiendo o eliminando antes de realizar el cobro.
 * 
 * @author Raul
 */
public class Cajero {

    /**
     * Nombre identificativo del cajero que se mostrará en los tickets
     * y en el cierre de caja.
     */
    String n;

    /**
     * Número de tickets emitidos por este cajero durante el día.
     */
    int c;

    /**
     * Importe total facturado por este cajero durante el día,
     * incluyendo impuestos.
     */
    double t;

    /**
     * Lista de productos que componen el ticket actual que se está
     * preparando para el cliente.
     */
    ArrayList <Producto> ps;

    /**
     * Crea un nuevo cajero con el nombre indicado.
     * <p>
     * Al crear el cajero, el número de tickets emitidos y el total del día
     * se inicializan a cero, y la lista de productos del ticket actual
     * comienza vacía.
     * </p>
     *
     * @param n nombre del cajero que se mostrará en los tickets
     */
    public Cajero(String n) {
        this.n = n;
        this.c = 0;
        this.t = 0;
        this.ps = new ArrayList<>();
    }

    /**
     * Añade un producto a la lista del ticket actual.
     * <p>
     * El producto pasado como parámetro se incorpora al final de la lista
     * de productos que se están cobrando a un cliente concreto.
     * </p>
     *
     * @param p producto que se desea añadir al ticket actual
     */
    public void ANADIRPRODUCTO(Producto p) {
        ps.add(p);
    }

    /**
     * Elimina un producto de la lista del ticket actual.
     * <p>
     * Si el producto indicado se encuentra en la lista del ticket,
     * se elimina la primera aparición de dicho producto. Si no está,
     * la lista permanece sin cambios.
     * </p>
     *
     * @param p producto que se desea eliminar del ticket actual
     */
    public void eliminarProDUCTO(Producto p) {
        ps.remove(p);
    }

    /**
     * Realiza el cobro del ticket actual y genera el ticket por pantalla.
     * <p>
     * Calcula el subtotal sumando el importe de todos los productos del
     * ticket, aplica el IVA, calcula el total, imprime el detalle del
     * ticket por consola, incrementa el contador de tickets emitidos,
     * acumula el total del día y, finalmente, limpia la lista de productos
     * para preparar el siguiente ticket.
     * </p>
     */
    public void cobrar() {
        double subt = 0;
        for (Producto p : ps) {
            subt = subt + p.calcularImporte();
        }
        double iva = subt * 0.21;
        double tot = subt + iva;

        System.out.println("===== TICKET =====");
        System.out.println("Cajero: " + n);
        for (Producto p : ps) {
            System.out.println(p.getNombre() + " x" + p.getCantidad()
                    + " = " + String.format("%.2f", p.calcularImporte()) + " EUR");
        }
        System.out.println("------------------");
        System.out.println("Subtotal: " + String.format("%.2f", subt) + " EUR");
        System.out.println("IVA (21%): " + String.format("%.2f", iva) + " EUR");
        System.out.println("TOTAL: " + String.format("%.2f", tot) + " EUR");
        System.out.println("==================");

        c = c + 1;
        t = t + tot;
        ps.clear();
    }

    /**
     * Muestra por pantalla el cierre de caja del día.
     * <p>
     * Calcula el IVA recaudado a partir del total facturado,
     * imprime un resumen con el nombre del cajero, el número de tickets
     * emitidos, el total facturado y el importe total de IVA recaudado.
     * </p>
     */
    public void cierreCaja() {
        double ivaRec = t - (t / (1 + 0.21));

        System.out.println("===== CIERRE DE CAJA =====");
        System.out.println("Cajero: " + n);
        System.out.println("--------------------------");
        System.out.println("Tickets emitidos: " + c);
        System.out.println("Total facturado: " + String.format("%.2f", t) + " EUR");
        System.out.println("IVA recaudado: " + String.format("%.2f", ivaRec) + " EUR");
        System.out.println("==========================");
    }

    /**
     * Indica si el ticket actual está vacío.
     * <p>
     * Un ticket se considera vacío cuando no contiene ningún producto
     * en la lista interna.
     * </p>
     *
     * @return {@code true} si no hay productos en el ticket actual;
     *         {@code false} en caso contrario
     */
    public boolean ticketVacio() {
        return ps.isEmpty();
    }

    /**
     * Devuelve el número total de tickets emitidos durante el día.
     *
     * @return cantidad de tickets emitidos por este cajero
     */
    public int getTicketsEmitidos() {
        return c;
    }

    /**
     * Devuelve el importe total facturado durante el día.
     * <p>
     * El total incluye todos los tickets emitidos y ya incorpora
     * los impuestos aplicados.
     * </p>
     *
     * @return importe total facturado en el día
     */
    public double getTotalDia() {
        return t;
    }
}
