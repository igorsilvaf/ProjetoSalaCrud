/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.curso.utils;

import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
/**
 *
 * @author igorf
 */
public class Conversao {
    public static Date converterData(String data) throws ParseException{
        SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd");
        if(data == null || data.trim().equals("")){
            return null;
        }else{
            Date date = fmt.parse(data);
            return date;
        }
    }
    public static String data2String(Date data){
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = fmt.format(data);
        return dataFormatada;
    }
    
    public static Date dataAtual(){
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        Date novaData = new Date(System.currentTimeMillis());
        return novaData;
    }
    
}
