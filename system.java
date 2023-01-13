import java.io.IOException;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;

public class system {
    public static <T> T choice(T[] arr) {
        Random rand = new Random();
        int randomIndex = rand.nextInt(arr.length);
        return arr[randomIndex];
    }
    public static void clear() throws InterruptedException, IOException{
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
    public static void log(String msg){
        System.out.print(msg);
    }
    public static void printArray(String[] array){
        for(int x = 0;x < array.length;x++){
            log(array[x]);
        }
    }
    public static void printArrayln(String[] array){
        for(int x = 0;x < array.length; x++){
            log(array[x]);
        }
        log("\n");
    }
    public static String[][] injectdb() throws IOException{
        String[][] arr = new String[403][403];
        FileReader myReader = new FileReader("database.txt");
        BufferedReader myBuffer = new BufferedReader(myReader);
        try {
            String line = myBuffer.readLine();
            String[] elements = line.replace("{", "").replace("}", "").split(",");
            for (int i = 0; i < elements.length; i++) {
                if(i < arr.length){
                    arr[i] = elements[i].trim().split("sssssssssssssssss");
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
        String[][] array = injectdb();
        int ret = 0;
        boolean returned = false;
        for(int x = 0;x < array.length;x ++){
            if((array[x][0] != null) && !(array[x][0].equals(newItem))){
            }else if(array[x][0].equals(newItem)){
                ret = x;
                returned = true;
                break;
            }
        }
        if(returned){
            return ret;
        } else {
            return 404;
        }
    }
}
