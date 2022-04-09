package Currency;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum CurrencyType {
    EUR, USD, INVALID;
    private static final Map<String, CurrencyType> ENUM_MAP = Stream.of(CurrencyType.values())
            .collect(Collectors.toMap(Enum::name, Function.identity()));

    public static CurrencyType of(final String name) {
        return ENUM_MAP.getOrDefault(name, INVALID);
    }
}
