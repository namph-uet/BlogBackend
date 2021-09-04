package org.namph.blog.entity;

import javax.persistence.*;

@Entity
@Table(name = "meta")
public class Meta {
    public static final String IMAGE_KEY = "IMAGE";
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "post_id")
    private int postId;

    @Column(name = "content")
    private String content;

    @Column(name = "key")
    private String key;

    public void setId(int id) {
        this.id = id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }
}
