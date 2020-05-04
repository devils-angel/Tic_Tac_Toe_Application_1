package com.example.tic_tac_toe_application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity<Int> extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    int toggle = 0;
    // toggle is used to toggle between zeroes and crosses
    //0 -- cross
    //1 -- zero
    Boolean active_game = true;
    //Gamestate is an array storing the state of the game
    // 0 = cross, 1 = zero , 2 = null
    int[] GameState = {2,2,2,2,2,2,2,2,2};

    int[][] winPositions = {{0,1,2}, {3,4,5}, {6,7,8},
            {0,3,6}, {1,4,7}, {2,5,8},
            {0,4,8}, {2,4,6}};



    public void player_tap(View view){


        ImageView img = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());
        String text;
        if(! active_game){
            gameReset(view);
        }

        if (GameState[tappedImage]==2){

        GameState[tappedImage]= toggle;

            if(toggle==0){
                toggle = 1;
                img.setImageResource(R.drawable.cross);
                TextView status = findViewById(R.id.status);
                status.setText("O's Turn - Tap to play");
            }
            else{
                toggle = 0;
                img.setImageResource(R.drawable.zero);
                TextView status = findViewById(R.id.status);
                status.setText("X's turn - Tap to play ");
            }


            for(int[] i : winPositions){
                if ((GameState[i[0]]==GameState[i[1]])&&(GameState[i[1]]==GameState[i[2]])&&(GameState[i[0]]!= 2)){
                    TextView status = findViewById(R.id.status);
                    if(GameState[tappedImage]==0)
                             text= "CROSS HAS WON!!! ;)";
                    else
                            text= "ZERO HAS WON!!! ;)";

                    status.setText(text);
                    active_game = false;

                }
            }


        }


    }

    public void gameReset(View view) {
        active_game = true;
        toggle= 0;
        for (int i = 0; i < GameState.length; i++) {
            GameState[i] = 2;
        }
        ((ImageView) findViewById(R.id.imageView9)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView) findViewById(R.id.imageView8)).setImageResource(0);

        TextView status = findViewById(R.id.status);
        status.setText("X's Turn - Tap to play");
    }


}
