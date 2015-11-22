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
public class NotEnoughIceCreamException extends Exception {
    public String toString(){
        
        return "There is not enough of this type of icecream!";
    }
    
}
