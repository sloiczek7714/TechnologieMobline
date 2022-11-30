package wb.tm.technologiemobline;
import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.RoomDatabase;
@Database(entities = PersonsTable.class, version = 1, exportSchema = false)
public abstract class PersonsDB extends RoomDatabase {
    public abstract PersonsDAO getPersonDao();
}
