package vttp.batch5.paf.movies.models;

import java.util.Arrays;
import java.util.List;

public class MovieDetails {
    private String imdbId;
    private String title;
    private String directors;
    private String overview;
    private String tagline;
    private String genres;
    private int imdbRating;
    private int imdbVotes;

    public static List<String> stringToList(String s) {
        String[] strings = s.split(",");
        
        List<String> list = Arrays.asList(strings);
        return list;
    }
    
    public String getImdbId() {
        return imdbId;
    }
    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDirectors() {
        return directors;
    }
    public void setDirectors(String directors) {
        this.directors = directors;
    }
    public String getOverview() {
        return overview;
    }
    public void setOverview(String overview) {
        this.overview = overview;
    }
    public String getTagline() {
        return tagline;
    }
    public void setTagline(String tagline) {
        this.tagline = tagline;
    }
    public String getGenres() {
        return genres;
    }
    public void setGenres(String genres) {
        this.genres = genres;
    }
    public int getImdbRating() {
        return imdbRating;
    }
    public void setImdbRating(int imdbRating) {
        this.imdbRating = imdbRating;
    }
    public int getImdbVotes() {
        return imdbVotes;
    }
    public void setImdbVotes(int imdbVotes) {
        this.imdbVotes = imdbVotes;
    }

    @Override
    public String toString() {
        return "MovieDetails [imdbId=" + imdbId + ", title=" + title + ", directors=" + directors + ", overview="
                + overview + ", tagline=" + tagline + ", genres=" + genres + ", imdbRating=" + imdbRating
                + ", imdbVotes=" + imdbVotes + "]";
    }
    

}
