package wb.tm.technologiemobline.model;


import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "person")
public class Person {
    @PrimaryKey(autoGenerate = true)
    int id;
    String name;
    String email;
    String number;
    String rank;
    String city;

    @Ignore
    public Person(String name, String email, String number, String rank, String city) {
        this.name = name;
        this.email = email;
        this.number = number;
        this.rank = rank;
        this.city = city;
    }

    public Person(int id, String name, String email, String number, String rank, String city) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.number = number;
        this.rank = rank;
        this.city = city;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
