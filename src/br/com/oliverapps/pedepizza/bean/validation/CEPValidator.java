 package br.com.oliverapps.pedepizza.bean.validation;
 
 import java.util.regex.Pattern;
 
 public class CEPValidator
 {
   private Pattern pattern = Pattern.compile("[0-9]{5}-[0-9]{3}");
   
   public CEPValidator() {}
 }