package org.serje3.BotBackend.discord.members;

import lombok.RequiredArgsConstructor;
import org.serje3.BotBackend.discord.events.log.EventLogService;
import org.serje3.BotBackend.discord.members.data.MemberInfo;
import org.serje3.BotBackend.domain.GuildId;
import org.serje3.BotBackend.domain.UserId;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("members/")
@RequiredArgsConstructor
public class MemberResource {

    private final MemberService memberService;

    @GetMapping("/{userId}/info")
    public ResponseEntity<MemberInfo> getMemberInfo(@PathVariable("userId") UserId userId){
        return ResponseEntity.ok().body(memberService.getMemberInfo(userId));
    }
}
