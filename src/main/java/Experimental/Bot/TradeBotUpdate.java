package Experimental.Bot;

import Order.OrderTypes.PlacedOrder;
import Quotes.Quote;

public class TradeBotUpdate {
    private PlacedOrder placedOrder;
    private Long time;
    private BotValues botValues;
    private BotSettings botSettings;

    public TradeBotUpdate(PlacedOrder placedOrder, Long time, BotValues botValues, BotSettings botSettings) {
        this.placedOrder = placedOrder;
        this.time = time;
        this.botValues = botValues;
        this.botSettings = botSettings;
    }

    public PlacedOrder getPlacedOrder() {
        return placedOrder;
    }

    public void setPlacedOrder(PlacedOrder placedOrder) {
        this.placedOrder = placedOrder;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public BotValues getBotValues() {
        return botValues;
    }

    public void setBotValues(BotValues botValues) {
        this.botValues = botValues;
    }

    public BotSettings getBotSettings() {
        return botSettings;
    }

    public void setBotSettings(BotSettings botSettings) {
        this.botSettings = botSettings;
    }
}
