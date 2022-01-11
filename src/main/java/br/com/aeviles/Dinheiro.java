package br.com.aeviles;

import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.NumberValue;

import org.javamoney.moneta.Money;
import org.javamoney.moneta.function.MonetaryOperators;

import br.com.caelum.stella.inwords.FormatoDeReal;
import br.com.caelum.stella.inwords.NumericToWordsConverter;

public class Dinheiro {

	public static void main(String[] args) {

		//primeira coisa para trabalhar com essa API é necessario criar a moeda
		CurrencyUnit moeda=Monetary.getCurrency("BRL");//qual a moeda que quero criar
		
		//criar valor
		MonetaryAmount valorDaParcela = Money.of(75, moeda);
		System.out.println(valorDaParcela);
		
		MonetaryAmount valorTotal = valorDaParcela.multiply(12);
		System.out.println(valorTotal);
		
		//10% do valor total
		MonetaryAmount desconto=valorTotal.with(MonetaryOperators.percent(10));
		System.out.println(desconto);
		
		NumberValue descontoSemMoeda = desconto.getNumber();
		
		//integrar com a bibliteca stela para  escrever por extenso
		
		NumericToWordsConverter conversor = new NumericToWordsConverter(new FormatoDeReal());
		String valorPorExtenso=conversor.toWords(descontoSemMoeda.doubleValue());
		System.out.println(valorPorExtenso);
		
		
	}

}
