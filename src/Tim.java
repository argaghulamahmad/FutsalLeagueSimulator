/**
 * Created by Arga Ghulam Ahmad on 3/11/2017.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 * Kelas Tim merepresentasikan Tim yang ada pada Liga. Setiap tim memiliki lima pemain.
 * Kelas Tim menyimpan informasi namaTim, peringkat, jumlahMenang, jumlahKalah, jumlahSeri, jumlahPoin, jumlahGol, dan jumlahKebobolan
 */
public class Tim {
    private String namaTim = "";
    private int jumlahMenang = 0;
    private int jumlahKalah = 0;
    private int jumlahSeri = 0;
    private int jumlahPoin = 0;
    private int jumlahGol = 0;
    private int jumlahKebobolan = 0;
    private int jumlahKartuKuning = 0;
    private int jumlahKartuMerah = 0;
    private int jumlahPelanggaran = 0;

    private Pemain[] pemainTim = new Pemain[5];

    public Tim(String namaTim) {
        this.namaTim = namaTim;
        this.pemainTim = initTeamPlayer();
    }
    public Tim() {
        this.pemainTim = initTeamPlayer();
    }

    public String getNamaTim() {
        return namaTim;
    }

    public void setNamaTim(String namaTim) {
        this.namaTim = namaTim;
    }

    public int getJumlahMenang() {
        return jumlahMenang;
    }

    public void setJumlahMenang(int jumlahMenang) {
        this.jumlahMenang = jumlahMenang;
    }

    public int getJumlahKalah() {
        return jumlahKalah;
    }

    public void setJumlahKalah(int jumlahKalah) {
        this.jumlahKalah = jumlahKalah;
    }

    public int getJumlahSeri() {
        return jumlahSeri;
    }

    public void setJumlahSeri(int jumlahSeri) {
        this.jumlahSeri = jumlahSeri;
    }

    public int getJumlahPoin() {
        return jumlahPoin;
    }

    public void setJumlahPoin(int jumlahPoin) {
        this.jumlahPoin = jumlahPoin;
    }

    public int getJumlahGol() {
        return jumlahGol;
    }

    public void setJumlahGol(int jumlahGol) {
        this.jumlahGol = jumlahGol;
    }

    public int getJumlahKebobolan() {
        return jumlahKebobolan;
    }

    public void setJumlahKebobolan(int jumlahKebobolan) {
        this.jumlahKebobolan = jumlahKebobolan;
    }

    public Pemain[] getPemainTim() {
        return pemainTim;
    }

