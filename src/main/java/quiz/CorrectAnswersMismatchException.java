package quiz;

public class CorrectAnswersMismatchException extends RuntimeException{

    public CorrectAnswersMismatchException() {
    }

    public CorrectAnswersMismatchException(String message) {
        super(message);
    }

    public CorrectAnswersMismatchException(String message, Throwable cause) {
        super(message, cause);
    }
}
