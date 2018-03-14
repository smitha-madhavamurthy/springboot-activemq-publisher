package com.lumiradx.publisher;

import com.lumiradx.LumiraMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@ComponentScan(basePackages = {"com.lumiradx.publisher"})
public class PublisherApplication implements ApplicationRunner
{
    private static Logger log = LoggerFactory.getLogger(PublisherApplication.class);

    @Autowired
    private MessagePublisher messagePublisher;

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception
    {
        log.info("Spring Boot ActiveMQ Publish Subscribe Topic Configuration Demo");
        LumiraMessage message= new LumiraMessage("Test Message from publisher","careplan-"+UUID.randomUUID().toString(),"patientId-"+UUID.randomUUID().toString(),"orgId-"+UUID.randomUUID().toString());
        int counter=1;
        // Keep producing messages in an infinite loop.
        while(1 > 0)
        {
            messagePublisher.send(message);
            TimeUnit.SECONDS.sleep(5);
            counter++;

            if(counter == 100){
                TimeUnit.SECONDS.sleep(600);
                counter =1;
            }
        }
    }

    public static void main(String[] args) throws Exception
    {
        SpringApplication.run(PublisherApplication.class, args);
    }

}


