package br.com.teste.cvc.commons.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

	public int calculaQtdDiasEntreDatas(String dataInicial, String dataFinal) {

		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		df.setLenient(false);
		long dt = 0;
		try {
			Date dataI = df.parse(dataInicial);
			Date dataF = df.parse(dataFinal);
			dt = (dataF.getTime() - dataI.getTime()) + 3600000; 
			dt = (dt / 86400000L);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return (int)dt;		
	}

	public Double calculaPeriodoEstadia(int diasEstadia, Double ValorPessoa) {
		Double valorMultiplicado = diasEstadia * ValorPessoa;
		return caculaValorEstadiaComComissao(valorMultiplicado);
	}

	private Double caculaValorEstadiaComComissao(Double valorViagem) {
		return Double.parseDouble(String.format("%.2f",(valorViagem / 0.7)));
	}

}
