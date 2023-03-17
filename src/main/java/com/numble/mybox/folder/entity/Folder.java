package com.numble.mybox.folder.entity;

import com.numble.mybox.file.entity.File;
import com.numble.mybox.user.entity.User;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity @Table(name = "FOLDER")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Folder {
    @Id @Column(name = "folder_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long folderId;

    @Column(name = "folder_name", nullable = false, length = 50, unique = true)
    private String folderName;

    @Column(name = "deleted", nullable = false)
    private boolean deleted;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "folder")
//    @JoinColumn(name = "file_id")
    private List<File> files = new ArrayList<>();

    public Folder(String folderName) {
        this.folderName = folderName;
    }

    public void addUser(User user) {
        this.user = user;
    }

    public void addFile(File file) {
        files.add(file);
    }
}
