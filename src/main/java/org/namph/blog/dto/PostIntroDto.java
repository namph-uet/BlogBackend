package org.namph.blog.dto;

import java.time.LocalDateTime;

/**
 * author namph
 * p.meta_title, p.summary, p.published, p.published_at dto
 */
public class PostIntroDto {
    private String metaTitle;
    private String summary;
    private boolean published;
    private LocalDateTime published_at;
}
