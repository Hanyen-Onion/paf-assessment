package vttp.batch5.paf.movies.models;

import java.util.Date;

public class Movie {
    private String imdbId;
    private float voteAverage;
    private int voteCount;
    private Date releaseDate;
    private float revenue;
    private float budget;
    private int runtime;
    
    public String getImdbId() {
        return imdbId;
    }
    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }
    public float getVoteAverage() {
        return voteAverage;
    }
    public void setVoteAverage(float voteAverage) {
        this.voteAverage = voteAverage;
    }
    public int getVoteCount() {
        return voteCount;
    }
    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }
    public Date getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
    public float getRevenue() {
        return revenue;
    }
    public void setRevenue(float revenue) {
        this.revenue = revenue;
    }
    public float getBudget() {
        return budget;
    }
    public void setBudget(float budget) {
        this.budget = budget;
    }
    public int getRuntime() {
        return runtime;
    }
    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    @Override
    public String toString() {
        return "movie [imdbId=" + imdbId + ", voteAverage=" + voteAverage + ", voteCount=" + voteCount
                + ", releaseDate=" + releaseDate + ", revenue=" + revenue + ", budget=" + budget + ", runtime="
                + runtime + "]";
    }


}
