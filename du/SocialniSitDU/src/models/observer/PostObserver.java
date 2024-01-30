package models.observer;

import models.Post;

public interface PostObserver {

    void notifyPostAdded(Post post);
    
}
