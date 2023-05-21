package dev.luanluz.iftonews.ui.fragments;

import android.content.Context;

import dev.luanluz.iftonews.R;

public class NoticesRssFragment extends BaseRssFragment {
    private final Context context;
    public NoticesRssFragment(Context context) {
        this.context = context;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_notices;
    }

    @Override
    public Context getContext() {
        return context;
    }

    @Override
    protected String geRssURL() {
        return "http://www.ifto.edu.br/editais/em-aberto/RSS";
    }
}