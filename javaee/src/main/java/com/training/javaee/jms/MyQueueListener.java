package com.training.javaee.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSDestinationDefinition;
import javax.jms.JMSDestinationDefinitions;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@JMSDestinationDefinitions({
                             @JMSDestinationDefinition(destinationName = "TJMSQueue",
                                                       name = "java:/jms/TJMSQueue",
                                                       interfaceName = "javax.jms.Queue"),
                             @JMSDestinationDefinition(destinationName = "TJMSTopic",
                                                       name = "java:/jms/TJMSTopic",
                                                       interfaceName = "javax.jms.Topic")
})

@MessageDriven(activationConfig = {
                                    @ActivationConfigProperty(propertyName = "destination",
                                                              propertyValue = "TJMSQueue"),
                                    @ActivationConfigProperty(propertyName = "destinationType",
                                                              propertyValue = "javax.jms.Queue")
})
public class MyQueueListener implements MessageListener {

    public MyQueueListener() {
    }

    @Override
    public void onMessage(final Message message) {
        if (message instanceof TextMessage) {
            TextMessage messageLoc = (TextMessage) message;
            try {
                System.out.println("TextMessage QueueListener1: " + messageLoc.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
        System.out.println(message);
    }

}
