/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package salahuddin_ayubi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import salahuddin_ayubi.configs.EntityManagerUtil;

/**
 *
 * @author Dell-3460
 */
public class Salahuddin_Ayubi extends Application
    {
    
    @Override
    public void start(Stage stage) throws Exception
        {
//        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument_Updated.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
        }

    @Override
    public void stop()
        {
            EntityManagerUtil.closeEntityManager();
        }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
        {
        launch(args);
        }
    
    }
