package org.acme.routes;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;

public class MainRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("direct:MyLog")
                .log("Disaparando Procesamiento...")
                .to("direct:LlamadoHttp")
                .end();


        from("direct:LlamadoHttp")
                .setHeader(Exchange.HTTP_METHOD, constant("GET"))
                .log("Iniciando llamado HTTP...")
                .to("http://api.icndb.com/jokes/random?firstName=John&amp;lastName=Doe")
                .log("Body: ${body}")
                .end();

    }

}
