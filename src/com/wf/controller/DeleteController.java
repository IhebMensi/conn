/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.controller;

import com.wf.entity.User1;
import com.wf.service.User1Service;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

/**
 *
 * @author ihebm
 */
public class DeleteController {
      @FXML
private TextField txtid;
  
    @FXML
    private void deleteUser(ActionEvent event) throws ClassNotFoundException, SQLException{
                   User1 u= new User1(Integer.parseInt(txtid.getText()));
            User1Service pdao1 = User1Service.getInstance();
            pdao1.delete(u);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(" Supprimer");
        alert.setHeaderText(null);
        alert.setContentText("Personne supprimé avec succés!");
        alert.show();
        txtid.setText("");

  }
}
