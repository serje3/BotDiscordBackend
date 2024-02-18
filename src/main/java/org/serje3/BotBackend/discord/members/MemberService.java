package org.serje3.BotBackend.discord.members;

import lombok.RequiredArgsConstructor;
import org.serje3.BotBackend.discord.events.log.EventLogRepository;
import org.serje3.BotBackend.discord.members.data.MemberInfo;
import org.serje3.BotBackend.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    private final EventLogRepository eventLogRepository;

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

    public MemberInfo getMemberInfo(UserId userId) {
        List<EventLog.Ref> userSlashLogs = eventLogRepository.getBySenderIdAndType(userId, EventLogType.SLASH);
        List<EventLog.RatingRef> ratingOnSenders = eventLogRepository.getRatingOnSenders(EventLogType.SLASH);
        EventLog.RatingRef ratingSender = ratingOnSenders.stream().filter(ref -> ref.getSenderId().equals(userId.getValue()))
                .findFirst()
                .orElse(new EventLog.RatingRef(1, userId.getValue(), 0));

        return MemberInfo.builder()
                .countExecutedCommands(userSlashLogs != null ? userSlashLogs.size() : 0)
                .rating(ratingSender)
                .build();
    }
}
