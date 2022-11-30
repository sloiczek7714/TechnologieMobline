package wb.tm.technologiemobline;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Insert;
import androidx.room.Dao;
import androidx.room.Update;

import java.util.List;

@Dao
public interface PersonsDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insert(PersonsTable... person);

    @Update
    void update(PersonsTable... person);

    @Query("DELETE FROM persons_table")
    public void deleteALL();

    @Query("SELECT COUNT(*) FROM persons_table")
    public long getCount();

    @Query("SELECT * FROM persons_table WHERE name = :name")
    public List<PersonsTable> getName(String name);

    @Query("SELECT * FROM persons_table WHERE surname = :surname")
    public List<PersonsTable> getSurname(String surname);

    @Query("SELECT * FROM persons_table WHERE rank = :rank")
    public List<PersonsTable> getRank(String rank);

    @Query("SELECT * FROM persons_table WHERE rank = :tableNumber")
    public List<PersonsTable> getTableNumber(Integer tableNumber );

    @Query("SELECT * FROM persons_table ORDER BY surname")
    public List<PersonsTable> getPersons();

}
