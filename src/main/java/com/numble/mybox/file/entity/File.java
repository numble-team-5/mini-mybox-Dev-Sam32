package com.numble.mybox.file.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.numble.mybox.folder.entity.Folder;
import com.numble.mybox.user.entity.User;
import lombok.*;

import javax.persistence.*;

@Entity @Table(name = "FILE")
@Getter @Setter
@NoArgsConstructor
public class File {
    @JsonIgnore
    @Id
    @Column(name = "file_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fileId;

    @Column(name = "file_name", nullable = false, length = 50, unique = true)
    private String fileName;

    @Column(name = "file_size", nullable = false)
    private Long fileSize;


    @Column(name = "deleted", nullable = false)
    private boolean deleted;

    @ManyToOne
    @JoinColumn(name = "folder_id")
    private Folder folder;

    public void addFolder(Folder folder) {
        this.folder = folder;
    }

    public File(String fileName, Long fileSize) {
        this.fileName = fileName;
        this.fileSize = fileSize;
    }
}
