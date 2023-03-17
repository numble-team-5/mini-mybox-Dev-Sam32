package com.numble.mybox.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.numble.mybox.folder.entity.Folder;
import com.numble.mybox.storage.entity.Storage;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity @Table(name = "USER")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id @Column(name = "user_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "user_name", nullable = false, length = 50, unique = true)
    private String username;

    @JsonIgnore
    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Folder> folders = new ArrayList<>();

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private Storage storage;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void addFolder(Folder folder) {
        folders.add(folder);
    }
}
