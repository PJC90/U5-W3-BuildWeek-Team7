package buld.week.u5w4bw.exceptions;


import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException {

    public NotFoundException(long id) {
        super("Item with id: " + id + " not found");
    }

    public NotFoundException(String message) {
        super(message);
    }

}
