package no.hiof.trondkw.models;

import java.util.ArrayList;

public class Month {
    // -------------------------------------------------------------------
    // class description
    /**
     *      The Month class (name to be decided) is designed to hold
     *      all the data needed to give the user a monthly overview
     *      for budget and expenses.
     *
     */
    // -------------------------------------------------------------------
    // fields

    private int monthId;

    private ArrayList<Expense> monthlyExpenses;

    private double budget;
    private double expenses;    // needed?
    private double remaining;   // probably not needed

    // -------------------------------------------------------------------
    // constructors
    public Month() {

    }
    // -------------------------------------------------------------------

    // TODO
    //

}
