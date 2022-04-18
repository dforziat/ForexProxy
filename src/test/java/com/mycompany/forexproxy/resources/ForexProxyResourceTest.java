
package com.mycompany.forexproxy.resources;

import com.mycompany.forexproxy.constant.ErrorCodes;
import com.mycompany.forexproxy.dto.ErrorDto;
import java.util.Arrays;
import java.util.List;
import javax.ws.rs.core.Response;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author daniel forziat
 */
public class ForexProxyResourceTest {

    
    
    public ForexProxyResourceTest() {
    }

    /**
     * Test of getExchangeRate method, of class ForexProxyResource.
     */
    @Test
    public void testGetExchangeRateNullList() {
        List<String> currencyPairs = null;
        ForexProxyResource instance = new ForexProxyResource();
        Response expResult = Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(new ErrorDto(ErrorCodes.INPUT_ERROR, "Currencies are empty.")).build();
        Response result = instance.getExchangeRate(currencyPairs);
        assertEquals(expResult.getEntity().toString(), result.getEntity().toString());
    }

    @Test
    public void testGetExchangeRateEmptyList() {
        List<String> currencyPairs = null;
        ForexProxyResource instance = new ForexProxyResource();
        Response expResult = Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(new ErrorDto(ErrorCodes.INPUT_ERROR, "Currencies are empty.")).build();
        Response result = instance.getExchangeRate(currencyPairs);
        assertEquals(expResult.getEntity().toString(), result.getEntity().toString());
    }

    @Test
    public void testGetExchangeRateIncorrectDigits() {
        String pair = "USDJY";
        List<String> currencyPairs = Arrays.asList(pair);
        ForexProxyResource instance = new ForexProxyResource();
        Response expResult = Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(new ErrorDto(ErrorCodes.INPUT_ERROR, "Currency pair:  " + pair + " + is invalid.")).build();
        Response result = instance.getExchangeRate(currencyPairs);
        assertEquals(expResult.getEntity().toString(), result.getEntity().toString());
    }

    @Test
    public void testGetExchangeRateMatchingPair() {
        String pair = "USDUSD";
        List<String> currencyPairs = Arrays.asList(pair);
        ForexProxyResource instance = new ForexProxyResource();
        Response expResult = Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(new ErrorDto(ErrorCodes.INPUT_ERROR, "Currency codes are the same: " + pair)).build();
        Response result = instance.getExchangeRate(currencyPairs);
        assertEquals(expResult.getEntity().toString(), result.getEntity().toString());
    }

    @Test
    public void testGetExchangeRateIncorrectFirstCode() {
        String pair = "USJJPY";
        String firstCurrency = "USJ";
        List<String> currencyPairs = Arrays.asList(pair);
        ForexProxyResource instance = new ForexProxyResource();
        Response expResult = Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(new ErrorDto(ErrorCodes.INPUT_ERROR, firstCurrency + " is an invalid currency")).build();
        Response result = instance.getExchangeRate(currencyPairs);
        assertEquals(expResult.getEntity().toString(), result.getEntity().toString());
    }

    @Test
    public void testGetExchangeRateIncorrectSecondCode() {
        String pair = "USDJPP";
        String secondCurrency = "JPP";
        List<String> currencyPairs = Arrays.asList(pair);
        ForexProxyResource instance = new ForexProxyResource();
        Response expResult = Response.status(Response.Status.BAD_REQUEST.getStatusCode()).entity(new ErrorDto(ErrorCodes.INPUT_ERROR, secondCurrency + " is an invalid currency")).build();
        Response result = instance.getExchangeRate(currencyPairs);
        assertEquals(expResult.getEntity().toString(), result.getEntity().toString());
    }

    //@Test
    public void testGetExchangeRateSuccessfulResponse() {
        String pair = "USDJPY";
        List<String> currencyPairs = Arrays.asList(pair);
        ForexProxyResource instance = new ForexProxyResource();
        int expResult = 200;
        Response result = instance.getExchangeRate(currencyPairs);
        assertEquals(expResult, result.getStatus());
    }

}
