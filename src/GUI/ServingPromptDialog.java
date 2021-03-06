/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author THETEAM!!
 */
public class ServingPromptDialog extends javax.swing.JDialog {

    private String servingtarget;
    private boolean keepgoing=true;
    private BananaSplitDialog bananasplitdialog;
    private IceCreamConeDialog icecreamconedialog;
    private IceCreamSundaeDialog icecreamsundaedialog;
    private IceCreamSodaDialog icecreamsodadialog;
    private RootBeerConfirmationD rootbdialog;
    
    boolean nuts=false;
    private String[] icecreams;
    private int[] toppingpositions;
    private int[] icecreampositions;
    private int singletopping;
    private Shop shopeditor;
    boolean firstserving= true;
    private int workerposition;
    private int customerposition;
    
    /**
     * Creates new form FlavorPromptDialog
     */
    public ServingPromptDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
          
        bananasplitdialog= new BananaSplitDialog(parent,true);
        icecreamconedialog = new IceCreamConeDialog(parent,true);
        icecreamsundaedialog = new IceCreamSundaeDialog(parent,true);
        icecreamsodadialog= new IceCreamSodaDialog(parent,true);
        rootbdialog = new RootBeerConfirmationD(parent,true);
        initComponents();
    }

    public void setWorkerposition(int workerposition) {
        this.workerposition = workerposition;
    }

    public void setCustomerposition(int customerposition) {
        this.customerposition = customerposition;
    }

    public void setShopeditor(Shop shopeditor) {
        this.shopeditor = shopeditor;
    }
public void setIceCreamArray(ArrayList <XIceCream> icecreamz){
    
    int i;
    this.icecreams= new String[icecreamz.size()];
    for(i=0;i<icecreamz.size();i++) icecreams[i]= icecreamz.get(i).getFlavor();
    
    
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(250, 200));

        jLabel1.setFont(new java.awt.Font("Segoe UI Symbol", 0, 14)); // NOI18N
        jLabel1.setText("Please choose a serving type:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Ice Cream Cone", "Ice Cream Sundae", "Banana Split", "Ice Cream Soda", "Root Beer Float" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton1.setText("Apply");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Done");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Cancel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Next");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jButton1)
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton4)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)
                                .addGap(18, 18, 18)
                                .addComponent(jButton3))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jLabel1)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      servingtarget= jComboBox1.getSelectedItem().toString();       // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       firstserving=true;
       
       dispose();







// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
      int i, conetype;
       servingtarget= jComboBox1.getSelectedItem().toString();   
      
        switch(servingtarget){
            
            case "Ice Cream Cone":
                icecreamconedialog.setIcecreamnames(icecreams);
                icecreamconedialog.setVisible(true);
                icecreampositions=icecreampositionCreator(icecreamconedialog.getIcecreamchosen());
                conetype = icecreamconedialog.getConetype();
                if(firstserving){
                        try {
                        shopeditor.newtransaction(customerposition, workerposition, icecreampositions, 1, conetype, false, null);
                             } 
                        catch (FileNotFoundException ex) {
                                Logger.getLogger(ServingPromptDialog.class.getName()).log(Level.SEVERE, null, ex);
                                } 
                        catch (NotEnoughIceCreamException ex) {
                        Logger.getLogger(ServingPromptDialog.class.getName()).log(Level.SEVERE, null, ex);
                        }
                firstserving=false;
                }
                else{
                        try {
                        shopeditor.addservingct(icecreampositions, 1, conetype, false, null);
                        } 
                        catch (FileNotFoundException ex) {
                            Logger.getLogger(ServingPromptDialog.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (NotEnoughIceCreamException ex) {
              Logger.getLogger(ServingPromptDialog.class.getName()).log(Level.SEVERE, null, ex);
          }
                                }
                    
              
                break;
            case "Ice Cream Sundae":
                icecreamsundaedialog.setIcecreams(icecreams);
                icecreamsundaedialog.setVisible(true);
                icecreampositions = icecreampositionCreator(icecreamsundaedialog.getIcecreamchosen());
                singletopping = icecreamsundaedialog.getTopping();
                nuts = icecreamsundaedialog.isNuts();
                if(firstserving){
                    
          try {
              shopeditor.newtransaction(customerposition, workerposition, icecreampositions, 2, singletopping, nuts, null);
          } catch (FileNotFoundException ex) {
              Logger.getLogger(ServingPromptDialog.class.getName()).log(Level.SEVERE, null, ex);
          } catch (NotEnoughIceCreamException ex) {
              Logger.getLogger(ServingPromptDialog.class.getName()).log(Level.SEVERE, null, ex);
          }
                  firstserving=false;  
                }
                
                else{
          try {
              shopeditor.addservingct(icecreampositions, 2, singletopping, nuts, null);
          } catch (FileNotFoundException ex) {
              Logger.getLogger(ServingPromptDialog.class.getName()).log(Level.SEVERE, null, ex);
          } catch (NotEnoughIceCreamException ex) {
              Logger.getLogger(ServingPromptDialog.class.getName()).log(Level.SEVERE, null, ex);
          }
                    
                }
                
                break;
            case "Banana Split":
                bananasplitdialog.setIceCreamz(icecreams);
                bananasplitdialog.setVisible(true);
                toppingpositions= bananatoppingCreator(bananasplitdialog.getBsyrup());
                icecreampositions= icecreampositionCreator(bananasplitdialog.getBicecreams());
                if(firstserving){
               
                        try {
                               shopeditor.newtransaction(customerposition, workerposition, icecreampositions, 3, 0, false, toppingpositions);
                            } catch (FileNotFoundException ex) {
                                    Logger.getLogger(ServingPromptDialog.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (NotEnoughIceCreamException ex) {
                                    Logger.getLogger(ServingPromptDialog.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            firstserving= false;
                }
                else
                      try {
                        shopeditor.addservingct(icecreampositions,3,0,false,toppingpositions);
                            } 
                      catch (FileNotFoundException ex) {
                         Logger.getLogger(ServingPromptDialog.class.getName()).log(Level.SEVERE, null, ex);
                           } catch (NotEnoughIceCreamException ex) {
          Logger.getLogger(ServingPromptDialog.class.getName()).log(Level.SEVERE, null, ex);
      }
               break;
                
            case "Ice Cream Soda":
                icecreamsodadialog.setIcecreams(icecreams);
                icecreamsodadialog.setVisible(true);
                icecreampositions = icecreampositionCreator(icecreamsodadialog.getIcecreamschosen());
                if(firstserving){
                        try {
                            shopeditor.newtransaction(customerposition, workerposition, icecreampositions, 4, 0, false, null);
                            } 
                        catch (FileNotFoundException ex) {
                            Logger.getLogger(ServingPromptDialog.class.getName()).log(Level.SEVERE, null, ex);
                            } 
                        catch (NotEnoughIceCreamException ex) {
                        Logger.getLogger(ServingPromptDialog.class.getName()).log(Level.SEVERE, null, ex);
                            }
//                        firstserving=false;
                }
                else{
                    
                    
                    try {
                        shopeditor.addservingct(icecreampositions, 4, 0, false, null);
                         } 
                    catch (FileNotFoundException ex) {
                        Logger.getLogger(ServingPromptDialog.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (NotEnoughIceCreamException ex) {
              Logger.getLogger(ServingPromptDialog.class.getName()).log(Level.SEVERE, null, ex);
          }
                }
                    
                  
                
                
                break;
                
            case "Root Beer Float":
                if(firstserving)
                {
                    try {
                        shopeditor.newtransaction(customerposition,workerposition,null,5,0,false,null);
                        } 
                    catch (FileNotFoundException ex) {
                         Logger.getLogger(ServingPromptDialog.class.getName()).log(Level.SEVERE, null, ex);
                            } 
                    catch (NotEnoughIceCreamException ex) {
                           Logger.getLogger(ServingPromptDialog.class.getName()).log(Level.SEVERE, null, ex);
                            }
                    
                        firstserving=false;   
                         }
                else{
                    
                         try {
                                shopeditor.addservingct(null,5,0, false, null);
                             } 
                            catch (FileNotFoundException ex) {
                        Logger.getLogger(ServingPromptDialog.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (NotEnoughIceCreamException ex) {
              Logger.getLogger(ServingPromptDialog.class.getName()).log(Level.SEVERE, null, ex);
          }
                
                        }
                 
                    rootbdialog.setVisible(true);
                    break;
        }
           
          
          
          
          
          
          
          
      
       
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ServingPromptDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServingPromptDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServingPromptDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServingPromptDialog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ServingPromptDialog dialog = new ServingPromptDialog(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    public String getServingtarget() {
        return servingtarget;
    }

   

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables

public int[] icecreampositionCreator(String[] icecreamschosen){
    int i,currenticecream=0;
    int [] icecreampositions= new int[icecreamschosen.length];
   
    for(i=0;i<shopeditor.getIcecreamz().size() && currenticecream<icecreamschosen.length; i++) {
       
        if(icecreamschosen[currenticecream].equals(shopeditor.getIcecreamz().get(i).getFlavor())){
           
            icecreampositions[currenticecream]= i;
            currenticecream +=1;
            
            }
        } 
    
    return icecreampositions;
 }

public int[] bananatoppingCreator(String[] bananatoppings){
    int i;
    int toppingpositions[]= new int[bananatoppings.length];
    for(i=0;i<bananatoppings.length;i++){
        switch(bananatoppings[i]){
            case("Strawberry"):
                toppingpositions[i]=0;
                break;
            case("Chocolate Syrup"):
                toppingpositions[i]=1;
                break;
            case("Marshmellow cream"):
                toppingpositions[i]=2;
                break;
            case("Pineapple"):
                toppingpositions[i]=3;
                break;
            case("Ketchup"):
                toppingpositions[i]=4;
                break;
            case("Mustard"):
                toppingpositions[i]=5;
                break;
            case("Pickle Relish"):
                toppingpositions[i]=6;
                break;
        }
    }
    
    return toppingpositions;
            
  }
        
        
 }
    
    
    
    
    
    
    
    











