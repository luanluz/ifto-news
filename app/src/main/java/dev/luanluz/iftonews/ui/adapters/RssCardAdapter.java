package dev.luanluz.iftonews.ui.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import dev.luanluz.iftonews.R;
import dev.luanluz.iftonews.model.RssItem;

public class RssCardAdapter extends RecyclerView.Adapter<RssCardAdapter.viewHolder> {
    private List<RssItem> rssItems;

    public RssCardAdapter(List<RssItem> rssItems) {
        this.rssItems = rssItems;
    }

    public void
    setRssItems(List<RssItem> rssItems) {
        this.rssItems = rssItems;
    }

    public static class viewHolder extends RecyclerView.ViewHolder {
        public TextView rssTitle;
        public TextView rssDescription;
        public TextView rssPubDate;

        public viewHolder(View itemView) {
            super(itemView);

            rssTitle = itemView.findViewById(R.id.rssTitle);
            rssDescription = itemView.findViewById(R.id.rssDescription);
            rssPubDate = itemView.findViewById(R.id.rssPubDate);
        }
    }

    @NonNull
    @Override
    public RssCardAdapter.viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_rss_card, parent, false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(viewHolder holder, @SuppressLint("RecyclerView") int position) {
        RssItem rssItem = rssItems.get(position);

        holder.rssTitle.setText(rssItem.getTitle());
        holder.rssDescription.setText(rssItem.getDescription());
        holder.rssPubDate.setText(rssItem.getPubDateInRelativeTime());

        holder.itemView.setOnClickListener(view -> Toast.makeText(view.getContext(), rssItem.getTitle(), Toast.LENGTH_SHORT).show());
    }

    @Override
    public int getItemCount() {
        return rssItems.size();
    }
}
