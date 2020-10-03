/**
 * Функције за одређивање НЗД за два и за три цела броја.
 */

class ModularnoNzdNzsFunkcije {
    // Oдређивање НЗД за два броја
    static int NZD(int prvi, int drugi) {
        while (true)
            if (prvi > drugi)
                // први је већи
                if (prvi % drugi == 0)
                    return drugi;
                else
                    prvi %= drugi;
            else
                // први је мањи или једнак
                if (drugi % prvi == 0)
                    return prvi;
                else
                    drugi %= prvi;
    }

    // одређивање НЗД за три броја
    static int NZD(int prvi, int drugi, int treci) {
        return NZD(NZD(prvi, drugi), treci);
    }

    // одређивање НЗС за два броја
    static int NZS(int prvi, int drugi) {
        return (prvi * drugi) / NZD(prvi, drugi);
    }

    // одређивање НЗС за три броја
    static int NZS(int prvi, int drugi, int treci) {
        return NZS(NZS(prvi, drugi), treci);
    }

}
