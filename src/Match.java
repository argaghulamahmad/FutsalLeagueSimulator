/**
 * Created by Arga Ghulam Ahmad on 3/11/2017.
 */

import java.util.Random;


/**
 * Kelas Match merepresentasikan pertandingan yang ada pada liga.
 */
public class Match {
    private Tim tim1;
    private Tim tim2;

    private int golMatchTim1 = 0;
    private int golMatchTim2 = 0;
    private int pelanggaranMatchTim1 = 0;
    private int pelanggaranMatchTim2 = 0;
    private int kartukuningMatchTim1 = 0;
    private int kartukuningMatchTim2 = 0;
    private int kartumerahMatchTim1 = 0;
    private int kartumerahMatchTim2 = 0;

    public int getGolMatchTim1() {
        return golMatchTim1;
    }

    public void setGolMatchTim1(int golMatchTim1) {
        this.golMatchTim1 = golMatchTim1;
    }

    public int getGolMatchTim2() {
        return golMatchTim2;
    }

    public void setGolMatchTim2(int golMatchTim2) {
        this.golMatchTim2 = golMatchTim2;
    }

    public int getPelanggaranMatchTim1() {
        return pelanggaranMatchTim1;
    }

    public void setPelanggaranMatchTim1(int pelanggaranMatchTim1) {
        this.pelanggaranMatchTim1 = pelanggaranMatchTim1;
    }

    public int getPelanggaranMatchTim2() {
        return pelanggaranMatchTim2;
    }

    public void setPelanggaranMatchTim2(int pelanggaranMatchTim2) {
        this.pelanggaranMatchTim2 = pelanggaranMatchTim2;
    }

    public int getKartukuningMatchTim1() {
        return kartukuningMatchTim1;
    }

    public void setKartukuningMatchTim1(int kartukuningMatchTim1) {
        this.kartukuningMatchTim1 = kartukuningMatchTim1;
    }

    public int getKartukuningMatchTim2() {
        return kartukuningMatchTim2;
    }

    public void setKartukuningMatchTim2(int kartukuningMatchTim2) {
        this.kartukuningMatchTim2 = kartukuningMatchTim2;
    }

    public int getKartumerahMatchTim1() {
        return kartumerahMatchTim1;
    }

    public void setKartumerahMatchTim1(int kartumerahMatchTim1) {
        this.kartumerahMatchTim1 = kartumerahMatchTim1;
    }

    public int getKartumerahMatchTim2() {
        return kartumerahMatchTim2;
    }

    public void setKartumerahMatchTim2(int kartumerahMatchTim2) {
        this.kartumerahMatchTim2 = kartumerahMatchTim2;
    }

    public Tim getTim1() {
        return tim1;
    }

    public void setTim1(Tim tim1) {
        this.tim1 = tim1;
    }

    public Tim getTim2() {
        return tim2;
    }

    public void setTim2(Tim tim2) {
        this.tim2 = tim2;
    }

    public Match(int nomorMatch, Tim tim1, Tim tim2) {
        this.tim1 = tim1;
        this.tim2 = tim2;
    }

    @Override
    public String toString() {
        return  String.format("%-8s VS %-8s", tim1.getNamaTim(), tim2.getNamaTim());
    }


    /**
     * Error pemain tidak dapat ditemukan karena tidak ada atau sudah dinonaktifkan karena pinalty pelanggaran.
     * @param namaTim1 nama tim1 dalam match.
     * @param namaTim2 nama tim2 dalam match.
     * @param nomorPemain nomor pemain yang tidak dapat ditemukan.
     */
    public void errorNotFindPlayer (String namaTim1, String namaTim2, int nomorPemain) {
        System.out.println("ERROR: Tidak ada pemain nomor " + nomorPemain + " di Tim " + namaTim1 + " ataupun Tim " + namaTim2 + "!");
        System.out.println();
    }


    //OTOMATIS

