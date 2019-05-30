package com.example.android.dieorlive;

import android.content.Context;
import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static String AGE = "com.example.android.example.AGE";
    public static String GUESS = "com.example.android.example.GUESS";
    EditText age_edit, guess_edit;
    int agecheck,guesscheck;
    Button setplay;
    String age="";
    String guess="";
    String CONDITION="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        age_edit = (EditText) findViewById(R.id.Age);
        guess_edit = (EditText) findViewById(R.id.guess);
        setplay = (Button) findViewById(R.id.but);
    }

    public void set(View view)

    {   age_edit = (EditText) findViewById(R.id.Age);
        guess_edit = (EditText) findViewById(R.id.guess);
        setplay = (Button) findViewById(R.id.but);
        age = (age_edit.getText().toString());
        guess = (guess_edit.getText().toString());
        agecheck=Integer.parseInt(age);
        guesscheck=Integer.parseInt(guess);

        if ((age.equals("")) || (guess.equals("")))
        {Toast.makeText(this, "Enter Inputs!", Toast.LENGTH_SHORT).show();
        }
        else

        {if ((agecheck > 0) && (agecheck < 100) ) {
            AGE = age;
            GUESS = guess;
            Intent CheckAge = new Intent(this, Main2Activity.class);
            startActivityForResult(CheckAge, 1);
        }
        else {
            Toast.makeText(this, "Age should lie between 0 and 100!", Toast.LENGTH_SHORT).show();
            age_edit.setText("");
        }

        }}

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
      if(requestCode==1)
      {
          if (resultCode==RESULT_OK)
          {
              int result = data.getIntExtra("reset",0);
              if(result==2|result==0)
              {
                  age_edit.setText("");
                  guess_edit.setText("");
              }
          }
      }
    }
}




