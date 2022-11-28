package wb.tm.technologiemobline;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ComponentsSecndActivity extends AppCompatActivity {

    private TextView wej2;
    private Button odbB;
    private Button odeB;
    private Intent odbIntent;
    private String val;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_components_secnd);

        wej2 = findViewById(R.id.text3);
        odbB = findViewById(R.id.getB);
        odeB = findViewById(R.id.sendB);

        odbB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                odb();
            }
        });

        odeB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ode();
            }
        });
    }

    private void ode() {
        val += " ma kota";
        odbIntent.putExtra("outVal", val);
        setResult(RESULT_OK, odbIntent);
        finish();
    }

    private void odb() {
        odbIntent = getIntent();
        wej2.setText(odbIntent.getStringExtra("inVal"));
        val = wej2.getText().toString();
    }
}
