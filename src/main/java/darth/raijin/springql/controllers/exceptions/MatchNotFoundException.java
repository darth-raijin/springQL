package darth.raijin.springql.controllers.exceptions;

public class MatchNotFoundException extends RuntimeException {

    public MatchNotFoundException(Long id) {
        super(String.format("Match with Id %d not found", id));
    }

}
