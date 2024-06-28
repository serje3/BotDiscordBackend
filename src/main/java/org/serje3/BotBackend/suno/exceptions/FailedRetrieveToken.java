package org.serje3.BotBackend.suno.exceptions;

public class FailedRetrieveToken extends IllegalArgumentException{
    public FailedRetrieveToken(String s) {
        super(s);
    }
}
