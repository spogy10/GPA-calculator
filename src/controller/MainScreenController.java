package controller;

import JavaFXHelper.FXHelper;
import gpa.calculator.Course;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.util.Callback;
import listviewcell.CourseListCell;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainScreenController implements Initializable {

    public static final String FXML = "/view/MainScreen.fxml";
    public static final String TITLE = "GPA Calculator";

    @FXML private Button btCalculate;
    @FXML private ListView list;
    @FXML private ChoiceBox<Integer> cbNumberOfCourses;
    private ObservableList<Course> observableList = FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cbNumberOfCourses.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9);
        cbNumberOfCourses.setValue(1);
        initializeList();
    }

    private void initializeList(){
        list.setItems(observableList);
        list.setCellFactory(new Callback<ListView, ListCell>() {
            @Override
            public ListCell call(ListView param) {
                return new CourseListCell();
            }
        });
    }

    @FXML
    private void changeCourseNumber(){
        observableList.clear();
        for(int i =0; i < cbNumberOfCourses.getValue(); i++)
            observableList.add(new Course());
    }


    @FXML
    private void calculate(){

        //System.out.println("observable list size: "+observableList.size());

        boolean check = true;
        for( Course c : observableList){
            if( !(c.getCredits() != 0 && !(c.getGrade() == null || c.getGrade().equals(""))) )
                check = false;
        }

        try {
            if (!check)
                FXHelper.alertPopup(this, "Error", "Please fill out all fields");
            else
                FXHelper.alertPopup(this, "GPA", "GPA = "+ Course.calculateGPA(observableList));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
