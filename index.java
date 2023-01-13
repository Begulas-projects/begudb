import java.io.IOException;

class index {
    public static void main(String[] args) throws IOException{
        String[] array = { "i am an array" };
        db.add(array);
        String[][] database = db.inject();
        system.printArrayln(database[db.find("i am an array")]);
    }
}