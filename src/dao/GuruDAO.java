/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.Guru;
import koneksi.Koneksi;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Serge
 */
public class GuruDAO {
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    ArrayList <Guru> listGuru;
    Guru guru;

    public GuruDAO() {
        con = Koneksi.getConnection();
    }

    public void setGuru() throws SQLException {
        guru.setNik(rs.getString("nik"));
        guru.setNama(rs.getString("nama"));
        guru.setJenkel(rs.getString("jenkel"));
        guru.setTmpLahir(rs.getString("tmplahir"));
        guru.setTglLahir(rs.getDate("tgllahir"));
        guru.setAlamat(rs.getString("alamat"));
        guru.setTelp(rs.getString("telp"));
        guru.setUser(rs.getString("user"));
        guru.setWaktu(rs.getDate("waktu"));
    }

    // CRUD

    public ArrayList<Guru> getListGuru () {
        try {
            listGuru = new ArrayList<>();
            ps = con.prepareStatement("SELECT * FROM guru", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = ps.executeQuery();
            rs.beforeFirst();
            while (rs.next()) {
                guru = new Guru();
                setGuru();

                listGuru.add(guru);
            }
        }
        catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return listGuru;
    }
    
    public DefaultTableModel getModelAllGuru() {
        Object[][] dataTable = new Object[getListGuru().size()][9];
        String jenkel;
        
        listGuru = getListGuru();
        for (int i = 0; i < listGuru.size(); i++) {
            dataTable[i][0] = listGuru.get(i).getNik();
            dataTable[i][1] = listGuru.get(i).getNama();
            dataTable[i][2] = listGuru.get(i).getJenkel();
            dataTable[i][3] = listGuru.get(i).getTmpLahir();
            dataTable[i][4] = listGuru.get(i).getTglLahir();
            dataTable[i][5] = listGuru.get(i).getAlamat();
            dataTable[i][6] = listGuru.get(i).getTelp();
            dataTable[i][7] = listGuru.get(i).getWaktu();
            dataTable[i][8] = listGuru.get(i).getUser();
        }
        String[] colNames = {"NIK", "Nama", "Jenis Kelamin", "Tempat Lahir", "Tanggal Lahir", "Alamat", "Telepon", "Waktu", "User"};
        DefaultTableModel model = new DefaultTableModel(dataTable, colNames);
        
        return model;
    }

    public Guru getGuruByNik (String nik) {
        guru = new Guru();
        try {
            ps = con.prepareStatement("SELECT * FROM guru WHERE nik = ?", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ps.setString(1, nik);
            rs = ps.executeQuery();
            rs.beforeFirst();
            if (rs.next()) {
                setGuru();
            }
            else {
                throw new SQLException("Guru tidak ditemukan");
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
            return guru = null;
        }
        return guru;
    }
    
    public void saveGuru(Guru guru) {
        String query = "SELECT * FROM guru WHERE nik = ?";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, guru.getNik());
            rs = ps.executeQuery();
            if (rs.next()) {
                query = "UPDATE guru SET nama = ?, jenkel = ?, tmpLahir = ?, tglLahir = ?, alamat = ?, telp = ?, user = ?, foto = ?" +
                "WHERE nik = ?";
            } else {
                query = "INSERT INTO guru (nama, jenkel, tmpLahir, tglLahir, alamat, telp, user, foto, nik) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            }
            ps = con.prepareStatement(query);
            ps.setString(1, guru.getNama());
            ps.setString(2, guru.getJenkel());
            ps.setString(3, guru.getTmpLahir());
            ps.setDate(4, guru.getTglLahir());
            ps.setString(5, guru.getAlamat());
            ps.setString(6, guru.getTelp());
            ps.setString(7, guru.getUser());
            ps.setString(8, guru.getFoto());
            ps.setString(9, guru.getNik());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void deleteGuru (String nik) {
        String query = "DELETE FROM guru WHERE nik = ?";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, nik);

            ps.executeUpdate();
            System.out.println("Data guru sudah terhapus");
        }
        catch (SQLException e) {
            System.out.println("Data guru tidak ditemukan dengan NIK = " + nik);
        }
    }
}
