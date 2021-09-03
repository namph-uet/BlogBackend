package org.namph.blog.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CreateUserRequest {

    @NotNull
    @NotBlank
    private String firsName;
    @NotNull
    @NotBlank
    private String lastName;
    private String mobile;
    @NotNull
    @NotBlank
    private String email;
    @NotNull
    @NotBlank
    private String password;
    private String intro;
    private String profile;


    public String getEmail() {
        return email;
    }

    public String getFirsName() {
        return firsName;
    }

    public String getIntro() {
        return intro;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMobile() {
        return mobile;
    }

    public String getPassword() {
        return password;
    }

    public String getProfile() {
        return profile;
    }
}
