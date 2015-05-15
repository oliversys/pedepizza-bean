 package br.com.oliverapps.pedepizza.bean.domain;
 
 public enum EnumCategoriaCardapio
 {
   MAIS_PEDIDAS, 
   PROMOCIONAL, 
   ESPECIAL, 
   DOCE;
   
   public static boolean contains(String s) {
     if (valueOf(s) != null) {
       return true;
     }
     return false;
   }
 }