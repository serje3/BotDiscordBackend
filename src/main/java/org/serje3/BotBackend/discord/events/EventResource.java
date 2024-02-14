package org.serje3.BotBackend.discord.events;

import lombok.RequiredArgsConstructor;
import org.serje3.BotBackend.discord.events.data.SlashCommandEvent;
import org.serje3.BotBackend.discord.members.MemberService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/events")
public class EventResource {

    private final MemberService memberService;

    @PostMapping("/slash-received")
    public void onSlashCommandInteraction(@RequestBody SlashCommandEvent event) {
        memberService.save(event.getMember());
    }
}
