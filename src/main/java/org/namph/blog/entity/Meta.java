package org.namph.blog.entity;

import javax.persistence.*;

@Entity
@Table(name = "meta")
public class Meta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(name = "postId")
    private String postId;

    @Column(name = "content")
    private String content;

    @Column(name = "key")
    private String key;
}