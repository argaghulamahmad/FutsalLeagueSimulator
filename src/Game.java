/**
 * Created by Arga Ghulam Ahmad on 3/11/2017.
 */

/**
 * Arga Ghulam Ahmad - 1606821601
 * Tugas1 DDP2 - Program Klasemen Liga
 */

import java.util.Scanner;

/**
 * Kelas Game merupakan main program pengolah utama input perintah dari pengguna.
 * Kelas ini menyimpan informasi mengenai liga.
 * Method dalam kelas ini memiliki fungsi meliputi:
 *      1. Meminta input dari pengguna.
 *      2. 'Split' dan 'Parsing' input dari pengguna.
 *      3. Menunjuk method manakah yang akan di gunakan.
 */

public class Game {
    private Liga liga;

    private boolean init = false;       //indikator apakah liga telah diinisiasi apa belum
    private boolean manual = false;      //indkator perintah dalam mode manual
    private boolean finish = false;     //indikator apakah game sudah selesai

    public boolean isInit() {
        return init;
    }

    public void setInit(boolean init) {
        this.init = init;
    }

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    public Liga getLiga() {
        return liga;
    }

    public void setLiga(Liga liga) {
        this.liga = liga;
    }

    public boolean isManual() {
        return manual;
    }

    public void setManual(boolean manual) {
        this.manual = manual;
    }

    /**
     * Pesan error bila input invalid.
     */
    private void inputErrorMsg() {
        System.out.println("ERROR: Input invalid! Masukkan input yang valid!");
        System.out.println();
    }

    /**
     * Pesan error bahwa liga telah diinisiasi.
     */
    private void initErrorMsg() {
        System.out.println("ERROR: Game sudah di-init, init gagal!");
    }

    /**
     * Pesan error bahwa liga belum diinisiasi.
     */
    private void notinitedErrorMsg() {
        System.out.println("ERROR: Game belum di-init, silakan init terlebih dahulu dengan perintah: init [jumlahTim]");
    }



    /**
     * Penunjuk method perintah "init" pada kelas Liga.
     * @param liga liga yang akan di proses.
     * @param input array string yang berisi input yang telah di split dengan spasi.
     */
    private void commandInit(Liga liga, String[] input) {
        try {
            if (isInit()==false) {
                int jumlahTim = Integer.parseInt(input[1]);
                if (jumlahTim >= 4 && jumlahTim <= 10) {
                    System.out.println("MESSAGE: Init berhasil!");
                    System.out.println();
                    liga.initTeam(jumlahTim);
                    liga.initMatch();
                    liga.initLeaguePlayer();
                    setInit(true);
                } else {
                    System.out.println("ERROR: Jumlah tim minimal 4 tim dan maksimal 10 tim!");
                    System.out.println();
                }
            } else {
                initErrorMsg();
                System.out.println();
            }
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException error) {
                inputErrorMsg();
        }
    }


    /**
     * Penunjuk method perintah "nextMatch" pada kelas Liga.
     * @param liga liga yang akan di proses.
     * @param input array string yang berisi input yang telah di split dengan separator spasi.
     */
    private void commandNextMatch (Liga liga, String[] input) {
        try {
            String strInput = String.join(" ", input);
            if (isInit()==true) {
                if (strInput.contains("-g")) {
                    liga.nextMatchGoalViolation(input);
                    setManual(true);
                } else if (input.length==1 && !isManual()) {
                    liga.nextMatchRandom();
                } else if (input.length==2 && input[1].equals("-all") && !isManual()) {
                    liga.nextMatchAll();
                } else {
                    inputErrorMsg();
                }
            } else {
                notinitedErrorMsg();
                System.out.println();
            }
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException error) {
            inputErrorMsg();
        }
    }

    /**
     * Penunjuk method perintah "show" pada kelas Liga.
     * @param liga liga yang akan di proses.
     * @param input array string yang berisi input yang telah di split dengan spasi.
     */
    private void commandShow (Liga liga, String[] input) {
        try {
            if (isInit()==true) {
                if (input[1].equals("klasemen")) {
                    liga.showStandings();
                } else if (input[1].equals("pencetakGol")) {
                    liga.showTopPlayer();
                } else if (input[1].equals("tim")) {
                    liga.showTeam(input[2]);
                } else if (input[1].equals("pemain")) {
                    liga.showPlayer(input[2], input[3]);
                } else if (input[1].equals("nextGame")) {
                    liga.shownextMatch();
                } else {
                    inputErrorMsg();
                }
            } else {
                notinitedErrorMsg();
                System.out.println();
            }
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException error) {
            inputErrorMsg();
        }
    }

    //MAIN METHOD
    public static void main(String[] args) {
        Game gameProgram = new Game();
        Liga csLeague = new Liga("CS LEAGUE", "CSL", 2017);
        gameProgram.setLiga(csLeague);
        Scanner scanInputEOF  = new Scanner(System.in);
        System.out.println("WELCOME!");

        while (!gameProgram.isFinish()) {
            System.out.print("[" + gameProgram.getLiga().getKodeLiga() + gameProgram.getLiga().getTahunLiga() + "] > ");

            String mainInput = scanInputEOF.nextLine();

            String[] splittedInput = mainInput.split(" ");
            String perintah  = splittedInput[0];

            if (perintah.equals("init")) {
                gameProgram.commandInit(gameProgram.getLiga(), splittedInput);
            } else if (perintah.equals("nextGame")) {
                gameProgram.commandNextMatch(gameProgram.getLiga(), splittedInput);
            } else if (perintah.equals("show")) {
                gameProgram.commandShow(gameProgram.getLiga(), splittedInput);
            } else {
                gameProgram.inputErrorMsg();
            }

            gameProgram.setFinish(gameProgram.getLiga().isFinish());
        }

        gameProgram.getLiga().updateLeagueStandings();
        gameProgram.getLiga().updateTopPlayer();
        System.out.println(gameProgram.getLiga().getNamaLiga() + " MUSIM INI TELAH USAI");
        System.out.println();
        System.out.println("CHAMPION: Tim " + gameProgram.getLiga().getKlasemenLiga().get(0).getNamaTim());
        System.out.println();
        System.out.println("KLASEMEN");
        gameProgram.getLiga().showStandings();
        System.out.println();
        System.out.println("TOP SCORE");
        gameProgram.getLiga().showTopPlayer();
        System.out.println();
        System.out.println("GOODBYE!");
    }
}
