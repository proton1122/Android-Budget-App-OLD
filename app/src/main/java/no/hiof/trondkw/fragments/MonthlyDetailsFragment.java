package no.hiof.trondkw.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import no.hiof.trondkw.R;
import no.hiof.trondkw.adapter.ExpenseRecyclerAdapter;
import no.hiof.trondkw.models.Expense;
import no.hiof.trondkw.models.Month;
import no.hiof.trondkw.repositories.MonthRepository;
import no.hiof.trondkw.viewmodels.MonthViewModel;

public class MonthlyDetailsFragment extends Fragment {

    private MonthViewModel monthViewModel;


    public MonthlyDetailsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // get the view model
        monthViewModel = new ViewModelProvider(this).get(MonthViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_monthly_details, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        Month testMonth = monthViewModel.getCurrentMonth().getValue();
        ArrayList<Expense> expenses = monthViewModel.getCurrentMonth().getValue().getMonthlyExpenses();
        System.out.println("OnViewCreated: " + testMonth.getBudget());


        testSetupRecyclerView(view);

    }

    private void testSetupRecyclerView(View view) {

        RecyclerView expenseRecyclerView = view.findViewById(R.id.MonthlyDetailsFragment_RecyclerView);


        // MonthRepository.getTestExpenseList() needs to be replaced with ViewModel / LiveData!
        expenseRecyclerView.setAdapter(new ExpenseRecyclerAdapter(getContext(), MonthRepository.getTestExpenseList()));

        expenseRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

    }



}