/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.controller;

import com.wf.entity.User1;
import com.wf.service.User1Service;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;

/**
 *
 * @author ihebm
 */
public class ListData {
        private ObservableList<User1> users=FXCollections.observableArrayList();
    private Button button;

    public ListData() {
        
        User1Service pdao= User1Service.getInstance();
        users= pdao.displayAll();
        System.out.println(users);
    }

  
    
    public ObservableList<User1> getUsers(){
        return users;
    }
}
