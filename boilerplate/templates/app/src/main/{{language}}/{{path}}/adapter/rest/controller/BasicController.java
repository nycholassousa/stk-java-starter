package {{group}}.{{project_name|replace('-','')}}.adapter.rest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/v1/basic")
public class BasicController {

    @GetMapping
    public ResponseEntity<?> helloWorld() {
        return new ResponseEntity<>("Hello World!", HttpStatus.OK);
    }
}