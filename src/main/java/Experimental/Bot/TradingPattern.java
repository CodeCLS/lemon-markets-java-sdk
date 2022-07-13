package Experimental.Bot;

import Currency.CurrencyType;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class TradingPattern {

    public abstract void action();


    public static TradingPattern loadPattern(TradingPatternTypes meanReversion) {
        switch(meanReversion){
            default: return null;
            case MEAN_REVERSION:
                return new MeanReversionPattern();
        }
    }

    enum TradingPatternTypes{
        MEAN_REVERSION, INVALID;
        private static final Map<String, TradingPatternTypes> ENUM_MAP = Stream.of(TradingPatternTypes.values())
                .collect(Collectors.toMap(Enum::name, Function.identity()));

        public static TradingPatternTypes of(final String name) {
            return ENUM_MAP.getOrDefault(name, INVALID);
        }
        
    }
}
