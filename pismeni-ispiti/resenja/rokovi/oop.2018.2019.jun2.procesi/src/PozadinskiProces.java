public class PozadinskiProces extends Proces {

    private boolean sys;


    public PozadinskiProces(int pid, String ime, int mb, boolean sys) {
        super(pid, ime, mb);
        this.sys = sys;
    }


    public boolean isSys() {
        return sys;
    }

    @Override
    public String toString() {
        return super.toString() + (sys ? " (System)" : "");
    }
}
