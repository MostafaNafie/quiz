package com.mostafanafie.quiz;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class QuestionTwoFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question_two, container, false);

        final CheckBox africaCheckBox = view.findViewById(R.id.checkBox_africa);
        final CheckBox middleEastCheckBox = view.findViewById(R.id.checkBox_middle_east);
        final CheckBox worldCheckBox = view.findViewById(R.id.checkBox_world);

        Button nextButton = view.findViewById(R.id.button_next);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check the answer to update the score in MainActivity
                if (africaCheckBox.isChecked() && middleEastCheckBox.isChecked() && !worldCheckBox.isChecked()) {
                    ((MainActivity) getActivity()).score++;
                }
                // Navigate to next question
                ((MainActivity) getActivity()).setViewPager(2);
            }
        });
        return view;
    }
}
