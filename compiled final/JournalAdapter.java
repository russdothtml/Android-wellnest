package com.example.wellnestlayoutjournal;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class JournalAdapter extends RecyclerView.Adapter<JournalAdapter.ViewHolder> {

    private final List<JournalItem> journalList;
    private final Context context;

    public JournalAdapter(List<JournalItem> journalList, Context context) {
        this.journalList = journalList;
        this.context = context;
    }

    @NonNull
    @Override
    public JournalAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_journal_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JournalAdapter.ViewHolder holder, int position) {
        JournalItem item = journalList.get(position);
        holder.journal_title.setText(item.getTitle());
        holder.journal_date.setText(item.getDate());
        holder.journal_mood.setText(item.getMood());

        holder.journal_card.setOnClickListener(v -> {
            Intent intent = new Intent(context, JournalDetailActivity.class);
            intent.putExtra("title", item.getTitle());
            intent.putExtra("content", item.getContent());
            intent.putExtra("date", item.getDate());
            intent.putExtra("mood", item.getMood());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return journalList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView journal_title, journal_date, journal_mood;
        CardView journal_card;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            journal_title = itemView.findViewById(R.id.title_text);
            journal_date = itemView.findViewById(R.id.date_text);
            journal_mood = itemView.findViewById(R.id.mood_text);
            journal_card = itemView.findViewById(R.id.item_journal_card);

        }
    }
}
