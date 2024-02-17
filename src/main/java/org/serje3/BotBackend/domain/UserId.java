package org.serje3.BotBackend.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserId {
    Long value;

    public UserId(Long value) {
        this.value = value;
    }

    public UserId(String value) {
        this(Long.parseLong(value));
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
