package no.hiof.trondkw.models;

import java.util.ArrayList;
import java.util.List;

public class Expense {
    // -------------------------------------------------------------------
    // class description
    /**
     *      The Expense class is designed to hold the data
     *      for a single user expense.
     *
     */
    // -------------------------------------------------------------------
    // fields
    private int expenseId;
    private String expenseTitle;
    private String expenseDescription;
    //private ExpenseCategory category;
    //private Date date;
    private int sum;


    // -------------------------------------------------------------------
    // constructors
    public Expense() {
    }

    public Expense(String title, int sum) {
        this.expenseTitle = title;
        this.sum = sum;
    }
    // -------------------------------------------------------------------


    // TODO
    // ExpenseCategory class or just a String?
    // Date, what's the best format?
    // getters / setters


    public String getExpenseTitle() {
        return expenseTitle;
    }

    public int getSum() {
        return sum;
    }



    public static List<Expense> getData() {

        ArrayList<Expense> list = new ArrayList<>();


        for (int i = 0; i < 50; i++) {

            String title = "Expense " + i;
            int sum = 1000 + i;

            list.add(new Expense(title, sum));

        }


        return list;
    }


}
