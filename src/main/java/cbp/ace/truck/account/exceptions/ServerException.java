package cbp.ace.truck.account.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception that is mapped to 500 response code.
 *
 * @author Goutham Nyalakonda
 */
@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Server Error")
public class ServerException extends RuntimeException {

    /**
     * Constructor to create exception from any exception
     * @param t
     */
    public ServerException(Throwable t) {
        super(t);
    }
}
