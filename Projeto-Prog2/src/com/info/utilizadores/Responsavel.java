package com.info.utilizadores;
/*
 * A classe Responsavel corresponde ao utilizador responsavel pelo paciente que ira se cadastrar
  no sistema e efetuar operacoes como:
  * Ver ficha medica do paciente;
  * Ver estado atual do paciente
  * ver relatorio
  * ver Notificacoes do hospital
  * 
 */



import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.info.utilizadores.abstracts.classes.Pessoa;





public class Responsavel extends Pessoa  {
	

	private boolean cadastrado;
	private ArrayList<String> notificacoes = new ArrayList<String>(); // Arraylist que recebe as notificacoes do hospital
	Scanner scan = new Scanner(System.in); 
	
	public ArrayList<String> getNotificacoes() {
		return notificacoes;
	}

	public void setNotificacoes(String mensagem) { // modifiquei o paramentro
		this.notificacoes.add(mensagem);
	}
	
	// Medoto para cadastrar o usuario responsavel pelo pacientee
	
	public void cadastrar() { 
		try {
			System.out.println("---------Cadastro do responsavel pelo paciente------");
			System.out.print("nome: ");
			String nome = scan.nextLine();
			this.setNome(nome);
			System.out.print("idade: ");
			int idade = scan.nextInt();
			this.setIdade(idade);
			System.out.print("Genero ");
			char genero = scan.next().charAt(0);
			this.setGenero(genero);
			scan.nextLine();
			System.out.print("Numero BI: ");
			String bi = scan.nextLine();
			this.setNumeroBI(bi);
			System.out.print("Endereco: ");
			String endereco = scan.nextLine();
			this.setEndereco(endereco);
			System.out.print("Contacto: ");
			String contacto = scan.nextLine();
			this.setContacto(contacto);
			System.out.print("E-mail: ");
			String email = scan.nextLine();
			this.setEmail(email);
			System.out.println("----------------Cadastrado com sucesoo-----------------------\n Confira os seus dados");
			this.info();
			cadastrado = true;
			
			
			
		}
		catch(InputMismatchException e){
		System.out.println("Erro: Insira os dados corretamente");
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected error" +e.getStackTrace());
		}
	}
	
	
	
	
	// Metodo para acedar as informacoes do paciente associad
	public void operacoes(Paciente paciente) {
		if (cadastrado != true) {
			System.out.println("Erro: Nao esta cadastrado no SISTEMA");
			scan.close();
		}else {
			try {
				int opcao;
				do {
				System.out.println(" 1. Ficha Medica \n 2. Estado clinico \n 3. Notificacoes \n 4. relatorio \n 5. sair");
				opcao = scan.nextInt();
				switch (opcao) {
				case 1:
					System.out.println("Ficha Medica");
					System.out.println("-----Informcoes pessoais----");
					paciente.info();
					System.out.println("--------------------------------");
					System.out.println("Seguro: "+paciente.getCredencial()+"\n Hipertensao: "+paciente.isHipertensao()
					+"\n Diabete: "+paciente.isDiabete()+"\nPeso: "+paciente.getPeso()+"\n");
					if (paciente.isDoencaCronica()==true) {
						System.out.println("Doenca cronica"+paciente.isDoencaCronica()+"   Tipo de doenca: " +paciente.getTipoCronico());
					}else {
						System.out.println(paciente.isDoencaCronica());
					}
					if (paciente.isSeguroMedico()== true) {
						System.out.println("Seguro Medico: "+paciente.isSeguroMedico()+"     Seguradora: "+paciente.getSeguradora());
					}else {
						System.out.println("Seguro Medico: "+paciente.isSeguroMedico());
					} 
					System.out.println("Outras doenas: "+paciente.getOutrasDoencas());
				
				case 2:
					System.out.println("Estado Clinico");
					System.out.println("Infectado: "+paciente.isInfectado());
					System.out.println("Fase: "+paciente.getFaseclinica());break;
			
				case 3:
					System.out.println("Notificacoes");
					System.out.println(this.getNotificacoes());break;
				
				case 4:
					DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
					System.out.println("Relatorio \n "+ dtf.format(LocalDateTime.now())+ "\n"+paciente.getNome()+ 
							"\nTeve como resultado da avaliacao: \n "+paciente.getInfomation());
					
					// ler o arquivo relatorio criado na classe enfermiro
					String path = "D:\\"+paciente.getNome()+""+paciente.getCredencial()+".txt";
					
					try {
						File relatorio = new File(path);
						BufferedReader br = new BufferedReader(new FileReader(relatorio));
						int n =0;
							while((n = br.read()) != -1) {
								System.out.println((char)n);
							}
					}catch (IOException e) {
							System.out.println("Nao ha nenhum relatorio");;
						}
					break;
							
				default:
					System.out.println("Opcao invalida \n");break;
				}
				}while (opcao != 5);
			
				
			}catch(InputMismatchException e){
				System.out.println("Erro: Insira os dados corretamente " );
			}catch(IllegalArgumentException e) {
				System.out.println("Nao esta associado a este paciente");
			}
			catch (RuntimeException e) {
				System.out.println("Unexpected error");
			}
		}
		
	}

	@Override
	public void info() {
		System.out.println("Nome: "+this.getNome()
				+ "\n Bilhete de identificacao NR: "+this.getNumeroBI()+"\n Genero :"+this.getGenero()+"\n Endereco: "+this.getEndereco()+"\n contacto: "+this.getContacto());
	}
	
}
