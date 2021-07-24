package ucf.assignments;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class InventoryFunctionsTest {

    @Test
    void addItem() {
        InventoryFunctions func = new InventoryFunctions();
        ArrayList<HashMap<String,String>>list = new ArrayList();
        String name = "hamburger";
        String serial = "abc123459b";
        String value = "12";
        String actual = func.addItem(list,name,serial,value);
        String expected = "Item successfully added";
    }

    @Test
    void removeItem() {
        InventoryFunctions func = new InventoryFunctions();
        ArrayList<HashMap<String,String>> list = new ArrayList<>();
        HashMap<String,String> newItem = new HashMap<>();
        int index=0;
        newItem.put("name","hamburger");
        newItem.put("serial","abc123459b");
        newItem.put("value","12");
        list.add(newItem);
        String actual = func.removeItem(list,index);
        String expected = "Item successfully removed";
        assertEquals(expected,actual);
    }

    @Test
    void editValue() {
        InventoryFunctions func = new InventoryFunctions();
        ArrayList<HashMap<String,String>> list = new ArrayList<>();
        HashMap<String,String> newItem = new HashMap<>();
        String value = "25";
        int index=0;
        newItem.put("name","hamburger");
        newItem.put("serial","abc123459b");
        newItem.put("value","12");
        list.add(newItem);
        String actual = func.editValue(list,index,value);
        String expected = "Item value changed";
        assertEquals(expected,actual);
    }

    @Test
    void editSerialNumber() {
        InventoryFunctions func = new InventoryFunctions();
        ArrayList<HashMap<String,String>> list = new ArrayList<>();
        HashMap<String,String> newItem = new HashMap<>();
        String serial = "cab123459b";
        int index=0;
        newItem.put("name","hamburger");
        newItem.put("serial","abc123459b");
        newItem.put("value","12");
        list.add(newItem);
        String actual = func.editSerialNumber(list,index,serial);
        String expected = "Item serial number changed";
        assertEquals(expected,actual);
    }

    @Test
    void editItemName() {
        InventoryFunctions func = new InventoryFunctions();
        ArrayList<HashMap<String,String>> list = new ArrayList<>();
        HashMap<String,String> newItem = new HashMap<>();
        String name = "hotdog";
        int index=0;
        newItem.put("name","hamburger");
        newItem.put("serial","abc123459b");
        newItem.put("value","12");
        list.add(newItem);
        String actual = func.editItemName(list,index,name);
        String expected = "Item name changed";
        assertEquals(expected,actual);
    }

    @Test
    void sortByValue() {
        InventoryFunctions func = new InventoryFunctions();
        ArrayList<HashMap<String,String>> list = new ArrayList<>();
        ArrayList<HashMap<String,String>> valueSort= new ArrayList<>();
        HashMap<String,String> newItem = new HashMap<>();
        newItem.put("name","hamburger");
        newItem.put("serial","abc123459b");
        newItem.put("value","12");
        list.add(newItem);
        newItem.put("name","apples");
        newItem.put("serial","bac123459b");
        newItem.put("value","2");
        list.add(newItem);
        String actual = func.sortByValue(valueSort,list);
        String expected = "Items sorted by value";
        assertEquals(expected,actual);
    }

    @Test
    void sortBySerialNumber() {
        InventoryFunctions func = new InventoryFunctions();
        ArrayList<HashMap<String,String>> list = new ArrayList<>();
        ArrayList<HashMap<String,String>> serialSort= new ArrayList<>();
        HashMap<String,String> newItem = new HashMap<>();
        newItem.put("name","hamburger");
        newItem.put("serial","abc123459b");
        newItem.put("value","12");
        list.add(newItem);
        newItem.put("name","apples");
        newItem.put("serial","bac123459b");
        newItem.put("value","2");
        list.add(newItem);
        String actual = func.sortBySerialNumber(serialSort,list);
        String expected = "Items sorted by serial number";
        assertEquals(expected,actual);
    }

    @Test
    void sortByName() {
        InventoryFunctions func = new InventoryFunctions();
        ArrayList<HashMap<String,String>> list = new ArrayList<>();
        ArrayList<HashMap<String,String>> nameSort= new ArrayList<>();
        HashMap<String,String> newItem = new HashMap<>();
        newItem.put("name","hamburger");
        newItem.put("serial","abc123459b");
        newItem.put("value","12");
        list.add(newItem);
        newItem.put("name","apples");
        newItem.put("serial","bac123459b");
        newItem.put("value","2");
        list.add(newItem);
        String actual = func.sortByName(nameSort,list);
        String expected = "Items sorted by name";
        assertEquals(expected,actual);
    }

    @Test
    void searchByName() {
        InventoryFunctions func = new InventoryFunctions();
        ArrayList<HashMap<String,String>> list = new ArrayList<>();
        ArrayList<HashMap<String,String>> nameSearch= new ArrayList<>();
        HashMap<String,String> newItem = new HashMap<>();
        String searchKey = "apple";
        newItem.put("name","hamburger");
        newItem.put("serial","abc123459b");
        newItem.put("value","12");
        list.add(newItem);
        newItem.put("name","apple");
        newItem.put("serial","bac123459b");
        newItem.put("value","2");
        list.add(newItem);
        String actual = func.searchByName(nameSearch,list,searchKey);
        String expected = "Item searched by name";
        assertEquals(expected,actual);
    }

    @Test
    void searchBySerialNumber() {
        InventoryFunctions func = new InventoryFunctions();
        ArrayList<HashMap<String,String>> list = new ArrayList<>();
        ArrayList<HashMap<String,String>> serialSearch= new ArrayList<>();
        HashMap<String,String> newItem = new HashMap<>();
        String searchKey = "bac123459b";
        newItem.put("name","hamburger");
        newItem.put("serial","abc123459b");
        newItem.put("value","12");
        list.add(newItem);
        newItem.put("name","apple");
        newItem.put("serial","bac123459b");
        newItem.put("value","2");
        list.add(newItem);
        String actual = func.searchBySerialNumber(serialSearch,list,searchKey);
        String expected = "Item searched by serial number";
        assertEquals(expected,actual);
    }

    @Test
    void clearList() {
        InventoryFunctions func = new InventoryFunctions();
        ArrayList<HashMap<String, String>> list = new ArrayList<>();
        HashMap<String, String> newItem = new HashMap<>();
        newItem.put("name", "hamburger");
        newItem.put("serial", "abc123459b");
        newItem.put("value", "12");

        String actual = func.clearList(list);
        String expected = "List successfully cleared";
        assertEquals(expected, actual);
    }
}