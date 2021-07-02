package com.training.javaee.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(activationConfig = {
                                    @ActivationConfigProperty(propertyName = "destination",
                                                              propertyValue = "TJMSTopic"),
                                    @ActivationConfigProperty(propertyName = "destinationType",
                                                              propertyValue = "javax.jms.Topic")
})
public class MyTopicListener2 implements MessageListener {

    public MyTopicListener2() {
    }

    @Override
    public void onMessage(final Message message) {
        if (message instanceof TextMessage) {
            TextMessage messageLoc = (TextMessage) message;
            try {
                System.out.println("TextMessage TopicListener2: " + messageLoc.getText());
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
        System.out.println(message);
    }

}
