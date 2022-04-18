
package com.mycompany.forexproxy.resources;

import com.mycompany.forexproxy.constant.Currencies;
import com.mycompany.forexproxy.constant.ErrorCodes;
import com.mycompany.forexproxy.dto.ErrorDto;
import com.mycompany.forexproxy.logic.ForexProxyLogic;
import java.util.List;
import java.util.logging.Logger;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

/**
 *
 * @author daniel.forziat
 */
@Path("forexproxy")
public class ForexProxyResource {
    
    private static final Logger LOGGER = Logger.getLogger(ForexProxyResource.class.getName());
    
    @GET
    @Path("exchangerate")
    public Response getExchangeRate(@QueryParam("currencyPair") List<String> currencyPairs) {
        LOGGER.info("Get Exchange Rate Process START.");
        LOGGER.info(String.format("Requested currency pairs: %s" , currencyPairs));
        //Check input from api
        Response response = validateInput(currencyPairs);
        //Check again to make sure input is still valid. 
        if (response.getStatus() == Response.Status.OK.getStatusCode()) {
            //Call business logic
            ForexProxyLogic logic = new ForexProxyLogic();
            response = logic.execute(currencyPairs);
        }
        LOGGER.info(String.format("Get Exchange Rate Process END. Response Code: %d", response.getStatus()));
        return response;
    }

    private Response validateInput(List<String> currencyPairs) {
        if (currencyPairs == null || currencyPairs.isEmpty()) {
            LOGGER.warning("Currency Pair list is empty");
            return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(new ErrorDto(ErrorCodes.INPUT_ERROR, "Currencies are empty.")).build();
        }
        for (String pair : currencyPairs) {
            //Assuming all currency codes are 3 digits and all pairs are 6 digits.
            if (pair.length() != Currencies.PAIR_LENGTH) {
                LOGGER.warning(String.format("Currency Pair %s length is not 6", pair.length()));
                return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(new ErrorDto(ErrorCodes.INPUT_ERROR, "Currency pair:  " + pair + " + is invalid.")).build();
            }

            String firstCurrency = pair.substring(0, 3);
            String secondCurrency = pair.substring(3);
            //Compare to the list of available currencies. 
            //This is a little slow inside of a for-loop, but want to print different errors so it's easier to understand. 
            if (firstCurrency.equals(secondCurrency)) {
                LOGGER.warning("Currency Pair is the same currency");
                return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(new ErrorDto(ErrorCodes.INPUT_ERROR, "Currency codes are the same: " + pair)).build();
            }
            if (!Currencies.AVAILIABLE_CURRENCY_LIST.contains(firstCurrency)) {
                LOGGER.warning(String.format("Currency %s is not a valid currency", firstCurrency));
                return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(new ErrorDto(ErrorCodes.INPUT_ERROR, firstCurrency + " is an invalid currency")).build();
            } else if (!Currencies.AVAILIABLE_CURRENCY_LIST.contains(secondCurrency)) {
                LOGGER.warning(String.format("Currency %s is not a valid currency", secondCurrency));
                return Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(new ErrorDto(ErrorCodes.INPUT_ERROR, secondCurrency + " is an invalid currency")).build();
            }

        }
        return Response.ok().build();
    }

}
