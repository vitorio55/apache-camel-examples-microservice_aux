package com.vitorio.examples.springboot.camelmicroservice_aux.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class ActiveMQReceiverRouter extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		// Docker container used for ActiveMQ: rmohr/activemq
		
		from("activemq:my-activemq-queue")
		.to("log:received-message-from-active-mq");
	}

}
