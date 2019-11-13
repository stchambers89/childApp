package com.example.childapp;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

/**
 * In order to handle configuration changes (like screen-rotation), one must use a
 * ViewModel.
 * https://developer.android.com/topic/libraries/architecture/viewmodel.html
 */
public class CustomViewModel extends ViewModel {
    private MutableLiveData<List<Shape>> shapes;
    public LiveData<List<Shape>> getShapes() {
        if (shapes == null) {
            shapes = new MutableLiveData<List<Shape>>();
            loadShapes();
        }
        return shapes;
    }

    private void loadShapes() {
        // Do an asynchronous operation to fetch shapes.
    }
}
