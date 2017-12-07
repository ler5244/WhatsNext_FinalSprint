/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WhatsNext_Sprint3;

import java.util.ArrayList;

/**
 *
 * @author mattb
 */
public class Query {

       
    private ArrayList<String> genres; 
    private ArrayList<String> positiveFilters; 
    private ArrayList<String> negativeFilters; 
    
    public Query(ArrayList<String> g, ArrayList<String> pos, ArrayList<String> neg)
    {
        genres = g;
        positiveFilters = pos;
        negativeFilters = neg;
        
    }
    
    /**
     * @return the genres
     */
    public ArrayList<String> getGenres() {
        return genres;
    }

    /**
     * @return the positiveFilters
     */
    public ArrayList<String> getPositiveFilters() {
        return positiveFilters;
    }

    /**
     * @return the negativeFilters
     */
    public ArrayList<String> getNegativeFilters() {
        return negativeFilters;
    }
}
