package buld.week.u5w4bw.payloads;

import java.util.List;

public record ErrorPayloadList(String message,
                               List<String> errorsList) {
}
