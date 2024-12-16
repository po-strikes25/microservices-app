package com.business.user_service.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "micro_user")
public class User
{
    @Id
    /*  Below does not work if we have @Column:
        @GeneratedValue(strategy = GenerationType.IDENTITY) */
    @Column(name = "ID")
    private String  userId;

    @Column(name = "NAME", length = 30)
    private String  userName;

    @Column(name = "EMAIL")
    private String  email;

    @Column(name = "ABOUT")
    private String  about;

    @Transient
    private List<Rating> ratings = new ArrayList<>();
}