        /**
         * Method yang berfungsi untuk menghasilkan data dummy untuk sebuah pertandingan.
         */
        public void randomMatchData() {
                Random rand = new Random();
                int randTotalGolTim1 = (rand.nextInt(6));
                int randTotalKartuKuningTim1 = (rand.nextInt(4));
                int randTotalKartuMerahTim1 = (rand.nextInt(3));
                int randTotalPelanggaranTim1 = (rand.nextInt(6));

                int randTotalGolTim2 = (rand.nextInt(6));
                int randTotalKartuKuningTim2 = (rand.nextInt(4));
                int randTotalKartuMerahTim2 = (rand.nextInt(3));
                int randTotalPelanggaranTim2 = (rand.nextInt(6));

                //random gol yang terjadi dalam pertandingan
                for (int i=0; i<randTotalGolTim1; i++) {
                    tim1.randomGol();
                    tim2.setJumlahKebobolan(tim2.getJumlahKebobolan()+1);
                    setGolMatchTim1(getGolMatchTim1()+1);
                }

                for (int i=0; i<randTotalGolTim2; i++) {
                    tim2.randomGol();
                    tim1.setJumlahKebobolan(tim1.getJumlahKebobolan()+1);
                    setGolMatchTim2(getGolMatchTim2()+1);
                }


                //random pelanggaran yang menghasilkan kartu kuning dalam pertandingan
                for (int i=0; i<randTotalKartuKuningTim1; i++) {
                    if (tim1.randomKartuKuning(toString())) {setKartumerahMatchTim1(getKartumerahMatchTim1()+1);}
                    setKartukuningMatchTim1(getKartukuningMatchTim1()+1);
                    setPelanggaranMatchTim1(getPelanggaranMatchTim1()+1);
                }

                for (int i=0; i<randTotalKartuKuningTim2; i++) {
                    if (tim2.randomKartuKuning(toString())) {setKartumerahMatchTim2(getKartumerahMatchTim2()+1);}
                    setKartukuningMatchTim2(getKartukuningMatchTim2()+1);
                    setPelanggaranMatchTim2(getPelanggaranMatchTim2()+1);
                }

                //random pelanggaran yang menghasilkan kartu merah dalam pertandingan
                for (int i=0; i<randTotalKartuMerahTim1; i++) {
                    tim1.randomKartuMerah();
                    setKartumerahMatchTim1(getKartumerahMatchTim1()+1);
                    setPelanggaranMatchTim1(getPelanggaranMatchTim1()+1);
                }

                for (int i=0; i<randTotalKartuMerahTim2; i++) {
                    tim2.randomKartuMerah();
                    setKartumerahMatchTim2(getKartumerahMatchTim2()+1);
                    setPelanggaranMatchTim2(getPelanggaranMatchTim2()+1);
                }

                //random pelanggaran yang terjadi dalam pertandingan
                for (int i=0; i<randTotalPelanggaranTim1; i++) {
                    tim1.randomPelanggaran();
                    setPelanggaranMatchTim1(getPelanggaranMatchTim1()+1);
                }

                for (int i=0; i<randTotalPelanggaranTim2; i++) {
                    tim2.randomPelanggaran();
                    setPelanggaranMatchTim2(getPelanggaranMatchTim2()+1);
                }
            }


    //MANUAL
        /**
         * Memproses perintah manual nextGame -g [namaTim] [nomorPemain].
         * @param tim tim manakah yang telah mencetak gol.
         * @param nomorPemain pemain manakah yang telah mencetak gol.
         * @return boolean sebagai indikator bahwa perintah gol telah dilaksanakan.
         */
            public boolean gol(int tim, int nomorPemain) {
                boolean find = false;
                if (tim==1) {
                    for (Pemain pemain: getTim1().getPemainTim()) {
                        if (pemain.getNomorPemain()==nomorPemain) {
                            tim1.gol(nomorPemain);
                            tim2.setJumlahKebobolan(tim2.getJumlahKebobolan()+1);
                            setGolMatchTim1(getGolMatchTim1()+1);
                            find = true;
                        }
                    }
                } else if (tim==2) {
                    for (Pemain pemain: getTim2().getPemainTim()) {
                        if (pemain.getNomorPemain()==nomorPemain) {
                            tim2.gol(nomorPemain);
                            tim1.setJumlahKebobolan(tim1.getJumlahKebobolan()+1);
                            setGolMatchTim2(getGolMatchTim2()+1);
                            find = true;
                        }
                    }
                }

                if (find==false) {
                    errorNotFindPlayer(tim1.getNamaTim(), tim2.getNamaTim(), nomorPemain);
                }
                return find;
            }

