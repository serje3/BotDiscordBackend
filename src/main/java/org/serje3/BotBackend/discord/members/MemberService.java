package org.serje3.BotBackend.discord.members;

import lombok.RequiredArgsConstructor;
import org.serje3.BotBackend.domain.GuildId;
import org.serje3.BotBackend.domain.Member;
import org.serje3.BotBackend.domain.UserId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Member.Ref get(UserId userId, GuildId guildId) {
        return memberRepository.get(userId, guildId);
    }

    @Transactional
    public void save(Member member) {
        Member.Ref existingMember = get(member.getUserId(), member.getGuildId());
        System.out.println(existingMember);
        if (existingMember != null) {
            memberRepository.update(member);
        } else {
            memberRepository.create(member);
        }
    }
}
