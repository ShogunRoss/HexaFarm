package com.example.shogunross.hexafarm;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by ShogunRoss on 11/7/2017.
 */

public class ThirdFragment extends Fragment {

    private FragmentChangeListener mListener;

    public ThirdFragment(){}

    ListView listViewVegetable;
    ArrayList<VegetableType> arrayVegetable;
    VegetableAdapter adapter;
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().setTitle("Database");

        map();

        adapter = new VegetableAdapter(getActivity(), R.layout.list_vegetable, arrayVegetable);
        listViewVegetable.setAdapter(adapter);

        listViewVegetable.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(),"You selected " + arrayVegetable.get(position).getName(), Toast.LENGTH_SHORT).show();
                mListener.replaceFragment(1);
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.third_fragment, container, false);

        return view;
    }

    private void map(){
        listViewVegetable = (ListView) getActivity().findViewById(R.id.listViewVegetable);
        arrayVegetable = new ArrayList<>();

        arrayVegetable.add(new VegetableType("Broccoli", "Broccoli - Description here!", R.drawable.broccoli64));
        arrayVegetable.add(new VegetableType("Onion", "Onion - Description here!", R.drawable.onion64));
        arrayVegetable.add(new VegetableType("Lettuce", "Lettuce - Description here!", R.drawable.lettuce64));
        arrayVegetable.add(new VegetableType("Salad", "Salad - Description here!", R.drawable.salad64));
        arrayVegetable.add(new VegetableType("Potato", "Potato - Description here!", R.drawable.potatoes64));


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
