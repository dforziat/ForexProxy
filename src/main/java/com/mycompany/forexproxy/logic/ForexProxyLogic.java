
package com.mycompany.forexproxy.logic;

import com.mycompany.forexproxy.client.ForexProxyClient;
import com.mycompany.forexproxy.constant.ErrorCodes;
import com.mycompany.forexproxy.dto.ErrorDto;
import java.util.List;
import java.util.logging.Logger;
import javax.ws.rs.core.Response;

/**
 *
 * @author daniel.forziat
 */
public class ForexProxyLogic {
    
    private static final Logger LOGGER = Logger.getLogger(ForexProxyLogic.class.getName());
   
    public Response execute(List<String> currencyPairs){
        ForexProxyClient client = new ForexProxyClient();
        try{
           return client.getRateFromExchange(currencyPairs);
        } catch (Exception e){
            LOGGER.severe(e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode()).entity(new ErrorDto(ErrorCodes.INTERNAL_ERROR, "Error Connecting to external currency exchange.")).build();
        }
    }
    
}
