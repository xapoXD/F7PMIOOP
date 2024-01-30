import models.User;
import models.SocialNetwork;
import models.Post;
import models.Group;
import models.Feed;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        SocialNetwork socialNetwork = new SocialNetwork();

        User u1 = new User("u1");
        User u2 = new User("u2");
        User u3 = new User("u3");
        User u4 = new User("u4");


        socialNetwork.AddToSocialNetwork(u1);
        socialNetwork.AddToSocialNetwork(u2);
        socialNetwork.AddToSocialNetwork(u3);
        socialNetwork.AddToSocialNetwork(u4);

        u1.addFriend(u2);
        u1.addFriend(u3);
        u1.addFriend(u4);
        //u1.seeFriends();

        u2.addFriend(u3);
        u2.addFriend(u4);
        //u2.seeFriends();

        Group pejskari = new Group("Pejskaři");
        pejskari.AddToGroup(u3);
        pejskari.AddToGroup(u4);

        Group kockari = new Group("Kočkaři");
        kockari.AddToGroup(u1);
        kockari.AddToGroup(u2);

        //user prida post
        Post postU3psi = new Post(u3,"miluju psy bro");
        Post postU3 = new Post(u3,"post U3 bruh");
        Post postU1 = new Post(u1, "zkouska postu U1");
        Post postU2 = new Post(u2, "muluju kocicky dude");

        u3.addPost(postU3); // works
        u3.addPostToGroup(pejskari,postU3psi); // works
        u1.addPost(postU1); //works
        u2.addPostToGroup(kockari,postU2); // works

        u1.seeFeed();
        u2.seeFeed();
        u3.seeFeed();
        u4.seeFeed();



    }
}
