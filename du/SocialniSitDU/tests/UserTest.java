import models.Group;
import models.Post;
import models.SocialNetwork;
import models.User;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {


    @org.junit.jupiter.api.Test
    void addPost() {
        //Arrange
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

        u2.addFriend(u3);
        u2.addFriend(u4);

        Group pejskari = new Group("Pejskaři");
        pejskari.AddToGroup(u3);
        pejskari.AddToGroup(u4);

        Group kockari = new Group("Kočkaři");
        kockari.AddToGroup(u1);
        kockari.AddToGroup(u2);


        //Act
        Post postU3psi = new Post(u3,"miluju psy bro");
        Post postU3 = new Post(u3,"post U3 bruh");
        Post postU1 = new Post(u1, "zkouska postu U1");
        Post postU2kocky = new Post(u2, "muluju kocicky dude");

        u1.addPost(postU1); //works
        u3.addPost(postU3); // works
        u3.addPostToGroup(pejskari,postU3psi); // works
        u2.addPostToGroup(kockari,postU2kocky); //works

        //u1.seeFeed();
        //u2.seeFeed();
        //u3.seeFeed();
        //u4.seeFeed();

        //Assert
        Set<User> friendosU1;
        friendosU1 = u1.getFriendList();
        for(User friend : friendosU1){ //vsichni kamosi u1 maji mit jeho post
            assertEquals(friend.feed.postsList.contains(postU1), true);
        }

        Set<User> friendosU3;
        friendosU3 = u3.getFriendList();
        for(User friend : friendosU3){ //vsichni kamosi u3 maji mit jeho post
            assertEquals(friend.feed.postsList.contains(postU3), true);
        }

        Set<User> membersPejskari;
        membersPejskari = pejskari.getMemberList();
        for(User member : membersPejskari){ //vsichni members pejksari maji mit post ve feedu
            assertEquals(member.feed.groupList.contains(postU3psi), true);
        }

        Set<User> membersKockari;
        membersKockari = kockari.getMemberList();
        for(User member : membersKockari){ //vsichni members kockari maji mit post ve feedu
            assertEquals(member.feed.groupList.contains(postU2kocky), true);
        }


    }
}