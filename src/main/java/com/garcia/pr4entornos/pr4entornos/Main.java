/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.garcia.pr4entornos.pr4entornos;


public class Main {

    public static void main(String[] args) {
        Cajero cajero = new Cajero("Lorenzo");

        cajero.ANADIRPRODUCTO(new Producto("Leche", 1.20, 2));
        cajero.ANADIRPRODUCTO(new Producto("Pan", 0.80, 3));
        cajero.ANADIRPRODUCTO(new Producto("Manzanas", 2.50, 1));
        cajero.cobrar();

        Producto cereales = new Producto("Cereales", 3.20, 1);
        cajero.ANADIRPRODUCTO(new Producto("Yogur", 0.50, 6));
        cajero.ANADIRPRODUCTO(cereales);
        cajero.eliminarProDUCTO(cereales);
        cajero.cobrar();

        cajero.cierreCaja();
    }
}
