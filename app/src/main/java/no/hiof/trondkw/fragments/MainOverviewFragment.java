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





}