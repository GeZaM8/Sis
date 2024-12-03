/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author Serge
 */
public class Guru {
    private String nik;
    private String nama;
    private String tmpLahir;
    private Date tglLahir;
    private String alamat;
    private String jenkel;
    private String telp;
    private String user;
    private Date waktu;
    private String foto;
    
    public Guru (String nik, String nama, String tmpLahir, Date tglLahir, String alamat, String jenkel, String telp, String user, String foto) {
        this.nik = nik;
        this.nama = nama;
        this.tmpLahir = tmpLahir;
        this.tglLahir = tglLahir;
        this.alamat = alamat;
        this.jenkel = jenkel;
        this.telp = telp;
        this.user = user;
        this.foto = foto;
    }
    
    public Guru(){}

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTmpLahir() {
        return tmpLahir;
    }

    public void setTmpLahir(String tmpLahir) {
        this.tmpLahir = tmpLahir;
    }

    public Date getTglLahir() {
        return tglLahir;
    }

    public void setTglLahir(Date tglLahir) {
        this.tglLahir = tglLahir;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJenkel() {
        return jenkel;
    }

    public void setJenkel(String jenkel) {
        this.jenkel = jenkel;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getWaktu() {
        return waktu;
    }

    public void setWaktu(Date waktu) {
        this.waktu = waktu;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
