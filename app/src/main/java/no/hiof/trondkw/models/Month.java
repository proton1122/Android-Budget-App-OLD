package no.hiof.trondkw.models;

import java.util.ArrayList;
import java.util.List;

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
        this.budget = 0;
        this.expenses = 0;
        this.remaining = 0;
    }

    // temp constructor for dummy data
    public Month(double budget, ArrayList<Expense> expenses) {
        this.budget = budget;
        this.monthlyExpenses = expenses;
    }

    // -------------------------------------------------------------------

    // TODO
    //




    // -------------------------------------------------------------------
    // getters / setters

    public int getMonthId() {
        return monthId;
    }

    public ArrayList<Expense> getMonthlyExpenses() {
        return monthlyExpenses;
    }
    public void setMonthlyExpenses(ArrayList<Expense> monthlyExpenses) {
        this.monthlyExpenses = monthlyExpenses;
    } // delete?

    public double getBudget() {
        return budget;
    }
    public void setBudget(double budget) {
        this.budget = budget;
    }

    public double getExpenses() {
        return expenses;
    }
    public void setExpenses(double expenses) {
        this.expenses = expenses;
    } // get and add all expenses from ArrayList<Expense>

    public double getRemaining() {
        return remaining;
    }
    public void setRemaining(double remaining) {
        this.remaining = remaining;
    } // delete? ( budget - expenses )
    // -------------------------------------------------------------------





}
