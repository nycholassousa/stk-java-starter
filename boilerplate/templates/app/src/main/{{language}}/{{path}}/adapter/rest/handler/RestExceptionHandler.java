package {{group}}.{{project_name|replace('-','')}}.adapter.rest.handler;

import {{group}}.{{project_name|replace('-','')}}.domain.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@Slf4j
@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> handleIllegalArgumentException(IllegalArgumentException exception) {
        log.error("Handler exception of class {}", exception.getClass().getSimpleName());
        var error = buildErrorResponse(exception.getMessage(), exception.getClass().getSimpleName(), null);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
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
