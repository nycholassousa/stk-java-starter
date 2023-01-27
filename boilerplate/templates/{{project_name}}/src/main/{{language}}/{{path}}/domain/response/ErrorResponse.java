package {{group}}.{{project_name|replace('-','')}}.domain.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.extern.jackson.Jacksonized;

import java.time.LocalDateTime;

@Builder
@Jacksonized
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

    @JsonProperty(value = "exception_name")
    private String exceptionName;

    @JsonProperty(value = "message")
    private String message;

    @JsonProperty(value = "information_values")
    private Object information;

    @JsonProperty(value = "error_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private LocalDateTime errorDate;
}
