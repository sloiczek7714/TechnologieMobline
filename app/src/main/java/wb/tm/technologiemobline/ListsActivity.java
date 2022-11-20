package wb.tm.technologiemobline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class ListsActivity extends AppCompatActivity {

    private EditText edit;
    private Button dodaj;
    private Button usun;
    private Button wczytaj;
    private Button zapisz;
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lists);

        init();
        lista.add("Element1");
        lista.add("Element2");
        lista.add("Element3");

        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_multiple_choice, lista);
        listView.setAdapter(adapter);

        dodaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dodajElement(edit.getText().toString());
            }
        });

        usun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usunElement();
            }
        });

        zapisz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zapiszDoPliku("lista.txt");
            }
        });

        wczytaj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wczytajZPliku("lista.txt");
            }
        });
    }

    private void wczytajZPliku(String s) {
        ArrayList<String> lista = new ArrayList<String>();
        try {
            InputStreamReader streamReader = new InputStreamReader(openFileInput(s));
            BufferedReader bufferedReader = new BufferedReader(streamReader);
            String linia = "";
            while ((linia = bufferedReader.readLine()) != null) {
                lista.add(linia);
            }
            streamReader.close();
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
        adapter.clear();
        adapter.addAll(lista);
    }

    private void zapiszDoPliku(String s) {
        try {
            OutputStreamWriter outputStream = new OutputStreamWriter(openFileOutput(s, Context.MODE_PRIVATE));
            for (int i = 0; i < adapter.getCount(); i++) {
                outputStream.write(adapter.getItem(i).toString() + '\n');
            }
            outputStream.close();
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    private void usunElement() {
        if (listView.getCheckedItemCount() > 0) {
            SparseBooleanArray doUsuniecia = listView.getCheckedItemPositions();
            for (int i = doUsuniecia.size() - 1; i >= 0; i--) {
                adapter.remove(adapter.getItem(doUsuniecia.keyAt(i)));
            }
            listView.clearChoices();
        }
    }

    private void dodajElement(String element) {
        adapter.add(element);
        edit.setText("");
    }

    private void init() {
        edit = findViewById(R.id.editItem);
        dodaj = findViewById(R.id.buttonDodaj);
        usun = findViewById(R.id.buttonUsun);
        wczytaj = findViewById(R.id.buttonWczytaj);
        zapisz = findViewById(R.id.buttonZapisz);
        listView = findViewById(R.id.listView);
        lista = new ArrayList<String>();
    }
}

