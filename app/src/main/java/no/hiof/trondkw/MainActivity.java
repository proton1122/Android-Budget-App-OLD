package no.hiof.trondkw;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import no.hiof.trondkw.viewmodels.MonthViewModel;

public class MainActivity extends AppCompatActivity {

    private MonthViewModel monthViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //monthViewModel = new ViewModelProvider()

    }



}