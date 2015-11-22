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
public class XStocker extends XWorker {
    private int stamina;
    private boolean onBreak;
    private int workertype;
    
    
    
public XStocker(String newname, long newID, long newcustomersserved,long newnumberscoops,double newmoneytaken, int newstamina, boolean newonBreak){
    
    //super(newname,newID,newcustomersserved,newnumberscoops,newmoneytaken);
    name=newname;
    ID= newID;
    customersserved= newcustomersserved;
    numberscoops= newnumberscoops;
    moneytaken= newmoneytaken;
    stamina=newstamina;
    onBreak= newonBreak;
    workertype=1;
}

    public int getWorkertype() {
        return workertype;
    }

    public void setWorkertype(int workertype) {
        this.workertype = workertype;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public boolean isOnBreak() {
        return onBreak;
    }

    public void setOnBreak(boolean onBreak) {
        this.onBreak = onBreak;
    }















}
