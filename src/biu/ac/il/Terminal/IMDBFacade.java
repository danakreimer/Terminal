package biu.ac.il.Terminal;

public class IMDBFacade {
    private IMDBApi imdbApi;

    public IMDBFacade() {
        this.imdbApi = new IMDBApi();
    }

    public String getMovieData(String name) {
        Movie movie = this.imdbApi.getMovieData(name);

        if (movie == null) {
            return null;
        }

        return "Movie: " + movie.getTitle() + ", Year: " + movie.getYear() + ", Score: " + movie.getScore()
                + ", Director: " + movie.getDirector() + ", Country: " + movie.getCountry();
    }
}
