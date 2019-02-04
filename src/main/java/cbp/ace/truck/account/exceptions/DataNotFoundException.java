package cbp.ace.truck.account.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception that is used to return 404 exception in Rest Web Service
 *
 * @author Goutham Nyalakonda
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Data Not Found")
public class DataNotFoundException extends RuntimeException {
}
