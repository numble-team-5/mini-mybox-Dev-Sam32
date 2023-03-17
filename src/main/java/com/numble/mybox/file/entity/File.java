package com.numble.mybox.file.entity;

import com.numble.mybox.folder.entity.Folder;
import lombok.*;

import javax.persistence.*;

@Entity @Table(name = "FILE")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class File {
    @Id @Column(name = "file_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fileId;

    @Column(name = "file_name", nullable = false, length = 50, unique = true)
    private String fileName;

    @Column(name = "file_size", nullable = false)
    private Long fileSize;

    @Column(name = "deleted", nullable = false)
    private boolean deleted;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "folder_id")
    private Folder folder;

    public File(String fileName, Long fileSize) {
        this.fileName = fileName;
        this.fileSize = fileSize;
    }

    public void addFolder(Folder folder) {
        this.folder = folder;
    }
}
