/**
 * Created by Arga Ghulam Ahmad on 3/11/2017.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Kelas Liga menyimpan data klasemen yaitu array dari Tim yang berurutan (sorted) yang urutannya akan bergantung pada posisi dalam klasemen.
 * Setiap sebuah pertandingan selesai, array ini akan di-update berdasarkan poin yang diperoleh masing-masing tim atau selisih gol terbanyak
 * jika ada dua tim yang memiliki poin sama. */

public class Liga {
    private boolean finish = false;                                 //indikator apakah liga telah selesai
    private int currentMatch = 0;                                    //indikator match ke berapa

    private String namaLiga = "";
    private String kodeLiga = "";
    private int tahunLiga = 0;

    private ArrayList<Tim> klasemenLiga = new ArrayList<Tim>();     //arraylist yang berisi tim liga secara urut berdasrkan poin
    private ArrayList<Match> matchLiga = new ArrayList<Match>();       //arraylist yang berisi pertandingan pada suatu liga
    private ArrayList<Pemain> topPlayer = new ArrayList<Pemain>();  //arraylist yang berisi pemain liga secara urut berdasarkan jumlah gol

    public Liga(String namaLiga, String kodeLiga, int tahunLiga) {
        this.namaLiga = namaLiga;
        this.kodeLiga = kodeLiga;
        this.tahunLiga = tahunLiga;
    }

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    public int getCurrentMatch() {
        return currentMatch;
    }

    public void setCurrentMatch(int currentMatch) {
        this.currentMatch = currentMatch;
    }

    public String getNamaLiga() {
        return namaLiga;
    }

    public void setNamaLiga(String namaLiga) {
        this.namaLiga = namaLiga;
    }

    public ArrayList<Tim> getKlasemenLiga() {
        return klasemenLiga;
    }

    public void setKlasemenLiga(ArrayList<Tim> klasemenLiga) {
        this.klasemenLiga = klasemenLiga;
    }

    public ArrayList<Match> getMatchLiga() {
        return matchLiga;
    }

    public void setMatchLiga(ArrayList<Match> matchLiga) {
        this.matchLiga = matchLiga;
    }

    public ArrayList<Pemain> getTopPlayer() {
        return topPlayer;
    }

    public void setTopPlayer(ArrayList<Pemain> topPlayer) {
        this.topPlayer = topPlayer;
    }

    public String getKodeLiga() {
        return kodeLiga;
    }

    public void setKodeLiga(String kodeLiga) {
        this.kodeLiga = kodeLiga;
    }

    public int getTahunLiga() {
        return tahunLiga;
    }

    public void setTahunLiga(int tahunLiga) {
        this.tahunLiga = tahunLiga;
    }

    /**
     * Pesan error karena tim atau pemain yang dicari tidak ditemukan.
     * @param namaTim namaTim yang tidak dapat ditemukan di pertandingan yang berlangsung.
     */
    public void errorNotFindTeam (String namaTim) {
        System.out.println("ERROR: Tim " + namaTim + " sedang tidak bertanding atau salah tim!");
        System.out.println();
    }

    /**
     * Pesan error bila input invalid.
     */
    private void inputErrorMsg() {
        System.out.println("ERROR: Input invalid! Masukkan input yang valid!");
        System.out.println();
    }

    /**
     * Mengisi secara random tim yang ada di liga.
     * @param jumlahTim jumlah tim yang akan diinisiasi dalam objek liga.
     */
    public void initTeam(int jumlahTim) {
        String[] arrayNamaTim = {"Gajah", "Rusa", "Belalang", "Kodok", "Kucing", "Tupai", "Rajawali", "Siput",
                "Kumbang", "Semut", "Ular", "Harimau", "Kuda", "Serigala", "Panda", "Kadal", "Ayam", "Bebek"};

        ArrayList<String> tempNamaTim = new ArrayList<String>();
        ArrayList<Tim> tempKlasemenLiga = new ArrayList<Tim>();

        //inisiasi tim dengan nama acak
        Random rand = new Random();
        int count = 0;
        while(tempKlasemenLiga.size()<jumlahTim) {
            int randInt = rand.nextInt(arrayNamaTim.length);
            String randNamaTim = arrayNamaTim[randInt];
            if (!tempNamaTim.contains(randNamaTim)) {
                count++;
                tempNamaTim.add(randNamaTim);
                Tim tim$count = new Tim(randNamaTim);
                tempKlasemenLiga.add(tim$count);
            }
        }

        setKlasemenLiga(tempKlasemenLiga);

        System.out.println("TIM PESERTA " + getNamaLiga());
        for (Tim tim: klasemenLiga) {
            System.out.println(tim.toString());
        }

        System.out.println();
    }

