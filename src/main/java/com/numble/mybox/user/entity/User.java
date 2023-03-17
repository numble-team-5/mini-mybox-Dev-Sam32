package com.numble.mybox.user.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.numble.mybox.folder.entity.Folder;
import com.numble.mybox.storage.entity.Storage;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity @Table(name = "USER")
@Getter @Setter
@NoArgsConstructor
public class User {
    @JsonIgnore
    @Id @Column(name = "user_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "user_name", nullable = false, length = 50, unique = true)
    private String username;

    @JsonIgnore
    @Column(name = "password", nullable = false, length = 100)
    private String password;

    @OneToMany(mappedBy = "user")
//    @JoinColumn(name = "folder_id")
    private List<Folder> folders = new ArrayList<>();

    public void addFolder(Folder folder) {
        folders.add(folder);
    }

    @OneToOne(mappedBy = "user")
//    @JoinColumn(name = "storage_id")
    private Storage storage;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
