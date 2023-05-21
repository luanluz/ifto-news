package dev.luanluz.iftonews.network;

import android.annotation.SuppressLint;
import android.os.AsyncTask;

import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import dev.luanluz.iftonews.model.RssItem;

public class RssReader {
    public interface OnRssReadListener {
        void onSuccess(List<RssItem> rssItems);
        void onFailure(String errorMessage);
    }

    @SuppressLint("StaticFieldLeak")
    public void readRss(String rssUrl, OnRssReadListener listener) {
        new AsyncTask<Void, Void, List<RssItem>>() {
            @Override
            protected List<RssItem> doInBackground(Void... voids) {
                try {
                    URL url = new URL(rssUrl);
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    SyndFeedInput input = new SyndFeedInput();
                    SyndFeed feed = input.build(new XmlReader(httpURLConnection));

                    List<RssItem> rssItems = new ArrayList<>();
                    for (SyndEntry entry : feed.getEntries()) {
                        RssItem item = new RssItem();
                        item.setTitle(entry.getTitle());
                        item.setLink(entry.getLink());
                        item.setDescription(entry.getDescription().getValue());
                        item.setPubDate(entry.getPublishedDate());
                        rssItems.add(item);
                    }

                    return rssItems;
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }

            @Override
            protected void onPostExecute(List<RssItem> rssItems) {
                if (rssItems != null) {
                    listener.onSuccess(rssItems);
                } else {
                    listener.onFailure("Failed to read RSS feed.");
                }
            }
        }.execute();
    }
}
