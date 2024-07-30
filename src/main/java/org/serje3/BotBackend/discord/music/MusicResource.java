package org.serje3.BotBackend.discord.music;

import lombok.RequiredArgsConstructor;
import org.serje3.BotBackend.discord.music.data.SaveRecentTrack;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/music")
@RequiredArgsConstructor
public class MusicResource {
    private final MusicService musicService;

    @PostMapping("/recent")
    public ResponseEntity<?> saveLastTrack(@RequestBody SaveRecentTrack body) {
        musicService.saveRecentTrack(body);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/recent/{guildId}")
    public ResponseEntity<?> getRecentTracks(@PathVariable Long guildId) {
        return ResponseEntity.ok(musicService.getRecentTracks(guildId));
    }
}
