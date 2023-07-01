package com.upgrad.patterns.Middleware;

import com.upgrad.patterns.Authentication.AuthenticationProvider;
import com.upgrad.patterns.Authentication.BasicAuthProvider;

public class BasicAuthProcessor extends AuthenticationProcessor {

    public BasicAuthProcessor()
    {
        super();
    }

       @Override
    public void setNextProcessor(AuthenticationProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    // is User name and password is provided, use it to authenticate
    @Override
    public boolean isAuthorized(AuthenticationProvider provider) {
        if(provider instanceof BasicAuthProvider)
        {
            return provider.Authenticate();
        }
        else if(nextProcessor != null)
        {
            return nextProcessor.isAuthorized(provider);
        }
        return false;
    }
}
