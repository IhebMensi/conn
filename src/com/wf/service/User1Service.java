/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.service;

import com.wf.entity.User1;

import com.wf.util.ConnectionDB;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author ihebm
 */
public class User1Service implements IService<User1>{
    private static User1Service instance;
    private Statement st;
    private ResultSet rs;
    
    public User1Service() {
        ConnectionDB cs=ConnectionDB.getInstance();
        try {
            st=cs.getCnx().createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(User1Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static User1Service getInstance(){
        if(instance==null) 
            instance=new User1Service();
        return instance;
    }
    @Override
    public void insert(User1 o) {
        String req="insert into user1 (nom,prenom,img) values ('"+o.getNom()+"','"+o.getPrenom()+"','"+o.getImg()+"')";
        try {
            st.executeUpdate(req);
        } catch (SQLException ex) {
            Logger.getLogger(User1Service.class.getName()).log(Level.SEVERE, null, ex);
        }    }

    @Override
    public void delete(User1 o) {
        String req="DELETE from user1 where id="+o.getId();

              try {
            st.executeUpdate(req);
             
        } catch (SQLException ex) {
            Logger.getLogger(User1Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ObservableList<User1> displayAll() {
        String req="select * from user1";
        ObservableList<User1> list=FXCollections.observableArrayList();       
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                User1 p=new User1();
                p.setId(rs.getInt(1));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString(3));
                p.setImg(rs.getString(4));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(User1Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public List<User1> displayAllList() {
        String req="select * from personne";
        List<User1> list=new ArrayList<>();
        
        try {
            rs=st.executeQuery(req);
            while(rs.next()){
                User1 p=new User1();
                p.setId(rs.getInt(1));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString(3));
                 p.setImg(rs.getString(4));
                list.add(p);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(User1Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public User1 displayById(int id) {
           String req="select * from user1 where id ="+id;
           User1 p=new User1();
        try {
            rs=st.executeQuery(req);
           // while(rs.next()){
            rs.next();
                p.setId(rs.getInt("id"));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString("prenom"));
            //}  
        } catch (SQLException ex) {
            Logger.getLogger(User1Service.class.getName()).log(Level.SEVERE, null, ex);
        }
    return p;    }

    @Override
    public boolean update(User1 os) {
        String qry = "UPDATE user1 SET nom = '"+os.getNom()+"', prenom = '"+os.getPrenom()+"' WHERE id = "+os.getId();
        
        try {
            if (st.executeUpdate(qry) > 0) {
                return true;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(User1Service.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;    }
    
}
