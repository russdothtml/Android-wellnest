package com.example.wellnestlayoutjournal;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class JournalAdapter extends RecyclerView.Adapter<JournalAdapter.ViewHolder> {

    private List<JournalEntry> journals;
    private final Context context;

    public JournalAdapter(List<JournalEntry> journals, Context context) {
        this.journals = journals;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_journal_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        JournalEntry entry = journals.get(position);
        holder.date.setText(entry.getDate());
        holder.title.setText(entry.getTitle());
        holder.mood.setText("Mood: " + entry.getMood());
        holder.card.setCardBackgroundColor(entry.getColor());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, JournalDetailActivity.class);
            intent.putExtra("title", entry.getTitle());
            intent.putExtra("date", entry.getDate());
            intent.putExtra("mood", entry.getMood());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return journals.size();
    }

    public void setJournals(List<JournalEntry> newJournals) {
        this.journals = newJournals;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView date, title, mood;
        CardView card;

        public ViewHolder(View view) {
            super(view);
            date = view.findViewById(R.id.journalDate);
            title = view.findViewById(R.id.journalTitle);
            mood = view.findViewById(R.id.journalMood);
            card = view.findViewById(R.id.journalCard);
        }
    }
}
