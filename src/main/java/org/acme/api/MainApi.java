package org.acme.api;

import org.apache.camel.ProducerTemplate;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class MainApi {

    @Inject
    ProducerTemplate producerTemplate;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        producerTemplate.requestBody("direct:MyLog", null, String.class);
        return "hello";
    }

}