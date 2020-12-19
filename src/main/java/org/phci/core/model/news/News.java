package org.phci.core.model.news;

import java.io.Serializable;

public class News implements Serializable {
    private String title;
    private String content;
    private String date_issued;
    private String publisher;

    public News() {
    }

    public News(String title, String content, String dateIssued, String publisher) {
        this.title = title;
        this.content = content;
        this.date_issued = dateIssued;
        this.publisher = publisher;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDateIssued() {
        return date_issued;
    }

    public void setDateIssued(String dateIssued) {
        this.date_issued = dateIssued;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}
