package wb.tm.technologiemobline;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity(tableName="persons_table")
public class PersonsTable {

    @PrimaryKey(autoGenerate = true)
    private long id;
    private String name;
    private String surname;
    private int tableNumber;
    private String rank;
    public PersonsTable(String name, String surname, int tableNumber, String rank) {
        this.name = name;
        this.surname =surname;
        this.tableNumber = tableNumber;
        this.rank = rank;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
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

    public int getTableNumber() {
        return tableNumber;
    }
    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
