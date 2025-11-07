interface Computer{
    void code();
}
class Lap implements Computer{
    public void code(){
        System.out.println("Code,Run,Running...");
    }
}
class Dev implements Computer{
    public void devApp(Computer laptop) {
       laptop.code();
    }

    @Override
    public void code() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'code'");
    }
}
class Desktop implements Computer{
    public void code(){
        System.out.println("Code,Run, Faster");
    }
}
public class MainClass {
    public static void main(String[] args) {
        Desktop dk=new Desktop();
        Lap lp = new Lap();
        Dev dhee=new Dev();
        dhee.devApp(dk);
    }
}
