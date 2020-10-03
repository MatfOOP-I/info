public class AktivanProces extends Proces {

    private int iskoriscenostCPU;


    public AktivanProces(int pid, String naziv, int mb, int cpu) {
        super(pid, naziv, mb);
        this.iskoriscenostCPU = cpu;
    }


    public int getIskoriscenostCPU() {
        return iskoriscenostCPU;
    }

    @Override
    public String toString() {
        return super.toString() + " / " + this.getIskoriscenostCPU() + "% CPU";
    }
}
