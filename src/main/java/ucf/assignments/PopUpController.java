package ucf.assignments;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class PopUpController {

    @FXML
    public Button close_btn;
    @FXML
    public TextField addSearch;
    @FXML
    String test;
    @FXML
    private void closeBtnClick() throws IOException {

        //stores textfield input as a string
        test = addSearch.getText();

        Stage stage = (Stage)addSearch.getScene().getWindow();
        stage.setTitle(test);
        stage.close();
    }

}
