package com.frostix.backend.domain.board.message;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Message {
    private String message;

    @Builder
    public Message(String message){
        this.message = message;
    }
}
