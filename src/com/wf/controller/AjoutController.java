/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.wf.controller;

import com.wf.entity.User1;
import com.wf.service.User1Service;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.commons.io.FileUtils;

/**
 *
 * @author ihebm
 */
public class AjoutController {

    @FXML
    private TextField txtNom;
    @FXML
    private TextField txtPrenom;
        @FXML
    private TextField txtImg;
        @FXML
    private ImageView imageView;
    
    private String ImgToDb;
    @FXML
    private void insertUser(ActionEvent event) throws ClassNotFoundException,SQLException{
                 User1 u = new User1(txtNom.getText(), txtPrenom.getText(),ImgToDb);
            User1Service pdao = User1Service.getInstance();
            pdao.insert(u);
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText("Personne insérée avec succés!");
        alert.show();
                txtNom.setText("");
        txtPrenom.setText("");
    }
            @FXML
    public void BtnUpAction(ActionEvent event) throws IOException{
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image Files",
                        "*.bmp", "*.png", "*.jpg", "*.gif"));
        File selectedFile =fc.showOpenDialog(new Stage());
        System.out.println("");
        if (selectedFile != null){
            //System.out.println(selectedFile.getName());
//            System.out.println(selectedFile.getAbsolutePath());
//            btnup.setText(selectedFile.getAbsolutePath());

           String imagepath = selectedFile.toURI().toString();
           //System.out.println("file==>  "+imagepath);
           Image image = new Image(imagepath);
           imageView.setImage(image);
           
           File source = new File(selectedFile.getAbsolutePath());
           File dest = new File("C:\\xampp\\htdocs\\PIDev_WorldFriendship\\web\\images");
           FileUtils.copyFileToDirectory(source, dest);
           //               System.out.println("file uploaded ^^");
           Path p = Paths.get(selectedFile.getAbsolutePath());
           String file = p.getFileName().toString();
           //               System.out.println("your link :))))))))");
//               System.out.println("http://localhost/pidev/images/"+file);
ImgToDb = "http://localhost/wf/user1/img/"+file; 
 
            } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Dialogue D'information");
            alert.setHeaderText("Veuillez sélectionner un fichier");
            /*alert.setContentText("You didn't select a file!");*/
            alert.showAndWait();

            //System.out.println("not a valid File ");
        }
    }
    
    
//    /**
//     * Initializes the controller class.
//     *
//     * @param url
//     * @param rb
//     */
//
//    public void initialize(URL url, ResourceBundle rb) {
//        // TODO     
//        btn.setOnAction(event -> {
//            
//           User1 u = new User1(txtNom.getText(), txtPrenom.getText());
//            User1Service pdao = User1Service.getInstance();
//            pdao.insert(u);
//});
//                }
                }
