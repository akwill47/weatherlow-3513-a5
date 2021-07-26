package ucf.assignments;
/*
 *  UCF COP3330 Summer 2021 Assignment 5 Solution
 *  Copyright 2021 William Weatherlow
 */
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class InventoryController {
    InventoryFunctions func = new InventoryFunctions();
    @FXML
    TextField addName;
    @FXML
    TextField addSerial;
    @FXML
    TextField addValue;
    @FXML
    ListView<String> inventoryList;

    ArrayList<HashMap<String,String>>workList = new ArrayList<>();//main working list
    ObservableList<String> observList = FXCollections.observableArrayList();
    public void infoBox(String infoMessage, String titleBar, String headerMessage)
    {
        //create a pop up box with given warning message
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titleBar);
        alert.setHeaderText(headerMessage);
        alert.setContentText(infoMessage);
        alert.showAndWait();

    }
    private void refresh(){
        //resets the textfields
        addValue.setText(null);
        addName.setText(null);
        addSerial.setText(null);
    }

    public void AddListItem(ActionEvent actionEvent) {
        //calls additem function, assigns a predetermined string to test
        String test = func.addItem(workList, addName.getText(),addSerial.getText(),addValue.getText());
        //use test to check if item needs to be added to observable list
        if(test.equals("Item successfully added"))
            observList.add(func.prettyString(workList.get(workList.size()-1)));
        //set the listview to the observable list
        inventoryList.setItems(observList);
        //reset the textfields
        refresh();
    }

    public void removeItem(ActionEvent actionEvent) {
        //get the highlighted index
        int index = inventoryList.getSelectionModel().getSelectedIndex();
        //if an index is selected, call removeitem function, and also remove it from the observable list
        if(index>=0){
            func.removeItem(workList,index);
            observList.remove(index);
        }
    }

    public void editName(ActionEvent actionEvent) {
        //get the highlighted index
        int index = inventoryList.getSelectionModel().getSelectedIndex();
        //editname function is called
        if(index>=0){
            func.editItemName(workList,index,addName.getText());
        }
        //set observable list to proper format to the changed index
        observList.set(index,func.prettyString(workList.get(index)));
        refresh();
    }

    public void editSerial(ActionEvent actionEvent) {
        //get the highlighted index
        int index = inventoryList.getSelectionModel().getSelectedIndex();
        //editserial function is called
        if(index>=0){
            func.editSerialNumber(workList,index,addSerial.getText());
        }
        //set observable list to proper format to the changed index
        observList.set(index,func.prettyString(workList.get(index)));
        refresh();
    }

    public void editValue(ActionEvent actionEvent) {
        //get the highlighted index
        int index = inventoryList.getSelectionModel().getSelectedIndex();
        //editvalue function is called
        if(index>=0){
            func.editValue(workList,index,addValue.getText());
        }
        //set observable list to proper format to the changed index
        observList.set(index,func.prettyString(workList.get(index)));
        refresh();
    }

    public void clearList(ActionEvent actionEvent) {
        //call clear list function
        func.clearList(workList);
        //clear observable list
        observList.clear();
        //reset listview to cleared observable list to make sure list refreshes
        inventoryList.setItems(observList);
    }

    public void sortValue(ActionEvent actionEvent) {
        //call sort function with new array
        ArrayList<HashMap<String,String>> tempValue = new ArrayList<>();
        func.sortByValue(tempValue,workList);
        //build new observable list
        ObservableList<String> valueList = FXCollections.observableArrayList();
        //assign new array to observable list
        for(int i=0;i<tempValue.size();i++){
            valueList.add(func.prettyString(tempValue.get(i)));
        }
        //set observable list to listview
        inventoryList.setItems(valueList);
    }

    public void sortSerial(ActionEvent actionEvent) {
        //call sort function with new array
        ArrayList<HashMap<String,String>> tempSerial = new ArrayList<>();
        func.sortBySerialNumber(tempSerial,workList);
        //build new observable list
        ObservableList<String> serialList = FXCollections.observableArrayList();
        //assign new array to observable list
        for(int i=0;i<tempSerial.size();i++){
            serialList.add(func.prettyString(tempSerial.get(i)));
        }
        //set observable list to listview
        inventoryList.setItems(serialList);
    }

    public void sortName(ActionEvent actionEvent) {
        //call sort function with new array
        ArrayList<HashMap<String,String>> tempName = new ArrayList<>();
        func.sortByName(tempName,workList);
        //build new observable list
        ObservableList<String> nameList = FXCollections.observableArrayList();
        //assign new array to observable list
        for(int i=0;i<tempName.size();i++){
            nameList.add(func.prettyString(tempName.get(i)));
        }
        //set observable list to listview
        inventoryList.setItems(nameList);
    }

    public void saveCurrent(ActionEvent actionEvent) throws IOException {
        //build pop up to get input for function
        Stage popUpSave = new Stage();
        popUpSave.initModality(Modality.APPLICATION_MODAL);
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("PopUpSave.fxml"));
        Parent root = loader.load();

        PopUpController controller = loader.getController();

        Scene scene = new Scene(root);
        popUpSave.setScene(scene);
        popUpSave.showAndWait();
        //use .getText method to get required file info to save the working list
        String fileLocation = controller.fileLocation.getText();
        String fileName = controller.fileName.getText();
        String fileType = controller.fileType.getText().toLowerCase();
        //call saveInventory function
        func.saveInventory(workList,fileName,fileLocation,fileType);
    }

    public void loadOne(ActionEvent actionEvent) {
        //build pop up to get input for function
        //use .getText method to get required file info to save the working list
        //call loadInventory function
    }


    public void searchSerial(ActionEvent actionEvent) throws IOException {
        //build pop up to get input for search
        Stage popUpSearch = new Stage();
        popUpSearch.initModality(Modality.APPLICATION_MODAL);
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("PopUp.fxml"));
        Parent root = loader.load();

        PopUpController controller = loader.getController();

        Scene scene = new Scene(root);
        popUpSearch.setScene(scene);
        popUpSearch.showAndWait();
        //make new arrayList
        ArrayList<HashMap<String,String>> searchList = new ArrayList<>();
        //use getTitle to receive search key
        String searchKey = popUpSearch.getTitle();
        //call search function with searchkey and new list
        func.searchBySerialNumber(searchList,workList,searchKey);
        ObservableList<String> searchObservableList = FXCollections.observableArrayList();
        //assign new list items to new observable list
        for(int i=0;i<searchList.size();i++){
           searchObservableList.add(func.prettyString(searchList.get(i)));
        }
        //set observable list to listview
        inventoryList.setItems(searchObservableList);
    }

    public void searchName(ActionEvent actionEvent) throws IOException{
        //build pop up to get input for search
        Stage popUpSearch = new Stage();
        popUpSearch.initModality(Modality.APPLICATION_MODAL);
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("PopUp.fxml"));
        Parent root = loader.load();

        PopUpController controller = loader.getController();

        Scene scene = new Scene(root);
        popUpSearch.setScene(scene);
        popUpSearch.showAndWait();
        //make new arrayList
        ArrayList<HashMap<String,String>> searchList = new ArrayList<>();
        //use getTitle to receive search key
        String searchKey = popUpSearch.getTitle();
        func.searchByName(searchList,workList,searchKey);
        //call search function with searchkey and new list
        ObservableList<String> searchObservableList = FXCollections.observableArrayList();
        //assign new list items to new observable list
        for(int i=0;i<searchList.size();i++){
            searchObservableList.add(func.prettyString(searchList.get(i)));
        }
        //set observable list to listview
        inventoryList.setItems(searchObservableList);

    }

    public void sortAll(ActionEvent actionEvent) {
        //set regular observable list to listview to reset to default working list
        inventoryList.setItems(observList);
    }
}
