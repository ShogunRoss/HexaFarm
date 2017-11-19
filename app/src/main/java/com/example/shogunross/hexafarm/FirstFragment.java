package com.example.shogunross.hexafarm;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by ShogunRoss on 11/7/2017.
 */

public class FirstFragment extends Fragment {

    private FragmentChangeListener mListener;

    public FirstFragment(){}

    int i;
    ImageView entry1,entry2,entry3,entry4,entry5,entry6;
    ImageButton btnSeed, btnAuto, btnDig;

    public int vegetableSelected;
    public boolean[] entryChecked = new boolean[6];
    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("Manual Set");

        DatabaseReference mData = FirebaseDatabase.getInstance().getReference();

        entry1 = getActivity().findViewById(R.id.plantEmpty1);
        entry2 = getActivity().findViewById(R.id.plantEmpty2);
        entry3 = getActivity().findViewById(R.id.plantEmpty3);
        entry4 = getActivity().findViewById(R.id.plantEmpty4);
        entry5 = getActivity().findViewById(R.id.plantEmpty5);
        entry6 = getActivity().findViewById(R.id.plantEmpty6);

        btnSeed = getActivity().findViewById(R.id.buttonSeed);
        btnAuto = getActivity().findViewById(R.id.buttonAuto);
        btnDig = getActivity().findViewById(R.id.buttonDig);

        entry1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (vegetableSelected != 0){
                    entry1.setImageResource(R.drawable.base_plant10);
                    entryChecked[0] = true;
                }
            }
        });
        entry2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (vegetableSelected != 0){
                    entry2.setImageResource(R.drawable.base_plant10);
                    entryChecked[1] = true;
                }
            }
        });
        entry3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (vegetableSelected != 0){
                    entry3.setImageResource(R.drawable.base_plant10);
                    entryChecked[2] = true;
                }
            }
        });
        entry4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (vegetableSelected != 0){
                    entry4.setImageResource(R.drawable.base_plant10);
                    entryChecked[3] = true;
                }
            }
        });
        entry5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (vegetableSelected != 0){
                    entry5.setImageResource(R.drawable.base_plant10);
                    entryChecked[4] = true;
                }
            }
        });
        entry6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (vegetableSelected != 0){
                    entry6.setImageResource(R.drawable.base_plant10);
                    entryChecked[5] = true;
                }
            }
        });

        btnSeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"You have selected buttonSeed",Toast.LENGTH_SHORT).show();
                mListener.replaceFragment(2, 0, entryChecked);
            }
        });

        if (entryChecked[0]){
            entry1.setImageResource(R.drawable.base_plant10);
        }
        if (entryChecked[1]){
            entry2.setImageResource(R.drawable.base_plant10);
        }
        if (entryChecked[2]){
            entry3.setImageResource(R.drawable.base_plant10);
        }
        if (entryChecked[3]){
            entry4.setImageResource(R.drawable.base_plant10);
        }
        if (entryChecked[4]){
            entry5.setImageResource(R.drawable.base_plant10);
        }
        if (entryChecked[5]){
            entry6.setImageResource(R.drawable.base_plant10);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.first_fragment, container, false);

        Bundle bundle = getArguments();

        if(bundle != null){
            //Toast.makeText(getActivity(), "You have got "+ bundle.getInt("vegetableSelected"), Toast.LENGTH_SHORT).show();
            vegetableSelected = bundle.getInt("vegetableSelected");
            entryChecked = bundle.getBooleanArray("empty");
        }



        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (FragmentChangeListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;

    }

}
