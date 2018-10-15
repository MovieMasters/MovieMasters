package domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import datastorage.MovieDAO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Movie extends Model {
    private int id;
    private String title;
    private Date releaseDate;
    private int playTime;
    private String summary;
    private String language;
    private List<CastMember> castMembers;
    private List<Show> shows;

    public Movie(int id, String title, Date releaseDate, int playTime, String summary, String language) {
        this.id = id;
        this.title = title;
        this.releaseDate = releaseDate;
        this.playTime = playTime;
        this.summary = summary;
        this.language = language;
    }

    public Movie(int id, String title, Date releaseDate, int playTime, String summary, String language, List<CastMember> castMembers, List<Show> shows) {
        this(id, title, releaseDate, playTime, summary, language);
        this.castMembers = castMembers;
        this.shows = shows;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public int getPlayTime() {
        return playTime;
    }

    public void setPlayTime(int playTime) {
        this.playTime = playTime;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public List<CastMember> getCastMembers() {
        return castMembers;
    }

    public void setCastMembers(List<CastMember> castMembers) {
        this.castMembers = castMembers;
    }

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }
}
