/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import koneksi.Koneksi;
import model.Cabeka;
import model.Guru;
import model.Siswa;

/**
 *
 * @author Serge
 */
public class CabekaDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    ArrayList<Cabeka> listCabeka;
    ArrayList<Siswa> listSiswa;
    ArrayList<Guru> listGuru;
    
    Cabeka cabeka;
    Siswa siswa;
    Guru guru;
    
    public CabekaDAO () {
        con = Koneksi.getConnection();
    }
    
    public ArrayList<Cabeka> getListCabeka(String nis, Date tgl) {
        String query = "SELECT * FROM cabekaView WHERE nis = ?";
        if (tgl != null) query += " AND tgl = ?";
        query += " ORDER BY tgl"; 
        try {
            listCabeka = new ArrayList<>();
            ps = con.prepareStatement(query);
            ps.setString(1, nis);
            if (tgl != null) ps.setDate(2, tgl);
            rs = ps.executeQuery();
            while (rs.next()) {
                cabeka = new Cabeka();
                cabeka.setNis(rs.getString("nis"));
                cabeka.setTgl(rs.getDate("tgl"));
                cabeka.setPermasalahan(rs.getString("permasalahan"));
                cabeka.setSolusi(rs.getString("solusi"));
                cabeka.setKehadiran(rs.getString("kehadiran"));
                cabeka.setNik(rs.getString("petugas_bk"));
                
                guru = new Guru();
                guru.setNama(rs.getString("nama_pengampu"));
                
                siswa = new Siswa();
                siswa.setNama(rs.getString("nama_siswa"));
                
                cabeka.setGuru(guru);
                cabeka.setSiswa(siswa);
                
                listCabeka.add(cabeka);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return listCabeka;
    }
    
    public Cabeka getCabeka(String nis, Date tgl) {
        String query = "SELECT * FROM cabekaview WHERE nis = ? AND tgl = ?";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, nis);
            ps.setDate(2, tgl);
            rs = ps.executeQuery();
            if (rs.next()) {
                cabeka = new Cabeka();
                cabeka.setNis(rs.getString("nis"));
                cabeka.setTgl(rs.getDate("tgl"));
                cabeka.setPermasalahan(rs.getString("permasalahan"));
                cabeka.setSolusi(rs.getString("solusi"));
                cabeka.setKehadiran(rs.getString("kehadiran"));
                cabeka.setNik(rs.getString("petugas_bk"));

                guru = new Guru();
                guru.setNama(rs.getString("nama_pengampu"));

                siswa = new Siswa();
                siswa.setNama(rs.getString("nama_siswa"));

                cabeka.setGuru(guru);
                cabeka.setSiswa(siswa);
            }
        } catch (SQLException e) {
            System.out.println(e);
            cabeka = null;
        }
        return cabeka;
    }
    
    public DefaultTableModel getModelCabeka(String nis, Date tgl) {
        listCabeka = getListCabeka(nis, tgl);
        Object[][] dataTable = new Object[listCabeka.size()][8];
        
        for (int i = 0; i < listCabeka.size(); i++) {
            dataTable[i][0] = listCabeka.get(i).getNis();
            dataTable[i][1] = listCabeka.get(i).getSiswa().getNama();
            dataTable[i][2] = listCabeka.get(i).getTgl();
            dataTable[i][3] = listCabeka.get(i).getPermasalahan();
            dataTable[i][4] = listCabeka.get(i).getSolusi();
            dataTable[i][5] = listCabeka.get(i).getKehadiran();
            dataTable[i][6] = listCabeka.get(i).getNik();
            dataTable[i][7] = listCabeka.get(i).getGuru().getNama();
        }
        String[] colNames = {"NIS", "Nama", "Tanggal", "Permasalahan", "Solusi", "Kehadiran", "Pengampu"};
        DefaultTableModel model = new DefaultTableModel(dataTable, colNames);
        return model;
    }
    
    public void saveCabeka(Cabeka cabeka) {
        String query = "SELECT * FROM cabeka WHERE nis = ? AND tgl = ?";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, cabeka.getNis());
            ps.setDate(2, cabeka.getTgl());
            rs = ps.executeQuery();
            
            if (rs.next()) {
                query = "UPDATE cabeka SET permasalahan = ?, solusi = ?, kehadiran = ?, petugas_bk = ? "
                        + "WHERE nis = ? AND tgl = ?";
            } else {
                query = "INSERT INTO cabeka (permasalahan, solusi, kehadiran, petugas_bk, nis, tgl) "
                        + "VALUES (?, ?, ?, ?, ?, ?)";
            }
            ps = con.prepareStatement(query);
            ps.setString(1, cabeka.getPermasalahan());
            ps.setString(2, cabeka.getSolusi());
            ps.setString(3, cabeka.getKehadiran());
            ps.setString(4, cabeka.getNik());
            ps.setString(5, cabeka.getNis());
            ps.setDate(6, cabeka.getTgl());
            
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public void deleteCabeka(String nis, Date tgl) {
        String query = "DELETE FROM cabeka WHERE nis = ? AND tgl = ?";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, nis);
            ps.setDate(2, tgl);
            
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public DefaultTableModel getLookSiswa() {
        DefaultTableModel modelSiswa = new DefaultTableModel();
        try {
            listSiswa = new ArrayList<>();
            ps = con.prepareStatement("SELECT nis, nama FROM siswa", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = ps.executeQuery();
            rs.beforeFirst();
            while (rs.next()) {
                siswa = new Siswa();
                siswa.setNis(rs.getString("nis"));
                siswa.setNama(rs.getString("nama"));
                listSiswa.add(siswa);
            }
        } catch (SQLException e) {
            System.out.println(e);
            listSiswa = null;
        }
        
        Object[][] dataTable = new Object[listSiswa.size()][2];
        for (int i = 0; i < listSiswa.size(); i++) {
            dataTable[i][0] = listSiswa.get(i).getNis();
            dataTable[i][1] = listSiswa.get(i).getNama();
        }
        String[] colNames = {"NIS", "Nama"};
        modelSiswa = new DefaultTableModel(dataTable, colNames);
        return modelSiswa;
    }
    
    public DefaultTableModel getLookGuru() {
        DefaultTableModel modelGuru = new DefaultTableModel();
        try {
            listGuru = new ArrayList<>();
            ps = con.prepareStatement("SELECT nik, nama FROM guru", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = ps.executeQuery();
            rs.beforeFirst();
            while (rs.next()) {
                guru = new Guru();
                guru.setNik(rs.getString("nik"));
                guru.setNama(rs.getString("nama"));
                listGuru.add(guru);
            }
        } catch (SQLException e) {
            System.out.println(e);
            listGuru = null;
        }
        
        Object[][] dataTable = new Object[listGuru.size()][2];
        for (int i = 0; i < listGuru.size(); i++) {
            dataTable[i][0] = listGuru.get(i).getNik();
            dataTable[i][1] = listGuru.get(i).getNama();
        }
        String[] colNames = {"NIK", "Nama"};
        modelGuru = new DefaultTableModel(dataTable, colNames);
        return modelGuru;
    }
}
