package org.code4everything.efo.stand.dao.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.code4everything.boot.base.bean.BaseDomain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author pantao
 * @since 2019-04-17
 */
@Data
@ToString
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "efo_file", indexes = {@Index(name = "access_url", columnList = "accessUrl"), @Index(name = "user_id",
        columnList = "userId")})
public class FileDO implements BaseDomain {

    private static final long serialVersionUID = 5947621674068025981L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(columnDefinition = "varchar(256)", nullable = false)
    private String localPath;

    @Column(columnDefinition = "varchar(64)", nullable = false, unique = true)
    private String accessUrl;

    @Column(nullable = false)
    private Long size;

    @Column(columnDefinition = "varchar(256)")
    private String description;

    @Column(nullable = false)
    private Long categoryId;

    @Column(columnDefinition = "datetime default current_timestamp")
    private LocalDateTime createTime;

    @Override
    public Serializable primaryKey() {
        return id;
    }
}
