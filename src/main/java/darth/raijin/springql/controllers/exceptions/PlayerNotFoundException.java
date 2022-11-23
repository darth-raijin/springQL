package darth.raijin.springql.controllers.exceptions;

public class PlayerNotFoundException extends Exception {
    public PlayerNotFoundException(Long id) {
        super(String.format("Player with Id %d not found", id));
    }
}
