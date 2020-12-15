/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datamahasiswa;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import java.util.Collections;
/**
 *
 * @author Alvi
 */
public class Mahasiswa {
    String nim;
    String nam;
    int gender, tanggal, bulan, tahun;
    int nomenu;
    int menu = 1;
    Scanner input = new Scanner(System.in);
    ArrayList<String> daftarnim = new ArrayList();
    ArrayList<String> daftarnama = new ArrayList();
    ArrayList<Integer> daftargender = new ArrayList();
    ArrayList<Date> daftartgllahir = new ArrayList();
    
    void tambahData() {
        System.out.println("Masukkan Data Anda");
        input.nextLine();
        System.out.print("NIM : ");
        nim = input.nextLine();
        daftarnim.add(nim);
        System.out.print("Nama : ");
        nam = input.nextLine();
        daftarnama.add(nam);
        System.out.println("Tanggal Lahir (dd-mm-yyyy):");
        System.out.print("Tanggal : ");
        tanggal = input.nextInt();
        System.out.print("Bulan : ");
        bulan = input.nextInt();
        System.out.print("Tahun : ");
        tahun = input.nextInt();
        Date tanggall = new GregorianCalendar(tahun, bulan - 1, tanggal).getTime();
        daftartgllahir.add(tanggall);
        System.out.print("Gender (0:Perempuan 1:Laki-laki) :");
        gender = input.nextInt();
        daftargender.add(gender);
        System.out.println("Data telah tersimpan");
    }
    void hapusData(){
        if (daftarnim.size() > 0 ){
            System.out.print("Masukkan NIM : ");
            input.nextLine();
            String nimm = input.nextLine();
            if (nim.contains(nimm)== true){
                int index = Collections.binarySearch(daftarnim, nimm);
                daftarnim.remove(index);
                daftarnama.remove(index);
                daftargender.remove(index);
                daftartgllahir.remove(index);
                System.out.println("Data telah terhapus");
            }
            else {
                System.out.println("Data tidak ditemukan");
            }
        }
    }
    void cariData(){
        System.out.println("Anda ingin mencari data berdasarkan apa ?\n1. Berdasarkan Gender\n2. Berdasarkan NIM");
        System.out.print("Masukkan nomer pilihan Anda :");
        Integer nopil = input.nextInt();
        if (nopil == 1){
            System.out.print("Masukkan Gender (0:Perempuan 1:Laki-Laki) : ");
            Integer gen = input.nextInt();
            for (int g = 0; g < daftargender.size(); g++){
                if (this.daftargender.get(g) == gen){
                    System.out.println("Nama :" + daftarnama.get(g));
                    System.out.println("NIM :" + daftarnim.get(g));
                    System.out.println("Gender :" + daftargender.get(g));
                    System.out.println("Tgl Lahir :" + daftartgllahir.get(g));
                }
                else {
                    System.out.println("Tidak ada data yang tersedia");
                }
            }
        }else if (nopil == 2){
            if (daftarnim.size() > 0){
                System.out.print("Masukkan NIM : ");
                input.nextLine();
                String nonim = input.nextLine();
                if (nim.contains(nonim)== true){
                    int lala = Collections.binarySearch(daftarnim, nonim);
                    String namaa = daftarnama.get(lala);
                    String niim = daftarnim.get(lala);
                    Integer gendeer = daftargender.get(lala);
                    Date tgllahiir = daftartgllahir.get(lala);
                    System.out.println("Nama :"+ namaa);
                    System.out.println("NIM :"+ niim);
                    System.out.println("Gender :"+ gendeer);
                    System.out.println("Tgl Lahir :"+ tgllahiir);
                }
                else {
                    System.out.println("Data yang anda cari tidak ada");
                }
            }
            else {
                System.out.println("Tidak ada data yang tersedia");
            }
        }
    }
    void menampilkanData(){
        for (int i = 0; i < daftarnama.size(); i++){
            System.out.println("Nama :" + daftarnama.get(i));
            System.out.println("NIM :" + daftarnim.get(i));
            System.out.println("Gender :" + daftargender.get(i));
            System.out.println("Tgl Lahir :" + daftartgllahir.get(i));
        }
    }
    void menu(){
        while (menu == 1){
            while(true){
                System.out.println("**********************\nData Mahasiswa\n**********************");
                System.out.println("Menu : \n1. Tambah Data\n2. Hapus Data\n3. Cari Data\n4. Tampil Data\n5. Keluar");
                System.out.print("Pilih no menu: ");
                nomenu = input.nextInt();
                if (nomenu == 1){
                    tambahData();
                }
                else if (nomenu == 2){
                    hapusData();
                }
                else if (nomenu == 3){
                    cariData();
                }
                else if (nomenu == 4){
                    menampilkanData();
                }
                else if (nomenu == 5){
                    menu -= 1;
                    break;
                }
                else {
                    System.out.println("Menu yang anda pilih tidak tersedia, silahkan pilih menu yang ada");
                }
            }
        }
    }
}

