package com.mostafanafie.quiz;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {

    // Initialize the score variable
    int score = 0;
    // Initialize the ViewPager
    private CustomViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Remove title bar
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);

        // Setup the ViewPager
        mViewPager = findViewById(R.id.container);
        setupViewPager(mViewPager);

        Button playAgainButton = findViewById(R.id.button_play_again);
        playAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hideScore();
            }
        });
    }

    private void setupViewPager(ViewPager viewPager) {
        // Initialize the FragmentStatePagerAdapter
        QuestionsStatePagerAdapter adapter = new QuestionsStatePagerAdapter(getSupportFragmentManager());
        // Add the Fragments to the adapter
        adapter.addFragment(new QuestionOneFragment());
        adapter.addFragment(new QuestionTwoFragment());
        adapter.addFragment(new QuestionThreeFragment());
        adapter.addFragment(new QuestionFourFragment());
        // Attach the adapter to the ViewPager
        viewPager.setAdapter(adapter);
    }

    public void setViewPager(int fragmentNumber) {
        mViewPager.setCurrentItem(fragmentNumber);
        // Update progress
        TextView progressTextView = findViewById(R.id.textView_progress);
        progressTextView.setText("Question " + (fragmentNumber + 1) + " / 4");
    }

    public void showScore() {
        TextView scoreTextView = findViewById(R.id.textView_score);
        Button playAgainButton = findViewById(R.id.button_play_again);
        TextView progressTextView = findViewById(R.id.textView_progress);

        progressTextView.setText("Check your score");

        scoreTextView.setText("You scored " + score + " out of 4");

        // Show the score and hide the questions
        playAgainButton.setVisibility(View.VISIBLE);
        scoreTextView.setVisibility(View.VISIBLE);
        mViewPager.setVisibility(View.INVISIBLE);

        Toast.makeText(this, "You scored " + score + " out of 4", Toast.LENGTH_LONG).show();

    }

    private void hideScore() {
        TextView scoreTextView = findViewById(R.id.textView_score);
        Button playAgainButton = findViewById(R.id.button_play_again);

        // Hide the score and show the questions
        playAgainButton.setVisibility(View.INVISIBLE);
        scoreTextView.setVisibility(View.INVISIBLE);
        mViewPager.setVisibility(View.VISIBLE);

        // Reset the Score
        score = 0;

        // Navigate to next question
        setViewPager(0);

    }
}
