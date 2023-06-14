package dev.luanluz.iftonews.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import dev.luanluz.iftonews.R;

public class SystemsGridAdapter extends BaseAdapter {
    private final Context context;
    private final String[][] data;

    public SystemsGridAdapter(Context context, String[][] data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        return data[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null)
            view = LayoutInflater.from(context).inflate(R.layout.adapter_systems_card, parent, false);

        int rowHigh = 400;
        int systemPosition = 0;
        int categoryPosition = 1;

        TextView textViewSystem = view.findViewById(R.id.textViewSystem);
        TextView textViewCategory = view.findViewById(R.id.textViewCategory);

        textViewSystem.setText(data[position][systemPosition]);
        textViewCategory.setText(data[position][categoryPosition]);

        view.setLayoutParams(new GridView.LayoutParams(GridView.AUTO_FIT, rowHigh));

        return view;
    }
}
