package org.serje3.BotBackend.suno;

import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.serje3.BotBackend.suno.data.SunoAuth;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SunoService {
    private final SunoRepository repository;

    public void login(SunoAuth auth) {
        SunoAuth existedAuth = repository.getAuthByUserId(auth.userId());
        if (existedAuth == null) {
            repository.insertAuth(auth);
        } else {
            repository.updateAuth(auth);
        }
    }
}
