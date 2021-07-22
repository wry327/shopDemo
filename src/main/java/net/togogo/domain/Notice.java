package net.togogo.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Notice {

    private int id;
    private String topic;
    private String content;
    private String author;
    private Date createDate;
}
