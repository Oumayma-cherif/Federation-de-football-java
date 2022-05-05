/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author oumaymacherif
 */
public class Club {
    private int id ;
    private String nomc , logo ,descr;

    public Club(int id, String nomc, String logo, String descr) {
        this.id = id;
        this.nomc = nomc;
        this.logo = logo;
        this.descr = descr;
    }

    public Club(String nomc, String logo, String descr) {
        this.nomc = nomc;
        this.logo = logo;
        this.descr = descr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomc() {
        return nomc;
    }

    public void setNomc(String nomc) {
        this.nomc = nomc;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }
    
    
    
    
    
}
