package ucf.assignments;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
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

    private void refresh(){
        //resets the textfields
        addValue.setText(null);
        addName.setText(null);
        addSerial.setText(null);
    }

    public void AddListItem(ActionEvent actionEvent) {
        func.addItem(workList, addName.getText(),addSerial.getText(),addValue.getText());
        observList.add(func.prettyString(workList.get(workList.size()-1)));
        inventoryList.setItems(observList);

        refresh();
    }

    public void removeItem(ActionEvent actionEvent) {
        int index = inventoryList.getSelectionModel().getSelectedIndex();
        if(index>=0){
            func.removeItem(workList,index);
            observList.remove(index);
        }
    }

    public void editName(ActionEvent actionEvent) {
        int index = inventoryList.getSelectionModel().getSelectedIndex();
        if(index>=0){
            func.editItemName(workList,index,addName.getText());
        }
        observList.set(index,func.prettyString(workList.get(index)));
        refresh();
    }

    public void editSerial(ActionEvent actionEvent) {
        int index = inventoryList.getSelectionModel().getSelectedIndex();
        if(index>=0){
            func.editSerialNumber(workList,index,addSerial.getText());
        }
        observList.set(index,func.prettyString(workList.get(index)));
        refresh();
    }

    public void editValue(ActionEvent actionEvent) {
        int index = inventoryList.getSelectionModel().getSelectedIndex();
        if(index>=0){
            func.editValue(workList,index,addValue.getText());
        }
        observList.set(index,func.prettyString(workList.get(index)));
        refresh();
    }

    public void clearList(ActionEvent actionEvent) {
        func.clearList(workList);
        observList.clear();
        inventoryList.setItems(observList);
    }

    public void sortValue(ActionEvent actionEvent) {
        ArrayList<HashMap<String,String>> tempValue = new ArrayList<>();
        func.sortByValue(tempValue,workList);

        ObservableList<String> valueList = FXCollections.observableArrayList();
        for(int i=0;i<tempValue.size();i++){
            valueList.add(func.prettyString(tempValue.get(i)));
        }
        inventoryList.setItems(valueList);
    }

    public void sortSerial(ActionEvent actionEvent) {
        ArrayList<HashMap<String,String>> tempSerial = new ArrayList<>();
        func.sortBySerialNumber(tempSerial,workList);

        ObservableList<String> serialList = FXCollections.observableArrayList();
        for(int i=0;i<tempSerial.size();i++){
            serialList.add(func.prettyString(tempSerial.get(i)));
        }
        inventoryList.setItems(serialList);
    }

    public void sortName(ActionEvent actionEvent) {
        ArrayList<HashMap<String,String>> tempName = new ArrayList<>();
        func.sortByName(tempName,workList);

        ObservableList<String> nameList = FXCollections.observableArrayList();
        for(int i=0;i<tempName.size();i++){
            nameList.add(func.prettyString(tempName.get(i)));
        }
        inventoryList.setItems(nameList);
    }

    public void saveCurrent(ActionEvent actionEvent) {
    }

    public void loadOne(ActionEvent actionEvent) {
    }


    public void searchSerial(ActionEvent actionEvent) {
        ArrayList<HashMap<String,String>> searchList = new ArrayList<>();
        String searchKey = null;
        func.searchBySerialNumber(searchList,workList,searchKey);
        ObservableList<String> searchObservableList = FXCollections.observableArrayList();
        for(int i=0;i<searchList.size();i++){
           searchObservableList.add(func.prettyString(searchList.get(i)));
        }
        inventoryList.setItems(searchObservableList);
    }

    public void searchName(ActionEvent actionEvent) {
        ArrayList<HashMap<String,String>> searchList = new ArrayList<>();
        String searchKey = null;
        func.searchByName(searchList,workList,searchKey);
        ObservableList<String> searchObservableList = FXCollections.observableArrayList();
        for(int i=0;i<searchList.size();i++){
            searchObservableList.add(func.prettyString(searchList.get(i)));
        }
        inventoryList.setItems(searchObservableList);
    }

    public void sortAll(ActionEvent actionEvent) {
        inventoryList.setItems(observList);
    }
}
