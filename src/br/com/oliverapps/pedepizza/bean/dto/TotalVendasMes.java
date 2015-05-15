 package br.com.oliverapps.pedepizza.bean.dto;
 
 import java.math.BigDecimal;
 import javax.persistence.Column;
 import javax.persistence.Embeddable;
  
 @Embeddable
 public class TotalVendasMes
 {
   @Column(name="TOTAL_MENSAL")
   private BigDecimal totalVendasMensal;
   @Column(name="MES")
   private Byte mes;
   
   public TotalVendasMes() {}
   
   public BigDecimal getTotalVendasMensal()
   {
     return this.totalVendasMensal;
   }
   
   public void setTotalVendasMensal(BigDecimal totalVendasMensal) {
     this.totalVendasMensal = totalVendasMensal;
   }
   
   public Byte getMes() {
     return this.mes;
   }
   
   public void setMes(Byte mes) {
     this.mes = mes;
   }
   
   public String toString()
   {
     return "TotalVendasMesVO [totalVendasMensal=" + this.totalVendasMensal + ", mes=" + this.mes + "]";
   }
 }