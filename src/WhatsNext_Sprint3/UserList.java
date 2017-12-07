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
 * @author Laura
 */
public class UserList implements Serializable{
 
    private ArrayList<User> theList;
    public UserList()
    {
        theList = new ArrayList();
        
        // This is a test list, will be deleted l8r
        User user1 = new User("Test", "Test");
        User user2 = new User("testUse", "password");
        User user3 = new User("ihavealongusername", "ihaveanevenlongerpassword");
        User user4 = new User("test", "test");
        
        theList.add(user1);
        theList.add(user2);
        theList.add(user3);
        theList.add(user4);
        
        
    }
    
    public void addUsers(User user)
    {
        getTheList().add(user);
    }

    public ArrayList<User> getTheList() {
        return theList;
    }

}
