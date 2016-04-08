package com.throwawaycode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SillyService {


    @Value("${words.to.say}")
    private String wordsToSay;

    private static final Logger LOG = LoggerFactory.getLogger(SillyService.class);


    public void makeStuffHappen() {
        LOG.debug("{}", wordsToSay);
    }

    public void setWordsToSay(String wordsToSay) {
        this.wordsToSay = wordsToSay;
    }
}
