package com.example.taruc.practical3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Spinner spinnerAge;
    RadioGroup radioGroupGender;
    RadioButton radioButton;
    CheckBox checkBoxSmoker;
    TextView insurance;
    Button reset, calculate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerAge = findViewById(R.id.spinnerAge);
        radioGroupGender = findViewById(R.id.radioGroup);
        radioButton = findViewById(R.id.radioButton2);
        radioButton = findViewById(R.id.radioButton3);
        checkBoxSmoker = findViewById(R.id.checkBoxSmoker);
        insurance = findViewById(R.id.insurance);
        reset = findViewById(R.id.buttonReset);
        calculate = findViewById(R.id.buttonCalc);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.agegroup, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerAge.setAdapter(adapter);


    }

    public void calculatePremium() {
        int position = -1;
        double insurancePremium = 0;
        int gender;
        int checkBox;
        gender = radioGroupGender.getCheckedRadioButtonId();
        position = spinnerAge.getSelectedItemPosition();

        switch (position) {
            case 0:
                insurancePremium = 50;
                break;
            case 1:
                insurancePremium = 55;
        }
        if(gender == R.id.radioButtonMale){
            if(position>3){
                insurancePremium += 50;
            }
        }
        if(checkBoxSmoker.isChecked()){
            if(position==3){
                insurancePremium +=100;
            }
        }
    }
}
