package br.com.aeviles;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.NumberValue;

import org.javamoney.moneta.Money;

import br.com.caelum.stella.inwords.FormatoDeReal;
import br.com.caelum.stella.inwords.NumericToWordsConverter;
import br.com.caelum.stella.validation.CPFValidator;
import br.com.caelum.stella.validation.InvalidStateException;

public class ValidaCPF {

	public static void main(String[] args) {
		
//		Fa�a a valida��o desse CPF aqui: 51720155232 . Se ele for v�lido,
//		envie uma cobran�a pra ele no valor de R$900,00 ,referente � sua
//		fatura do cart�o de cr�dito. Se n�o for v�lido, envie uma mensagem 
//		pedindo para ele atualizar seus dados, pois est�o incorretos.
		
		String cpf = "51720155232";
		
		//CRIANDO A MOEDA
		CurrencyUnit real = Monetary.getCurrency("BRL");
		MonetaryAmount valorCobranca = Money.of(900, real);
		
		//mostra a penas o numero
		NumberValue valorCobrancaSemUnidadeDeMoeda = valorCobranca.getNumber();
		//transforma por extenso
		NumericToWordsConverter converter = new NumericToWordsConverter(new FormatoDeReal());
		
	    String valorCobrancaExtenso = converter.toWords(valorCobrancaSemUnidadeDeMoeda.doubleValue());
		
	    CPFValidator validador = new CPFValidator();
	    
	    try {
	    	validador.assertValid(cpf);
	    	System.out.println("Boa tarde! Temos uma cobran�a de "+ valorCobrancaExtenso + " pendentes");
			
		} catch (InvalidStateException e) {
			System.out.println("Seu CPF est� incorreto");
		}
	    
	}

}
