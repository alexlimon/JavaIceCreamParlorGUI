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
public class XCashier extends XWorker{
    private int patience; 
    private boolean onBreak;
    
    
 public XCashier(String newname, long newID, long newcustomersserved,long newnumberscoops, double newmoneytaken, int newpatience, boolean newonBreak)
    {
        //super(name,ID,customersserved,numberscoops,moneytaken);
    name=newname;
    ID= newID;
    customersserved= newcustomersserved;
    numberscoops= newnumberscoops;
    moneytaken= newmoneytaken;
    patience=newpatience;
    onBreak= newonBreak;
    workertype=2;
    }

    public int getPatience() {
        return patience;
    }

    public void setPatience(int patience) {
        this.patience = patience;
    }

    public boolean isOnBreak() {
        return onBreak;
    }

    public void setOnBreak(boolean onBreak) {
        this.onBreak = onBreak;
    }
    
    
    
    
}
