package dev.luanluz.iftonews.model;

import android.text.format.DateUtils;

import java.util.Date;

public class RssItem {
    private String title;
    private String link;
    private String description;
    private Date pubDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public String getPubDateInRelativeTime() {
        return DateUtils.getRelativeTimeSpanString(pubDate.getTime()).toString();
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }
}