    /**
     * Menginisiasi pertandingan pada suatu liga berdasarkan jumlah tim.
     */
    public void initMatch() {
        System.out.println("JADWAL PERTANDINGAN " + getNamaLiga());
        matchLiga.add(null);         //set awal dengan Match kosong agar bisa perintah Match selanjutnya

        int nomorMatch = 0;
        for (int i=0; i<getKlasemenLiga().size(); i++) {
            for (int j=i+1; j<getKlasemenLiga().size(); j++) {
                ++nomorMatch;
                Match Match$nomorMatch = new Match(nomorMatch, getKlasemenLiga().get(i), getKlasemenLiga().get(j));
                matchLiga.add(Match$nomorMatch);
                System.out.printf("    %-2d. %-30s \n", nomorMatch, Match$nomorMatch.toString());
            }
        }
        System.out.println();
    }

    /**
     * Menginisiasi pemain liga untuk klasemen top player.
     */
    public void initLeaguePlayer() {
        ArrayList<Pemain> tempArrayPemain = new ArrayList<Pemain>();
        for (Tim tim: getKlasemenLiga()) {
            for (Pemain pemain: tim.getPemainTim()) {
                tempArrayPemain.add(pemain);
            }
        }
        setTopPlayer(tempArrayPemain);
    }

    /**
     * Mengecek liga sudah selesai atau belum melalui instance variable currentMatch.
     */
    private void checkCurrentMatch() {
        if (getCurrentMatch()+1>= getMatchLiga().size()) {
            setFinish(true);
        }
    }


    /**
     * Memperbaharui urutan klasemen liga.
     */
    public void updateLeagueStandings() {
        ArrayList<Tim> tempKlasemenLiga;
        tempKlasemenLiga = getKlasemenLiga();

        boolean swapped;
        do {
            swapped = false;
            for (int i=0; i<tempKlasemenLiga.size()-1; i++) {
                swapped = false;
                if (tempKlasemenLiga.get(i).getJumlahPoin() < tempKlasemenLiga.get(i+1).getJumlahPoin()){
                    Tim tempTim = tempKlasemenLiga.get(i);
                    tempKlasemenLiga.set(i, tempKlasemenLiga.get(i+1));
                    tempKlasemenLiga.set(i+1, tempTim);
                    swapped = true;
                } else if ((tempKlasemenLiga.get(i).getJumlahPoin() == tempKlasemenLiga.get(i+1).getJumlahPoin()) &&
                        (tempKlasemenLiga.get(i).getJumlahGol() < tempKlasemenLiga.get(i+1).getJumlahGol())) {
                    Tim tempTim = tempKlasemenLiga.get(i);
                    tempKlasemenLiga.set(i, tempKlasemenLiga.get(i+1));
                    tempKlasemenLiga.set(i+1, tempTim);
                    swapped = true;
                }
            }
        } while (swapped);

        setKlasemenLiga(tempKlasemenLiga);
    }

    /**
     * Memperbaharui urutan pencetak gol terbanyak.
     */
    public void updateTopPlayer() {
        ArrayList<Pemain> tempTopPlayer;
        tempTopPlayer = getTopPlayer();

        boolean swapped;
        do {
            swapped = false;
            for (int i=0; i<tempTopPlayer.size()-1; i++) {
                if (tempTopPlayer.get(i).getJumlahGol() < tempTopPlayer.get(i+1).getJumlahGol()) {
                    Pemain tempPemain = tempTopPlayer.get(i);
                    tempTopPlayer.set(i, tempTopPlayer.get(i+1));
                    tempTopPlayer.set(i+1, tempPemain);
                    swapped = true;
                }
            }
        } while (swapped);

        setTopPlayer(tempTopPlayer);
    }


    /**
     * Method untuk perintah "nextMatch".
     */
    public void nextMatchRandom() {
        Match match = getMatchLiga().get(getCurrentMatch()+1);
        match.randomMatchData();

        match.updateTeamPoint();
        updateLeagueStandings();
        updateTopPlayer();
        match.displayStatistic();
        showStandings();

        setCurrentMatch(getCurrentMatch()+1);
        checkCurrentMatch();
    }

