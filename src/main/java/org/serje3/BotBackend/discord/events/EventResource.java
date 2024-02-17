package org.serje3.BotBackend.discord.events;

import lombok.RequiredArgsConstructor;
import org.serje3.BotBackend.discord.events.data.SlashCommandEvent;
import org.serje3.BotBackend.discord.events.log.EventLogService;
import org.serje3.BotBackend.discord.guilds.GuildService;
import org.serje3.BotBackend.discord.members.MemberService;
import org.serje3.BotBackend.domain.EventLog;
import org.serje3.BotBackend.domain.EventLogType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/events")
public class EventResource {

    private final MemberService memberService;
    private final GuildService guildService;
    private final EventLogService eventLogService;

    @PostMapping("/slash-received")
    public void onSlashCommandInteraction(@RequestBody SlashCommandEvent event) {
        memberService.save(event.getMember());
        guildService.save(event.getGuild());
        eventLogService.create(new EventLog(
                EventLogType.SLASH,
                event.getCommand(),
                event.getFullCommand(),
                event.getGuild().getGuildId(),
                event.getMember().getUserId()
        ));
    }
}
