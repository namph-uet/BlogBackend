package org.namph.blog.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "post_comment")
public class PostComment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "postId")
    private int postId;

    @Column(name = "title")
    private String title;

    @Column(name = "published")
    private boolean published;

    @Column(name = "createAt")
    private LocalDateTime createAt;

    @Column(name = "publishedAt")
    private LocalDateTime publishedAt;

    @Column(name = "Content")
    private String Content;
}
