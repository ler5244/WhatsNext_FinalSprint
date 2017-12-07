/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WhatsNext_Sprint3;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author mattb
 */
public class TheSearchEngine {
    
    private ArrayList<Movie> returnedMovieList;
    private ArrayList<Book> returnedBookList;
    private ArrayList<Integer> scores;
    private ArrayList<String> posFilters;
    private ArrayList<String> negFilters;
    private ArrayList<String> genres;
    
    
    public ArrayList<Movie> movieSearch (Query q)
    {
        returnedMovieList = new ArrayList<Movie>();
        if(q.getGenres()!=null)
        {
            genres = q.getGenres();
        }
        if(q.getPositiveFilters()!=null)
        {
            posFilters = q.getPositiveFilters();
        }
        if(q.getNegativeFilters()!=null)
        {
            negFilters = q.getNegativeFilters();
        }
        
        MovieList movies = new MovieList();
               
        
        for(Movie m:movies.getMovieList())
        {
            
            // Searches Genre
            int score = 0;
            if(genres != null)
            {
                for(String s:genres)
                {
                    if(m.getGenre().equalsIgnoreCase(s))
                    {
                        score += 20;
                    }

                }
            }
            ArrayList<String> desc = new ArrayList<>(Arrays.asList(m.getMovieDescription().split(" ")));
            ArrayList<String> title = new ArrayList<>(Arrays.asList(m.getMovieTitle().split(" ")));
            
            
            if(negFilters != null)
            {
                               
                for (String s:negFilters)
                {
                    for(String titleWord:title)
                    {
                        if (titleWord.equalsIgnoreCase(s))
                        {
                            score -= 30;
                        }
                    }
                }
                
                
                for (String s:negFilters)
                {
                    for(String descriptionWord : desc)
                    {
                        if (descriptionWord.equalsIgnoreCase(s))
                        {
                            score -= 2;
                        }
                    }
                }
                
            }
            

            // Break up title into words and compare positive filters
            for (String s:posFilters)
            {
                System.out.println("Search: " + s);
                for(String titleWord : title)
                {
                    System.out.println("Title: " + titleWord);
                    if (titleWord.equalsIgnoreCase(s))
                    {
                        score += 30;
                    }
                }
                
                for(String descriptionWord : desc)
                {
                    if (descriptionWord.equalsIgnoreCase(s))
                    {
                        score += 2;
                    }
                }
                
                
                
            }
            if(score > 0)
            {
                returnedMovieList.add(m);
            }
        }
        return returnedMovieList;
    }
    
    
    public ArrayList<Book> bookSearch (Query q)
    {
        returnedBookList = new ArrayList<Book>();
        if(q.getGenres()!=null)
        {
            genres = q.getGenres();
        }
        if(q.getPositiveFilters()!=null)
        {
            posFilters = q.getPositiveFilters();
        }
        if(q.getNegativeFilters()!=null)
        {
            negFilters = q.getNegativeFilters();
        }
        
        BookList books = new BookList();
               
        
        for(Book b:books.getBookList())
        {
            
            // Searches Genre
            int score = 0;
            if(genres != null)
            {
                for(String s:genres)
                {
                    if(b.getGenre().equalsIgnoreCase(s))
                    {
                        score += 20;
                    }

                }
            }
            ArrayList<String> desc = new ArrayList<>(Arrays.asList(b.getBookDescription().split(" ")));
            ArrayList<String> title = new ArrayList<>(Arrays.asList(b.getBookTitle().split(" ")));
            
            
            if(negFilters != null)
            {
                               
                for (String s:negFilters)
                {
                    for(String titleWord:title)
                    {
                        if (titleWord.equalsIgnoreCase(s))
                        {
                            score -= 30;
                        }
                    }
                }
                
                
                for (String s:negFilters)
                {
                    for(String descriptionWord : desc)
                    {
                        if (descriptionWord.equalsIgnoreCase(s))
                        {
                            score -= 2;
                        }
                    }
                }
                
            }
            

            // Break up title into words and compare positive filters
            for (String s:posFilters)
            {
                System.out.println("Search: " + s);
                for(String titleWord : title)
                {
                    System.out.println("Title: " + titleWord);
                    if (titleWord.equalsIgnoreCase(s))
                    {
                        score += 30;
                    }
                }
                
                for(String descriptionWord : desc)
                {
                    if (descriptionWord.equalsIgnoreCase(s))
                    {
                        score += 2;
                    }
                }
                
                
                
            }
            if(score > 0)
            {
                returnedBookList.add(b);
            }
        }
        return returnedBookList;
    }
}
