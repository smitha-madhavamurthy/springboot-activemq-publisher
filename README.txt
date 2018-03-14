Springboot-activemq-publisher service demonstrates the minimal functionality to publish a message to a topic in ActiveMQ.

Some basics on how this is configured and what it means:
Spring boot automatically configures connectionfactory if it detects ActiveMQ on the classpath.
In this case, it also makes use of embedded broker if does not find any ActiveMQ custom configurations in application.properties.

spring-boot-starter-activemq : It provides all the required dependencies to integrate JMS and activemq with spring boot.

activemq-broker : This provides embedded activemq in spring boot application. But since, we will be configuring our activemq outside the application ,we will not be adding this as  a dependency in our service.

spring-boot-maven-plugin : It will collect all the jar files present in the classpath and create a single executable jar.

With Publisher application, we configure additional jmsTemplate bean in ActiveMQConfig.

To integrate topic in Spring JMS, we need to manually configure spring to enable the behavior to work with MQ.
We need to set the boolean flag 'pubSubDomain' to true for the bean definition of JmsTemplate and the property to be set in application.properties 'spring.jms.pub-sub-domain' to true.

ActiveMq by default exposes a broker url tcp://localhost:61616 and an admin console on tcp://localhost:61616 with userId and password as admin and admin.

NOTE: LumiraMessage is a common Message model which needs to be handled by publisher and subscriber. Hence this model object will need to belong to a centralized library which both the services can use.
Once all applications in the platform can use Nexus as the artifact repo, these  common libraries will be published to Nexus.