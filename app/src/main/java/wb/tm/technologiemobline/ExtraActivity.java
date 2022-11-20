package wb.tm.technologiemobline;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.SearchManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class ExtraActivity extends AppCompatActivity  implements View.OnClickListener{

        private TextView wyswietl;
        private Button kontaktB;

        private EditText fraza;
        private Button wyszukajB;
        private Button mapaB;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_extra);
            init();
            uprawnienia();
        }

        private void uprawnienia() {
            if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED){
                kontaktB.setEnabled(false);
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_CONTACTS},1001);
            }
        }

        @Override
        public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            switch (requestCode){
                case 1001:
                    if (grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                        kontaktB.setEnabled(true);
                    }
                    break;
            }
        }

        private void init(){
            wyswietl = findViewById(R.id.textKontakt);
            kontaktB = findViewById(R.id.buttonKontakt);
            kontaktB.setOnClickListener(this);

            fraza = findViewById(R.id.editWyszukiwanie);
            wyszukajB = findViewById(R.id.buttonWyszukaj);
            wyszukajB.setOnClickListener(this);
            mapaB = findViewById(R.id.buttonMapa);
            mapaB.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.buttonKontakt:
                    wybierzKontakt();
                    break;
                case R.id.buttonWyszukaj:
                    wyszukaj(fraza.getText().toString());
                    break;
                case R.id.buttonMapa:
                    wyszukajMapa(fraza.getText().toString());
            }
        }

        private void wyszukajMapa(String s) {
            Intent wyszukajMapaIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q="+s));
            startActivity(wyszukajMapaIntent);
        }

        private void wyszukaj(String s) {
            Intent wyszukajIntent = new Intent();
            wyszukajIntent.setAction(Intent.ACTION_WEB_SEARCH);
            wyszukajIntent.putExtra(SearchManager.QUERY,s);
            startActivity(wyszukajIntent);
        }

        private void wybierzKontakt() {
            Intent wybierzKontaktIntent = new Intent(Intent.ACTION_PICK);
            wybierzKontaktIntent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE);
            startActivityForResult(wybierzKontaktIntent, 2001);
        }

        @Override
        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
            super.onActivityResult(requestCode, resultCode, data);
            if (requestCode == 2001){
                Uri contactUri = data.getData();
                String[] protection = new String[]{ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME, ContactsContract.CommonDataKinds.Phone.NUMBER};
                Cursor c = getApplicationContext().getContentResolver().query(contactUri, protection,null,null,null);
                if (c != null && c.moveToFirst()){
                    int nameInd = c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
                    int numInd = c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                    String wynik = c.getString(nameInd) + "\n" +c.getString(numInd);
                    wyswietl.setText(wynik);
                }
            }
        }
    }
