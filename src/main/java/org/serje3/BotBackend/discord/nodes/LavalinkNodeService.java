package org.serje3.BotBackend.discord.nodes;

import com.serje3.generated.jooq.tables.records.LavalinkNodeRecord;
import lombok.RequiredArgsConstructor;
import org.serje3.BotBackend.discord.nodes.data.LavalinkNode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LavalinkNodeService {
    private final LavalinkNodeRepository lavalinkNodeRepository;

    public List<LavalinkNode> getNodes() {
        return lavalinkNodeRepository.getNodes();
    }
}
