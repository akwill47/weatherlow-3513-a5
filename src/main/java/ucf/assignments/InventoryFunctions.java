package ucf.assignments;

import com.google.gson.Gson;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InventoryFunctions {
    public String prettyString(HashMap<String,String> item){
        return ""+item.get("value")+"\t\t\t" + item.get("serial") + "\t\t" + item.get("name");
    }
    public String addItem(ArrayList<HashMap<String,String>> list,String name,String serial,String value){
        //cannot duplicate serial number
        InventoryController  func = new InventoryController();
        double num;
        String tempValue;
        if(name == null)
            return "No name entered";

        if(serial == null)
            return "No serial number entered";
        if(value == null)
            return "No value entered";
        HashMap<String,String> newItem = new HashMap<>();
        String regex = "^[a-zA-Z0-9]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(serial);
        boolean matches = matcher.matches();
        if(serial.length()!=10 || matches==false){

            func.infoBox("Error, invalid serial number format","Invalid format",null);
            return "Invalid serial number";
        }
        serial = serial.toUpperCase();
        for(int i=0;i<list.size();i++){
            if(list.get(i).get("serial").equals(serial)){

                func.infoBox("Error, existing serial number","Duplicate input",null);
                return "Duplicate serial number found";
            }
        }
        newItem.put("serial",serial);

        newItem.put("name",name);

        DecimalFormat df = new DecimalFormat("#.00");
        num=Double.parseDouble(value);
        tempValue = df.format(num);
        newItem.put("value","$"+tempValue);
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
        InventoryController  func = new InventoryController();
        String regex = "^[a-zA-Z0-9]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(serialNumber);
        boolean matches = matcher.matches();
        if(serialNumber.length()!=10 || matches==false){

            func.infoBox("Error, invalid serial number format","Invalid format",null);
            return "Invalid serial number";
        }
        serialNumber = serialNumber.toUpperCase();

        for(int i=0;i<list.size();i++){
            if(list.get(i).get("serial").equals(serialNumber)){

                func.infoBox("Error, existing serial number","Duplicate input",null);
                return "Duplicate serial number found";
            }
        }

        list.get(index).put("serial",serialNumber);
        return "Item serial number changed";
    }
    public String editItemName(ArrayList<HashMap<String,String>> list,int index,String newName){
        list.get(index).put("name",newName);
        return "Item name changed";
    }
    public String sortByValue(ArrayList<HashMap<String,String>>valueSort, ArrayList<HashMap<String,String>> list){
        ArrayList<String> sorted = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            sorted.add(list.get(i).get("value"));
        }
        Collections.sort(sorted);

        for(int i=0;i<list.size();i++){
            for(int j=0;j<list.size();j++){
                if(sorted.get(i).equals(list.get(j).get("value"))){
                    valueSort.add(list.get(j));
                }
            }
        }
        return "Items sorted by value";
    }
    public String sortBySerialNumber(ArrayList<HashMap<String,String>>serialSort, ArrayList<HashMap<String,String>> list){
        ArrayList<String> sorted = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            sorted.add(list.get(i).get("serial"));
        }
        Collections.sort(sorted);

        for(int i=0;i<list.size();i++){
            for(int j=0;j<list.size();j++){
                if(sorted.get(i).equals(list.get(j).get("serial"))){
                    serialSort.add(list.get(j));
                }
            }
        }
        return "Items sorted by serial number";
    }
    public String sortByName(ArrayList<HashMap<String,String>>nameSort, ArrayList<HashMap<String,String>> list){
        ArrayList<String> sorted = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            sorted.add(list.get(i).get("name"));
        }
        Collections.sort(sorted);

        for(int i=0;i<list.size();i++){
            for(int j=0;j<list.size();j++){
                if(sorted.get(i).equals(list.get(j).get("name"))){
                    nameSort.add(list.get(j));
                }
            }
        }
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

        if(fileName.equals("tsv")){
            try {
                FileWriter file = new FileWriter(fileLocation+".txt");
                PrintWriter write = new PrintWriter(file);

                for (int i = 0; i < list.size(); i++) {
                    write.println(list.get(i).get("value")+"\t"+list.get(i).get("serial")+"\t"+list.get(i).get("name"));
                }
                write.close();
            }
            catch(IOException e){
                System.out.println("Error reading/writing to file");
            }
        }

        if(fileName.equals("html")){
            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(fileLocation + ".html"));
                bw.write("<html><head>");
                bw.write("<title>Inventory Management</title>");
                bw.write("</head><body>");
                bw.write("<table border=\"0\"><tr>");

                for (int i = 0; i < list.size(); i++) {
                    bw.write("<tr><td>"+list.get(i).get("value")+"</td></tr>");
                    bw.write("<tr><td>"+list.get(i).get("serial")+"</td></tr>");
                    bw.write("<tr><td>"+list.get(i).get("name")+"</td></tr>");
                    }
                bw.write("</table>");
                bw.write("</body></html>");
                bw.close();
                }catch(IOException e){
                    System.out.println("Error reading/writing to file");
                    }


            }
        if(fileName.equals("json")){
            try {
                Gson gson = new Gson();
                String json = gson.toJson(list);
                BufferedWriter bw = new BufferedWriter(new FileWriter(fileLocation + ".JSON"));
                bw.write(json);
                bw.close();
            }catch(IOException e){
                System.out.println("Error reading/writing to file");
            }
        }

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
