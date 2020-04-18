package ia.nazarov.gamesys.controllers;

import ia.nazarov.gamesys.models.BasicResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@Slf4j
@ControllerAdvice
public class BasicExceptionHandler {
    // TODO: Just basic error handling. Expand generous Exception to more detailed ones.
    @ExceptionHandler(Exception.class)
    public ResponseEntity<BasicResponse> handleException(RuntimeException ex, WebRequest request) {
        // TODO: log message should be more informative for support team.
        log.error(String.format("Exception during processing request [%s]\n[%s]", request.toString(), ex.toString()));
        return new ResponseEntity<>(
                new BasicResponse("Error during processing your request. Please contact support@domain.org"),
                HttpStatus.BAD_REQUEST);
    }
}
