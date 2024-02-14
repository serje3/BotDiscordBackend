package org.serje3.BotBackend.discord.members;

import lombok.RequiredArgsConstructor;
import org.serje3.BotBackend.domain.GuildId;
import org.serje3.BotBackend.domain.Member;
import org.serje3.BotBackend.domain.UserId;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Member get(UserId userId, GuildId guildId) {
        return memberRepository.get(userId, guildId);
    }

    public void save(Member member) {
        Member existingMember = get(member.getUserId(), member.getGuildId());
        if (existingMember != null) {
            memberRepository.update(member);
        } else {
            memberRepository.create(member);
        }
    }
}
