package br.com.yasmimm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author Yasmimm Alves
 *
 */
public class Desafio {

	public static void main(String[] args) {
		problema1();
		problema2();
	}

	private static void problema2() {
		int[][] board01 = { 
				{ 5, 3, 0, 0, 7, 0, 0, 0, 0 }, 
				{ 6, 0, 0, 1, 9, 5, 0, 0, 0 }, 
				{ 0, 9, 8, 0, 0, 0, 0, 6, 0 },
				{ 8, 0, 0, 0, 6, 0, 0, 0, 3 }, 
				{ 4, 0, 0, 8, 0, 3, 0, 0, 1 }, 
				{ 7, 0, 0, 0, 2, 0, 0, 0, 6 },
				{ 0, 6, 0, 0, 0, 0, 2, 8, 0 }, 
				{ 0, 0, 0, 4, 1, 9, 0, 0, 5 }, 
				{ 0, 0, 0, 0, 8, 0, 0, 7, 9 } 
			};

		int[][] board02 = { 
				{ 8, 3, 0, 0, 7, 0, 0, 0, 0 }, 
				{ 6, 0, 0, 1, 9, 5, 0, 0, 0 }, 
				{ 0, 9, 8, 0, 0, 0, 0, 6, 0 },
				{ 8, 0, 0, 0, 6, 0, 0, 0, 3 }, 
				{ 4, 0, 0, 8, 0, 3, 0, 0, 1 }, 
				{ 7, 0, 0, 0, 2, 0, 0, 0, 6 },
				{ 0, 6, 0, 0, 0, 0, 2, 8, 0 }, 
				{ 0, 0, 0, 4, 1, 9, 0, 0, 5 }, 
				{ 0, 0, 0, 0, 8, 0, 0, 7, 9 } 
			};

		System.out.println("\nPROBLEMA 02");

		System.out.println("Resultado do board 01: " + verificarRegrasSudoku(board01));
		System.out.println("Resultado do board 02: " + verificarRegrasSudoku(board02));
	}

	private static boolean verificarRegrasSudoku(int[][] board) {
		boolean validador = true;

		if (!regra01(board)) {
			validador = false;
		}

		if (!regra02(board)) {
			validador = false;
		}

		if (!regra03(board)) {
			validador = false;
		}

		return validador;
	}

	private static boolean regra01(int[][] board) {

		boolean controleExterno = true;
		ArrayList<Integer> arrControle = new ArrayList<Integer>();

		for (int linha = 0; linha <= 8; linha++) {

			arrControle.clear();

			for (int coluna = 0; coluna <= 8; coluna++) {

				if (board[linha][coluna] != 0) {

					boolean controleInterno = true;
					Integer itemA = board[linha][coluna];

					for (Integer itemB : arrControle) {
						if (itemB.equals(itemA)) {
							controleInterno = false;
							controleExterno = false;
						}
					}

					if (controleInterno) {
						arrControle.add(itemA);
					}

				}
			}
		}

		System.out.println("\nRESULTADO REGRA 01: " + controleExterno);

		return controleExterno;
	}

	private static boolean regra02(int[][] board) {
		boolean controleExterno = true;
		ArrayList<Integer> arrControle = new ArrayList<Integer>();

		for (int coluna = 0; coluna <= 8; coluna++) {

			arrControle.clear();

			for (int linha = 0; linha <= 8; linha++) {

				boolean controleInterno = true;
				int itemA = board[linha][coluna];

				if (itemA != 0) {

					for (Integer itemB : arrControle) {
						if (itemA == itemB) {
							controleInterno = false;
							controleExterno = false;
						}
					}

					if (controleInterno) {
						arrControle.add(itemA);
					}

				}
			}
		}

		System.out.println("RESULTADO REGRA 02: " + controleExterno);

		return controleExterno;
	}

	private static boolean regra03(int[][] board) {
		boolean validador = true;

		for (int i = 0; i <= 2; i++) {

			int linha = i * 3;

			for (int j = 0; j <= 2; j++) {

				int coluna = j * 3;

				validador = verificarQuadrante(linha, coluna, board);

				System.out.println(" * resultado quadrante[" + linha + "][" + coluna + "]:" + validador);
			}
		}

		System.out.println("RESULTADO REGRA 03: " + validador);

		return validador;
	}

	private static boolean verificarQuadrante(int inicioLinha, int inicioColuna, int[][] board) {

		ArrayList<Integer> arrayControle = new ArrayList<Integer>();
		boolean validador = true;
		int fimLinha = inicioLinha + 2;
		int fimColuna = inicioColuna + 2;

		arrayControle.clear();

		for (int linha = inicioLinha; linha <= fimLinha; linha++) {
			for (int coluna = inicioColuna; coluna <= fimColuna; coluna++) {

				int itemA = board[linha][coluna];

				if (itemA != 0) {
					for (Integer itemB : arrayControle) {

						if (itemA == itemB) {
							validador = false;
							// System.out.println(" * item repetido: " + itemA);
						}

					}

					if (validador) {
						arrayControle.add(itemA);
						// System.out.println(" * item não repetido: " + itemA);
					}
				}
			}
		}

		return validador;
	}

	public static void problema1() {
		ArrayList<Integer> minhaLista = new ArrayList<Integer>(
				Arrays.asList(new Integer[] { 8, 5, 10, 5, 2, 4, 4, 3 }));

		Collections.sort(minhaLista);
		removeDuplicados(minhaLista);

		System.out.println("PROBLEMA 01 \n");

		for (int elementoAtual : minhaLista) {
			System.out.println("Lista Única e Ordenada: " + elementoAtual);
		}
	}

	private static void removeDuplicados(ArrayList<Integer> minhaLista) {
		ArrayList<Integer> listaUnicas = new ArrayList<Integer>();
		boolean validador = true;
		for (Integer itemA : minhaLista) {
			validador = true;
			for (Integer itemB : listaUnicas) {
				if (itemA.equals(itemB)) {
					validador = false;
				}
			}
			if (validador == true) {
				listaUnicas.add(itemA);
			}
		}
		minhaLista.clear();
		minhaLista.addAll(listaUnicas);
	}

}
