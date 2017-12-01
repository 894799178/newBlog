package com.blog.domain;

import java.sql.Date;

public class Content {
    private Integer id ;
    private String title;
    private String content;
    private Date ddate;
    @Override
    public String toString() {
        return "Content{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", dddate='" + ddate + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getDdate() {
        return ddate;
    }

    public void setDdate(Date ddate) {
        this.ddate = ddate;
    }

    public Content() {
    }

    public Content(Integer id, String title, String content, Date ddate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.ddate = ddate;
    }
}
