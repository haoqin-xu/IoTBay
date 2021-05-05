/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uts.isd.model;

import java.io.Serializable;

/**
 *
 * @author 61452
 */
public class Invoice implements Serializable{
    private String recipientemail;
    private String content;

    public Invoice(String recipientemail, String content) {
        this.recipientemail = recipientemail;
        this.content = content;
    }

    public String getRecipientemail() {
        return recipientemail;
    }

    public String getContent() {
        return content;
    }

    public void setRecipientemail(String recipientemail) {
        this.recipientemail = recipientemail;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
}
