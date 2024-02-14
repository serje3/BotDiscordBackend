package org.serje3.BotBackend.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserId {
    int value;

    public UserId(int value) {
        this.value = value;
    }

    public UserId(String value) {
        this(Integer.parseInt(value));
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
