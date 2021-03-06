public class Driver extends Member{
    private String noPlat, jenis;

    public Driver(String nik, String nama , String noTelpon, double saldo, String noPlat, String jenis){
        super(nik, nama, noTelpon, saldo);
        this.noPlat = noPlat;
        this.jenis = jenis;
    }
    @Override
    public void display(){
        System.out.println("Status Member : Driver");
        System.out.println("NIK : " + this.nik);
        System.out.println("Nama : " + this.nama);
        System.out.println("No Telpon : " + this.noTelpon);
        System.out.printf("Saldo : %.2f\n" , this.saldo);
        System.out.println("No Plat : " + this.noPlat);
        System.out.println("Jenis : " + this.jenis);
        System.out.println();


    }
}
