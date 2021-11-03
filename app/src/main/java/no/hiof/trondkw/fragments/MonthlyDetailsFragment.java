package no.hiof.trondkw.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Objects;

import no.hiof.trondkw.R;
import no.hiof.trondkw.adapter.ExpenseRecyclerAdapter;
import no.hiof.trondkw.databinding.FragmentMonthlyDetailsBinding;
import no.hiof.trondkw.models.Expense;
import no.hiof.trondkw.models.Month;
import no.hiof.trondkw.repositories.MonthRepository;
import no.hiof.trondkw.viewmodels.MonthViewModel;

public class MonthlyDetailsFragment extends Fragment {

    private FragmentMonthlyDetailsBinding binding;
    private MonthViewModel monthViewModel;
    private LiveData<Month> currentMonth;


    public MonthlyDetailsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // get the view model
        monthViewModel = new ViewModelProvider(this).get(MonthViewModel.class);
        currentMonth = monthViewModel.getCurrentMonth();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //return inflater.inflate(R.layout.fragment_monthly_details, container, false);

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_monthly_details, container, false);

        // bind data (to be changed)
        binding.setMonthViewModel(monthViewModel);

        return binding.getRoot();

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ExpenseRecyclerAdapter adapter = new ExpenseRecyclerAdapter();
        binding.MonthlyDetailsFragmentRecyclerView.setAdapter(adapter);
        adapter.setExpenses(Objects.requireNonNull(currentMonth.getValue()).getMonthlyExpenses());

     /*   RecyclerView expenseRecyclerView = view.findViewById(R.id.MonthlyDetailsFragment_RecyclerView);

        //expenseRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        expenseRecyclerView.setHasFixedSize(true);


        expenseRecyclerView.setAdapter(adapter);
      */


        binding.monthlyDetailsFragmentFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Hello from FAB");
                ArrayList<Expense> expenseArraylist = new ArrayList<>();
                expenseArraylist.add(new Expense("test expense", 5000));
                binding.getMonthViewModel().getCurrentMonth().getValue().setMonthlyExpenses(expenseArraylist);
                currentMonth.getValue().setBudget(5000);
            }
        });


        monthViewModel.getCurrentMonth().observe(requireActivity(), new Observer<Month>() {
            @Override
            public void onChanged(Month month) {
                //binding.setMonthViewModel(monthViewModel);
                //adapter.setExpenses(month.getMonthlyExpenses());
            }
        });



        /*
        Month testMonth = monthViewModel.getCurrentMonth().getValue();
        ArrayList<Expense> expenses = monthViewModel.getCurrentMonth().getValue().getMonthlyExpenses();
        System.out.println("OnViewCreated: " + testMonth.getBudget());


        testSetupRecyclerView(view);
        */

    }

    private void testSetupRecyclerView(View view) {

        RecyclerView expenseRecyclerView = view.findViewById(R.id.MonthlyDetailsFragment_RecyclerView);


        // MonthRepository.getTestExpenseList() needs to be replaced with ViewModel / LiveData!
        expenseRecyclerView.setAdapter(new ExpenseRecyclerAdapter(getContext(), MonthRepository.getTestExpenseList()));

        expenseRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

    }



}