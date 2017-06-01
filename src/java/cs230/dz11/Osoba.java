package cs230.dz11;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Filip
 */
@Named
@SessionScoped
public class Osoba implements Serializable {

    private String brojIndeksa;
    private String ime;
    private String status;
    private String tradicionalni;
    private String uloga;
    

    public String getBrojIndeksa() {
        return brojIndeksa;
    }

    public void setBrojIndeksa(String brojIndeksa) {
        this.brojIndeksa = brojIndeksa;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTradicionalni() {
        return tradicionalni;
    }

    public void setTradicionalni(String tradicionalni) {
        this.tradicionalni = tradicionalni;
    }

    public String getUloga() {
        return uloga;
    }

    public void setUloga(String uloga) {
        this.uloga = uloga;
    }

}
