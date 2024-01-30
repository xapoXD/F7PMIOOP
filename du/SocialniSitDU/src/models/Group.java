package models;

import models.observer.PostObserver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Group implements PostObserver {

    public String groupName;
 //   public ArrayList<User> usersList = new ArrayList<User>(); //
    private Set<User> users = new HashSet<>();

    public Set<User> getMemberList() {
        return users;
    }

    public void AddToGroup(User addUser){
        users.add(addUser);
        addUser.addUserToGroup(this);
      //  usersList.add(addUser);
    }

    public Group(String groupName) {
        this.groupName = groupName;
    }

    @Override
    public void notifyPostAdded(Post post) {

        for(User user : users){

            if(!user.feed.postsList.contains(post)){
                user.feed.groupList.add(post);
            }
        }

        //users.forEach(profile -> profile.feed.groupList.add(post));
    }
}
