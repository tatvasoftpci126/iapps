package com.tatva.iapps.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Entity class for EpaperRequest.
 */

@Entity
@Table(name = "epaper")
@Data
public class Epaper {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String newspaperName;

    @Column
    private Long height;

    @Column
    private Long width;

    @Column
    private Long dpi;

    @Column
    private LocalDateTime uploadDateTime;

    @Column
    private String fileName;
}
