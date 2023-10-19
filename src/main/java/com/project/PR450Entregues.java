package com.project;

import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

class PR450Entregues {
    private ArrayList<PR450Producte> productes;
    private PropertyChangeSupport propertyChangeSupport;

    public PR450Entregues() {
        productes = new ArrayList<>();
        this.propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public void addProducte(PR450Producte producte) {
        productes.add(producte);
        propertyChangeSupport.firePropertyChange("entreguesAdd", null, producte);
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
            propertyChangeSupport.firePropertyChange("entreguesRemove", removedProducte, null);
        }
    }

    public PropertyChangeSupport getPropertyChangeSupport() {
        return propertyChangeSupport;
    }

    @Override
    public String toString() {
        return "Entregues: productes = " + productes;
    }
}