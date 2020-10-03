package klasifikacija;

public enum Pol
{
    MUSKO, ZENSKO;

    @Override
    public String toString()
    {
        switch (this)
        {
            case MUSKO: return "m";
            case ZENSKO: return "z";
            default: return "z";
        }
    }

    public static Pol createFromString(String s)
    {
        if (s.equals("m")) return MUSKO;
        else return ZENSKO;
    }
}
