package org.namph.blog.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="`User`")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "firsName")
    private String firsName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "email")
    private String email;

    @Column(name = "passwordHash")
    private String passwordHash;

    @Column(name = "registeredAt")
    private LocalDateTime registeredAt;

    @Column(name = "lastLogin")
    private LocalDateTime lastLogin;

    @Column(name = "intro")
    private String intro;

    @Column(name = "profile")
    private String profile;
}
