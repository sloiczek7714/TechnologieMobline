package wb.tm.technologiemobline.model;


import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "person")
public class Person {
    @PrimaryKey(autoGenerate = true)
    int id;
    String name;
    String surname;
    String tableNumber;
    String rank;

    @Ignore
    public Person(String name, String surname, String tableNumber, String rank) {
        this.name = name;
        this.surname = surname;
        this.tableNumber = tableNumber;
        this.rank = rank;
    }

    public Person(int id, String name, String surname, String tableNumber, String rank) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.tableNumber = tableNumber;
        this.rank = rank;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(String tableNumber) {
        this.tableNumber = tableNumber;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

}
