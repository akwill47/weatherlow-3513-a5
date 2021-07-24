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
    String returnText;
    @FXML
    private void closeBtnClick() throws IOException {

        //stores textfield input as a string
        returnText = addSearch.getText();

        Stage stage = (Stage)addSearch.getScene().getWindow();
        stage.setTitle(returnText);
        stage.close();
    }

}
