package com.example.radiobutton;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class secondPage extends AppCompatActivity {
    RadioGroup radioGroup;
    TextView txt1, txt2;
    RadioButton radioButton;
    Button btnFavorite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);

        radioGroup = findViewById(R.id.rGroupFavorite);
        txt1 = findViewById(R.id.txtSecondPage);
        txt2 = findViewById(R.id.txtShow);
        btnFavorite = findViewById(R.id.btnYourFavorite);

        btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int r_btn_ID = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(r_btn_ID);



                Intent intent = getIntent();
                String page_1 = intent.getStringExtra("Page1_Answer");
                String Name = intent.getStringExtra("name");
                txt1.setText("Wel Come "+Name+"...."+" You Selected Number from 1St Page : "+page_1);

                txt2.setText("Hey "+ Name +"!!!"+" Now; Your Choice is : "+ radioButton.getText());


            }
        });

    }
    public void selectFavorite(View v){
        int r_btn_ID  = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(r_btn_ID);

        Toast.makeText(this, "Your Favorite is " + radioButton.getText(), Toast.LENGTH_SHORT).show();

    }
}