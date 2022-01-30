package com.myproject.workshopmongo.resources.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class URL {

	public static String decodificarParametro(String texto) {// REMOVER%20ESPAÇOS%20NA%20URL
		try {					//	(VAR, PADRÃO DE TEXTO)
			return URLDecoder.decode(texto, "UTF-8"); 
		} catch (UnsupportedEncodingException e) {
			return "";
			}
	}
	
	public static Date converterData(String dataTexto, Date valorPadrao) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		try {
			return sdf.parse(dataTexto);
		} catch (ParseException e) {
			return valorPadrao;
		}
	}
}
