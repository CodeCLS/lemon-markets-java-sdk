package Experimental.Bot;

import Quotes.Quote;

import java.util.ArrayList;

import static Experimental.Bot.TradingPattern.TradingPatternTypes.MEAN_REVERSION;

@BotSettings(botName="Bot-Caleb", botVersion = 1)
public class DemoBotClass extends BotFeatures {
    @Override
    public void applyValues(BotValues botValues) {
        botValues.stocks = new ArrayList<>();
        botValues.pattern = TradingPattern.loadPattern(MEAN_REVERSION);


    }

    @Override
    public void performedAction(TradeBotUpdate update) {
        System.out.println(update.getPlacedOrder().getIsin());

    }
}
