/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package HungrySquirrel;

/**
 *
 * @author Luke
 */
public class Almond extends Nuts {

    Almond()
    {
        nutritionPoints = 5;
        create();
    }
    
    @Override
    public char getSymbol()
    {
        symbol = 'A';
        return symbol;
    }
    
}
