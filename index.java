import java.io.IOException;

class index {
    public static void main(String[] args) throws IOException{
        String[][] array = { {"test", "test"}, {"test", "test"} };
        db.write(array);
        String[][] database = db.inject();
        system.printArrayln(database[1]);
        system.printArrayln(database[db.find("test")]);
    }
}