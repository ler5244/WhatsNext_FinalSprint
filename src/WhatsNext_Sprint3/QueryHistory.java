/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WhatsNext_Sprint3;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author mattb
 */
public class QueryHistory implements Serializable {
    ArrayList <Query> queryHistory;
    
    public QueryHistory(){
        queryHistory = new ArrayList();
    }
    
    public void addToHistory (Query q)
    {
        queryHistory.add(q);
    }
    
    public ArrayList<Query> getHistory(){
        return queryHistory;
    }
}
