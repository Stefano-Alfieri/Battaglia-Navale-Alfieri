package org.generation.italy;

import java.util.Scanner;
import java.util.Random;

public class BattagliaNavale {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random r = new Random();
		String risposta;
		do {
			String navi[][] = new String[8][8];
			String campo[][] = new String[8][8];
			String numeroGiocatori;
			int contatore = 0, x, y, verso, xSparo, ySparo, contatoreSparo = 0;
			// creazione campi
			for (int i = 0; i <= 7; i++) {
				for (int j = 0; j <= 7; j++) {
					campo[i][j] = "0";
					navi[i][j] = "0";
				}
			}
			System.out.println("Benvenuto nel gioco di battaglia navale.");
			System.out.println("selezionare numero giocatori(1 o 2)");
			numeroGiocatori = sc.nextLine();
			if (numeroGiocatori.equals("1")) {
				System.out.println("hai selezionato la modalità giocatore singolo");
				// posizionamento navi
				do {
					contatore = 0;
					verso = r.nextInt(2);// verso nave tramite 0 e 1
					if (verso == 0) {// verticale
						y = r.nextInt(6);
						x = r.nextInt(8);
						if (navi[y][x].equals(navi[y + 1][x]) && navi[y][x].equals(navi[y + 2][x])
								&& navi[y][x].equals("0")) {
							navi[y][x] = "1";
							navi[y + 1][x] = "1";
							navi[y + 2][x] = "1";
						}
					} else {
						y = r.nextInt(8);
						x = r.nextInt(6);
						if (navi[y][x].equals(navi[y][x + 1]) && navi[y][x].equals(navi[y][x + 2])
								&& navi[y][x].equals("0")) {
							navi[y][x] = "1";
							navi[y][x + 1] = "1";
							navi[y][x + 2] = "1";
						}
					}
					// conteggio navi
					for (int i = 0; i < 8; i++) {
						for (int j = 0; j < 8; j++) {
							if (!navi[i][j].equals("0"))
								contatore++;
						}
					}
				} while (contatore < 3);
				// stampa campo computer
				System.out.println("Campo computer:");
				for (int i = 0; i <= 7; i++) {
					for (int j = 0; j <= 7; j++) {
						System.out.print(navi[i][j]);
					}
					System.out.println();
				}
				// parte sparo
				do {
					System.out.println("Inserisci le cordinate del tuo sparo");
					System.out.println("riga:");
					ySparo = sc.nextInt();
					System.out.println("colonna");
					xSparo = sc.nextInt();
					sc.nextLine();
					// verifica sparo valido
					if (xSparo < 8 && ySparo < 8) {
						if (!navi[ySparo][xSparo].equals("0") && !campo[ySparo][xSparo].equals("1")
								&& !campo[ySparo][xSparo].equals("/")) {
							campo[ySparo][xSparo] = "1";
							contatoreSparo++;
							// verifica se colpito o no
							if (contatoreSparo < contatore)
								System.out.println("Colpito!");
							else
								System.out.println("Affondato!");
						} else if (campo[ySparo][xSparo].equals("1") || campo[ySparo][xSparo].equals("/")) {
							System.out.println("hai già sparato in questo punto");

						} else {
							System.out.println("Acqua!");
							campo[ySparo][xSparo] = "/";
						}
					} else
						System.out.println("Fuori dal campo!");
					// stampa campo giocatore
					System.out.println("Campo Giocatore:");
					for (int i = 0; i < 8; i++) {
						for (int j = 0; j < 8; j++) {
							System.out.print(campo[i][j]);
						}
						System.out.println();
					}
				} while (contatoreSparo < contatore);
				System.out.println("hai vinto");
			} else if (numeroGiocatori.equals("2")) {
				System.out.println("modalità due giocatori ancora non disponibile");
			}
			System.out.println("vuoi iniziare una nuova partita?");
			risposta = sc.nextLine();
		} while (risposta.equalsIgnoreCase("si"));
		System.out.println("arrivederci.");

	}// fine main

}