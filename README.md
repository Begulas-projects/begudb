# Java database
This is a open-source project for creating databases in java using only txt files, it's free to use without credits!
### What these functions got
- find system: `db.find(ITEM);`
  - this returns 404_404_404 when the item is not found
- read database:
```java
String[][] database = db.inject();
system.printArrayln(database[INDEX]);
```
  - you can also read the database by finding the item:
  ```java
  String[][] database = db.inject();
  system.printArrayln(array[system.find(ITEM HERE)]);
  ```
- clear console (windows only): `system.clear();`
- `System.out.print` in short: `system.log(MSG);`
- randomizer: `system.choice(ARRAY WITH STRING ITEMS);`
- print arrays:
  - new line after printing array: `system.printArrayln(ARRAY);`
  - stay on line: `system.printArray(ARRAY);`

# IMPORTANT!
## **The database can only have up to 400 items, you can change that in the system.java file at the declaration of `db.inject()`!**
More soon!
