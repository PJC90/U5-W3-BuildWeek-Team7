package buld.week.u5w4bw.payloads;

import java.time.LocalDateTime;

public record ErrorPayload(String message, LocalDateTime time) {
}
