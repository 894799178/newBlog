package com.blog.domain;

import java.sql.Date;

/**'
 * 该类主要用来存储
 * 用户博客的内容和标题.以及编写改博客的时间
 */
public class Content {
    private Integer id ;
    private String title;
    private String content;
    private String monthday;


    public Content(Integer id, String title, String content, String monthday) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.monthday = monthday;
    }

    public Content() {
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

    public String getMonthday() {
        return monthday;
    }

    public void setMonthday(String monthday) {
        this.monthday = monthday;
    }

    @Override
    public String toString() {
        return "Content{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", monthday='" + monthday + '\'' +
                '}';
    }
}
