package com.example.android.dieorlive;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Comment;

public class Main2Activity extends AppCompatActivity {
    TextView NGuess,NGuess_text,GAge_text,Comment;
    Button check;
    EditText GAge;
    int i =0,pguess=0,remaining;
    String comment = "";
    int guess,age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        NGuess =(TextView)findViewById(R.id.Disp2);
        Comment=(TextView) findViewById(R.id.Comment);
        check = (Button)findViewById(R.id.checkbut);
        guess = Integer.parseInt(MainActivity.GUESS);
        NGuess.setText(""+guess);
        GAge_text = (TextView)findViewById(R.id.Disp3);
        GAge = (EditText) findViewById(R.id.Disp4);
        age = Integer.parseInt(MainActivity.AGE);
        NGuess_text = (TextView)findViewById(R.id.Disp1);

    }
    public void check(View view)
    {
        pguess=Integer.parseInt(GAge.getText().toString());
        i++;

        if(i < guess)
        { remaining = guess - i;
            if(pguess==age)
            {
                GAge.setVisibility(View.INVISIBLE);
                NGuess.setVisibility(View.INVISIBLE);
                NGuess_text.setVisibility(View.INVISIBLE);
                GAge_text.setVisibility(View.INVISIBLE);
                check.setVisibility(View.INVISIBLE);
                comment="WELL DONE!\nTHE CORRECT AGE IS:"+age;
            }
            else if(pguess<age)
            {
                NGuess.setText(""+remaining);
                GAge.setText(null);
                comment="YOU ARE KILLING THE SOUL EARLY!";
            }
            else
            {
                NGuess.setText(""+remaining);
                GAge.setText(null);
                comment="YOU HAVE TO KILL THE SOUL EARLY!";
            }
            Comment.setText(comment);
        }
        else if (i == guess)
        {  remaining = guess - i;
            if(pguess==age)
            {
                GAge.setVisibility(View.INVISIBLE);
                NGuess.setVisibility(View.INVISIBLE);
                NGuess_text.setVisibility(View.INVISIBLE);
                GAge_text.setVisibility(View.INVISIBLE);
                check.setVisibility(View.INVISIBLE);
                comment="WELL DONE!\nTHE CORRECT AGE IS : "+age;
            }
            else if(pguess<age)
            {
                NGuess.setText(""+remaining);
                GAge.setVisibility(View.INVISIBLE);
                GAge_text.setVisibility(View.INVISIBLE);
                check.setVisibility(View.INVISIBLE);
                comment="YOU ARE KILLING THE SOUL EARLY!\nYOU HAVE LOST YOUR TRIES!\nTHE CORRECT AGE IS : "+age;
            }
            else
            {
                NGuess.setText(""+remaining);
                GAge.setVisibility(View.INVISIBLE);
                GAge_text.setVisibility(View.INVISIBLE);
                check.setVisibility(View.INVISIBLE);
                comment="YOU SHOULD HAVE KILLED THE SOUL EARLY!\nYOU HAVE LOST YOUR TRIES!\nTHE CORRECT AGE IS : "+age;
            }
            Comment.setText(comment);
            i=0;
        }

    }

    public void reset(View view)
    {
        int res=2;
        GAge.setText("");
        NGuess.setText("");
        Intent inte = new Intent();
        inte.putExtra("reset",res);
        setResult(RESULT_OK,inte);
        finish();
    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        String guessleft = NGuess.getText().toString();
        String com = Comment.getText().toString();
        String ageval = GAge.getText().toString();
        outState.putString("guessleft",guessleft);
        outState.putString("com",com);
        outState.putString("ageval",ageval);
        outState.putInt("guessover",i);
    }
   @Override
   protected void onRestoreInstanceState(Bundle savedInstanceState)
   {
       super.onSaveInstanceState(savedInstanceState);
       String ageval=savedInstanceState.getString("ageval");
       String guessleft = savedInstanceState.getString("guessleft");
       String com = savedInstanceState.getString("com");
        i = savedInstanceState.getInt("guessover");
       GAge.setText(ageval);
       Comment.setText(com);
       NGuess.setText(guessleft);
   }
}

