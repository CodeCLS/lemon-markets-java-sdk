package Trading;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum TradingEnvironment {
    PAPER, LIVE, INVALID;
    private static final Map<String, TradingEnvironment> ENUM_MAP = Stream.of(TradingEnvironment.values())
            .collect(Collectors.toMap(Enum::name, Function.identity()));

    public static TradingEnvironment of(final String name) {
        return ENUM_MAP.getOrDefault(name, INVALID);
    }
}
