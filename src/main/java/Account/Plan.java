package Account;

import Order.Side;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Plan {
    BASIC,
    INVALID,
    FREE;

    private static final Map<String, Plan> ENUM_MAP = Stream.of(Plan.values())
            .collect(Collectors.toMap(Enum::name, Function.identity()));

    public static Plan of(final String name) {
        return ENUM_MAP.getOrDefault(name, INVALID);
    }
}
