package com.upgrad.patterns.Middleware;

import com.upgrad.patterns.Authentication.AuthenticationProvider;
import com.upgrad.patterns.Authentication.JwtAuthProvider;

public class JwtAuthProcessor extends AuthenticationProcessor {

    public JwtAuthProcessor()
    {
        super();
    }

    // If JWT token is provided, use it to authenticate
    @Override
    public boolean isAuthorized(AuthenticationProvider provider) {

        if(provider instanceof JwtAuthProvider)
        {
            return provider.Authenticate();
        }
        else if(nextProcessor != null)
        {
            return nextProcessor.isAuthorized(provider);
        }
        return false;
    }

    public void setNextProcessor(AuthenticationProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }
}
