package itp341.bhatia.shamit.a9.Model;

import java.util.ArrayList;

/**
 * Created by Shamit on 10/31/17.
 */

public class Movie {

    private String title = "";
    private String description = "";
    private int genre = 0;
    private ArrayList<String> comments = new ArrayList<>();
    private String URL = "";

    // Constructors
    public Movie(String title, String description, int genre, ArrayList<String> comments, String URL) {
        this.title = title;
        this.description = description;
        this.genre = genre;
        this.comments = comments;
        this.URL = URL;
    }

    public Movie(){
        super();
    }

    // Getters & Setters

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getGenre() {
        return genre;
    }

    public void setGenre(int genre) {
        this.genre = genre;
    }

    public ArrayList<String> getMyList() {
        return comments;
    }

    public void setMyList(ArrayList<String> comments) {
        this.comments = comments;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    // to String

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", genre=" + genre +
                ", myList=" + comments +
                ", URL='" + URL + '\'' +
                '}';
    }
}
