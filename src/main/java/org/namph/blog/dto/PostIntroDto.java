package org.namph.blog.dto;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

/**
 * author namph
 * p.meta_title, p.summary, p.published, p.published_at dto
 */
public class PostIntroDto {
    private int id;
    private String summary;
    private String [] tagName;
    private String lastName;
    private String firstName;
    private String publishedAt;
    private String title;
    private String image_intro;

    private static final String CONCAT_CHAR = "&";

    public PostIntroDto(int id, String summary,
                        String lastName, String firstName,
                        String publishedAt, String title, String tags,
                        String image_intro) {
        this.id = id;
        this.summary = summary;
        this.lastName = lastName;
        this.firstName = firstName;
        this.publishedAt = publishedAt;
        this.title = title;
        this.tagName = tags.split(CONCAT_CHAR);
        this.image_intro = image_intro;
    }

    public String getLastName() {
        return lastName;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSummary() {
        return summary;
    }

    public static String getConcatChar() {
        return CONCAT_CHAR;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public String[] getTagName() {
        return tagName;
    }

    public String getImage_intro() {
        return image_intro;
    }
}
