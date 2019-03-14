package com.blackbeast.booklibrary.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Hire {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date hireDate;
    private Date plannedGiveBackDate;
    private Date realGiveBackDate;

    @OneToOne
    private User hireUser;

    @ManyToOne
    private Book hiredBook;
}
