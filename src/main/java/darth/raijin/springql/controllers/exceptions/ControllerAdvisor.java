package darth.raijin.springql.controllers.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import darth.raijin.springql.models.records.ErrorRecord;

@RestControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

  @ExceptionHandler({ PlayerNotFoundException.class })
  public final ResponseEntity<ErrorRecord> handlePlayerNotFound(PlayerNotFoundException ex) {
    return new ResponseEntity<>(new ErrorRecord(422, ex.getMessage()),
        HttpStatus.UNPROCESSABLE_ENTITY);
  }

  @Override
  protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers,
      HttpStatus status, WebRequest request) {
    return new ResponseEntity<>(new ErrorRecord(422, ex.getMostSpecificCause().getMessage()),
        HttpStatus.UNPROCESSABLE_ENTITY);
  }

  @ExceptionHandler({ MatchNotFoundException.class })
  public final ResponseEntity<ErrorRecord> handleMatchNotFound(MatchNotFoundException ex) {
    ErrorRecord errorRecord = new ErrorRecord(422, ex.getMessage());
    return new ResponseEntity<>(errorRecord, HttpStatus.UNPROCESSABLE_ENTITY);
  }

  @ExceptionHandler({ Exception.class })
  public final ResponseEntity<ErrorRecord> handleUnhandled(Exception ex) {
    ErrorRecord error = new ErrorRecord(500, ex.getMessage());
    return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
