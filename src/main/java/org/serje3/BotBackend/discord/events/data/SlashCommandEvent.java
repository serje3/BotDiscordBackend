package org.serje3.BotBackend.discord.events.data;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.serje3.BotBackend.domain.Member;

@Getter
@RequiredArgsConstructor
public class SlashCommandEvent {
    private final String command;
    private final Member member;
}
