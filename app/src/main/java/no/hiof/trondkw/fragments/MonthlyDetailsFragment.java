package no.hiof.trondkw.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import no.hiof.trondkw.R;
import no.hiof.trondkw.adapter.ExpenseRecyclerAdapter;
import no.hiof.trondkw.models.Expense;

public class MonthlyDetailsFragment extends Fragment {


    public MonthlyDetailsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_monthly_details, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        testSetupRecyclerView(view);

    }

    private void testSetupRecyclerView(View view) {

        RecyclerView expenseRecyclerView = view.findViewById(R.id.MonthlyDetailsFragment_RecyclerView);

        expenseRecyclerView.setAdapter(new ExpenseRecyclerAdapter(getContext(), Expense.getData()));

        expenseRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

    }



}