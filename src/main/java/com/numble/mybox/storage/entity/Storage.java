package com.numble.mybox.storage.entity;

import com.numble.mybox.user.entity.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Table(name = "STORAGE")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Storage {
    @Id @Column(name = "storage_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storageId;

    @Column(name = "tot_storage_size", columnDefinition="Decimal(10,2)", nullable = false)
    @ColumnDefault("30")
    private Long totStorageSize;

    @Column(name = "used_storage_size", columnDefinition="Decimal(10,2)", nullable = false)
    @ColumnDefault("0")
    private Long usedStorageSize;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public Storage(Long totStorageSize, Long usedStorageSize) {
        this.totStorageSize = totStorageSize;
        this.usedStorageSize = usedStorageSize;
    }
}
