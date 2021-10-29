package no.hiof.trondkw.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

import no.hiof.trondkw.models.Month;


public class MonthRepository {


    // FireBase stuff... to be implemented


    public LiveData<List<Month>> getAllMonths() {

        return null;
    }

















    // SQLite stuff..... not implementing for now

    //private MonthDao monthDao //SQLite database stuff
    private LiveData<List<Month>> allMonths;

    public MonthRepository(Application application) {
        //MonthDatabase database = MonthDatabase.getInstance(application) //not implemented
        //monthDao = database.monthDao();
        //allMonths = monthDao.getAllMonths
    }

    /*
    --- asyncTasks
    insert
    update
    delete
    deleteAll...
    ---

    getAll...
     */




}
