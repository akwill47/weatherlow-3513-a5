package ucf.assignments;

import java.util.ArrayList;
import java.util.HashMap;

public class InventoryFunctions {
    public String prettyString(HashMap<String,String> item){
        return "Serial Number: " + item.get("serial") + "\tName: " + item.get("name") + "\t\t\t\t\tValue: " + item.get("value");
    }
    public String addItem(ArrayList<HashMap<String,String>> list,String name,String serial,String value){
        //cannot duplicate serial number
        HashMap<String,String> newItem = new HashMap<>();
        newItem.put("serial",serial);
        newItem.put("name",name);
        newItem.put("value",value);
        list.add(newItem);
        return "Item successfully added";
    }
    public String removeItem(ArrayList<HashMap<String,String>> list,int index){
        list.remove(index);
        return "Item successfully removed";
    }
    public String editValue(ArrayList<HashMap<String,String>> list,int index, String value){
        list.get(index).put("value",value);
        return "Item value changed";
    }
    public String editSerialNumber(ArrayList<HashMap<String,String>> list,int index,String serialNumber){
        //cannot duplicate serial number
        list.get(index).put("serial",serialNumber);
        return "Item serial number changed";
    }
    public String editItemName(ArrayList<HashMap<String,String>> list,int index,String newName){
        list.get(index).put("name",newName);
        return "Item name changed";
    }
    public String sortByValue(ArrayList<HashMap<String,String>>valueSort, ArrayList<HashMap<String,String>> list){

        return "Items sorted by value";
    }
    public String sortBySerialNumber(ArrayList<HashMap<String,String>>serialSort, ArrayList<HashMap<String,String>> list){

        return "Items sorted by serial number";
    }
    public String sortByName(ArrayList<HashMap<String,String>>nameSort, ArrayList<HashMap<String,String>> list){

        return "Items sorted by name";
    }
    public String searchByName(ArrayList<HashMap<String,String>>nameSearch, ArrayList<HashMap<String,String>> list,String searchKey){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).get("name").equals(searchKey)) {
                nameSearch.add(list.get(i));
            }
        }
        return "Item searched by name";
    }
    public String searchBySerialNumber(ArrayList<HashMap<String,String>>serialSearch, ArrayList<HashMap<String,String>> list,String searchKey){
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).get("serial").equals(searchKey)) {
                serialSearch.add(list.get(i));
            }
        }
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
    public String clearList(ArrayList<HashMap<String,String>> list){
        //reference overall list

        //remove each index one by one
        for(int i=list.size();i>0;i--){
            list.remove(i-1);
        }
        return "List successfully cleared";
    }
}