    public void setPemainTim(Pemain[] pemainTim) {
        this.pemainTim = pemainTim;
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

    public int getJumlahPelanggaran() {
        return jumlahPelanggaran;
    }

    public void setJumlahPelanggaran(int jumlahPelanggaran) {
        this.jumlahPelanggaran = jumlahPelanggaran;
    }

    @Override
    public String toString() {
        String[] namaPemainTim = new String[5];
        int[] nomorPemainTim = new int[5];

        for (int i=0; i<namaPemainTim.length; i++) {
            namaPemainTim[i]=getPemainTim()[i].getNamaPemain();
            nomorPemainTim[i]=getPemainTim()[i].getNomorPemain();
        }

        return  "    Tim " + getNamaTim() + " { \n" +
                "       pemainTim: " + Arrays.toString(namaPemainTim) + "\n" +
                "       nomorPemain: " + Arrays.toString(nomorPemainTim) + "\n" +
                "    }";
    }

    /**
     * Method init pemain tim akan merandom pemain tim untuk sebuah tim.
     * @return array pemain hasil init random pemain tim.
     */
    public Pemain[] initTeamPlayer() {
        String[] arrayNamaPemain = {"Arnold", "Kaidou", "Chopper", "Pica", "Enel", "Zoro", "Pedro", "Beckman", "Ace", "Shiryu", "Sakazuki",
                "Marco", "Garp", "Dadan", "Sengoku", "Sanji", "Magellan", "Dragon", "Sabo", "Smoker", "Luffy", "Franky", "Borsalino", "Buggy",
                "Crocodile", "Shanks", "Yasopp", "Coby", "Burgess", "Usopp", "Law", "Kid", "Bege", "Yonji", "Doffy", "Edward", "Mihawk",
                "Shanks", "Jinbei", "Killer", "Robin", "Roger", "Shiki", "Rayleigh", "Robb", "Kuma", "Moriah", "Teach", "Pagaya", "Conis",
                "Hachi", "Brook", "Kinemon", "Vergo", "Caesar", "Momo", "Mohji", "Cabaji", "Jozu", "Vista", "Doma", "Augur", "Drake", "Ivankov",
                "Charlotte", "Bellamy", "Demaro", "Dorry", "Brogy", "Kuro", "Zeff", "Gin", "Pearl", "Alvide", "Apoo", "Kuzan", "Nami", "Brook",
                "Hancock", "Koala"};

        ArrayList<String> reservedNamaPemain = new ArrayList<String>();         //list nama yang sudah dipakai
        ArrayList<Pemain> tempListPemainTim = new ArrayList<Pemain>();
        ArrayList<Integer> reservedNomorPemain = new ArrayList<Integer>();

        Random rand = new Random();
        int count = 0;
        while(tempListPemainTim.size()<5) {
            int randIntNama = rand.nextInt(arrayNamaPemain.length);
            Integer randIntNomor = rand.nextInt(100);
            String randNamaPemain = arrayNamaPemain[randIntNama];
            if (!reservedNamaPemain.contains(randNamaPemain) && !reservedNomorPemain.contains(randIntNomor) && randIntNomor!=0) {
                count++;
                reservedNamaPemain.add(arrayNamaPemain[randIntNama]);
                reservedNomorPemain.add(randIntNomor);
                Pemain pemain$count = new Pemain(randNamaPemain, randIntNomor, getNamaTim());
                tempListPemainTim.add(pemain$count);
            }
        }

        Pemain[] tempArrayPemainTim = new Pemain[tempListPemainTim.size()];
        tempArrayPemainTim = tempListPemainTim.toArray(tempArrayPemainTim);

        return tempArrayPemainTim;
    }


    //RANDOM AUTO
        /**
         * Random pemain mana yang mencetak gol.
         */
        public void randomGol() {
            Random randInt = new Random();
            int randPemain = randInt.nextInt(5);
            for (Pemain pemain: getPemainTim()) {
                if (Arrays.asList(getPemainTim()).indexOf(pemain)==randPemain){
                    pemain.gol();
                    setJumlahGol(getJumlahGol()+1);
                }
            }
        }

        /**
         * Random pemain mana yang menerima kartu kuning.
         * @return boolean sebagai indikator bahwa tim mendapat kartu kuning.
         * @param match indikator apakah match masih sama apa tidak.
         */
        public boolean randomKartuKuning(String match) {
                Random randInt = new Random();
                int randPemain = randInt.nextInt(5);
                for (Pemain pemain: getPemainTim()) {
                    if (Arrays.asList(getPemainTim()).indexOf(pemain)==randPemain) {
                        pemain.kartuKuning();
                        pemain.pelanggaran();
                        setJumlahPelanggaran(getJumlahPelanggaran()+1);
                        setJumlahKartuKuning(getJumlahKartuKuning()+1);
                        if (pemain.pinaltyPelanggaran(match)) {
                            setJumlahKartuMerah(getJumlahKartuMerah()+1);
                            return true;
                        }
                    }
                }
                return false;
            }

        /**
         * Random pemain mana yang menerima kartu merah.
         */
        public void randomKartuMerah() {
            Random randInt = new Random();
            int randPemain = randInt.nextInt(5);
            for (Pemain pemain: getPemainTim()) {
                if (Arrays.asList(getPemainTim()).indexOf(pemain)==randPemain) {
                    pemain.kartuMerah(false);
                    setJumlahKartuMerah(getJumlahKartuMerah()+1);
                }
            }
        }

        /**
         * Random pemain mana yang melakukan pelanggaran.
         */
        public void randomPelanggaran() {
            Random randInt = new Random();
            int randPemain = randInt.nextInt(5);
            for (Pemain pemain: getPemainTim()) {
                if (Arrays.asList(getPemainTim()).indexOf(pemain)==randPemain) {
                    pemain.pelanggaran();
                    setJumlahPelanggaran(getJumlahPelanggaran()+1);
                }
            }
        }

    //MANUAL
        /**
         * Pemain tim mencetak gol.
         * @param nomorPemain nomor pemain pencetak gol.
         */
        public void gol(int nomorPemain) {
                for (Pemain pemain: getPemainTim()) {
                    if (pemain.getNomorPemain()==nomorPemain) {
                        pemain.gol();
                        setJumlahGol(getJumlahGol()+1);
                        break;
                    }
                }
            }

        /**
         * Pemain tim mendapat kartu kuning.
         * @param nomorPemain nomor pemain tim yang mendapat kartu kuning.
         * @return boolean sebagai indikator pinalti kartu kuning.
         * @param match indikator apakah match masih sama apa tidak.
         */
        public boolean kartuKuning(int nomorPemain, String match) {
                for (Pemain pemain: getPemainTim()) {
                    if (pemain.getNomorPemain()==nomorPemain) {
                        pemain.kartuKuning();
                        setJumlahKartuKuning(getJumlahKartuKuning()+1);
                        if (pemain.pinaltyPelanggaran(match)) {
                            setJumlahKartuMerah(getJumlahKartuMerah()+1);
                            return true;
                        }
                    }
                }
                return false;
            }

        /**
         * Pemain tim mendapat kartu merah.
         * @param nomorPemain nomor pemain tim yang mendapat kartu merah.
         */
        public void kartuMerah(int nomorPemain) {
                for (Pemain pemain: getPemainTim()) {
                    if (pemain.getNomorPemain()==nomorPemain) {
                        pemain.kartuMerah(false);
                        setJumlahKartuMerah(getJumlahKartuMerah()+1);
                        break;
                    }
                }
            }

        /**
         * Pemain tim melakukan pelanggaran.
         * @param nomorPemain nomor pemain tim yang melakukan pelanggaran.
         */
        public void pelanggaran(int nomorPemain) {
                for (Pemain pemain: getPemainTim()) {
                    if (pemain.getNomorPemain()==nomorPemain) {
                        pemain.pelanggaran();
                        setJumlahPelanggaran(getJumlahPelanggaran()+1);
                        break;
                    }
                }
            }
}
