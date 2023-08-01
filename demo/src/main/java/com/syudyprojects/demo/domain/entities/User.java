package com.syudyprojects.demo.domain.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Document
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String name;
    private String email;

    @Setter(AccessLevel.NONE)
    @DBRef(lazy = true)
    private List<Post> posts = new ArrayList<>();

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
