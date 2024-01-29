package buld.week.u5w4bw.exceptions;


import lombok.Getter;

import java.util.UUID;

@Getter
public class NotFoundException extends RuntimeException {

    public NotFoundException(UUID id) {
        super("Item with id: " + id + " not found");
    }

    public NotFoundException(long id) {
        super("Item with id: " + id + " not found");
    }


    public NotFoundException(String message) {
        super(message);
    }

}
