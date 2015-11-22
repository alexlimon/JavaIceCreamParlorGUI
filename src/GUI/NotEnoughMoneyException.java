/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author Alex
 */
public class NotEnoughMoneyException extends Exception {
    @Override
    public String toString(){
        
        return "Whoops! The customer doesn't have enough cash for this order, no worries pay it in credit next time using Poor...";
        
        
        
    }
    
}
