/**
 * Created by Arga Ghulam Ahmad on 3/11/2017.
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Kelas ini merepresentasikan Pemain yang ada pada Tim.
 * Informasi utama yang akan Anda simpan ialah nomorPemain dan nama namaPemain.
 * Selain itu, Kelas Pemain juga menyimpan informasi jumlahGol, jumlahPelanggaran, jumlahKartuKuning, dan jumlahKartuMerah.
 */
public class Pemain {
    private String namaPemain = "";
    private int nomorPemain = 0;
    private String namaTim = "";
    private int jumlahGol = 0;
    private int jumlahPelanggaran = 0;
    private int jumlahKartuKuning = 0;
    private int jumlahKartuMerah = 0;

    private Map<String, Integer>  kartukuningPemainMatch = new HashMap<String, Integer>();    //kartukuning yang dimiliki pemain dalam setiap match

    public Pemain(String namaPemain, int nomorPemain, String namaTim) {
        this.namaPemain = namaPemain;
        this.nomorPemain = nomorPemain;
        this.namaTim = namaTim;
    }

    public String getNamaPemain() {
        return namaPemain;
    }

    public void setNamaPemain(String namaPemain) {
        this.namaPemain = namaPemain;
    }

    public int getNomorPemain() {
        return nomorPemain;
    }

    public void setNomorPemain(int nomorPemain) {
        this.nomorPemain = nomorPemain;
    }

    public int getJumlahGol() {
        return jumlahGol;
    }

    public void setJumlahGol(int jumlahGol) {
        this.jumlahGol = jumlahGol;
    }

    public int getJumlahPelanggaran() {
        return jumlahPelanggaran;
    }

    public void setJumlahPelanggaran(int jumlahPelanggaran) {
        this.jumlahPelanggaran = jumlahPelanggaran;
    }

    public int getJumlahKartuKuning() {
        return jumlahKartuKuning;
    }

    public void setJumlahKartuKuning(int jumlahKartuKuning) {
        this.jumlahKartuKuning = jumlahKartuKuning;
    }

    public int getJumlahKartuMerah() {
        return jumlahKartuMerah;
    }

    public void setJumlahKartuMerah(int jumlahKartuMerah) {
        this.jumlahKartuMerah = jumlahKartuMerah;
    }

    public String getNamaTim() {
        return namaTim;
    }

    public void setNamaTim(String namaTim) {
        this.namaTim = namaTim;
    }

    public Map<String, Integer> getKartukuningPemainMatch() {
        return kartukuningPemainMatch;
    }

    public void setKartukuningPemainMatch(Map<String, Integer> kartukuningPemainMatch) {
        this.kartukuningPemainMatch = kartukuningPemainMatch;
    }

    /**
     * Pemain mencetak gol.
     */
    public void gol() {
        setJumlahGol(getJumlahGol() + 1);
    }

    /**
     * Pemain menerima kartu kuning.
     */
    public void kartuKuning() {
        setJumlahKartuKuning(getJumlahKartuKuning() + 1);
    }

    /**
     * Pemain menerima kartu merah.
     * @param pinalty boolean sebagai indikator darimanakah perintah kartu merah berasal apakah dari pinalty atau perintah kartu merah langsung.
     */
    public void kartuMerah(boolean pinalty) {
        if (pinalty) {
            setJumlahKartuMerah(getJumlahKartuMerah()+1);
        } else {
            setJumlahKartuMerah(getJumlahKartuMerah() + 1);
            setJumlahPelanggaran(getJumlahPelanggaran() + 1);
        }
    }

    /**
     * Pemain melakukan pelanggaran.
     */
    public void pelanggaran() {
        setJumlahPelanggaran(getJumlahPelanggaran() + 1);
    }

    /**
     * Pinalty pelanggaran bila sudah mendapat dua kartu kuning.
     * @return boolean sebagai indikator bahwa pemain mendapat kartu merah akibat pinalty pelanggaran.
     * @param match merupakan toString dari sebuah match, sehingga dapat diketahui apakah match masih sama apa tidak.
     */
    public boolean pinaltyPelanggaran(String match) {
        boolean pinalty = true;
        if (!getKartukuningPemainMatch().containsKey(match)) {
            getKartukuningPemainMatch().put(match, 1);
        } else {
            getKartukuningPemainMatch().put(match, 2);
        }

        if (getKartukuningPemainMatch().get(match) == 2) {
            kartuMerah(pinalty);
            return true;
        }
        return false;
    }
}
