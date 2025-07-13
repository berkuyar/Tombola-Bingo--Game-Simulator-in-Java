package _22010310073_Berk_Uyar;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class _22010310073_TombalaOyun {

	private List<_22010310073_Oyuncu> oyuncular;
    private Set<Integer> cekilenSayilar;
    private Random random;

    public _22010310073_TombalaOyun(List<_22010310073_Oyuncu> oyuncular) {
        this.oyuncular = oyuncular;
        this.cekilenSayilar = new HashSet<>();
        this.random = new Random();
    }

    public void baslat() throws InterruptedException {
        System.out.println("Oyun başladı.");
        while (true) {
            int sayi = random.nextInt(20) + 1;
            if (cekilenSayilar.contains(sayi)) continue;

            cekilenSayilar.add(sayi);
            System.out.println("Çekilen sayı: " + sayi);

            for (_22010310073_Oyuncu oyuncu : oyuncular) {
                oyuncu.sayiCekildi(sayi);
                System.out.println(oyuncu.durumYazdir(sayi));
                if (oyuncu.kazandiMi()) {
                    System.out.println("Kazanan: " + oyuncu.getIsim());
                    return;
                }
            }
            Thread.sleep(500);
        }
    }
}
