package Order;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Status {
    EXECUTED, PENDING, INVALID;
    private static final Map<String, Status> ENUM_MAP = Stream.of(Status.values())
            .collect(Collectors.toMap(Enum::name, Function.identity()));

    public static Status of(final String name) {
        return ENUM_MAP.getOrDefault(name, INVALID);
    }
}
