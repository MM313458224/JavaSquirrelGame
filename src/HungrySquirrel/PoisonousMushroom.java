/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HungrySquirrel;

/**
 *
 * @author Luke
 */
public class PoisonousMushroom extends Nuts{
    
    PoisonousMushroom()
    {
       nutritionPoints = -15;
       create();
    }

    @Override
    public char getSymbol()
    {
        symbol = 'M';
        return symbol;
    }
    
}
