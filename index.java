import java.io.IOException;

import src.db;
import src.system;

class index {
    public static void main(String[] args) throws IOException {
        db.create();
        String[] array = {"value 1", "value 2"};
        db.add(array);
        String[][] database = db.inject();
        system.printArrayln(database[5]);
        system.log(database[0].length + "");
    }
}