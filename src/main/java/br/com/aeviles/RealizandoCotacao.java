package br.com.aeviles;

import org.javamoney.moneta.FastMoney;
import org.javamoney.moneta.convert.ExchangeRateType;
import javax.money.CurrencyUnit;
import javax.money.Monetary;
import javax.money.MonetaryAmount;
import javax.money.convert.CurrencyConversion;
import javax.money.convert.ExchangeRateProvider;
import javax.money.convert.MonetaryConversions;



public class RealizandoCotacao {

	public static void main(String[] args) {
		//ExchangeRateProvider do API
		//Primeiro vamos criar as moedas e os valores
        // moedas
        CurrencyUnit dolar = Monetary.getCurrency("USD");
        CurrencyUnit real = Monetary.getCurrency("BRL");
        // valores
        MonetaryAmount valorProdutoDolar = FastMoney.of(90, dolar);
        MonetaryAmount valorImpostoReal = FastMoney.of(30, real);

        //Agora vamos usar o provider para pegar a cota��o
        ExchangeRateProvider provider = MonetaryConversions.getExchangeRateProvider(ExchangeRateType.ECB_HIST90);

        //Vamos pegar a convers�o atual(do dia)
        CurrencyConversion conversaoAtual = provider.getCurrencyConversion(dolar);

        //Agora vamos transformar o valor do imposto em Real para d�lar
        MonetaryAmount valorImpostoDolar = conversaoAtual.apply(valorImpostoReal);

        //Agora que o valor do imposto est� em d�lar, podemos somar com o valor inicial do produto
        MonetaryAmount valorFinalProdutoDolar = valorProdutoDolar.add(valorImpostoDolar);

        System.out.println(valorFinalProdutoDolar);
    }
}
