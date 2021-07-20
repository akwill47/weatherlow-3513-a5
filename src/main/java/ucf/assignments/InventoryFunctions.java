package ucf.assignments;

import java.util.ArrayList;
import java.util.HashMap;

public class InventoryFunctions {
    public String addItem(ArrayList<HashMap<String,String>> list,String info){
        //cannot duplicate serial number
        return "Item successfully added";
    }
    public String removeItem(ArrayList<HashMap<String,String>> list,int index){
        return "Item successfully removed";
    }
    public String editValue(ArrayList<HashMap<String,String>> list,int index, double value){
        return "Item value changed";
    }
    public String editSerialNumber(ArrayList<HashMap<String,String>> list,int index,double serialNumber){
        //cannot duplicate serial number
        return "Item serial number changed";
    }
    public String editItemName(ArrayList<HashMap<String,String>> list,int index,String newName){
        return "Item name changed";
    }
    public String sortByValue(ArrayList<HashMap<String,String>> list){
        return "Items sorted by value";
    }
    public String sortBySerialNumber(ArrayList<HashMap<String,String>> list){
        return "Items sorted by serial number";
    }
    public String sortByName(ArrayList<HashMap<String,String>> list){
        return "Items sorted by name";
    }
    public String searchByName(ArrayList<HashMap<String,String>> list,String searchKey){
        return "Item searched by name";
    }
    public String searchBySerialNumber(ArrayList<HashMap<String,String>> list,String searchKey){
        return "Item searched by serial number";
    }
    public String saveInventory(ArrayList<HashMap<String,String>> list,String fileName,String fileLocation){
        //user provides file name and file location to save
        //can save in TSV/HTML/JSON
        return "Inventory Items saved to file";
    }
    public String loadInventory(ArrayList<HashMap<String,String>> list,String fileName,String fileLocation){
        //user provides filename and file location
        return "Inventory Items loaded from file";
    }
}
