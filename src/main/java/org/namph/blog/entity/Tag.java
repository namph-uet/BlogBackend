package org.namph.blog.entity;

import javax.persistence.*;

@Entity
@Table(name = "tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "metaTitle")
    private String metaTitle;

    @Column(name = "slug")
    private String slug;

    @Column(name = "content")
    private String content;
}
