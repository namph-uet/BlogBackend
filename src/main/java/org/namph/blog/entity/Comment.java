package org.namph.blog.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "post_id")
    private int postId;

    @Column(name = "title")
    private String title;

    @Column(name = "published")
    private boolean published;

    @Column(name = "create_at")
    private LocalDateTime createAt;

    @Column(name = "published_at")
    private LocalDateTime publishedAt;

    @Column(name = "content")
    private String content;
}
