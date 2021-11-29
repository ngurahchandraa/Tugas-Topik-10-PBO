public abstract class Member {
    protected String nik ,  nama , noTelpon;
    protected  double saldo;

    public Member (String nik, String nama, String noTelpon , double saldo){
        this.nik = nik;
        this.nama = nama;
        this.noTelpon = noTelpon;
        this.saldo = saldo;
    }

    public void transaksi(Member lain, double nominal){
        this.saldo = this.saldo + nominal;
        lain.saldo = lain.saldo - nominal;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getNik(){
        return nik;
    }
    public abstract void display();
}
