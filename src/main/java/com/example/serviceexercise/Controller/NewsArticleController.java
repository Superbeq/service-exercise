package com.example.serviceexercise.Controller;


import com.example.serviceexercise.ApiResponse.ApiResponse;
import com.example.serviceexercise.Model.NewsArticle;
import com.example.serviceexercise.Service.NewsArticleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("api/v1/newsarticle")
@RequiredArgsConstructor
public class NewsArticleController {


    private final NewsArticleService newsarticleservice;



    @GetMapping("/get")
    public ResponseEntity getNewsArtcles(){


        ArrayList<NewsArticle> newsArticles = newsarticleservice.getNewsArticles();

        return ResponseEntity.status(200).body(newsArticles);
    }



    @PostMapping("/post")
    public ResponseEntity postNewsArticle(@Valid @RequestBody NewsArticle newsArticle, Errors errors){

        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        newsarticleservice.addNewsArticle(newsArticle);
        return ResponseEntity.status(200).body(new ApiResponse("The News article is posted"));


    }



    @PutMapping("/update/{id}")
    public ResponseEntity updateNewsArticle(@PathVariable int id, @Valid @RequestBody NewsArticle news, Errors errors){
        if(errors.hasErrors()){
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = newsarticleservice.updateNewsArticle(news, id);
        if(isUpdated){
            return ResponseEntity.status(200).body(new ApiResponse("The news article is updated successfully"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Failed to update the news article"));
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteNewsArticle(@PathVariable int id){

        boolean isDeleted = newsarticleservice.deleteNewsArticle(id);

        if(isDeleted){

            return ResponseEntity.status(200).body(new ApiResponse("The news Article has been deleted succesfully"));

        }


        return ResponseEntity.status(400).body(new ApiResponse("Failed to delete the news article"));
    }



    @PutMapping("/publish/{id}")
    public ResponseEntity publishNewsArticle(@PathVariable int id){
        boolean publish = newsarticleservice.publishNewsArticle(id);

        if(publish){

            return ResponseEntity.status(200).body("news Article published successfully !");

        }

        return ResponseEntity.status(404).body("news Article not found !");

    }

    @GetMapping("/get/published")
    public ResponseEntity getPublishedNewsArticle(){

        ArrayList<NewsArticle> published = newsarticleservice.getAllPublishedNewsArticles();

        return ResponseEntity.status(200).body(published);

    }


    @GetMapping("/bycategory/{category}")
    public ResponseEntity getNewsArticleByCategory(@PathVariable String category){

        ArrayList<NewsArticle> byCategory = newsarticleservice.getNewsArticlesByCategory(category);

        return ResponseEntity.status(200).body(byCategory);

    }


}
