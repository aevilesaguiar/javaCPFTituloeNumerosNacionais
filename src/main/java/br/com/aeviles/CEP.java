package br.com.aeviles;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.http.HttpConnectTimeoutException;

import com.github.gilbertotorrezan.viacep.se.ViaCEPClient;
import com.github.gilbertotorrezan.viacep.shared.ViaCEPEndereco;

public class CEP {

	public static void main(String[] args) {
//FEITO MANUALMENTE
//		try {
//			URL url = new URL("https://viacep.com.br/ws/01001000/json/unicode/");
//			try {
//				HttpURLConnection conexao =(HttpURLConnection) url.openConnection();
//				conexao.setRequestMethod("GET");
//				conexao.getInputStream();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		} catch (MalformedURLException e) {
//			 
//			e.printStackTrace();
//		}
		//O protocolo usado é o HTTP, usando seus verbos GET, POST, UPDATE, DELETE e outros verbos deste protocolo.
		//É muito importante saber o conceito por trás da API ViaCEP, que é o REST
		ViaCEPClient cliente = new ViaCEPClient();
		try {
			ViaCEPEndereco endereco= cliente.getEndereco("82010340");
			System.out.println(endereco.getLogradouro());
			System.out.println(endereco.getComplemento());
			System.out.println(endereco.getIbge());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
