public abstract class Proces {

    private int pid;
    private String ime;
    private int MB;


    protected Proces(int pid, String ime, int mb) {
        this.pid = pid;
        this.ime = ime;
        this.MB = mb;
    }


    public int getPid() {
        return pid;
    }

    public String getIme() {
        return ime;
    }

    public int getMB() {
        return MB;
    }


    @Override
    public String toString() {
        return "[" + this.getPid() + "] " + this.getIme() + " | " + this.getMB() + " MB";
    }
}
