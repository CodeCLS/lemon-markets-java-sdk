package Order;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Type {
    MARKET, INVALID;
    private static final Map<String, Type> ENUM_MAP = Stream.of(Type.values())
            .collect(Collectors.toMap(Enum::name, Function.identity()));

    public static Type of(final String name) {
        return ENUM_MAP.getOrDefault(name, INVALID);
    }
}
