package com.project;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Main {
    public static void main(String[] args) {
        PR450Producte p0 = new PR450Producte(0, "Llibre");
        PR450Producte p1 = new PR450Producte(1, "Boli");
        PR450Producte p2 = new PR450Producte(2, "Rotulador");
        PR450Producte p3 = new PR450Producte(3, "Carpeta");
        PR450Producte p4 = new PR450Producte(4, "Motxilla");

        PR450Magatzem magatzem = new PR450Magatzem();
        PR450Entregues entregues = new PR450Entregues();

        // Crear listeners para los productos, magatzem y entregues
        PropertyChangeListener productListener = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().equals("producteId")) {
                    System.out.println("Producte con ID " + evt.getOldValue() + " ha cambiado a ID " + evt.getNewValue());
                } else if (evt.getPropertyName().equals("producteName")) {
                    System.out.println("Producte ha cambiado el nombre de '" + evt.getOldValue() + "' a '" + evt.getNewValue() + "'");
                }
            }
        };

        PropertyChangeListener magatzemListener = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().equals("magatzemAdd")) {
                    System.out.println("S'ha afegit el producte amb ID " + ((PR450Producte) evt.getNewValue()).getId() +
                            " al magatzem, capacitat: " + magatzem.getCapacitat());
                } else if (evt.getPropertyName().equals("magatzemRemove")) {
                    System.out.println("S'ha esborrat el producte amb ID " + ((PR450Producte) evt.getOldValue()).getId() +
                            " del magatzem, capacitat: " + magatzem.getCapacitat());
                } else if (evt.getPropertyName().equals("magatzemEntrega")) {
                    System.out.println("S'ha mogut el producte amb ID " + ((PR450Producte) evt.getOldValue()).getId() +
                            " del magatzem cap a les entregues");
                }
            }
        };

        PropertyChangeListener entreguesListener = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                if (evt.getPropertyName().equals("entreguesAdd")) {
                    System.out.println("S'ha afegit el producte amb ID " + ((PR450Producte) evt.getNewValue()).getId() +
                            " a la llista d'entregues");
                } else if (evt.getPropertyName().equals("entreguesRemove")) {
                    System.out.println("S'ha entregat el producte amb ID " + ((PR450Producte) evt.getOldValue()).getId());
                }
            }
        };

        // Agregar los Property Listeners a las clases pertinentes
        p0.getPropertyChangeSupport().addPropertyChangeListener(productListener);
        p1.getPropertyChangeSupport().addPropertyChangeListener(productListener);
        p2.getPropertyChangeSupport().addPropertyChangeListener(productListener);
        p3.getPropertyChangeSupport().addPropertyChangeListener(productListener);
        p4.getPropertyChangeSupport().addPropertyChangeListener(productListener);

        magatzem.getPropertyChangeSupport().addPropertyChangeListener(magatzemListener);
        entregues.getPropertyChangeSupport().addPropertyChangeListener(entreguesListener);

        p0.setId(5);
        p0.setNom("Llibreta");
        p1.setNom("Boli");

        magatzem.addProducte(p0);
        magatzem.addProducte(p1);
        magatzem.addProducte(p2);
        magatzem.addProducte(p3);
        magatzem.addProducte(p4);

        magatzem.removeProducte(2);
        magatzem.removeProducte(3);
        magatzem.removeProducte(4);

        entregues.removeProducte(2);
        entregues.removeProducte(3);

        System.out.println(magatzem);
        System.out.println(entregues);
    }
}