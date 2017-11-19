package com.example.shogunross.hexafarm;

import android.app.Activity;
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

    public void showPopup(View anchorView) {

        View popupView = getLayoutInflater().inflate(R.layout.popup_menu, null);

        PopupWindow popupWindow = new PopupWindow(popupView,
                LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);



        // Initialize more widgets from `popup_layout.xml`

        // If the PopupWindow should be focusable
        popupWindow.setFocusable(true);

        // If you need the PopupWindow to dismiss when when touched outside
        popupWindow.setBackgroundDrawable(new ColorDrawable());

        int location[] = new int[2];

        // Get the View's(the one that was clicked in the Fragment) location
        anchorView.getLocationOnScreen(location);

        // Using location, the PopupWindow will be displayed right under anchorView
        popupWindow.showAtLocation(anchorView, Gravity.NO_GRAVITY,
                location[0], location[1] + anchorView.getHeight());

    }

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



        btnSeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Toast.makeText(getActivity(),"You have selected buttonSeed",Toast.LENGTH_SHORT).show();
            mListener.replaceFragment(2);

                //showPopup(v);

                /*PopupMenu popupMenu = new PopupMenu(getActivity(), view);
                popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());

                popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        Toast.makeText(getActivity(),"You Clicked : " + item.getTitle(),Toast.LENGTH_SHORT).show();
                        return false;
                    }
                });
                popupMenu.show();//showing popup menu*/

            }

        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.first_fragment, container, false);
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
