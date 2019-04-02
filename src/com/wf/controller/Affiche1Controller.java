
package com.wf.controller;

import com.wf.entity.User1;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.TextFieldTableCell;

/**
 *
 * @author ihebm
 */
public class Affiche1Controller implements Initializable {
     @FXML
    private TableView userTable;
    @FXML
    private TableColumn<User1, Integer> colId;
    @FXML
    private TableColumn<User1, String> colNom;
    @FXML
    private TableColumn<User1, String> colPrenom;
        @FXML
    private TableColumn<User1, Button> colUpdate;
       //Set up the ImageView
 @FXML
     private TableColumn<User1, String> colImage;
    @FXML
    private TextField rechercheId;
       @FXML
    private Label idLabel;
    @FXML
    private Label nomLabel;
    @FXML
    private Label prenomLabel;
    
   private ListData listdata = new ListData();
    @FXML
    @Override
    public void initialize(URL location, ResourceBundle resources) {
         userTable.setItems(listdata.getUsers());
              
         colId.setCellValueFactory(cell ->  cell.getValue().getIdProperty().asObject());
                colNom.setCellValueFactory(cellData -> cellData.getValue().getNomProperty());
             colPrenom.setCellValueFactory(cellData -> cellData.getValue().getPrenomProperty());
          
    }
     public void editTableCols(){

                  colNom.setCellFactory(TextFieldTableCell.forTableColumn());
         colNom.setOnEditCommit(e->{
             e.getTableView().getItems().get(e.getTablePosition().getRow()).setNom(e.getNewValue());
         });
                  colPrenom.setCellFactory(TextFieldTableCell.forTableColumn());
         colPrenom.setOnEditCommit(e->{
             e.getTableView().getItems().get(e.getTablePosition().getRow()).setPrenom(e.getNewValue());
             
         });
         
         userTable.setEditable(true);
     }
     
     
}
