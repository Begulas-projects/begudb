import java.io.IOException;

class index {
    public static void main(String[] args) throws IOException{
        String[][] array = { {"I am a item", "i am also a item"}, {"this is a test", "teeeeeeest"} };
        db.write(array);
        String[][] database = db.inject();
        system.printArrayln(database[1]);
        system.printArrayln(database[db.find("i am also a item")]);
    }
}