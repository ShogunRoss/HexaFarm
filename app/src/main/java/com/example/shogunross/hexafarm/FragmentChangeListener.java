package com.example.shogunross.hexafarm;

import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by ShogunRoss on 11/19/2017.
 */

public interface FragmentChangeListener {
    public void replaceFragment(int id, int position, boolean[] empty);
}
