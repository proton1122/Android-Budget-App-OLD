package no.hiof.trondkw.adapter;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.zip.Inflater;

import no.hiof.trondkw.R;
import no.hiof.trondkw.models.Expense;

public class ExpenseRecyclerAdapter extends RecyclerView.Adapter<ExpenseRecyclerAdapter.ExpenseViewHolder> {

    private List<Expense> expenseList;
    private LayoutInflater inflater;


    public ExpenseRecyclerAdapter(Context context, List<Expense> expenseList) {
        inflater = LayoutInflater.from(context);

        this.expenseList = expenseList;
    }


    @NonNull
    @Override
    public ExpenseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {

        View itemView = inflater.inflate(R.layout.expense_list_item, parent, false);

        return new ExpenseViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ExpenseViewHolder holder, int position) {

        Expense expenseToDisplay = expenseList.get(position);

        holder.setExpense(expenseToDisplay);


    }

    @Override
    public int getItemCount() {
        return expenseList.size();
    }





    public class ExpenseViewHolder extends RecyclerView.ViewHolder {

        private TextView expenseTitleTextView;
        private TextView expenseSumTextView;

        public ExpenseViewHolder(@NonNull View itemView) {
            super(itemView);

            expenseTitleTextView = itemView.findViewById(R.id.ExpenseListItem_ExpenseTitleTextView);
            expenseSumTextView = itemView.findViewById(R.id.ExpenseListItem_ExpenseSumTextView);

        }

        public void setExpense(Expense expenseToDisplay) {
            expenseTitleTextView.setText(expenseToDisplay.getExpenseTitle());

            String sum = expenseToDisplay.getSum() + ",-";
            expenseSumTextView.setText(sum);
        }


    }





}
