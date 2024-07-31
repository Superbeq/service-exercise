package com.example.serviceexercise.Model;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import java.util.Date;

@Data
@AllArgsConstructor
public class NewsArticle {


    @NotNull
    @Positive(message = "The id should be a positive number")
    private int id;


    @NotEmpty(message = "Cannot be empty")
    @Size(max = 100, message = "The id is no longer than 100 charchters")
    private String title;

    @NotEmpty(message = "Cannot be empty")
    @Size(min = 5, max = 20, message = "The name of the author should be between 5 to 20 letters")
    private String author;

    @NotEmpty(message = "Cannot be empty")
    @Size(min = 200, message = "The content should be more that 200 letters")
    private String content;

    @NotEmpty(message = "Cannot be empty")
    @Pattern(regexp="^(Politics|Sports|Technology)$",message="invalid category")
    private String category;

    @NotEmpty(message = "Cannot be empty")
    @URL(message = "The url format is uncorrect")
    private String imageUrl;


    @AssertFalse(message = "The isPublished should be false initially")
    private boolean isPublished = false;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date publishDate;


}
