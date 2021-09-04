package org.namph.blog;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@SpringBootApplication
@EntityScan()
public class BlogApplication {
    final static Logger logger = Logger.getLogger(BlogApplication.class);
    public static void main(String[] args) {
        logger.info("test log");
        SpringApplication.run(BlogApplication.class, args);
    }
}
