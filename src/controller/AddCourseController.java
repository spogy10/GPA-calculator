package controller;

import gpa.calculator.Course;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AddCourseController implements Initializable {

    public static final String FXML = "/view/AddCourse.fxml";
    public static final String TITLE = "";

    @FXML private TextField tfCourseName;
    @FXML private ChoiceBox<Integer> cbCredits;
    @FXML private ChoiceBox<String> cbGrade;
    Course course;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cbCredits.getItems().addAll(0, 1, 2, 3, 4, 5, 6);
        cbGrade.getItems().addAll("A", "A-", "B+", "B", "B-", "C", "C+", "C-", "D+", "D", "D-", "U", "AB");
        tfCourseName.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                course.setName(newValue);
            }
        });
    }

    @FXML
    private void onCreditsChange(){
        course.setCredits(cbCredits.getValue());
    }

    @FXML
    private void onGradeChange(){
        course.setGrade(cbGrade.getValue());
    }

    public TextField getTfCourseName() {
        return tfCourseName;
    }

    public ChoiceBox<Integer> getCbCredits() {
        return cbCredits;
    }

    public ChoiceBox<String> getCbGrade() {
        return cbGrade;
    }

    public void setVariables(Course item) {
        course = item;
        tfCourseName.setText(course.getName());
        cbCredits.setValue(course.getCredits());
        cbGrade.setValue(course.getGrade());
    }
}
