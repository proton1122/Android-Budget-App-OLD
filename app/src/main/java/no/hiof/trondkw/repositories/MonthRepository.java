package no.hiof.trondkw.repositories;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.ArrayList;
import java.util.List;

import no.hiof.trondkw.models.Expense;
import no.hiof.trondkw.models.Month;


public class MonthRepository {



    public MonthRepository() {

    }





    // Generate dummy data
    public static Month getTestMonth() {
        double budget = 10000;

        ArrayList<Expense> list = new ArrayList<>(getTestExpenseList());

        return new Month(budget, list);
    }

    public static List<Expense> getTestExpenseList() {
        List<Expense> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            String title = "Expense " + i;
            int sum = 1000 + i;

            list.add(new Expense(title, sum));
        }
        return list;
    }










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
