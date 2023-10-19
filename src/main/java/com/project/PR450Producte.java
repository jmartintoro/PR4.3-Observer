package com.project;

import java.beans.PropertyChangeSupport;

class PR450Producte {
    private int id;
    private String nom;
    private PropertyChangeSupport propertyChangeSupport;

    public PR450Producte(int id, String nom) {
        this.id = id;
        this.nom = nom;
        this.propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        int oldId = this.id;
        this.id = id;
        propertyChangeSupport.firePropertyChange("producteId", oldId, id);
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        String oldNom = this.nom;
        this.nom = nom;
        propertyChangeSupport.firePropertyChange("producteName", oldNom, nom);
    }

    public PropertyChangeSupport getPropertyChangeSupport() {
        return propertyChangeSupport;
    }
}