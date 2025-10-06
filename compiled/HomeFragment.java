package com.example.wellnestlayoutjournal;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {


    private RecyclerView recyclerView;
    private GoalAdapter goalAdapter;
    private List<Goal> goalList;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);


        recyclerView = view.findViewById(R.id.recyclerGoals);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));


        // Dummy data
        goalList = new ArrayList<>();
        goalList.add(new Goal("John Doe", "I'm glad I ran 5k this week!", R.drawable.ic_launcher_foreground));
        goalList.add(new Goal("Jane Smith", "Finished my journal entries before Sunday.", 0));
        goalList.add(new Goal("Alex Kim", "I Meditated for 10 minutes each morning.", R.drawable.ic_launcher_foreground));
        goalList.add(new Goal("Maria Lopez", "Writing my journal daily helps.", 0));
        goalList.add(new Goal("Chris Evans", "Drink 2 liters of water every day.", R.drawable.ic_launcher_foreground));


        goalAdapter = new GoalAdapter(goalList);
        recyclerView.setAdapter(goalAdapter);


        return view;
    }
}
