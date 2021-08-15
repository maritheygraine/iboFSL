package com.example.bigkas;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fingerspelling#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fingerspelling extends Fragment {

    //Declarations
    TextView textView;
    EditText editText;
    Button clear_btn, translate_btn;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fingerspelling() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fingerspelling.
     */
    // TODO: Rename and change types and number of parameters
    public static Fingerspelling newInstance(String param1, String param2) {
        Fingerspelling fragment = new Fingerspelling();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
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
        View view =  inflater.inflate(R.layout.fragment_fingerspelling, container, false);

        editText = view.findViewById(R.id.normal_txt);
        clear_btn = view.findViewById(R.id.clear_btn);
        translate_btn = view.findViewById(R.id.translate_btn);
        textView =  view.findViewById(R.id.fingerspell_view);

        clear_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText.getText().clear();
            }
        });

        translate_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String translated = editText.getText().toString();
                textView.setText(translated);
            }
        });
        return view;
    }
}