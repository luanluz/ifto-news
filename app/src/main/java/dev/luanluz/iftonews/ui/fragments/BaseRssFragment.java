package dev.luanluz.iftonews.ui.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import dev.luanluz.iftonews.R;
import dev.luanluz.iftonews.model.RssItem;
import dev.luanluz.iftonews.network.RssReader;
import dev.luanluz.iftonews.ui.MainActivity;
import dev.luanluz.iftonews.ui.adapters.RssCardAdapter;

public abstract class BaseRssFragment extends Fragment {
    protected abstract int getLayoutId();
    protected abstract String geRssURL();
    public abstract Context getContext();

    @Override
    public View
    onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState
    ) {
        View view = inflater.inflate(getLayoutId(), container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        RssCardAdapter adapter = new RssCardAdapter(getActivity(), new ArrayList<>());
        recyclerView.setAdapter(adapter);

        RssReader rssReader = new RssReader();
        String rssUrl = geRssURL();

        rssReader.readRss(rssUrl, new RssReader.OnRssReadListener() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onSuccess(List<RssItem> items) {
                adapter.setRssItems(items);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(String errorMessage) {
                Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
