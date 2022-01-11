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
		
//		Faça a validação desse CPF aqui: 51720155232 . Se ele for válido,
//		envie uma cobrança pra ele no valor de R$900,00 ,referente à sua
//		fatura do cartão de crédito. Se não for válido, envie uma mensagem 
//		pedindo para ele atualizar seus dados, pois estão incorretos.
		
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
	    	System.out.println("Boa tarde! Temos uma cobrança de "+ valorCobrancaExtenso + " pendentes");
			
		} catch (InvalidStateException e) {
			System.out.println("Seu CPF está incorreto");
		}
	    
	}

}
