package biu.ac.il.Terminal;

public class IMDBCommand extends AdvancedCommand {
    private IMDBFacade imdbFacade;

    public IMDBCommand(String[] args) {
        super(args);
        this.imdbFacade = new IMDBFacade();
    }

    @Override
    public String execute() {
        // Convert all spaces into %20 to match the json structure
        String movie = this.imdbFacade.getMovieData(String.join("%20", this.args));

        if (movie == null) {
            return "Error: movie not found";
        }

        return movie;
    }
}
