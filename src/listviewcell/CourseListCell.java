package listviewcell;

import controller.AddCourseController;
import gpa.calculator.Course;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.ListCell;

import java.io.IOException;


public class CourseListCell extends ListCell<Course> {

    private Node graphic;
    private AddCourseController controller;

    public  CourseListCell() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(AddCourseController.FXML));
            graphic = loader.load();
            controller = loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void updateItem(Course item, boolean empty) {
        super.updateItem(item, empty);
        if(item == null && empty)
            setGraphic(null);
        else{
            controller.setVariables(item);
            setGraphic(graphic);
        }
    }
}
