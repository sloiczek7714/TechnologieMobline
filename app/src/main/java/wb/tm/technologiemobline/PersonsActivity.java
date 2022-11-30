package wb.tm.technologiemobline;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.List;
import java.util.Locale;

public class PersonsActivity extends AppCompatActivity {

    private PersonsDAO personsDAO;
    private PersonsDB personDB;
    private RecyclerView personsListsRecycler;
    private RecyclerAdapter adapter;
    private Button writePlk, writeWeroniki, writePersons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persons);
        writePersons = findViewById(R.id.writeDatabaseB);
        writePlk = findViewById(R.id.writePlkB);
        writeWeroniki = findViewById(R.id.writeWeronikiB);
         writePersons.setOnClickListener(listener);
         writePlk.setOnClickListener(listener);
         writeWeroniki.setOnClickListener(listener);

        initDB();
        writeToLogs("Persons", personsDAO.getPersons());
        writeToLogs("Weronika", personsDAO.getName("weronika".toUpperCase()));
        writeToLogs("Buras", personsDAO.getSurname("buras".toUpperCase()));
        writeToLogs("27", personsDAO.getTableNumber(Integer.valueOf("27".toUpperCase())));
        writeToLogs("Szeregowy", personsDAO.getRank("szeregowy".toUpperCase()));
        loadDataToDB();
        initRecycleView();

    }

    private void initRecycleView() {
        personsListsRecycler = findViewById(R.id.recyclerView);
        personsListsRecycler.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerAdapter(this, personsDAO.getPersons());
        personsListsRecycler.setAdapter(adapter);
    }

    private void writeToLogs(String TAG, List<PersonsTable> lista) {
        for (PersonsTable person : lista) {
            Log.i(TAG, person.getName() + ' ' + person.getSurname() + ' ' + person.getTableNumber() + ' ' + person.getRank());
        }
    }

    private void initDB() {
        personDB = Room.databaseBuilder(this, PersonsDB.class, "PersonDB").allowMainThreadQueries().build();
        personsDAO = personDB.getPersonDao();
        if (personsDAO.getCount() == 0) {
            loadDataToDB();
        }
        Log.i("HOW MUCH", String.valueOf(personsDAO.getCount()));
    }

    private void loadDataToDB() {
        String name;
        String surname;
        Integer tableNumber;
        String rank;
        String[] person = getResources().getStringArray(R.array.persons_table);
        for (int i = 0; i < person.length; i++) {
            int indeks = person[i].indexOf(":");
            String[] tmp = person[i].split(":");
            name = tmp[0].toUpperCase();
            surname = tmp[1].toUpperCase();
            tableNumber = Integer.valueOf(tmp[2].toUpperCase());
            rank = tmp[3];
            personsDAO.insert(new PersonsTable(name, surname, tableNumber, rank));
        }
    }

    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.writeDatabaseB:
                    personsListsRecycler.setAdapter(new RecyclerAdapter(getApplicationContext(), personsDAO.getPersons()));
                    break;
                case R.id.writePlkB:
                    personsListsRecycler.setAdapter(new RecyclerAdapter(getApplicationContext(), personsDAO.getRank("Pulkownik".toUpperCase())));
                    break;
                case R.id.writeWeronikiB:
                    personsListsRecycler.setAdapter(new RecyclerAdapter(getApplicationContext(), personsDAO.getName("Weronika".toUpperCase())));
                    break;
                default:
                    throw new IllegalStateException("Unxpected value: " + view.getId());
                }
            }
        };
    }
