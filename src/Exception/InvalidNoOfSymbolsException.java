package Exception;

public class InvalidNoOfSymbolsException extends RuntimeException{
    public InvalidNoOfSymbolsException() {
    }

    public InvalidNoOfSymbolsException(String message) {
        super(message);
    }

    public InvalidNoOfSymbolsException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidNoOfSymbolsException(Throwable cause) {
        super(cause);
    }

    public InvalidNoOfSymbolsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
