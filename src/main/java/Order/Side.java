package Order;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Side {
    BUY, SELL, INVALID;
    private static final Map<String, Side> ENUM_MAP = Stream.of(Side.values())
            .collect(Collectors.toMap(Enum::name, Function.identity()));

    public static Side of(final String name) {
        return ENUM_MAP.getOrDefault(name, INVALID);
    }
}
