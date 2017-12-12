package WhatsNext_Sprint3;

import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Laura
 */
public class User implements Serializable{
    
    private String username;
    private String password;
    private QueryHistory bookSearchHistory;
    private QueryHistory movieSearchHistory;
    
    public User(String u, String p) 
    {
        this.username = u;
        this.password = p;
        this.bookSearchHistory = new QueryHistory();
        this.movieSearchHistory = new QueryHistory();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public QueryHistory getBookSearchHistory() {
        return this.bookSearchHistory;
    }
    public QueryHistory getMovieSearchHistory() {
        return this.movieSearchHistory;
    }
}
