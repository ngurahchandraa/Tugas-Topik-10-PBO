import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    private static Scanner input = new Scanner(System.in);
    private static ArrayList<Member> member = new ArrayList<>();

    public static void main (String[] args){
        int select;
        do {
            System.out.println("--- Select Menu ---");
            System.out.println("1. Input Driver");
            System.out.println("2. Input Customer");
            System.out.println("3. Show Member");
            System.out.println("4. Top-up Saldo");
            System.out.println("5. Antar Penumpang");
            System.out.println("0. Keluar");

            System.out.print("\nSelect Menu : ");
            select = input.nextInt();
            input.nextLine();

            switch (select){
                case 1 :
                    inputDriver();
                    break;
                case 2 :
                    inputCustomer();
                    break;
                case 3 :
                    showMember();
                    break;
                case 4 :
                    transaksi("Top-Up");
                    break;
                case 5 :
                    transaksi("Antar");
                    break;
                case 0 :
                    System.out.println("\n Anda Telah keluar dari aplikasi!");
                    break;
            }

        }while (select != 0);

    }

    private static void inputDriver(){
        System.out.println("\n--- Input Driver ---");
        System.out.print("NIK : ");
        String nik = input.nextLine();
        System.out.print("Nama : ");
        String nama = input.nextLine();
        System.out.print("No Telpon : ");
        String noTelpon = input.nextLine();
        System.out.print("Saldo : ");
        double saldo = input.nextDouble();
        input.nextLine();
        System.out.print("No Plat : ");
        String noPlat = input.nextLine();
        System.out.print("Jenis : ");
        String jenis = input.nextLine();

        Member d = searchMember(nik);

        if(d == null) {
            Driver driver = new Driver(nik, nama, noTelpon, saldo, noPlat, jenis);
            member.add(driver);
            System.out.println("\nDriver berhasil ditambahkan!\n");
        }else {
            System.out.println("\nNIK sudah terdaftar!\n");
        }

    }
    private static void inputCustomer(){
        System.out.println("\n--- Input Customer ---");
        System.out.print("NIK : ");
        String nik = input.nextLine();
        System.out.print("Nama : ");
        String nama = input.nextLine();
        System.out.print("No Telpon : ");
        String noTelpon = input.nextLine();
        System.out.print("Saldo : ");
        double saldo = input.nextDouble();

        Member c = searchMember(nik);

        if(c == null) {
            Customer customer = new Customer(nik, nama, noTelpon, saldo);
            member.add(customer);
            System.out.println("\nCustomer berhasil ditambahkan!\n");
        }else {
            System.out.println("\nNIK sudah terdaftar!\n");
        }
    }
    private static void showMember(){
        System.out.println();
        for (Member m : member){
            m.display();
        }
    }

    private static void transaksi(String tipe){
        if (tipe.equalsIgnoreCase("Top-Up"))
        System.out.println("\n--- Top-Up Saldo ---");
        else
            System.out.println("\n--- Antar Penumpang ---");

        System.out.print("ID Driver : ");
        String nikDriver = input.nextLine();
        System.out.print("ID Customer : ");
        String nikCustomer = input.nextLine();

        if (tipe.equalsIgnoreCase("Top-Up"))
            System.out.print("Nominal : ");
        else
            System.out.print("Biaya : ");

        double nomimal = input.nextDouble();

        Member d = searchMember(nikDriver);
        Member c = searchMember(nikCustomer);

        System.out.println();
        if((d instanceof Driver && c instanceof Customer)){
            if(tipe.equalsIgnoreCase("Top-Up")) {
                if (d.getSaldo() < nomimal){
                    System.out.println("Saldo driver tidak cukup!\n");
                }else {
                    c.transaksi(d, nomimal);
                    System.out.println("Saldo Customer " + c.getNik() + " Ditambahkan!\n");
                }

            }else {
                if (c.getSaldo() < nomimal){
                    System.out.println("Saldo Customer tidak cukup!\n");
                }else {
                    d.transaksi(c, nomimal);
                    System.out.println("Saldo Driver " + d.getNik() + " Ditambahkan!\n");
                }
            }

        }else if (d == null){
            System.out.println("ID Driver Tidak Ditemukan!\n");
        }else {
            System.out.println("ID Customer Tidak Ditemukan!\n");
        }
    }
    private static Member searchMember(String nik){
        Member members = null;
        for(Member m : member){
            if (m.getNik().equalsIgnoreCase(nik)){
                members = m;
                break;
            }
        }
        return members;
    }
}
