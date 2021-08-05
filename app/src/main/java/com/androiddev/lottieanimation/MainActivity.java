package com.androiddev.lottieanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.androiddev.lottieanimation.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    LottieAnimationView lottieAnimationView;
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        assignViews();
        
    }

    private void assignViews() {
        lottieAnimationView = findViewById(R.id.lottieAnimationView);
        lottieAnimationView.playAnimation();
        lottieAnimationView.addAnimatorListener(new Animator.AnimatorListener()
        {
            @Override
            public void onAnimationStart(Animator animator)
            {
                //showToast("animation started");
            }

            @Override
            public void onAnimationEnd(Animator animator)
            {
                //lottieAnimationView.playAnimation();
                //showToast("animation staring again");
            }

            @Override
            public void onAnimationCancel(Animator animator)
            {
                //showToast("animation canceled");
            }

            @Override
            public void onAnimationRepeat(Animator animator)
            {
                //showToast("animation is repeating");
            }
        });
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
    public void animate(View v) {
        binding.playAnimationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lottieAnimationView.isAnimating()) {
                    lottieAnimationView.cancelAnimation();//starts from frame 1 -using playAnimation() || starts from the frame where it stopped - resumeAnimation()
                    lottieAnimationView.pauseAnimation();//starts from frame 1 -using playAnimation() || starts from the frame where it stopped - resumeAnimation()
                    //showToast("cancelAnimation is called");
                } else {
                    //lottieAnimationView.playAnimation();
                    lottieAnimationView.resumeAnimation();
                    //showToast("resumeAnimation is called");
                }
            }
        });

    }
    @Override
    protected void onStart() {
        super.onStart();
        lottieAnimationView.setProgress(0f);
        lottieAnimationView.playAnimation();
    }
    @Override
    protected void onStop() {
        super.onStop();
        lottieAnimationView.cancelAnimation();
    }


}