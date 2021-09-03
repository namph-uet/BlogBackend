package org.namph.blog.entity;

import javax.persistence.*;

@Entity
@Table(name = "post_tag")
public class PostTag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "postId")
    private int postId;

    @Column(name = "tagId")
    private int tagId;
}
