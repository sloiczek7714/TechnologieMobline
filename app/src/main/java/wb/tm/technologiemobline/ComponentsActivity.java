package wb.tm.technologiemobline;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ComponentsActivity extends AppCompatActivity {
    private Button go2ActivityButton;
    private EditText in;
    private EditText out;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_components);

        go2ActivityButton = findViewById(R.id.obliczB);
        in = findViewById(R.id.edit1);
        out = findViewById(R.id.edit2);

        go2ActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToActivity2();

            }
        });
    }

    private void goToActivity2() {
        Intent go2ActivityIntent = new Intent(ComponentsActivity.this, ComponentsSecndActivity.class);
        go2ActivityIntent.putExtra("inVal", in.getText().toString());
        startActivityForResult(go2ActivityIntent, 1234);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == 1234){
            out.setText(data.getStringExtra("outVal"));
        }
    }
}
