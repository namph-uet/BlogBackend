package org.namph.blog.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="`user`")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "email")
    private String email;

    @Column(name = "password_hash")
    private String passwordHash;

    @Column(name = "registered_at")
    private LocalDateTime registeredAt;

    @Column(name = "last_login")
    private LocalDateTime lastLogin;

    @Column(name = "intro")
    private String intro;

    @Column(name = "profile")
    private String profile;

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFirsName(String firstName) {
        this.firstName = firstName;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public void setLastLogin(LocalDateTime lastLogin) {
        this.lastLogin = lastLogin;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public void setRegisteredAt(LocalDateTime registeredAt) {
        this.registeredAt = registeredAt;
    }
}
