package org.namph.blog.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "authorId")
    private int authorId;

    @Column(name = "title")
    private String title;

    @Column(name = "metaTitle")
    private String metaTitle;

    @Column(name = "slug")
    private String slug;

    @Column(name = "summary")
    private String summary;

    @Column(name = "published")
    private boolean published;

    @Column(name = "createAt")
    private LocalDateTime createAt;

    @Column(name = "updateAt")
    private LocalDateTime updateAt;

    @Column(name = "publishedAt")
    private LocalDateTime publishedAt;

    @Column(name = "content")
    private String content;

    @ManyToMany
    Set<Category> categories;

    @OneToMany
    Set<PostComment> comments;

    @ManyToMany
    Set<Tag> tags;

    @OneToMany
    Set<PostMeta> metas;
}
