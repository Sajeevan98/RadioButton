package com.example.radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup rGroup;
    RadioButton rBtn;
    TextView txtView;
    Button btnAplay, btnNXT;
    EditText etxt_name ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rGroup = findViewById(R.id.radioGroup);
        txtView = findViewById(R.id.txtSelection);
        btnNXT = findViewById(R.id.btnNext);
        etxt_name = findViewById(R.id.etxtName);

        btnAplay = findViewById(R.id.btnApply);

        btnAplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioId = rGroup.getCheckedRadioButtonId();
                rBtn = findViewById(radioId);
                txtView.setText("Hello "+ etxt_name.getText()+ "!!!"+" Your Choice is : "+ rBtn.getText());

            }
        });

        btnNXT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSecondActivity();
            }
        });



    }

    public void selectButton(View v) {
        int radioId = rGroup.getCheckedRadioButtonId();
        rBtn = findViewById(radioId);
        Toast.makeText(this, "Selected Radio Button : "+rBtn.getText(),  Toast.LENGTH_SHORT).show();

    }
    public void openSecondActivity(){
        Intent intent = new Intent(this,secondPage.class);
        intent.putExtra("Page1_Answer", rBtn.getText().toString()); // send value second_page from first_page...
        intent.putExtra("name",etxt_name.getText().toString());
        startActivity(intent);

    }

}