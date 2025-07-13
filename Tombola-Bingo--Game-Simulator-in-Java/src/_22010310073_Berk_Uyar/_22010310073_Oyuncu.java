package _22010310073_Berk_Uyar;

import java.util.Set;

public class _22010310073_Oyuncu {
	String name;
    _22010310073_Kart kart;

    _22010310073_Oyuncu(String name, _22010310073_Kart kart) {
        this.name = name;
        this.kart = kart;
    }

    boolean isWinner() {
        return kart.numbers.isEmpty();
    }
}

