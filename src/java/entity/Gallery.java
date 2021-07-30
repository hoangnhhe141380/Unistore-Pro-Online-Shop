/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Riel
 */
public class Gallery {

    private int gid;
    private String gimage;

    public Gallery(int gid, String gimage) {
        this.gid = gid;
        this.gimage = gimage;
    }

    public Gallery() {
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getGimage() {
        return gimage;
    }

    public void setGimage(String gimage) {
        this.gimage = gimage;
    }

}
