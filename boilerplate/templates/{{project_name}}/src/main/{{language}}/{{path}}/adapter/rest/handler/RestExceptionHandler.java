package {{group}}.{{project_name|replace('-','')}}.adapter.rest.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(NotAuthorizedException.class)
    public ResponseEntity<?> handleNotAuthorizedException(NotAuthorizedException exception) {
        log.error("Handler exception of class {}", exception.getClass().getSimpleName());
        var error = buildErrorResponse(exception.getMessage(), exception.getClass().getSimpleName(), null);
        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }

    private ErrorResponse buildErrorResponse(String message, String exceptionClassName, Object information) {
        return ErrorResponse.builder()
                .message(message)
                .errorDate(LocalDateTime.now())
                .exceptionName(exceptionClassName)
                .information(information)
                .build();
    }
}
