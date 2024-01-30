package models;

import java.util.ArrayList;
import java.util.List;

public class SocialNetwork {

    public ArrayList<User> usersList = new ArrayList<User>();
    public ArrayList<Group> groupsList = new ArrayList<Group>();


    public void AddToSocialNetwork(User addUser){

        usersList.add(addUser);

    }

}
