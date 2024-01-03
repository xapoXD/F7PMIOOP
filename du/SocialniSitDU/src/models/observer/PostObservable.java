package models.observer;

import models.User;

public interface PostObservable {

    void addFriend(User user);

    void removeFriend(User profile);

}
