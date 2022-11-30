package wb.tm.technologiemobline;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ComponentsActivity extends AppCompatActivity {
    private Button sendIn,sendOut, imageB;
    private EditText in;
    private EditText out;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_components);
        FragmentManager fragmentManager = getSupportFragmentManager();
        //in = findViewById(R.id.edit1);
       // out = findViewById(R.id.edit2);
        Button sendIn = findViewById(R.id.goToParamWej);
        sendIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.fragmentContainerView, ParamWejsciowyFragment.class, null);
                transaction.commit();

            }
        });
        Button sendOut = findViewById(R.id.goToParamWyj);
        sendOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.fragmentContainerView, ParamWyjFragment.class, null);
                transaction.commit();

            }
        });

        Button imageB = imageB = findViewById(R.id.goToGallery);
        imageB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.fragmentContainerView, ImageFragment.class, null);
                transaction.commit();

            }
        });
    }

//    private void goToActivity2() {
//        Intent go2ActivityIntent = new Intent(ComponentsActivity.this, ComponentsSecndActivity.class);
//        go2ActivityIntent.putExtra("inVal", in.getText().toString());
//        startActivityForResult(go2ActivityIntent, 1234);
//
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (resultCode == RESULT_OK && requestCode == 1234){
//            out.setText(data.getStringExtra("outVal"));
//        }
//    }
}
