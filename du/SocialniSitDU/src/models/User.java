package models;

import models.observer.PostObservable;
import models.observer.PostObserver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class User implements PostObservable, PostObserver {

    private ArrayList<Group> inGroups = new ArrayList<Group>();

    private Set<User> friendList = new HashSet<>();

    public Set<User> getFriendList() {
        return friendList;
    }

    public String userName;
    public Feed feed = new Feed();

    public String getUserName() {
        return userName;
    }

    public User(String userName) {
        this.userName = userName;
    }

    public void addUserToGroup(Group group){
        inGroups.add(group);
    }

    @Override
    public void addFriend(User addUser){

        friendList.add(addUser);

        if(!addUser.friendList.contains(User.this)){
            //kdyz pridavany uzivatel nema ve friendlistu requestora, tak se prida taky do jeho
            addUser.friendList.add(User.this);
        }

    }

    @Override
    public void removeFriend(User profile) {
    }


    public void seeFeed(){
        System.out.println(this.userName + " feed: ");

        System.out.println("----- FRIENDS FEED -----");
        for(int i = 0; i < feed.postsList.size(); i++){

            System.out.println("friend post: " + feed.postsList.get(i).content);
        }

        System.out.println("----- GROUP   FEED -----");
        for(int i = 0; i < inGroups.size(); i++){

            if(!feed.groupList.isEmpty()){
                System.out.println("group post: " + feed.groupList.get(i).content);
            }

        }
    }


    public void seeFriends(){
        friendList.forEach(profile -> System.out.println(profile.getUserName()));
    }

    @Override
    public void notifyPostAdded(Post post) {
        feed.postsList.add(post);
    }


    public void addPost(Post post){
        this.feed.postsList.add(post); //prida sobe do feedu
        friendList.forEach(profile -> profile.notifyPostAdded(post)); //prida friendum do feedu post -> friendi maji

    }

    public void addPostToGroup(Group group, Post post){
        // prioritu vuci skupinam, proto se pridavaji prvni a az ve skupine se checkuje jestli jiz neobsahuje ten post

        for(int i = 0; i < inGroups.size(); i++){ //loopni pres skupiny ve kterych je

            if(group == inGroups.get(i)){
                inGroups.get(i).notifyPostAdded(post); //prida kazdemu ve skupine post do feedu
            }
        }

    }

}
