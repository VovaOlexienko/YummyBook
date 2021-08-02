package com.yummybook.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "user_roles")
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ToString.Include
    @EqualsAndHashCode.Include
    @NotBlank
    private String username;

    @ToString.Include
    @EqualsAndHashCode.Include
    @NotBlank
    private String role = "ROLE_USER";

    public UserRole(String username) {
        this.username = username;
    }

    public UserRole(String username, String role) {
        this.username = username;
        this.role = role;
    }
}