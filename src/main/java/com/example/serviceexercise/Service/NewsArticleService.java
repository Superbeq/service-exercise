package com.example.serviceexercise.Service;

import com.example.serviceexercise.Model.NewsArticle;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.ArrayList;

@Service
public class NewsArticleService {






    ArrayList<NewsArticle> newsArticles = new ArrayList<>();


    public ArrayList<NewsArticle> getNewsArticles(){


        return newsArticles;


    }


    public void addNewsArticle(NewsArticle newsArticle){

        newsArticles.add(newsArticle);

    }





    public boolean updateNewsArticle(NewsArticle news, int id){

        for (int i = 0; i < newsArticles.size(); i++) {

            if(newsArticles.get(i).getId() == id){

                newsArticles.set(i, news);

                return true;

            }
        }

        return false;

    }


    public boolean deleteNewsArticle(int id){

        for (int i = 0; i < newsArticles.size(); i++) {

            if(newsArticles.get(i).getId() == id){

                newsArticles.remove(i);

                return true;

            }
        }

        return false;

    }


    public boolean publishNewsArticle(int id) {
        for (int i = 0; i < newsArticles.size(); i++) {
            if(newsArticles.get(i).getId()==id){
                newsArticles.get(i).setPublished(true);
                return true;
            }
        }
        return false;
    }

    public ArrayList<NewsArticle> getAllPublishedNewsArticles() {

        ArrayList<NewsArticle> published = new ArrayList<>();

        for (int i = 0; i < newsArticles.size(); i++) {

            if(newsArticles.get(i).isPublished()){

                published.add(newsArticles.get(i));

            }
        }
        return published;
    }

    public ArrayList<NewsArticle> getNewsArticlesByCategory(String category) {
        ArrayList<NewsArticle> byCategory = new ArrayList<>();
        for (int i = 0; i < newsArticles.size(); i++) {
            if(newsArticles.get(i).getCategory().equalsIgnoreCase(category)){
                byCategory.add(newsArticles.get(i));
            }
        }
        return byCategory;
    }

    }


