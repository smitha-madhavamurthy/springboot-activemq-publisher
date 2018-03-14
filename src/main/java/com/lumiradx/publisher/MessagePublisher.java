package com.lumiradx.publisher;

import com.lumiradx.LumiraMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

/**
 * @author Smitha
 */
@Component
public class MessagePublisher
{
    private static Logger log = LoggerFactory.getLogger(MessagePublisher.class);

    @Value("${careprogram.enrol.topic.name}")
    String careprogramEnrolTopic;

    @Autowired
    private JmsTemplate jmsTemplate;

    public void send(LumiraMessage msg)
    {
        log.info("Message[] "+msg+" is being published to the Topic[] " + careprogramEnrolTopic);
        jmsTemplate.convertAndSend(careprogramEnrolTopic, msg);
    }

}
