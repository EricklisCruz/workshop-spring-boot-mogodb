package com.syudyprojects.demo.domain.entities;

import com.syudyprojects.demo.dto.AuthorDTO;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Document
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private Date date;
    private String title;
    private String body;

    private AuthorDTO author;

    public Post(Date date, String title, String body, AuthorDTO author) {
        this.date = date;
        this.title = title;
        this.body = body;
        this.author = author;
    }
}
