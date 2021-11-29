public class Customer extends Member{

    public Customer(String nik, String nama, String noTelpon, double saldo){
        super(nik, nama, noTelpon, saldo);
    }

    @Override
    public void display(){
        System.out.println("Status Member : Customer");
        System.out.println("NIK : " + this.nik);
        System.out.println("Nama : " + this.nama);
        System.out.println("No Telpon : " + this.noTelpon);
        System.out.printf("Saldo : %.2f\n" , this.saldo);
        System.out.println();
    }
}
