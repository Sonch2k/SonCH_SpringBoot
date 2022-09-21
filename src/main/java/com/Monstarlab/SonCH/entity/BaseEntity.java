package com.Monstarlab.SonCH.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass

public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    protected Long id;

//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "created_date")
//    protected Date createdDate;
//
//    @Column(name = "created_by")
//    protected String createdBy;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "updated_date")
//    protected Date updatedDate;
//
//    @Column(name = "updated_by")
//    protected String updatedBy;

}
