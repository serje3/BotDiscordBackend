package org.serje3.BotBackend.domain;

import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(of = "value")
public class GuildId {
    int value;

    public GuildId(int value) {
        this.value = value;
    }

    public GuildId(String value) {
        this(Integer.parseInt(value));
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