    /**
     * Method untuk perintah "nextMatch -all".
     */
    public void nextMatchAll() {
        for (Match match : getMatchLiga().subList(getCurrentMatch()+1, getMatchLiga().size())) {
            match.randomMatchData();

            match.updateTeamPoint();
            updateLeagueStandings();
            updateTopPlayer();
            match.displayStatistic();
            showStandings();

            setCurrentMatch(getCurrentMatch() + 1);
            checkCurrentMatch();
        }
    }

    /**
     * Method untuk perintah "nextMatch -g -kk -km -p".
     * @param input arrayString (input yang telah di'split') dari user.
     */
    public void nextMatchGoalViolation(String[] input) {
        ArrayList<String> stripPerintah = new ArrayList<>();
        Match match = getMatchLiga().get(getCurrentMatch()+1);

        for (int i=0; i<input.length; i++) {
            if (input[i].contains("-")) {
                stripPerintah.add(String.join(" ", Arrays.copyOfRange(input, i, i+3)));
            }
        }

        //memeriksa perintah nextMatch yang berurutan dengan mengindeks menggunakan "-"
        try {
            for (String perintahNextMatch: stripPerintah) {
                String[] arrayPerintah = perintahNextMatch.split(" ");
                if (arrayPerintah[0].equals("-g")) {
                    if (match.getTim1().getNamaTim().equals(arrayPerintah[1])) {
                        if (!match.gol(1, Integer.parseInt(arrayPerintah[2]))) return;
                    } else if (match.getTim2().getNamaTim().equals(arrayPerintah[1])) {
                        if (!match.gol(2, Integer.parseInt(arrayPerintah[2]))) return;
                    } else {
                        errorNotFindTeam(arrayPerintah[1]);
                        return;
                    }
                } else if (arrayPerintah[0].equals("-kk")) {
                    if (match.getTim1().getNamaTim().equals(arrayPerintah[1])) {
                        if (!match.kartuKuning(1, Integer.parseInt(arrayPerintah[2]))) return;
                    } else if (match.getTim2().getNamaTim().equals(arrayPerintah[1])) {
                        if (!match.kartuKuning(2, Integer.parseInt(arrayPerintah[2]))) return;
                    } else {
                        errorNotFindTeam(arrayPerintah[1]);
                        return;
                    }
                } else if (arrayPerintah[0].equals("-km")) {
                    if (match.getTim1().getNamaTim().equals(arrayPerintah[1])) {
                        if (!match.kartuMerah(1, Integer.parseInt(arrayPerintah[2]))) return;
                    } else if (match.getTim2().getNamaTim().equals(arrayPerintah[1])) {
                        if (!match.kartuMerah(2, Integer.parseInt(arrayPerintah[2]))) return;
                    } else {
                        errorNotFindTeam(arrayPerintah[1]);
                        return;
                    }
                } else if (arrayPerintah[0].equals("-p")) {
                    if (match.getTim1().getNamaTim().equals(arrayPerintah[1])) {
                        if (!match.pelanggaran(1, Integer.parseInt(arrayPerintah[2]))) return;
                    } else if (match.getTim2().getNamaTim().equals(arrayPerintah[1])) {
                        if (!match.pelanggaran(2, Integer.parseInt(arrayPerintah[2]))) return;
                    } else {
                        errorNotFindTeam(arrayPerintah[1]);
                        return;
                    }
                }
            }
        } catch (NumberFormatException error) {
            inputErrorMsg();
            return;
        }

        match.updateTeamPoint();
        updateLeagueStandings();
        updateTopPlayer();
        match.displayStatistic();
        showStandings();

        setCurrentMatch(getCurrentMatch()+1);
        checkCurrentMatch();
    }

    /**
     * Method ini berfungsi untuk menampilkan klasemen sementara terkini. Klasemen ditampilkan berurutan mulai dari puncak klasemen hingga tim dengan score terendah.
     */
    public void showStandings() {
        updateLeagueStandings();
        System.out.println("Peringkat | Nama Tim | Jumlah Gol | Jumlah Kebobolan | Menang | Kalah | Seri | Poin");
        System.out.println("-----------------------------------------------------------------------------------");

        for (Tim tim: getKlasemenLiga()) {
            System.out.printf("    %-2d    | %-9s|     %-2d     |        %-2d        |   %-2d   |   %-2d  |   %-2d |  %-2d  \n",
                    getKlasemenLiga().indexOf(tim)+1, tim.getNamaTim(), tim.getJumlahGol(), tim.getJumlahKebobolan(), tim.getJumlahMenang(), tim.getJumlahKalah(), tim.getJumlahSeri(), tim.getJumlahPoin());
        }
        System.out.println();
    }

