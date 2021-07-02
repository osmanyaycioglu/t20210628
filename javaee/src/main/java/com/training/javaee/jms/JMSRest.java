package com.training.javaee.jms;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.jms.Topic;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/jms")
public class JMSRest {

    @Inject
    private JMSContext context;

    @Resource(lookup = "java:/jms/TJMSQueue")
    private Queue      queue;

    @Resource(lookup = "java:/jms/TJMSTopic")
    private Topic      topic;

    @Path("/send/queue")
    @GET
    public String sendMessageToJMS(@QueryParam("msg") final String str) {
        this.context.createProducer()
                    .send(this.queue,
                          str);
        return "SUCCESS";
    }

    @Path("/send/topic")
    @GET
    public String sendMessageToTopicJMS(@QueryParam("msg") final String str) {
        this.context.createProducer()
                    .send(this.topic,
                          str);
        return "SUCCESS";
    }

}
