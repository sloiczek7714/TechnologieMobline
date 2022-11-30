package wb.tm.technologiemobline;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.tabs.TabLayout;

import wb.tm.technologiemobline.adaptors.ViewPagerAdapter;

public class ComponentsActivity extends AppCompatActivity {
    private Button sendIn,sendOut, imageB;
    private EditText in;
    private EditText out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_components);
       FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setReorderingAllowed(true);
        ParamWejsciowyFragment f = new ParamWejsciowyFragment();
        transaction.replace(R.id.fragmentContainerView, f, null);
        transaction.commit();
       // in = findViewById(R.id.edit1);
        // out = findViewById(R.id.edit2);
       //  Button sendIn = findViewById(R.id.goToParamWej);
//
//        sendIn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                FragmentTransaction transaction = fragmentManager.beginTransaction();
//                transaction.setReorderingAllowed(true);
//                ParamWejsciowyFragment f = new ParamWejsciowyFragment();
//                Bundle bundle = new Bundle();
//                //bundle.putString("edit2", );
//                f.setArguments(bundle);
//                transaction.replace(R.id.fragmentContainerView, f, null);
//                transaction.commit();
//
//            }
//        });
//
//        Button sendOut = findViewById(R.id.goToParamWyj);
//        sendOut.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                FragmentTransaction transaction = fragmentManager.beginTransaction();
//                transaction.setReorderingAllowed(true);
//                transaction.replace(R.id.fragmentContainerView, ParamWyjFragment.class, null);
//                transaction.commit();
//
//            }
//        });
//
//        Button imageB = imageB = findViewById(R.id.goToGallery);
//        imageB.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                FragmentTransaction transaction = fragmentManager.beginTransaction();
//                transaction.setReorderingAllowed(true);
//                transaction.replace(R.id.fragmentContainerView, ImageFragment.class, null);
//                transaction.commit();
//
//            }
//        });
    }

}

    
