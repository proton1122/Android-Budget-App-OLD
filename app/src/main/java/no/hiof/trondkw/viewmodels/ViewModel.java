package no.hiof.trondkw.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import no.hiof.trondkw.models.Month;

public class ViewModel extends androidx.lifecycle.ViewModel {


    private MutableLiveData<Month> currentMonth;


    public LiveData<Month> getCurrentMonth() {
        return currentMonth;
    }










}