    /**
     * Method ini berfungsi untuk menampilkan 10 pencetak gol terbanyak. Daftar pencetak gol ditampilkan berurutan mulai tertinggi hingga terendah.
     */
    public void showTopPlayer() {
        updateTopPlayer();
        System.out.println("Peringkat | Nama Pemain | Nama Tim | Jumlah Gol");
        System.out.println("-----------------------------------------------");

        int count = 0;
        for (int i=0; i<10; i++) {
            Pemain pemain = getTopPlayer().get(i);
            if (pemain.getJumlahGol()!=0) {
                ++count;
                System.out.printf("    %-2d    | %-12s| %-9s|     %-2d    \n",
                        count, pemain.getNamaPemain(), pemain.getNamaTim(), pemain.getJumlahGol());
            }
        }
        System.out.println();
    }


    /**
     * Method ini berfungsi untuk menampilkan 5 pemain dalam tim lengkap dengan informasinya.
     * @param namaTim namaTim yang akan ditampilkan informasi pemainnya.
     */
    public void showTeam(String namaTim) {
        boolean find = false;

        for (Tim tim: getKlasemenLiga()) {
            if (tim.getNamaTim().equals(namaTim)) {
                find = true;

                System.out.println("Nomor | Nama Pemain | Gol | Pelanggaran | Kartu Kuning | Kartu Merah");
                System.out.println("--------------------------------------------------------------------");
                for (Pemain pemain: tim.getPemainTim()) {
                    System.out.printf("  %-2d  | %-12s|  %-1d  |      %-1d      |      %-1d       |      %-1d      \n",
                            pemain.getNomorPemain(), pemain.getNamaPemain(), pemain.getJumlahGol(), pemain.getJumlahPelanggaran(),
                            pemain.getJumlahKartuKuning(), pemain.getJumlahKartuMerah());
                }

            }
        }

        if (find==false) {
            System.out.println("ERROR: Tim dengan nama " + namaTim + " tidak ada dalam liga " + namaLiga + " musim ini!");
        }

        System.out.println();
    }

    /**
     *Method ini berfungsi untuk menampilkan informasi pemain.
     * @param namaTim namaTim yang ingin ditampilkan informasi pemainnya.
     * @param pemainNomorNama parameter yang bisa berupa nomor atau nama pemain dalam tipe String.
     */
    public void showPlayer(String namaTim, String pemainNomorNama) {
        int nomorPemain = 0;
        String namaPemain = "";

        boolean find = false;
        boolean flag = false;         //true: input berupa nomor, false: input berupa string

        try {
            nomorPemain = Integer.parseInt(pemainNomorNama);
            flag = true;
        } catch (NumberFormatException e) {
            namaPemain = pemainNomorNama;
        }

        //looping cari pemain dengan parameter nama tim dan pemain tim dari klasemen liga
        for (Tim tim: getKlasemenLiga()) {
            if (tim.getNamaTim().equals(namaTim)) {
                for (Pemain pemain: tim.getPemainTim()) {
                    if (pemain.getNomorPemain()==nomorPemain || pemain.getNamaPemain().equals(namaPemain)) {
                        System.out.println("Nomor : " + pemain.getNomorPemain());
                        System.out.println("Nama : " + pemain.getNamaPemain());
                        System.out.println("Gol : " + pemain.getJumlahGol());
                        System.out.println("Pelanggaran : " + pemain.getJumlahPelanggaran());
                        System.out.println("Kartu Kuning : " + pemain.getJumlahKartuKuning());
                        System.out.println("Kartu Merah : " + pemain.getJumlahKartuMerah());
                        find = true;
                    }
                }
            }
        }

        if (find==false) {
            if (flag) {
                System.out.println("ERROR: Pemain dengan nomor " + nomorPemain + " bukan anggota dari Tim " + namaTim +"!");
            } else {
                System.out.println("ERROR: Pemain dengan nama " + namaPemain + " bukan anggota dari Tim " + namaTim + "!");
            }
        }

        System.out.println();
    }

    /**
     * Method untuk menampilkan informasi pertandingan selanjutnya.
     */
    public void shownextMatch() {
        System.out.println(getMatchLiga().get(currentMatch+1).getTim1().getNamaTim() + " VS " + getMatchLiga().get(currentMatch+1).getTim2().getNamaTim());
        System.out.println();
    }
}
