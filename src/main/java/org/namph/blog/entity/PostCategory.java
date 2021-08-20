package org.namph.blog.entity;

import javax.persistence.*;

@Entity
@Table(name = "post_category")
public class PostCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String postId;
    private String categoryId;
}
