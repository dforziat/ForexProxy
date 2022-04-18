
package com.mycompany.forexproxy.constant;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author daniel.forziat
 */
public final class Currencies {
    
      /**
       * List of available currencies that can searched. 
       */
      public static final List<String> AVAILIABLE_CURRENCY_LIST = Arrays.asList("AUD", "CAD", "CHF", "EUR", "GBP", "NZD", "JPY", "SGD", "USD");
      
     /**
      * Pair length
      */
      public static final int PAIR_LENGTH = 6;
      
      /**
       * Currency Code Length
       */
      public static final int CURRENCY_CODE_LENGTH = 3;
  
}