        /**
         * Memproses perintah manual nextGame -kk [namaTim] [nomorPemain].
         * @param tim tim manakah yang mendapat kartu kuning.
         * @param nomorPemain pemain manakah yang mendapat kartu kuning.
         * @return boolean sebagai indikator bahwa perintah kartuKuning telah dilaksanakan.
         */
        public boolean kartuKuning(int tim, int nomorPemain) {
                boolean find = false;
                if (tim==1) {
                    for (Pemain pemain: getTim1().getPemainTim()) {
                        if (pemain.getNomorPemain()==nomorPemain) {
                            if (tim1.kartuKuning(nomorPemain, toString())) {setKartumerahMatchTim1(getKartumerahMatchTim1()+1);}
                            pemain.setJumlahPelanggaran(pemain.getJumlahPelanggaran()+1);
                            tim1.setJumlahKartuKuning(tim1.getJumlahKartuKuning()+1);
                            setKartukuningMatchTim1(getKartukuningMatchTim1()+1);
                            tim1.setJumlahPelanggaran(tim1.getJumlahPelanggaran()+1);
                            setPelanggaranMatchTim1(getPelanggaranMatchTim1()+1);
                            find = true;
                        }
                    }
                } else if (tim==2) {
                    for (Pemain pemain: getTim2().getPemainTim()) {
                        if (pemain.getNomorPemain()==nomorPemain) {
                            if (tim2.kartuKuning(nomorPemain, toString())) {setKartumerahMatchTim2(getKartumerahMatchTim2()+1);}
                            pemain.setJumlahPelanggaran(pemain.getJumlahPelanggaran()+1);
                            tim2.setJumlahKartuKuning(tim2.getJumlahKartuKuning()+1);
                            setKartukuningMatchTim2(getKartukuningMatchTim2()+1);
                            tim2.setJumlahPelanggaran(tim2.getJumlahPelanggaran()+1);
                            setPelanggaranMatchTim2(getPelanggaranMatchTim2()+1);
                            find = true;
                        }
                    }
                }

                if (find==false) {
                    errorNotFindPlayer(tim1.getNamaTim(), tim2.getNamaTim(), nomorPemain);
                }
                return find;
            }

        /**
         * Memproses perintah manual nextGame -km [namaTim] [nomorPemain].
         * @param tim tim manakah yang mendapat kartu merah.
         * @param nomorPemain pemain manakah yang mendapat kartu merah.
         * @return boolean sebagai indikator perintah kartuMerah telah dilaksanakan.
         */
        public boolean kartuMerah(int tim, int nomorPemain) {
                boolean find = false;
                if (tim==1) {
                    for (Pemain pemain: getTim1().getPemainTim()) {
                        if (pemain.getNomorPemain()==nomorPemain) {
                            tim1.kartuMerah(nomorPemain);
                            tim1.setJumlahKartuMerah(tim1.getJumlahKartuMerah()+1);
                            setKartumerahMatchTim1(getKartumerahMatchTim1()+1);
                            tim1.setJumlahPelanggaran(tim1.getJumlahPelanggaran()+1);
                            setPelanggaranMatchTim1(getPelanggaranMatchTim1()+1);
                            find = true;
                        }
                    }
                } else if (tim==2){
                    for (Pemain pemain: getTim2().getPemainTim()) {
                        if (pemain.getNomorPemain()==nomorPemain) {
                            tim2.kartuMerah(nomorPemain);
                            tim2.setJumlahKartuMerah(tim2.getJumlahKartuMerah()+1);
                            setKartumerahMatchTim2(getKartumerahMatchTim2()+1);
                            tim2.setJumlahPelanggaran(tim2.getJumlahPelanggaran()+1);
                            setPelanggaranMatchTim2(getPelanggaranMatchTim2()+1);
                            find = true;
                        }
                    }
                }

                if (find == false) {
                    errorNotFindPlayer(tim1.getNamaTim(), tim2.getNamaTim(), nomorPemain);
                }
                return find;
            }

