public class Grip extends ZaraznaBolest {
    public Grip(int duzinaBolesti){
        super(duzinaBolesti);
    }
    public Grip(Grip g){
        this(g.getDuzinaBolesti());
    }

    @Override
    public String toString() {
        return "Grip traje: " + super.getDuzinaBolesti();
    }
}
