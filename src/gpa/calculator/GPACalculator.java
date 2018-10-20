/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gpa.calculator;  //page 149

import JavaFXHelper.FXHelper;
import controller.MainScreenController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 *
 * @author poliv
 */
public class GPACalculator extends Application {



    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {//3.12, 3.06, 3.36, 3.47, 3.46, 3.51
        // TODO code application logic here
        
//        Course[] courses = {new Course(3,"A-"), new Course(4,"A"), new Course(3,"A-"), new Course(2,"B+"), new Course(3,"B-")};
//
//        System.out.println(courses.length);
//        System.out.println(Course.calculateGPA(courses));

        launch(args);
        
        
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(MainScreenController.FXML));

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);

        primaryStage.setTitle(MainScreenController.TITLE);

        primaryStage.show();

        primaryStage.setOnCloseRequest(e -> {
            e.consume();
            try{
                FXHelper.closeProgram(this, primaryStage);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        });
    }
}
