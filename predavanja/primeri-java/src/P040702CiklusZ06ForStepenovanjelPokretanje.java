/*

Написати Јава програм који одређује степен датог
реалног броја (основе) датим природним изложиоцем.

*/

// Задатак представља илустрацију коришћења наредбе циклуса do while

class PokretanjeForStepenovanjel {

    public static void main(String[] args) {
        int n = 10;
        double x = 2;
        double stepen = 1;
        for (int i = 1; i <= n; i++)
            stepen *= x;
        System.out.println(x + "^" + n + "=" + stepen);
    }
}
