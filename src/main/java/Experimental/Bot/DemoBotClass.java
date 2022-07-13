package Experimental.Bot;

import static Experimental.Bot.TradingPattern.TradingPatternTypes.MEAN_REVERSION;

@BotSettings(botName="Bot-Caleb", botVersion = 1)
public class DemoBotClass extends BotFeatures {
    @Override
    public void applyValues(BotValues botValues) {
        botValues.stocks =new String["ISIN","ISIN","ISIN"];
        botValues.pattern = TradingPattern.loadPattern(MEAN_REVERSION);


    }

    @Override
    public void doWork(TradeBotUpdate update) {

    }
}
