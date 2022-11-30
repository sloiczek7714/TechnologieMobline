package wb.tm.technologiemobline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import wb.tm.technologiemobline.constans.Constants;
import wb.tm.technologiemobline.database.AppDatabase;
import wb.tm.technologiemobline.database.AppExecutors;
import wb.tm.technologiemobline.model.Person;

public class EditPersonActivity extends AppCompatActivity {
    EditText name, surname, rank, tableNumber;
    Button button;
    int mPersonId;
    Intent intent;
    private AppDatabase mDb;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_person);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        initViews();
        mDb = AppDatabase.getInstance(getApplicationContext());
        intent = getIntent();
        if (intent != null && intent.hasExtra(Constants.UPDATE_Person_Id)) {
            button.setText("Update");

            mPersonId = intent.getIntExtra(Constants.UPDATE_Person_Id, -1);

            AppExecutors.getInstance().diskIO().execute(new Runnable() {
                @Override
                public void run() {
                    Person person = mDb.personDao().loadPersonById(mPersonId);
                    populateUI(person);
                }
            });


        }

    }

    private void populateUI(Person person) {

        if (person == null) {
            return;
        }

        name.setText(person.getName());
        surname.setText(person.getSurname());
        tableNumber.setText(person.getTableNumber());
        rank.setText(person.getRank());
    }

    private void initViews() {
        name = findViewById(R.id.edit_name);
        surname = findViewById(R.id.edit_surname);
        rank = findViewById(R.id.edit_rank);
        tableNumber = findViewById(R.id.edit_tableNumber);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onSaveButtonClicked();
            }
        });

    }

    public void onSaveButtonClicked() {
        final Person person = new Person(
                name.getText().toString(),
                surname.getText().toString(),
                tableNumber.getText().toString(),
                rank.getText().toString());

        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                if (!intent.hasExtra(Constants.UPDATE_Person_Id)) {
                    mDb.personDao().insertPerson(person);
                } else {
                    person.setId(mPersonId);
                    mDb.personDao().updatePerson(person);
                }
                finish();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
