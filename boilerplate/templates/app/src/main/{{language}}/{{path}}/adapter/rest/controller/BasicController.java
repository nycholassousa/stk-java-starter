package {{group}}.{{project_name|replace('-','')}}.adapter.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/basic")
public class BasicController {

    @GetMapping
    public ResponseEntity<?> helloWorld() {
        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }

    @GetMapping(value = "/throw")
    public ResponseEntity<?> throwException() {
        throw new IllegalArgumentException("Hello Error!");
    }
}