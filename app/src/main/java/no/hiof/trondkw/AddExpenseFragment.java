package no.hiof.trondkw;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;


public class AddExpenseFragment extends Fragment implements DatePickerDialog.OnDateSetListener {

    private TextView dateEditText;

    private int dayOfMonth;
    private int month;
    private int year;


    public AddExpenseFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_add_expense, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dateEditText = view.findViewById(R.id.AddExpenseFragment_SelectDateView);
        dateEditText.setOnClickListener(view1 -> showDatePickerDialog());
        setDefaultDate();

        // SELECT EXPENSE CATEGORY
        // populate category spinner with a predefined string array
        // TODO
        // Separate class / data for categories
        Spinner spinner = view.findViewById(R.id.AddExpenseFragment_SelectCategorySpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.expense_category_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
    }


    private void showDatePickerDialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), this, year, month, dayOfMonth);

        datePickerDialog.show();
    }


    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        this.year = year;
        this.month = month;
        this.dayOfMonth = dayOfMonth;
        String date = "day/month/year: " + dayOfMonth + "/" + (month + 1) + "/" + year;
        dateEditText.setText(date);
    }

    private void setDefaultDate() {
        year = Calendar.getInstance().get(Calendar.YEAR);
        month = Calendar.getInstance().get(Calendar.MONTH);
        dayOfMonth = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);

        String date = "Today";
        dateEditText.setText(date);
    }

}