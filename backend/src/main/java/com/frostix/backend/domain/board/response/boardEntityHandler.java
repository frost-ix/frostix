package com.frostix.backend.domain.board.response;

import com.frostix.backend.domain.board.message.Message;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class boardEntityHandler {
    /***
     * @apiNote
     *          <h1>Success status</h1>
     *          - Throw success code to Front-end
     * @return new ResponseEntity<>({message:OK}, {HttpStatus.OK})
     */
    @GetMapping("/ok")
    public ResponseEntity returnSuccess() {
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    /***
     * @apiNote
     *          <h1>Handler for error status</h1>
     *          - Throw from server's error status to Front-end <br>
     * @return new ResponseEntity<>({error message}, {internal serer error status})
     */
    @GetMapping(value = "/errorCode", produces = "application/json")
    public ResponseEntity returnError() {
        Message message = Message.builder()
                .message("Error")
                .build();
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("onlyStatus")
    public ResponseEntity onlyStatus() {
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/header")
    public ResponseEntity header() {
        MultiValueMap<String, String> header = new LinkedMultiValueMap<>();
        header.add("AUTH_CODE", "xxxxxxxx");
        header.add("TOKEN", "xxxxxxxx");
        return new ResponseEntity(header, HttpStatus.OK);
    }
}