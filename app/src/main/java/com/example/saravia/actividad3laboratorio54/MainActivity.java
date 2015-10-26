package com.example.saravia.actividad3laboratorio54;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView animationTarget;
    private Button rotar;
    private Button escalar;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animationTarget = (ImageView) this.findViewById(R.id.imagen);
    rotar =(Button)findViewById(R.id.rotar);
        escalar=(Button)findViewById(R.id.escalar);
        rotar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat
                        (animationTarget, "rotation", 360f);
                scaleXAnimator.setRepeatCount(0);
                scaleXAnimator.setDuration(1000);
                scaleXAnimator.start();
            }
        });
        escalar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                ObjectAnimator scaleXAnimator = ObjectAnimator.ofFloat
                        (animationTarget, "scaleX", 0.5f);
                scaleXAnimator.setRepeatMode(ValueAnimator.REVERSE);
                scaleXAnimator.setRepeatCount(1);
                scaleXAnimator.setDuration(1000);
                scaleXAnimator.start();
            }
        });


    }

    public void escala(View v){
        Animator animation = AnimatorInflater.loadAnimator
                (this, R.anim.escala);
        animation.setTarget(animationTarget);
        animation.start();
    }
    public void rota (View v){
        Animator animation = AnimatorInflater.loadAnimator
                (this, R.anim.rotate_around_center_point);
        animation.setTarget(animationTarget);
        animation.start();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
