package org.serje3.BotBackend.discord.members.data;

import lombok.Builder;
import lombok.Getter;
import org.serje3.BotBackend.domain.EventLog;

@Builder
@Getter
public class MemberInfo {
    private Integer countExecutedCommands;
    private EventLog.RatingRef rating;
}
