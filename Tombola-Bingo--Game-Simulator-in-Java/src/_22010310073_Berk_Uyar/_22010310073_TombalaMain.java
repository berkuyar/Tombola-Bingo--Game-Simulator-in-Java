package _22010310073_Berk_Uyar;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _22010310073_TombalaMain {


		 public static void main(String[] args) {
		        try {
		            List<_22010310073_Oyuncu> oyuncular = new ArrayList<>();
		            BufferedReader br = new BufferedReader(new FileReader("Bilgiler.txt"));
		            String line;
		            while ((line = br.readLine()) != null) {
		                String[] parts = line.split(" ");
		                String isim = parts[0];
		                String kartIsmi = parts[1];
		                Set<Integer> sayilar = new HashSet<>();
		                for (int i = 2; i < parts.length; i++) {
		                    sayilar.add(Integer.parseInt(parts[i]));
		                }
		                oyuncular.add(new _22010310073_Oyuncu(isim, kartIsmi, sayilar));
		            }
		            br.close();

		            _22010310073_TombalaOyun oyun = new _22010310073_TombalaOyun(oyuncular);
		            oyun.baslat();
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
		    }
		}