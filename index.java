import java.io.IOException;

class index {
    public static void main(String[] args) throws IOException {
        String[] array = {"value 1", "value 2"};
        db.add(array);
        String[][] database = db.inject();
        system.printArrayln(database[5]);
    }
}