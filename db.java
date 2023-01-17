package begudb;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;

public class db {
    public static String[] inject() throws IOException{
        String[] arr = new String[Config.databaseItemAmount()];
        FileReader myReader = new FileReader("database.txt");
        BufferedReader myBuffer = new BufferedReader(myReader);
        try {
            String line = myBuffer.readLine();
            String[] elements = line.replace("{", "").replace("}", "").split(",");
            for (int i = 0; i < elements.length; i++) {
                if(i < arr.length){
                    arr[i] = elements[i].trim();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        myBuffer.close();
        return arr;
    }
    public static int find(String item) throws IOException {
        String newItem = "\"" + item + "\"";
        String[] array = inject();
        int ret = 0;
        boolean returned = false;
        for(int x = 0;x < array.length;x ++){
            if(array[x] == null){
                continue;
            }else if(array[x].equals(newItem)){
                ret = x;
                returned = true;
                break;
            }
        }
        if(returned){
            return ret;
        } else {
            return 404_404_404;
        }
    }
    public static String write(String[] arr) {
        try {
            FileWriter myWriter = new FileWriter("database.txt", false);
            BufferedWriter myBuffer = new BufferedWriter(myWriter);
            myBuffer.write("{ \""); // beginning, --> {...
            for(int item = 0;item < arr.length;item++){
                if(arr[item] != null){
                    myBuffer.write(arr[item].replaceAll("\"",""));
                    if(item != arr.length - 1){
                        myBuffer.write("\", \"");
                    }
                }
            }
            myBuffer.write("\" }");
            myBuffer.close();
            FileReader myReader = new FileReader("database.txt");
            BufferedReader breader = new BufferedReader(myReader);
            String newDb = breader.readLine();
            breader.close();
            return newDb;
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed";
        }
    }
    public static void add(String[] arr) throws IOException {
        StringBuilder sb = new StringBuilder();
        FileReader myReader = new FileReader("database.txt");
        BufferedReader breader = new BufferedReader(myReader);
        String line;
        while ((line = breader.readLine()) != null) {
            sb.append(line).append("\n");
        }
        breader.close();
        myReader.close();
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
        sb.append(", { ");
        for(int item = 0;item < arr.length;item++){
            if(item != arr.length - 1){
                sb.append("\"" + arr[item] + "\"" + ", ");
            } else {
                sb.append("\"" + arr[item] + "\"" + "} }");
            }
        }

        FileWriter myWriter = new FileWriter("database.txt", false);
        BufferedWriter myBuffer = new BufferedWriter(myWriter);
        myBuffer.write(sb.toString());
        myBuffer.close();
    }
    public static void create() throws IOException {
        File file = new File("database.txt");
        file.createNewFile();
        String[] array = { "ITEM", "ITEM", "ITEM", "ITEM" };
        write(array);
    }
    public static void remove(String value) throws IOException {
        String[] arr = inject();
        int index = find(value);
        int len = 0;
        for (int k = 0; k < arr.length; k++) {
            if(k != index){
                if(arr[k] != null){
                    len++;
                }
            }
        }
        String[] newArr = new String[len];
        int j = 0;
        for (int k = 0; k < arr.length; k++) {
            if(k != index){
                if(arr[k] != null){
                    newArr[j] = arr[k];
                    j++;
                }
            }
        }
        write(newArr);
    }
    public static boolean test() throws IOException {
        String[] database = inject();
        boolean success = find(database[0].substring(1,database[0].length() - 1)) < 400000;
        boolean passed;
        if(success){
            System.out.println("\033[32mTest one passed");
            passed = true;
        } else {
            System.out.println("\033[31mTest one failed");
            passed = false;
        }
        try {
            String[] array = { "testing", "testing" };
            add(array);
            System.out.println("\033[32mTest two passed");
        } catch(Exception e){
            passed = false;
            System.out.println("\033[31mTest two failed");
        }
        try {
            remove("testing");
            remove("testing");
            System.out.println("\033[32mTest three passed\033[0m");
        } catch(Exception e){
            System.out.println("\033[31mTest three failed\033[0m");
            passed = false;
        }
        write(database);
        return passed;
    }
}
