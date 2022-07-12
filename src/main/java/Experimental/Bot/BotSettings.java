package Experimental.Bot;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.TYPE)
public @interface BotSettings {
    String botName() default ("trading-bot");
    int botVersion() default 1;
}
