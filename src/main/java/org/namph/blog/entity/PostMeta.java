package org.namph.blog.entity;

import javax.persistence.*;

@Entity
@Table(name = "post_comment")
public class PostMeta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "postId")
    private int postId;

    @Column(name = "key")
    private String key;

    @Column(name = "content")
    private String content;
}
