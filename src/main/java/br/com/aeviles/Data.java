package br.com.aeviles;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Data {
	public static void main(String[] args) {
		
		LocalDate hoje = LocalDate.now();
		System.out.println(hoje);
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println(hoje.format(formatador));
		
		
		
		LocalDateTime agora = LocalDateTime.now();
		System.out.println(agora);
		DateTimeFormatter formatadorHora=DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
		System.out.println(agora.format(formatadorHora));
		
		//trabalha com enum
		DateTimeFormatter formatadorCurto=DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		System.out.println(agora.format(formatadorCurto));
		
		DateTimeFormatter formatadorLongo=DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
		System.out.println(agora.format(formatadorLongo));
		
		DateTimeFormatter formatadorFull=DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
		System.out.println(agora.format(formatadorFull));
		
		//ESSE TAMBÉM CRIA UM ENUM
		DateTimeFormatter formatadorMedio=DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(new Locale("pt","br"));
		System.out.println(agora.format(formatadorMedio));
		System.out.println(agora.minusHours(5));
		System.out.println(agora.plusHours(5));
		
	}
	
	

}
