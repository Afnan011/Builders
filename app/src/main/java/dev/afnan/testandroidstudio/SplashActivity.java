package dev.afnan.testandroidstudio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    ImageView logo;
    TextView tagline, footer;
    Animation scale, top, bottom;

    private static int SPLASH_SCREEN = 2500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
        );
        setContentView(R.layout.activity_splash);

        logo = findViewById(R.id.logo);
        tagline = findViewById(R.id.tagline);
        footer = findViewById(R.id.footer);

        scale = AnimationUtils.loadAnimation(this, R.anim.scale);
        bottom = AnimationUtils.loadAnimation(this, R.anim.bottom);
        top = AnimationUtils.loadAnimation(this, R.anim.top);

        logo.setAnimation(scale);
        tagline.setAnimation(scale);
        footer.setAnimation(top);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_SCREEN
        );

    }
}