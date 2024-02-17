package org.serje3.BotBackend.discord.events.log;

import lombok.RequiredArgsConstructor;
import org.serje3.BotBackend.domain.EventLog;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventLogService {
    private final EventLogRepository eventLogRepository;

    public void create(EventLog eventLog){
        eventLogRepository.create(eventLog);
    }
}
