/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author Lacherois
 */
public class XDataNode {
    
    private String name;
    private int amount;
    private int height;
    
    public XDataNode(){
        
        name="";
        amount= -1;
        height=0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
    
    public String ToSring(){
        String result;
        result=String.format("%s,%d", this.getName(), this.getAmount());
        return result;
    } 
    
    
}
