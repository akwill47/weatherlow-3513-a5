package ucf.assignments;
/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 William Weatherlow
 */
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class PopUpController {

    @FXML
    public Button close_btn;
    @FXML
    public Button close_btn_save;
    @FXML
    public TextField addSearch;
    @FXML
    String returnText;
    @FXML
    TextField fileLocation;
    @FXML
    TextField fileName;
    @FXML
    TextField fileType;
    @FXML
    private void closeBtnClick() throws IOException {

        //sets searchKey to title and closes
        returnText = addSearch.getText();

        Stage stage = (Stage)addSearch.getScene().getWindow();
        stage.setTitle(returnText);
        stage.close();
    }

    private void closeSaveClick() {
        Stage stage = (Stage)fileType.getScene().getWindow();
        stage.close();

    }

}
