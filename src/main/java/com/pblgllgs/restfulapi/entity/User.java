package com.pblgllgs.restfulapi.entity;
/*
 *
 * @author pblgl
 * Created on 18-11-2024
 *
 */

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "USERS_TABLE")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(nullable = false, unique = true)
    private String email;
}
