package org.namph.blog.entity;

import javax.persistence.*;

@Entity
@Table(name = "post_tag")
public class PostTag {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @Column(name = "postId")
    private String postId;

    @Column(name = "tagId")
    private String tagId;
}
