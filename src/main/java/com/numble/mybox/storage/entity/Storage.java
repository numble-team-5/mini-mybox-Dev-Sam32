package com.numble.mybox.storage.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.numble.mybox.user.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Table(name = "STORAGE")
@Getter @Setter
@NoArgsConstructor
public class Storage {
    @JsonIgnore
    @Id
    @Column(name = "storage_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long storageId;

    @Column(name = "tot_storage_size", columnDefinition="Decimal(10,2)", nullable = false)
    @ColumnDefault("30")
    private Long totStorageSize;

    @Column(name = "used_storage_size", columnDefinition="Decimal(10,2)", nullable = false)
    @ColumnDefault("0")
    private Long usedStorageSize;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
