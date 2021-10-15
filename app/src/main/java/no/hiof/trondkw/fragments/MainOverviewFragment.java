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

import no.hiof.trondkw.R;

public class MainOverviewFragment extends Fragment {

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

        Button goToSecondFragmentButton = view.findViewById(R.id.MainOverviewFragment_AddExpenseButton);
        goToSecondFragmentButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_mainOverviewFragment_to_addExpenseFragment));


        Button goToMonthlyDetailsFragment = view.findViewById(R.id.MainOverviewFragment_DetailsButton);
        goToMonthlyDetailsFragment.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_mainOverviewFragment_to_monthlyDetailsFragment));


    }

}