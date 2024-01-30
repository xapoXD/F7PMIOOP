package models;

public class Post {

    public User author;

    public String content;

    public Post(User author, String content) {
        this.author = author;
        this.content = content;
    }
}
