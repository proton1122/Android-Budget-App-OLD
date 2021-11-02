package no.hiof.trondkw.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import no.hiof.trondkw.models.Month;
import no.hiof.trondkw.repositories.MonthRepository;

public class MonthViewModel extends ViewModel {


    private MutableLiveData<Month> currentMonth;


    public LiveData<Month> getCurrentMonth() {

        if(currentMonth == null) {
            currentMonth = new MutableLiveData<>();
            loadMonth();
        }

        return currentMonth;
    }


    private void loadMonth() {
        // Do an asynchronous operation to fetch users.

        currentMonth.setValue(MonthRepository.getTestMonth());
    }









    /*
    // constructor not needed?
    public MonthViewModel() {
        // change to get from Repository
        mCurrentMonth.setValue(MonthRepository.getTestMonth());
    }
     */


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
