package com.mostafanafie.quiz;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class QuestionThreeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question_three, container, false);

        final EditText answerEditText = view.findViewById(R.id.edittext_answer);

        Button nextButton = view.findViewById(R.id.button_next);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Update Score in MainActivity
                if (answerEditText.getText().toString().equals("Football")) {
                    ((MainActivity) getActivity()).score++;
                }
                // Navigate to next question
                ((MainActivity) getActivity()).setViewPager(3);
            }
        });
        return view;
    }

}

