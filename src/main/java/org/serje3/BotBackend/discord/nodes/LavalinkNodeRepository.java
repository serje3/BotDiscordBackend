package org.serje3.BotBackend.discord.nodes;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.serje3.BotBackend.discord.nodes.data.LavalinkNode;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.serje3.generated.jooq.Tables.LAVALINK_NODE;

@Repository
@RequiredArgsConstructor
public class LavalinkNodeRepository {
    private final DSLContext dsl;


    public List<LavalinkNode> getNodes() {
        return dsl.selectFrom(LAVALINK_NODE)
                .fetchInto(LavalinkNode.class);
    }
}
