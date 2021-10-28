package no.hiof.trondkw.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import no.hiof.trondkw.R;
import no.hiof.trondkw.models.Expense;
import no.hiof.trondkw.models.Month;

public class MainOverviewFragment extends Fragment {

    // fields

    private Month currentMonth;


    // constructor
    public MainOverviewFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_main_overview, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        // load data
        loadData();


        // show data
        showData(view);



        // navigation
        Button goToAddExpenseFragment = view.findViewById(R.id.MainOverviewFragment_AddExpenseButton);
        goToAddExpenseFragment.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_mainOverviewFragment_to_addExpenseFragment));

        Button goToMonthlyDetailsFragment = view.findViewById(R.id.MainOverviewFragment_DetailsButton);
        goToMonthlyDetailsFragment.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_mainOverviewFragment_to_monthlyDetailsFragment));
    }



    private void loadData() {
        // firebase?

        // temp get dummy data

        double budget = 10000;

        ArrayList<Expense> expenses = new ArrayList<>(Expense.getData());

        currentMonth = new Month(budget, expenses);
    }


    private void showData(View view) {
        // graph...


        // budget
        TextView monthlyBudgetTextView = view.findViewById(R.id.MainOverviewFragment_BudgetInputTextView);
        monthlyBudgetTextView.setText(String.valueOf(currentMonth.getBudget()));

        // expenses
        TextView monthlyExpensesTextView = view.findViewById(R.id.MainOverviewFragment_ExpensesInputTextView);

        ArrayList<Expense> expenses = currentMonth.getMonthlyExpenses();

        double totalExpenses = 0;

        for (Expense expense: expenses) {
            totalExpenses += expense.getSum();
        }

        monthlyExpensesTextView.setText(String.valueOf(totalExpenses));


        // remaining
        TextView monthlyRemainingTextView = view.findViewById(R.id.MainOverviewFragment_RemainingInputTextView);

        double remaining = currentMonth.getBudget() - totalExpenses;

        monthlyRemainingTextView.setText(String.valueOf(remaining));


    }




} // end MainOverviewFragment class