    /**
     * Memproses perintah nextGame -p [namaTim] [namaPemain].
     * @param tim tim manakah yang telah melakukan pelanggaran.
     * @param nomorPemain pemain manakah yang telah melakukan pelanggaran.
     * @return boolean sebagai indikator perintah pelanggaran telah dilaksanakan.
     */
    public boolean pelanggaran(int tim, int nomorPemain) {
            boolean find = false;
            if (tim==1) {
                for (Pemain pemain: getTim1().getPemainTim()) {
                    if (pemain.getNomorPemain()==nomorPemain) {
                        tim1.pelanggaran(nomorPemain);
                        setPelanggaranMatchTim1(getPelanggaranMatchTim1()+1);
                        find = true;
                    }
                }
            } else if (tim==2){
                for (Pemain pemain: getTim2().getPemainTim()) {
                    if (pemain.getNomorPemain()==nomorPemain) {
                        tim2.pelanggaran(nomorPemain);
                        setPelanggaranMatchTim2(getPelanggaranMatchTim2()+1);
                        find = true;
                    }
                }
            }

            if (find==false) {
                errorNotFindPlayer(tim1.getNamaTim(), tim2.getNamaTim(), nomorPemain);
            }
            return find;
        }


    /**
     * Update data pertandingan apakah menang/kalah/seri kedalam tim1 dan tim2.
     */
    public void updateTeamPoint() {
        if (getGolMatchTim1() > getGolMatchTim2()) {
            tim1.setJumlahMenang(tim1.getJumlahMenang()+1);
            tim1.setJumlahPoin(tim1.getJumlahPoin()+3);
            tim2.setJumlahKalah(tim2.getJumlahKalah()+1);
        } else if (getGolMatchTim1() < getGolMatchTim2()) {
            tim1.setJumlahKalah(tim1.getJumlahKalah()+1);
            tim2.setJumlahMenang(tim2.getJumlahMenang()+1);
            tim2.setJumlahPoin(tim2.getJumlahPoin()+3);
        } else if (getGolMatchTim1() == getGolMatchTim2()) {
            tim1.setJumlahSeri(tim1.getJumlahSeri()+1);
            tim2.setJumlahSeri(tim2.getJumlahSeri()+1);
            tim1.setJumlahPoin(tim1.getJumlahPoin()+1);
            tim2.setJumlahPoin(tim2.getJumlahPoin()+1);
        }
    }

    /**
     * Menampilkan statisktik hasil pertandingan.
     */
    public void displayStatistic() {
        System.out.println();
        System.out.println("Statistika Pertandingan Tim " + tim1.getNamaTim() + " VS Tim " + tim2.getNamaTim());
        System.out.println();
        System.out.println("Tim : " + tim1.getNamaTim());
        System.out.println("Gol : " + getGolMatchTim1());
        System.out.println("Pelanggaran : " + getPelanggaranMatchTim1());
        System.out.println("Kartu Kuning : " + getKartukuningMatchTim1());
        System.out.println("Kartu Merah : " + getKartumerahMatchTim1());
        System.out.println();
        System.out.println("Tim : " + tim2.getNamaTim());
        System.out.println("Gol : " + getGolMatchTim2());
        System.out.println("Pelanggaran : " + getPelanggaranMatchTim2());
        System.out.println("Kartu Kuning : " + getKartukuningMatchTim2());
        System.out.println("Kartu Merah : " + getKartumerahMatchTim2());
        System.out.println();
    }
}
