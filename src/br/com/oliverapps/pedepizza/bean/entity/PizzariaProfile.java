 package br.com.oliverapps.pedepizza.bean.entity;
 
 import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.oliverapps.pedepizza.bean.domain.EnumAssinatura;
import br.com.oliverapps.pedepizza.bean.dto.TotalVendasMes;
 
 @Entity
 @Table(name="PIZZARIA_PROFILES")
 public class PizzariaProfile
   implements IPedePizzaEntity
 {
   private static final long serialVersionUID = 7279682309591880569L;
   @Id
   @Column(name="PROFILE_ID")
   @GeneratedValue(strategy=GenerationType.AUTO)
   private Long id;
   @Enumerated(EnumType.STRING)
   @Column(name="ASSINATURA")
   private EnumAssinatura assinatura;
   @Column(name="DATA_CRIACAO")
   @Temporal(TemporalType.DATE)
   private Date dataInicialRegistro;
   @Column(name="DATA_VENCIMENTO_ASSINATURA")
   @Temporal(TemporalType.DATE)
   private Date dataVencimentoAssinatura;
   @Column(name="VALOR_ASSINATURA")
   private BigDecimal valorAssinatura;
   @Embedded
   private TotalVendasMes totalVendasMes;
   @OneToOne
   @JoinColumn(name="PROFILE_PIZZARIA_ID")
   private Pizzaria pizzaria;
   
   @PrePersist
   protected void onCreate()
   {
     this.dataInicialRegistro = new Date();
   }
   
   public PizzariaProfile(EnumAssinatura ass)
   {
     this.assinatura = ass;
   }
   
   public PizzariaProfile() {}
   
   public Long getId() {
     return this.id;
   }
   
   public void setId(Long id) {
     this.id = id;
   }
   
   public EnumAssinatura getAssinatura() {
     return this.assinatura;
   }
   
   public void setAssinatura(EnumAssinatura assinatura) {
     this.assinatura = assinatura;
   }
   
   public Date getDataInicialRegistro() {
     return this.dataInicialRegistro;
   }
   
   public void setDataInicialRegistro(Date dataInicialRegistro) {
     this.dataInicialRegistro = dataInicialRegistro;
   }
   
   public Date getDataVencimentoAssinatura() {
     return this.dataVencimentoAssinatura;
   }
   
   public TotalVendasMes getTotalVendasMes() {
     return this.totalVendasMes;
   }
   
   public void setTotalVendasMes(TotalVendasMes totalVendasMes) {
     this.totalVendasMes = totalVendasMes;
   }
   
   public Pizzaria getPizzaria() {
     return this.pizzaria;
   }
   
   public void setPizzaria(Pizzaria pizzaria) {
     this.pizzaria = pizzaria;
   }
   
   public void setDataVencimentoAssinatura(Date dataVencimentoAssinatura) {
     this.dataVencimentoAssinatura = dataVencimentoAssinatura;
   }
   
   public BigDecimal getValorAssinatura() {
     return this.valorAssinatura;
   }
   
   public void setValorAssinatura(BigDecimal valorAssinatura) {
     this.valorAssinatura = valorAssinatura;
   }
   
   public TotalVendasMes getTotalMes() {
     return this.totalVendasMes;
   }
   
   public void setTotalMes(TotalVendasMes totalMes) {
     this.totalVendasMes = totalMes;
   }
 
   public void assinarPlano() {}
   
 
   public String toString()
   {
     return "PizzariaProfile [id=" + this.id + ", assinatura=" + this.assinatura + ", dataInicialRegistro=" + this.dataInicialRegistro + ", dataVencimentoAssinatura=" + this.dataVencimentoAssinatura + ", valorAssinatura=" + this.valorAssinatura + ", totalVendasMes=" + this.totalVendasMes + "]";
   }
 }