/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WhatsNext_Sprint3;

import java.io.*;

/**
 *
 * @author mattb
 */
public class PeristentDataCollection implements Serializable{
    
    private UserList theUserList;
    private MovieList theMovieList;
    private BookList theBookList;
    
    // All other persistent data will go below here
    
    public PeristentDataCollection(){
        if(theUserList == null){
            theUserList = new UserList();
        }
        if(theMovieList == null){
            theMovieList = new MovieList();
        }
        if(theBookList == null){
            theBookList = new BookList();
        }
        
    }
    
    public UserList getuserList(){
        return theUserList;
    }
    public MovieList getMovieList(){
        return theMovieList;
    }
    
}
