package com.app.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id

    private String userId;
    private String username;
    private String email;
    private String about;
@Transient
    private List<Rating> ratings= new ArrayList<>();
}
