package com.company;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner scan = new Scanner(System.in);
        int menu= 0, pilih, hari;
        String tanggal;

        // menu 1
        try {
            while (menu == 0)
            {
                System.out.println("Pilihlah salat satu menu pada aplikasi ini : ");
                System.out.println("1. Membuat ucapan idul fitri untuk anonymous ");
                System.out.println("2. Membuat kartu ucapan idul fitri untuk seseorang ");
                System.out.println("3. Menghitung lama hari dari jarak 2 tanggal ");
                System.out.println("4. Menghitung kecepatan sebuah mobil ");
                System.out.println("5. Menentukan apakah sebuah tahun merupakan tahun kabisat atau bukan ");
                System.out.println("6. Menghitung perbedaan umur 2 orang pada hari ini. ");
                System.out.println("7. Exit");
                System.out.println("\n");
                System.out.print("Pilihan anda dari 1 - 7 ? "); pilih = scan.nextInt();
                switch (pilih) {
                    case 1:
                        System.out.println(Menu1);

                        System.out.println("================================================================\n");
                        System.out.println("Kembali ke menu ? \n Ketik 0 jika YA, ketik 1 jika TIDAK "); menu = scan.nextInt();
                        break;
                    case 2:
                        try{
                            scan.nextLine();
                            System.out.println("========================================================================");
                            System.out.print("Diucapkan untuk : ");
                            String nama = scan.nextLine();
                            Menu2(nama);

                            System.out.printf("================================================================\n");
                            System.out.println("Kembali ke menu ? \n Ketik 0 jika YA, ketik 1 jika TIDAK "); menu = scan.nextInt();
                        }catch (Exception ex){
                            System.out.println("Something Wrong.");
                        }
                        break;
                    case 3:
                        try{
                            scan.nextLine();
                            System.out.println("========================================================================");
                            System.out.print("Dari tanggal (Tanggal/Bulan/Tahun) : "); String tanggal1 = scan.nextLine();
                            System.out.print("Sampai tanggal (Tanggal/Bulan/Tahun) : "); String tanggal2 = scan.nextLine();
                            long selisih = Menu3(tanggal1,tanggal2);
                            System.out.println("Jarak dari " + tanggal1 + " - " + tanggal2 + " adalah " + selisih + " hari.");

                            System.out.printf("================================================================\n");
                            System.out.println("Kembali ke menu ? \n Ketik 0 jika YA, ketik 1 jika TIDAK "); menu = scan.nextInt();
                        }catch (Exception ex){
                            System.out.println("Input tanggal tidak sesuai, silahkan klik Enter untuk mencoba lagi.");
                        }
                        break;
                    case 4:
                        try{
                            scan.nextLine();
                            System.out.println("========================================================================");
                            System.out.print("Jarak yang ditempuh (Dalam KM) : "); double jarak = scan.nextDouble();
                            System.out.print("Waktu yang ditempuh (Dalam Jam) : "); double waktu = scan.nextDouble();
                            double kecepatan = Menu4(jarak,waktu);
                            System.out.printf("Kecepatan Mobil adalah %.2f KM/Jam \n\n", kecepatan);
                            scan.nextLine();

                            System.out.printf("================================================================\n");
                            System.out.println("Kembali ke menu ? \n Ketik 0 jika YA, ketik 1 jika TIDAK "); menu = scan.nextInt();
                        }catch (Exception ex){
                            System.out.println("Data yang anda masukan tidak sesuai.");
                        }
                        break;
                    case 5:
                        try{
                            scan.nextLine();
                            System.out.println("========================================================================");
                            System.out.print("Tahun yang ingin dicek : "); int tahun = scan.nextInt();
                            boolean kabisat = Menu5(tahun);
                            if(kabisat == true){
                                System.out.println("Tahun " + tahun + " adalah TAHUN KABISAT.");
                            } else {
                                System.out.println("Tahun " + tahun + " BUKAN TAHUN KABISAT.");
                            }
                            scan.nextLine();

                            System.out.printf("================================================================\n");
                            System.out.println("Kembali ke menu ? \n Ketik 0 jika YA, ketik 1 jika TIDAK "); menu = scan.nextInt();
                        }catch (Exception ex){
                            System.out.println("Data yang anda masukan tidak sesuai.");
                        }
                        break;
                    case 6:
                        try{
                            scan.nextLine();
                            System.out.println("========================================================================");
                            System.out.print("Nama Orang Pertama : "); String person1 = scan.nextLine();
                            System.out.printf("Kapan %s dilahirkan (Tanggal/Bulan/Tahun) : ", person1); String datePerson1 = scan.nextLine();
                            System.out.print("Nama Orang Kedua : "); String person2 = scan.nextLine();
                            System.out.printf("Kapan %s dilahirkan (Tanggal/Bulan/Tahun) : ", person2); String datePerson2 = scan.nextLine();
                            long selisihUmur = Menu6(datePerson1,datePerson2);
                            if (selisihUmur < 0) {
                                String selisihUmurString = String.valueOf(selisihUmur);
                                selisihUmurString = selisihUmurString.replace('-',' ');
                                System.out.printf("Perbedaan umur %s dan %s adalah %s tahun pada hari ini. \n\n", person1,person2,selisihUmurString);
                            }else{
                                String selisihUmurString = String.valueOf(selisihUmur);
                                System.out.printf("Perbedaan umur %s dan %s adalah %s tahun pada hari ini. \n", person1,person2,selisihUmurString);
                            }

                            System.out.printf("================================================================\n");
                            System.out.println("Kembali ke menu ? \n Ketik 0 jika YA, ketik 1 jika TIDAK "); menu = scan.nextInt();
                        }catch (Exception ex){
                            System.out.println("Data yang anda masukan tidak sesuai.");
                        }
                        break;
                    default:
                        System.out.println("Terima kasih !");
                        System.exit(0);
                }
            }
        } catch (Exception e) {
            System.out.println("Input salah" + "\nTerima kasih telah menggunakan layanan kami");
        }
    }

    public static String Menu1 = "Selama Hari Raya Idul Fitri, mohon maaf lahir dan batin.";
    public static void Menu2(String nama){
        System.out.printf("Kepada %s, Selamat Hari Raya Idul Fitri, mohon maaf lahir dan batin \n", nama);
    }
    public static long Menu3(String tanggal1,String tanggal2){
        Locale indonesia = new Locale("id", "ID");
        DateTimeFormatter indoFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy", indonesia);

        String date1 = tanggal1;
        String date2 = tanggal2;
        LocalDate newDate1 = LocalDate.parse(date1, indoFormat);
        LocalDate newDate2 = LocalDate.parse(date2, indoFormat);

        long selisih;
        selisih = ChronoUnit.DAYS.between(newDate1,newDate2);
        return selisih;
    }
    public static double Menu4(double jarak, double waktu){
        double kecepatan;
        kecepatan = jarak / waktu;
        return kecepatan;
    }
    public static boolean Menu5(int tahun){
        boolean kabisat;
        LocalDate year = LocalDate.of(tahun,1,1);
        kabisat = year.isLeapYear();

        return  kabisat;
    }
    public static long Menu6(String datePerson1, String datePerson2){
        Locale indonesia = new Locale("id", "ID");
        DateTimeFormatter indoFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy", indonesia);

        String date1 = datePerson1;
        String date2 = datePerson2;
        LocalDate newDate1 = LocalDate.parse(date1, indoFormat);
        LocalDate newDate2 = LocalDate.parse(date2, indoFormat);

        long selisih;
        selisih = ChronoUnit.YEARS.between(newDate1,newDate2);
        return selisih;

    }

}
