/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HungrySquirrel;

/**
 *
 * @author Luke
 */
public class Peanut extends Nuts {
    
    Peanut()
    {
        nutritionPoints = 10;
        create();
    }
    
    @Override
    public char getSymbol()
    {
        symbol = 'P';
        return symbol;
    }
}
