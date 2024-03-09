package org.serje3.BotBackend.discord.nodes;

import com.serje3.generated.jooq.tables.records.LavalinkNodeRecord;
import lombok.RequiredArgsConstructor;
import org.serje3.BotBackend.discord.nodes.data.LavalinkNode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("lavalink/nodes")
@RequiredArgsConstructor
public class LavalinkNodeResource {
    private final LavalinkNodeService service;


    @GetMapping()
    public ResponseEntity<List<LavalinkNode>> getBotNodes(){
        return ResponseEntity.ok(service.getNodes());
    }
}
