package no.hiof.trondkw.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import no.hiof.trondkw.models.Expense;
import no.hiof.trondkw.models.Month;

public class MonthViewModel extends ViewModel {


    private MutableLiveData<Month> mCurrentMonth = new MutableLiveData<>();


    // constructor
    public MonthViewModel() {

        // change to get from Repository
        mCurrentMonth.setValue(Month.getTestMonth());
    }


    // getters / setters
    public MutableLiveData<Month> getCurrentMonth() {
        return mCurrentMonth;
    }





    // -----------------------------------------------------------------------------------------
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
    */
    // -----------------------------------------------------------------------------------------


} // end MonthViewModel class
