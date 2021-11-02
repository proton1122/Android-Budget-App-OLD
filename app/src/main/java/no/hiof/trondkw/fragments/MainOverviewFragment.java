package no.hiof.trondkw.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import no.hiof.trondkw.R;
import no.hiof.trondkw.databinding.FragmentMainOverviewBinding;
import no.hiof.trondkw.models.Expense;
import no.hiof.trondkw.models.Month;
import no.hiof.trondkw.repositories.MonthRepository;
import no.hiof.trondkw.viewmodels.MonthViewModel;

public class MainOverviewFragment extends Fragment {

    // fields

    //private LiveData<Month> currentMonth;
    private Month currentMonth;

    private FragmentMainOverviewBinding binding;
    private MonthViewModel monthViewModel;



    // constructor
    public MainOverviewFragment() {
        // Required empty public constructor
        //loadData();
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        // get the view model
        monthViewModel = new ViewModelProvider(this).get(MonthViewModel.class);

        /*
        // observe the viewModel
        monthViewModel.getCurrentMonth().observe(this, month -> {

            // update UI
        });
         */

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main_overview, container, false);

        // bind data (to be changed)
        binding.setMonthViewModel(monthViewModel);

        //binding.setCurrentMonth(currentMonth);


        // wrong? which object to observe and where?
        /*
        binding.getMonthViewModel().getCurrentMonth().observe(getViewLifecycleOwner(), month -> {

        });
        */


        // bind data with ViewModel
        // not working, returns MutableLiveData (is this correct though?)
        //binding.setCurrentMonth(monthViewModel.getCurrentMonth());

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // navigation
        binding.MainOverviewFragmentFloatingActionButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_mainOverviewFragment_to_addExpenseFragment));
        binding.MainOverviewFragmentDetailsButton.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_mainOverviewFragment_to_monthlyDetailsFragment));

        // show data


        /*
        monthViewModel.getCurrentMonth().observe(getViewLifecycleOwner(), month -> {
            binding.MainOverviewFragmentRemainingInputTextView.setText("5000");
        });
         */






        binding.getMonthViewModel().getCurrentMonth().observe(getViewLifecycleOwner(), month -> {
            binding.MainOverviewFragmentBudgetInputTextView.setText(String.valueOf(monthViewModel.getCurrentMonth().getValue().getBudget()));
            double exp = calcExpenses(monthViewModel.getCurrentMonth().getValue().getMonthlyExpenses());
            System.out.println("Observer: " + exp);
            binding.MainOverviewFragmentExpensesInputTextView.setText(String.valueOf(calcExpenses(monthViewModel.getCurrentMonth().getValue().getMonthlyExpenses())));
            binding.MainOverviewFragmentRemainingInputTextView.setText("5000");
        });


        //binding.MainOverviewFragmentBudgetInputTextView.setText(String.valueOf(currentMonth.getValue().getBudget()));

        /*
        loadData();
        showData(view);
         */
    }



    private void loadData() {
        // firebase?

        // temp get dummy data
        currentMonth = MonthRepository.getTestMonth();
        //currentMonth = monthViewModel.getCurrentMonth();

    }


    private void showData(View view) {
        // graph...

        // budget
        TextView monthlyBudgetTextView = view.findViewById(R.id.MainOverviewFragment_BudgetInputTextView);

        // changed currentMonth from dummy data Month to LiveData<Month>
        //monthlyBudgetTextView.setText(String.valueOf(currentMonth.getBudget()));

        // why possible NullPointerException?
        monthlyBudgetTextView.setText(String.valueOf(currentMonth.getBudget()));



        // expenses
        TextView monthlyExpensesTextView = view.findViewById(R.id.MainOverviewFragment_ExpensesInputTextView);
        ArrayList<Expense> expenses = currentMonth.getMonthlyExpenses();
        double totalExpenses = calcExpenses(expenses);
        monthlyExpensesTextView.setText(String.valueOf(totalExpenses));

        // remaining
        TextView monthlyRemainingTextView = view.findViewById(R.id.MainOverviewFragment_RemainingInputTextView);
        double remaining = currentMonth.getBudget() - totalExpenses;
        monthlyRemainingTextView.setText(String.valueOf(remaining));
    }

    private double calcExpenses(ArrayList<Expense> expenses) {
        double totalExpenses = 0;

        for (Expense expense: expenses) {
            totalExpenses += expense.getSum();
        }
        System.out.println("Total expenses: " + totalExpenses);
        return totalExpenses;
    }




} // end MainOverviewFragment class