package Utils;

public class BaseError extends RuntimeException {
    public String message;
    public position pos;
    public BaseError(position pos, String message) {
        this.message = message;
        this.pos = pos;
    }
    @Override
    public String toString() {
        return "Error: " + message + " at " + pos.toString();
    }
}