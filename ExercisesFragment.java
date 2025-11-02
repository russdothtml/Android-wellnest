package com.example.wellnestlayoutjournal;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class ExercisesFragment extends Fragment implements View.OnClickListener {

    CardView cardView_joggingcard;
    CardView cardView_yogacard;
    CardView cardView_breathingexercisescard;
    CardView cardView_meditationcard;
    CardView cardView_bodyweightsquatscard;

    public ExercisesFragment() {
        // required empty constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the same layout you used before
        return inflater.inflate(R.layout.activity_exercises, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // IMPORTANT: findViewById from the fragment view, not from an Activity
        cardView_joggingcard = view.findViewById(R.id.jogging_card);
        cardView_yogacard = view.findViewById(R.id.yoga_card);
        cardView_breathingexercisescard = view.findViewById(R.id.breathing_exercises_card);
        cardView_meditationcard = view.findViewById(R.id.meditation_card);
        cardView_bodyweightsquatscard = view.findViewById(R.id.bodyweight_squats_card);

        // Attach listeners
        cardView_joggingcard.setOnClickListener(this);
        cardView_yogacard.setOnClickListener(this);
        cardView_breathingexercisescard.setOnClickListener(this);
        cardView_meditationcard.setOnClickListener(this);
        cardView_bodyweightsquatscard.setOnClickListener(this);

        // Back button in the exercises header (if you'd like it to return to MainActivity)
        // Note: If this fragment is inside MainActivity already, tapping back_button could
        // pop the fragment or do nothing. If you want to go to MainActivity explicitly:
        View backBtn = view.findViewById(R.id.back_button);
        if (backBtn != null) {
            backBtn.setOnClickListener(v -> {
                // If you want to go back to MainActivity's home fragment:
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container, new HomeFragment())
                        .commit();
            });
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        Intent intent = null;

        if (id == R.id.jogging_card) {
            intent = new Intent(requireContext(), Joggingtype.class);
        } else if (id == R.id.yoga_card) {
            intent = new Intent(requireContext(), Yogatype.class);
        } else if (id == R.id.breathing_exercises_card) {
            intent = new Intent(requireContext(), breathingexercisestype.class);
        } else if (id == R.id.meditation_card) {
            intent = new Intent(requireContext(), meditationtype.class);
        } else if (id == R.id.bodyweight_squats_card) {
            intent = new Intent(requireContext(), bodyweightsquatstype.class);
        }

        if (intent != null) {
            startActivity(intent);
        }
    }
}
