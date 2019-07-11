package com.mostafanafie.quiz;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class QuestionFourFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question_four, container, false);

        final RadioButton gizaRadioButton = view.findViewById(R.id.radioButton_giza);

        Button nextButton = view.findViewById(R.id.button_next);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check the answer to update the score in MainActivity
                if (gizaRadioButton.isChecked()) {
                    ((MainActivity) getActivity()).score++;
                }
                // Show the score
                ((MainActivity) getActivity()).showScore();
            }
        });
        return view;
    }

}
