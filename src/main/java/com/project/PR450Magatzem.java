package com.project;

import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

class PR450Magatzem {
    private ArrayList<PR450Producte> productes;
    private int capacitat;
    private PropertyChangeSupport propertyChangeSupport;

    public PR450Magatzem() {
        productes = new ArrayList<>();
        capacitat = 10;
        this.propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public ArrayList<PR450Producte> getProductes() {
        return productes;
    }

    public void addProducte(PR450Producte producte) {
        productes.add(producte);
        capacitat--;
        propertyChangeSupport.firePropertyChange("magatzemAdd", null, producte);
    }

    public void removeProducte(int id) {
        PR450Producte removedProducte = null;
        for (PR450Producte producte : productes) {
            if (producte.getId() == id) {
                removedProducte = producte;
                break;
            }
        }
        if (removedProducte != null) {
            productes.remove(removedProducte);
            capacitat++;
            propertyChangeSupport.firePropertyChange("magatzemRemove", removedProducte, null);
            propertyChangeSupport.firePropertyChange("magatzemEntrega", removedProducte, null);
        }
    }

    public PropertyChangeSupport getPropertyChangeSupport() {
        return propertyChangeSupport;
    }

    public int getCapacitat() {
        return capacitat;
    }

    @Override
    public String toString() {
        return "Magatzem: capacitat = " + capacitat + ", productes = " + productes;
    }
}