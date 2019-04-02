/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.controller;

import com.wf.entity.User1;
import com.wf.service.User1Service;

import java.io.File;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
/**
 *
 * @author ihebm
 */
public class AfficheController implements Initializable {
     @FXML
    private TableView userTable;
    @FXML
    private TableColumn<User1, Integer> colId;
    @FXML
    private TableColumn<User1, String> colNom;
    @FXML
    private TableColumn<User1, String> colPrenom;
       //Set up the ImageView
 @FXML
     private TableColumn<User1, String> colImage;
 @FXML
     private TableColumn<User1, Image> colImage2;
    @FXML
    private TextField rechercheId;
       @FXML
    private Label idLabel;
    @FXML
    private Label nomLabel;
    @FXML
    private Label prenomLabel;
    @FXML
    private Label image;
    @FXML
    private ImageView imageView;
    private User1 u;
       @FXML
   private TextField recherche;
       
    private ObservableList<User1> listuser;
   
     FilteredList<User1> filter = new FilteredList<>(listuser, e -> true);
    
//    FileChooser fc = new FileChooser();
//    File selectedFile = new File("");
   private ListData listdata = new ListData();
    @FXML
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         userTable.setItems(listdata.getUsers());
              
         colId.setCellValueFactory(cell ->  cell.getValue().getIdProperty().asObject());
                colNom.setCellValueFactory(cellData -> cellData.getValue().getNomProperty());
             colPrenom.setCellValueFactory(cellData -> cellData.getValue().getPrenomProperty());
               colImage.setCellValueFactory(cellData -> cellData.getValue().getImgProperty());
             //  colImage2.setCellValueFactory(cellData -> cellData.getValue().getImgProperty());
             
                     userTable.setOnMouseClicked(event->{
        idLabel.setText(String.valueOf(listdata.getUsers()
                .get(userTable.getSelectionModel().getSelectedIndex())
                .getId()));
        nomLabel.setText(listdata.getUsers()
                .get(userTable.getSelectionModel().getSelectedIndex())
                .getNom());
        prenomLabel.setText(listdata.getUsers()
                .get(userTable.getSelectionModel().getSelectedIndex())
                .getPrenom());
//          imageView.setImage(new Image(listdata.getUsers()
//                .get(userTable.getSelectionModel().getSelectedIndex()).getImg()));
//                   
   image.setText(listdata.getUsers()
                .get(userTable.getSelectionModel().getSelectedIndex())
                .getImg());
   
   
    String imagepath = "/images/"+listdata.getUsers()
                .get(userTable.getSelectionModel().getSelectedIndex())
                .getImg();
           //System.out.println("file==>  "+imagepath);
           Image image = new Image(imagepath);
           imageView.setImage(image);
              
          userTable.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
                  
                             });
                             }
    
    
        
//    private void Image() {
//
//        //File file = new File(image.getText());
//        //Image image1 = new Image(file.toURI().toString());
//        System.out.println(""+selectedFile.getName());
//         Image image1 = new Image("http://localhost/wf/user1/img/"+image.getText());
//        imageView.setImage(image1);
//
//    }
    @FXML
    public void deleteButton(){
        ObservableList<User1> selectedRows, allusers;
        allusers = userTable.getItems();
        selectedRows = userTable.getSelectionModel().getSelectedItems();
        for(User1 user: selectedRows)
        {
          //  User1Service pdao1 = User1Service.getInstance();
            allusers.remove(user);
            
        }
        
    }
//        public void search1() {
//        FilteredList<User1> filter = new FilteredList<>(listuser, e -> true);
//        recherche.setOnKeyReleased(e -> {
//       recherche.textProperty().addListener((observable,oldValue,newValue) -> {
//           filter.setPredicate((Predicate<? super User1>) (User1 user1)->{
//           
//             if(newValue.isEmpty() || newValue==null){
//                 return true;
//             }
//             else if  (user1.getNom().contains(newValue)){
//                 return true;
//             }
//           return false;
//           });
//       });
//       SortedList sort=new SortedList(filter);
//       sort.comparatorProperty().bind(userTable.comparatorProperty());
//       userTable.setItems(sort);
//        });
//        }
        @FXML
    private void search1(KeyEvent event) {
        FilteredList<User1> filter = new FilteredList<>(listuser, e -> true);
       recherche.textProperty().addListener((observable,oldValue,newValue) -> {
           filter.setPredicate((Predicate<? super User1>) (User1 user1)->{
           
             if(newValue.isEmpty() || newValue==null){
                 return true;
             }
             else if((user1.getNom().contains(newValue)) || (user1.getNom().toLowerCase().contains(newValue))){
                 return true;
             }
           return false;
           });
           
       });
       SortedList sort=new SortedList(filter);
       sort.comparatorProperty().bind(userTable.comparatorProperty());
       userTable.setItems(sort);
    }
    
    }

    
    








//        colId.setCellValueFactory(cell -> cell.getValue().getIdProperty());
//        PrenomColonne.setCellValueFactory(cell -> cell.
//                getValue().getPrenomProperty());
//     colId.setCellValueFactory(cellData -> cellData.getValue().getIdProperty().asObject());
//          colNom.setCellValueFactory(cellData -> cellData.getValue().getNomProperty());
//               colPrenom.setCellValueFactory(cellData -> cellData.getValue().getPrenomProperty());
//                           User1Service u = User1Service.getInstance();
//
//     ObservableList<User1> user1List = u.displayAll();
//     populateTable(user1List);

    
//    private void populateTable(ObservableList<User1> user1List){
//      userTable.setItems(user1List);
//        
//    }

//    @FXML
//    private void rechercher(ActionEvent event) throws ClassNotFoundException,SQLException{
//         User1Service u1 = User1Service.getInstance();
//         ObservableList<User1> list;
//        list = (ObservableList<User1>) u1.displayById(Integer.parseInt(rechercheId.getText()));   
//          populateTable(list);
//          
//  
//         
//    }


