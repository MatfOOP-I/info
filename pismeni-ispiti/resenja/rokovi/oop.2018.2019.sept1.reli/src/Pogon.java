public enum Pogon {
    Prednji,
    Zadnji,
    SvaCetiri;

    public String toString() {
        switch (this) {
            case Prednji: return "FWD";
            case Zadnji: return "RWD";
            case SvaCetiri: return "4WD";
        }
        return "404";
    }

    public static Pogon izNiske(String s) {
        switch (s) {
            case "FWD": return Pogon.Prednji;
            case "RWD": return Pogon.Zadnji;
            case "4WD": return Pogon.SvaCetiri;
            default: return Pogon.SvaCetiri;
        }
    }
}
