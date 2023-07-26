import java.util.Random;
import java.util.Scanner;
public class jogo {
	
	
	private static char [][] matriz1 = new char[4][4];
	private static char [][] matriz2 = new char[4][4];
	private static char [][] matrizshow2 = new char[4][4];
	private static char [][] matrizshow1 = new char [4][4];
	
	public static void MostrarMatrizesSimultaneasJogoSozinho() {
	
		System.out.println("Matriz 1\t Matriz 2");
		byte cont =2;
		while(cont>0){
			for(byte i=0;i<4;i++) {
				System.out.print(" "+i);
			}
			System.out.print("\t ");
			cont--;
		}

		for(byte i=0;i<4;i++) {
			System.out.print("\n"+i);
			for(byte j=0;j<matriz1[i].length;j++) {
				if(matriz1[i][j]!='S'&& matriz1[i][j]!='T'&& matriz1[i][j]!='X') {
					matriz1[i][j]='*';
					if(j==0) {
						System.out.print(matriz1[i][j]);
					}else {
						System.out.print(" "+matriz1[i][j]);
					}
				}else {
					if(j==0) {
						System.out.print(matriz1[i][j]);
					}else {
						System.out.print(" "+matriz1[i][j]);
					}
				}
			}
			System.out.print("\t "+i);
			for(byte j=0;j<matriz2[i].length;j++) {
				if(matriz2[i][j]!='T'&& matriz2[i][j]!='X') {
					matrizshow2[i][j]='*';
					if(j==0) {
						System.out.print(matrizshow2[i][j]);
					}else {
						System.out.print(" "+matrizshow2[i][j]);
					}
				}else {
					if(matriz2[i][j] == 'T') {
						matrizshow2[i][j] = 'T';
						if(j==0) {
							System.out.print(matrizshow2[i][j]);
						}else {
							System.out.print(" "+matrizshow2[i][j]);
						}
					}else {
						matrizshow2[i][j] = 'X';
						if(j==0) {
							System.out.print(matrizshow2[i][j]);
						}else {
							System.out.print(" "+matrizshow2[i][j]);
						}
					}
				}
			}
		}
		
	}

	
	public static void MostrarMatriz1() {
		for(byte i=0;i<4;i++) {
			System.out.print(" "+i);
		}

		for(byte i=0;i<4;i++) {
			System.out.print("\n"+i);
			for(byte j=0;j<4;j++) {
				if(matriz1[i][j]!='S') {
					matriz1[i][j]='*';
					if(j==0) {
						System.out.print(matriz1[i][j]);
					}else {
						System.out.print(" "+matriz1[i][j]);
					}
				}else {
					if(j==0) {
						System.out.print(matriz1[i][j]);
					}else {
						System.out.print(" "+matriz1[i][j]);
					}
				}
			} 
		}
		
	}
	
	
	public static void MostrarMatriz2() {
		for(byte i=0;i<4;i++) {
			System.out.print(" "+i);
		}

		for(byte i=0;i<4;i++) {
			System.out.print("\n"+i);
			for(byte j=0;j<4;j++) {
				if(matriz2[i][j]!='S') {
					matriz1[i][j]='*';
					if(j==0) {
						System.out.print(matriz2[i][j]);
					}else {
						System.out.print(" "+matriz2[i][j]);
					}
				}else {
					if(j==0) {
						System.out.print(matriz2[i][j]);
					}else {
						System.out.print(" "+matriz2[i][j]);
					}
				}
			} 
		}
		
	}
	
	
	public static void main (String[] arg) throws InterruptedException{
		
		Scanner input = new Scanner (System.in);
		Random sort = new Random ();
		System.out.print("\tBatalha Naval");
		System.out.println("\nEscolha uma opção de Jogo:");
		System.out.println("1-Jogar com a Máquina");
		System.out.println("2-Jogar com um amigo");
		System.out.print("~>");
		byte opcao = input.nextByte();
	
		switch(opcao) {
			case 1:
			//Posicionamento dos submarinos
				//mostrando matriz do usuario e escolhendo a onde vai colocar os submarinos 
				System.out.println("\nVocê tem 4 submarinos, informe onde vai posiciona-los:");
				byte submarino = 0;
				while(submarino<4) {
					MostrarMatriz1();
					submarino++;
					System.out.println("\n"+submarino+"° submarino");
					System.out.print("Informe a linha:");
					byte linha = input.nextByte();
					System.out.print("Informe a coluna:");
					byte coluna = input.nextByte();
					if(linha>3||coluna>3){

					}
					while( matriz1[linha][coluna]=='S') {
						MostrarMatriz1();
						System.out.print("\nVocê ja posicionou um submarino aqui, escolha outro lugar...");
						System.out.print("\nInforme a linha:");
						linha = input.nextByte();
						System.out.print("Informe a coluna:");
						coluna = input.nextByte();
					}
					 matriz1[linha][coluna]='S';
				}
				
				
				//robo escolhendo onde vai ficar os submarinos
				for(byte i =0;i<4;i++){
					int linhas = sort.nextInt(4);
					int colunas = sort.nextInt(4);
					boolean tem = true;
					//se ja tiver um sbmarino no lugar sorteado vai ser sorteado outro lugar, se não o submarino vai ser colocado no lugar sorteado 
					while(tem){
						if(matriz2[linhas][colunas]== 'S') {
							linhas = sort.nextInt(4);
							colunas = sort.nextInt(4);
						}else {
							matriz2[linhas][colunas] = 'S';
							tem= false;
						}
					}
					
				}
				//arrumando matriz2
				for(byte i=0;i<4;i++) {
					for(byte j=0;j<4;j++){
						if(matriz2[i][j]!='S') {
							matriz2[i][j]='*';
						}	
					}
				}
				
				//jogo
				byte submarino1=4;
				byte submarino2 = 4;
				while(submarino1>0 || submarino2>0) {
					//jogo usuario
					System.out.println("~>Escolha onde atacar");
					MostrarMatrizesSimultaneasJogoSozinho();
					Thread.sleep(5000);
					System.out.print("\nLinha:");
					byte linha =input.nextByte();
					System.out.print("Coluna:");
					byte coluna = input.nextByte();
					if(matriz2[linha][coluna]=='*') {
						matriz2[linha][coluna]='T';
						matrizshow2[linha][coluna]='T';
						
					}else{
						while(matriz2[linha][coluna] == 'S'){
							matrizshow2[linha][coluna]='X';
							matriz2[linha][coluna]='X';
							submarino2--;
							System.out.println("~>Escolha onde atacar");
							MostrarMatrizesSimultaneasJogoSozinho();
							System.out.print("\nLinha:");
							linha =input.nextByte();
							System.out.print("Coluna:");
							coluna = input.nextByte();
						}
						matrizshow2[linha][coluna]='T';
						matriz2[linha][coluna]='T';
					}
					MostrarMatrizesSimultaneasJogoSozinho();
					System.out.println("\nVez da maquina...");
					Thread.sleep(5000);
					// jogo maquina
					if(submarino2>0){
						int linhas =sort.nextInt(4);
						int colunas = sort.nextInt(4);
						while(matriz1[linhas][colunas]=='T'||matriz1[linhas][colunas]=='X') {
							linhas =sort.nextInt(4);
							colunas = sort.nextInt(4);
						}
						if(matriz1[linhas][colunas]=='*') {
							matriz1[linhas][colunas]='T';
							System.out.println("A maquina não acertou nenhum submarino.");
						
						}else{
							while(matriz1[linhas][colunas] == 'S'){
								matriz1[linhas][colunas]='X';
								submarino1--;
								 linhas =sort.nextInt(4);
								 colunas = sort.nextInt(4);
							 	while(matriz1[linhas][colunas]=='T'||matriz1[linhas][colunas]=='X') {
									linhas =sort.nextInt(4);
									colunas = sort.nextInt(4);
									
								}
								MostrarMatrizesSimultaneasJogoSozinho();
								Thread.sleep(5000);
								System.out.println("\nVez da maquina...");
							
							}
							matriz1[linhas][colunas]='T';
							System.out.println("A maquina não acertou nenhum submarino.");
						}
					}
					
				}
				if(submarino1>0){
					System.out.println("Você ganhou!!!");
				}else {
					System.out.println("Você perdeu...");
				}
				
				
				
			break;
			case 2:
				
				
			break;
	
		
		}
		input.close();
  }
}