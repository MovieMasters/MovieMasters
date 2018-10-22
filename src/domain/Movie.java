package domain;

import java.time.LocalDate;
import java.util.*;

public class Movie extends Model {
    private int id;
    private String title;
    private LocalDate releaseDate;
    private int playTime;
    private String summary;
    private String language;
    private List<CastMember> castMembers;
    private HashMap<String, ArrayList<Show>> shows;

    public Movie(int id, String title, LocalDate releaseDate, int playTime, String summary, String language) {
        this.id = id;
        this.title = title;
        this.releaseDate = releaseDate;
        this.playTime = playTime;
        this.summary = summary;
        this.language = language;
    }

    public Movie(int id, String title, LocalDate releaseDate, int playTime, String summary, String language, List<CastMember> castMembers, HashMap<String, ArrayList<Show>> shows) {
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

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
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

    public HashMap<String, ArrayList<Show>> getShows() {
        return shows;
    }

    public void setShows(HashMap<String, ArrayList<Show>> shows) {
        this.shows = shows;
    }
}
