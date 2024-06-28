package org.serje3.BotBackend.suno.data;


import java.util.List;

public record SunoGenerateResponse(String id, List<SunoClip> clips) { }
