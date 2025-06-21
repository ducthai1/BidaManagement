/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bidamanagement;

public class DataHolderSimpleBill {
    
    private static DataHolderSimpleBill instanceSimpleBill;
    
    // Luu trang thai cac o du lieu
    private String inputDataNameSimpleBill;
    private String inputDataSimpleBill;
    private String inputColorDataNameSimpleBill;
    // Luu trang thai cac button
    private boolean printBtnEnabledSimpleBill;
        
    private DataHolderSimpleBill() {
        inputDataSimpleBill = "";
        inputDataNameSimpleBill = "";
    }
    
    public static synchronized DataHolderSimpleBill getInstanceSimpleBill() {
        if (instanceSimpleBill == null) {
            instanceSimpleBill = new DataHolderSimpleBill();
        }
        return instanceSimpleBill;
    }
    
    public String getInputColorDataNameSimpleBill() {
        return inputColorDataNameSimpleBill;
    }
    
    public void setInputColorDataNameSimpleBill(String inputColorDatanameSimpleBill) {
        this.inputColorDataNameSimpleBill = inputColorDatanameSimpleBill;
    }

    public String getInputDataNameSimpleBill() {
        return inputDataNameSimpleBill;
    }

    public void setInputDataNameSimpleBill(String inputDatanameSimpleBill) {
        this.inputDataNameSimpleBill = inputDatanameSimpleBill;
    }

    public boolean isPrintBtnEnabledSimpleBill() {
        return printBtnEnabledSimpleBill;
    }

    public void setPrintBtnEnabledSimpleBill(boolean printBtnEnabledSimpleBill) {
        this.printBtnEnabledSimpleBill = printBtnEnabledSimpleBill;
    }
    
    private boolean addBtnEnableSimpleBill = false;
    
    public boolean isAddBtnEnabledSimpleBill() {
        return addBtnEnableSimpleBill;
    }

    public void setAddBtnEnabledSimpleBill(boolean AddBtnEnableSimpleBill) {
        this.addBtnEnableSimpleBill = AddBtnEnableSimpleBill;
    }
}
