
package com.mycompany.forexproxy.client;

import java.util.List;
import java.util.logging.Logger;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author daniel.forziat
 */
public class ForexProxyClient {

    /**
     * URL for my local docker deployment
     */
    private final String URL_BASE_STRING = "http://localhost:8082/rates";

    /**
     * Auth Token for Currency Exchange API Should be placed somewhere secure or
     * generated dynamically.
     */
    private final String TOKEN = "10dc303535874aeccc86a8251e6992f5";

    private static final Logger LOGGER = Logger.getLogger(ForexProxyClient.class.getName());

    public Response getRateFromExchange(List<String> currencyPairs) {
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target(URL_BASE_STRING)
                .queryParam("pair", currencyPairs.toArray());
        String responseBody = webTarget.request(MediaType.APPLICATION_JSON_TYPE)
                .header("token", TOKEN)
                .get(String.class);
        LOGGER.info(String.format("Currency Exchange Response: %s" ,responseBody));
        return Response.ok(responseBody).build();
    }

}
