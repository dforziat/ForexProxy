/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.forexproxy.logic;

import java.util.Arrays;
import java.util.List;
import javax.ws.rs.core.Response;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author bombe
 */
public class ForexProxyLogicTest {

    public ForexProxyLogicTest() {
    }

    /**
     * Test of execute method, of class ForexProxyLogic.
     */
    @Test
    public void testExecute() {
        String pair = "USDJPY";
        List<String> currencyPairs = Arrays.asList(pair);
        ForexProxyLogic instance = new ForexProxyLogic();
        Response result = instance.execute(currencyPairs);
        assertNotNull(result);
    }

}
