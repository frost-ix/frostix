package com.frostix.backend.domain.board.VO;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class resultVO {
    private String message;
    private Object data;

    public resultDTO() {
        this.message = null;
        this.data = null;
    }
    public resultDTO(final String message, final Object data) {
        if(!message.isEmpty()) {
            this.message = message;
            if (!(data == null)) this.data = data;
            else this.data = null;
        }
        else {
            this.message = null;
            this.data = null;
        }
    }
}
