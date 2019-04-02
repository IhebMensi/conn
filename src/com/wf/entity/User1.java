/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.entity;

import java.util.Objects;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

/**
 *
 * @author ihebm
 */
public class User1 {
    private SimpleIntegerProperty id;
    private SimpleStringProperty nom;
    private SimpleStringProperty prenom;
    private SimpleStringProperty img;
    private Button update;

    public User1(int id, String nom,String prenom, Button update) {
          this.nom = new SimpleStringProperty(nom);
        this.prenom = new SimpleStringProperty(prenom);
        this.update = update;
    }
    

    public User1() {
    }

    public User1(int id) {
        this.id = new SimpleIntegerProperty(id);
    }
    public User1(int id,String nom, String prenom) {
         this.id = new SimpleIntegerProperty(id);
        this.nom = new SimpleStringProperty(nom);
        this.prenom = new SimpleStringProperty(prenom);
         
    }
    public User1(String nom, String prenom,String img) {
        this.nom = new SimpleStringProperty(nom);
        this.prenom = new SimpleStringProperty(prenom);
           this.img = new SimpleStringProperty(img); 
    }

    public User1(SimpleIntegerProperty id) {
        this.id = id;
    }



    public User1(int id, String nom,String prenom,String img) {
        this.id = new SimpleIntegerProperty(id);
        this.nom = new SimpleStringProperty(nom);
        this.prenom = new SimpleStringProperty(prenom);
        this.img = new SimpleStringProperty(img); 
    }


    
         public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id = new SimpleIntegerProperty(id);
    }
 public SimpleIntegerProperty getIdProperty(){
        return id;
    }
    public String getNom() {
        return nom.get();
    }

    public void setNom(String nom) {
        this.nom = new SimpleStringProperty(nom);
    }

    public String getPrenom() {
        return prenom.get();
    }
    public SimpleStringProperty getNomProperty(){
        return nom;
    }
    public SimpleStringProperty getPrenomProperty(){
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = new SimpleStringProperty(prenom);
    }

    public String getImg() {
        return img.get();
    }

    public void setImg(String img) {
        this.img = new SimpleStringProperty(img);
    }
    public SimpleStringProperty getImgProperty(){
        return img;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id.get() + ", nom=" + nom.get() + ", prenom=" + prenom.get() + '}';
    }
        @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User1 other = (User1) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
