package biu.ac.il.Terminal;

public class Movie {
    private String actors;
    private String title;
    private String score;
    private String year;
    private String director;
    private String boxOffice;
    private String country;

    public Movie(String title, String actors, String score, String year, String director, String boxOffice, String country) {
        this.actors = actors;
        this.title = title;
        this.score = score;
        this.year = year;
        this.director = director;
        this.boxOffice = boxOffice;
        this.country = country;
    }

    public String getCountry() {
        return this.country;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getBoxOffice() {
        return boxOffice;
    }

    public void setBoxOffice(String boxOffice) {
        this.boxOffice = boxOffice;
    }
}
