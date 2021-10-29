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
    private String expenseCategory;
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


    // -------------------------------------------------------------------
    // getters / setters

    public int getExpenseId() {
        return expenseId;
    }

    public void setExpenseTitle(String expenseTitle) {
        this.expenseTitle = expenseTitle;
    }
    public String getExpenseDescription() {
        return expenseDescription;
    }

    public void setExpenseDescription(String expenseDescription) {
        this.expenseDescription = expenseDescription;
    }
    public String getExpenseCategory() {
        return expenseCategory;
    }

    public void setExpenseCategory(String expenseCategory) {
        this.expenseCategory = expenseCategory;
    }
    public void setSum(int sum) {
        this.sum = sum;
    }


    // -------------------------------------------------------------------

}
