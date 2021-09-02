package org.namph.blog.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PostRequest {
    private int authorId;
    @NotNull
    @NotBlank
    private String title;
    private String metaTitle;
    private String slug;
    private String summary;
    private boolean published;

    @NotNull
    @NotBlank
    private String content;

    public int getAuthorId() {
        return authorId;
    }

    public String getContent() {
        return content;
    }

    public String getMetaTitle() {
        return metaTitle;
    }

    public String getSlug() {
        return slug;
    }

    public String getSummary() {
        return summary;
    }

    public String getTitle() {
        return title;
    }
}
