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
public class UpdateController {
  @FXML
private TextField txtid;
  @FXML
private TextField  txtnom;
  @FXML
private TextField  txtprenom;

  @FXML
  private void updateUser(ActionEvent event1) throws ClassNotFoundException, SQLException{
                   User1 u=new User1(Integer.parseInt(txtid.getText()),txtnom.getText(),txtprenom.getText());
            User1Service pdao = User1Service.getInstance();
            pdao.update(u);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Personne modifié avec succés!");
        alert.show();
        txtid.setText("");
                txtnom.setText("");
        txtprenom.setText("");
  }

}
