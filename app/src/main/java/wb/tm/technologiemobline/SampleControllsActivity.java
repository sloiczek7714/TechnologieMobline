package wb.tm.technologiemobline;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class SampleControllsActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radio_one;
    RadioButton radio_two;
    EditText imie;
    EditText nazwisko;
    Switch switchA;
    Switch switchB;
    Button button;
    String table = " stolik prostokatny";
    String partner=" dla jednej osoby";
    TextView wynik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample_controlls);
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        radio_one = (RadioButton)findViewById(R.id.radioButton1);
        radio_two = (RadioButton)findViewById(R.id.radioButton2);
        imie = (EditText)findViewById(R.id.editTextTextPersonName);
        nazwisko = (EditText)findViewById(R.id.editTextTextPersonName2);
        switchA = (Switch)findViewById(R.id.switch2);
        switchB = (Switch)findViewById(R.id.switch3);
        button = (Button)findViewById(R.id.button1);
        wynik = (TextView)findViewById(R.id.textView3);

        switchA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(switchA.isChecked()){
                    table = " stolik okrągły";
                } else table = " stolik prostokatny";
            }
        });
        switchB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(switchB.isChecked()){
                    partner = " z osobą towarzyszącą";
                } else partner=" dla jednej osoby";
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String imieG = imie.getText().toString();
                String nazwiskoG = nazwisko.getText().toString();
                String klasa = "";
                if(radio_one.isChecked()){
                    klasa = " VIP ";
                }
                else if(radio_two.isChecked()){
                    klasa = " normlany ";
                }

                wynik.setText("Użytkownik " + imieG + " " + nazwiskoG + " kupił bilet " + klasa  + table + partner+".");

            }
        });
    };
}
