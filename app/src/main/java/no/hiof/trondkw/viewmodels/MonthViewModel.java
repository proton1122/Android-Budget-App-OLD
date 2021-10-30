package no.hiof.trondkw.viewmodels;

import android.app.Application;
import android.content.ClipData;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import no.hiof.trondkw.models.Expense;
import no.hiof.trondkw.models.Month;
import no.hiof.trondkw.repositories.MonthRepository;

public class MonthViewModel extends ViewModel {

    //private MonthRepository repository;


    private MutableLiveData<Month> monthMutableLiveData = new MutableLiveData<>();

    private MutableLiveData<Month> mCurrentMonth = new MutableLiveData<>();
    private MutableLiveData<List<Expense>> expenses;

    // constructor
    public MonthViewModel() {
        //currentMonth = new MutableLiveData<>(Month.getTestMonth());

        mCurrentMonth.setValue(Month.getTestMonth());
    }


    // getters / setters
    public MutableLiveData<Month> getCurrentMonth() {
        return monthMutableLiveData;
    }


    // TEST

    //private final MutableLiveData<List<Month>> months = new MutableLiveData<>();
    //private MutableLiveData<List<Month>> mAllMonths;
    //private LiveData<List<Month>> allMonths;

    // Application context is needed for database, so this might be unnecessary
    /*
    public MonthViewModel(@NonNull Application application) {


        //repository = new MonthRepository(application);
        //allMonths = repository.getAllMonths(); // RETURNS NULL!

    }
     */

    // database methods

    public void insert(Month month) {
        // repository.insert(month)
    }
    public void update(Month month) {}
    public void delete(Month month) {}
    public void deleteAll() {}
    public LiveData<List<Month>> getAllMonths() {
        return null;
    }

}
