package org.serje3.BotBackend.domain;

import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(of = "value")
public class GuildId {
    Long value;

    public GuildId(Long value) {
        this.value = value;
    }

    public GuildId(String value) {
        this(Long.parseLong(value));
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
