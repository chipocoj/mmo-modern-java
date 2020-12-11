package com.magenic.mmomodernjava.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Data
@Table(name = "questions")
public class Question {
    @Id
    @GeneratedValue(generator = "question_generator")
    @SequenceGenerator(
            name = "question_generator",
            sequenceName = "question_sequence",
            initialValue = 1
    )
    private Long id;

    @NotBlank
    @Size(min = 3, max = 100)
    private String title;

    private String description;
}
