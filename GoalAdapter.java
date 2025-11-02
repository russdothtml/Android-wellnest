package com.example.wellnestlayoutjournal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.List;


public class GoalAdapter extends RecyclerView.Adapter<GoalAdapter.GoalViewHolder> {


    private List<Goal> goalList;


    // Constructor
    public GoalAdapter(List<Goal> goalList) {
        this.goalList = goalList;
    }


    @NonNull
    @Override
    public GoalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item_goal, parent, false);
        return new GoalViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull GoalViewHolder holder, int position) {
        Goal goal = goalList.get(position);


        holder.tvUsername.setText(goal.getUsername());
        holder.tvGoal.setText(goal.getGoalText());


        // Show image if available
        if (goal.getImageResId() != 0) {
            holder.ivGoalImage.setVisibility(View.VISIBLE);
            holder.ivGoalImage.setImageResource(goal.getImageResId());
        } else {
            holder.ivGoalImage.setVisibility(View.GONE);
        }


        // Example Like button click
        holder.btnLike.setOnClickListener(v -> {
            holder.btnLike.setText("Liked");
        });


        // Example Comment button click
        holder.btnComment.setOnClickListener(v -> {
            holder.btnComment.setText("Commented");
        });
    }


    @Override
    public int getItemCount() {
        return goalList.size();
    }


    // ViewHolder
    public static class GoalViewHolder extends RecyclerView.ViewHolder {
        TextView tvUsername, tvGoal;
        ImageView ivGoalImage;
        Button btnLike, btnComment;


        public GoalViewHolder(@NonNull View itemView) {
            super(itemView);
            tvUsername = itemView.findViewById(R.id.tvUsername);
            tvGoal = itemView.findViewById(R.id.tvGoal);
            ivGoalImage = itemView.findViewById(R.id.ivGoalImage);
            btnLike = itemView.findViewById(R.id.btnLike);
            btnComment = itemView.findViewById(R.id.btnComment);
        }
    }
}

