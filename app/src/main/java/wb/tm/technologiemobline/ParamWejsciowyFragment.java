package wb.tm.technologiemobline;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ParamWejsciowyFragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class ParamWejsciowyFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ParamWejsciowyFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ParamWejsciowyFragment newInstance(String param1, String param2) {
        ParamWejsciowyFragment fragment = new ParamWejsciowyFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public ParamWejsciowyFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_param_wejsciowy, container, false);
       // getArguments().getString("recordID");
        Button sendIn = view.findViewById(R.id.goToParamWejWEJ);
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        sendIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);
                ParamWejsciowyFragment f = new ParamWejsciowyFragment();
                Bundle bundle = new Bundle();
                TextView tv = view.findViewById(R.id.edit2);
                bundle.putString("recordID", tv.getText().toString());
                f.setArguments(bundle);
                transaction.replace(R.id.fragmentContainerView, f, null);
                transaction.commit();

            }
        });

        Button sendOut = view.findViewById(R.id.goToParamWyjWEJ);
        sendOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);
                ParamWyjFragment f = new ParamWyjFragment();
                Bundle bundle = new Bundle();
                TextView tv = view.findViewById(R.id.edit2);
                bundle.putString("recordID", tv.getText().toString());
                f.setArguments(bundle);
                transaction.replace(R.id.fragmentContainerView, f, null);
                transaction.commit();

            }
        });

        Button imageB = view.findViewById(R.id.goToGalleryWEJ);
        imageB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.setReorderingAllowed(true);
                transaction.replace(R.id.fragmentContainerView, ImageFragment.class, null);
                transaction.commit();

            }
        });
        return view;
    }
}