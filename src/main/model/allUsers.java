package main.model;

/**
 * Created by kirill_korygin on 9/29/16.
 */
public class allUsers {

    /**
     * This class is used to implement the RegisterController
     */

    private static User [] x = new User[100];
    private static int size = 0;


    public static User [] getUsers(){
        return x;
    }

    public static void addUser(User user){
        x[size] = user;
        size++;
    }

    public static int getSize(){
        return size;
    }



}
