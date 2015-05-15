 package br.com.oliverapps.pedepizza.bean.entity;
 
 import br.com.oliverapps.pedepizza.bean.domain.EnumStatusPedido;
 import java.math.BigDecimal;
 import java.util.Date;
 import java.util.Set;
 import javax.persistence.Column;
 import javax.persistence.Entity;
 import javax.persistence.Enumerated;
 import javax.persistence.FetchType;
 import javax.persistence.GeneratedValue;
 import javax.persistence.GenerationType;
 import javax.persistence.Id;
 import javax.persistence.OneToMany;
 import javax.persistence.PrePersist;
 import javax.persistence.Table;
 import javax.persistence.Temporal;
 import javax.persistence.TemporalType;
 
 @Entity
 @Table(name="PEDIDOS")
 public class Pedido
   implements IPedePizzaEntity
 {
   private static final long serialVersionUID = -5377024798328036682L;
   @Id
   @Column(name="PEDIDO_ID")
   @GeneratedValue(strategy=GenerationType.AUTO)
   private Long id;
   @OneToMany(mappedBy="pedido", cascade={javax.persistence.CascadeType.ALL}, fetch=FetchType.EAGER)
   private Set<Pizza> itens;
   @Column(name="VALOR")
   private BigDecimal valor;
   @Column(name="EMAIL")
   private String emailCliente;
   @Enumerated
   private EnumStatusPedido situacao;
   @Column(name="CRIADO_EM")
   @Temporal(TemporalType.TIMESTAMP)
   private Date criadoEm;
   @Column(name="ENTREGA_PREVISTA_EM")
   @Temporal(TemporalType.TIMESTAMP)
   private Date entregaPrevistaPara;
   
   @PrePersist
   protected void onCreate()
   {
     this.criadoEm = new Date();
   }   
 
   public Pedido() {}
   
   public Pedido(Set<Pizza> itens, BigDecimal valor, String emailCliente, EnumStatusPedido sit, Date criadoEm, Date entregaPrevistaPara)
   {
     this.itens = itens;
     this.valor = valor;
     this.emailCliente = emailCliente;
     this.situacao = sit;
     this.criadoEm = criadoEm;
     this.entregaPrevistaPara = entregaPrevistaPara;
   }
   
   public Long getId() {
     return this.id;
   }
   
   public void setId(Long id) {
     this.id = id;
   }
   
   public Set<Pizza> getItens() {
     return this.itens;
   }
   
   public void setItens(Set<Pizza> itens) {
     this.itens = itens;
   }
   
   public BigDecimal getValor() {
     return this.valor;
   }
   
   public void setValor(BigDecimal valor) {
     this.valor = valor;
   }
   
   public String getEmailCliente() {
     return this.emailCliente;
   }
   
   public void setEmailCliente(String emailCliente) {
     this.emailCliente = emailCliente;
   }
   
   public EnumStatusPedido getSituacao() {
     return this.situacao;
   }
   
   public void setSituacao(EnumStatusPedido situacao) {
     this.situacao = situacao;
   }
   
   public Date getCriadoEm() {
     return this.criadoEm;
   }
   
   public void setCriadoEm(Date criadoEm) {
     this.criadoEm = criadoEm;
   }
   
   public Date getEntregaPrevistaPara() {
     return this.entregaPrevistaPara;
   }
   
   public void setEntregaPrevistaPara(Date entregaPrevistaPara) {
     this.entregaPrevistaPara = entregaPrevistaPara;
   }
   
   public String toString()
   {
     return      
       "Pedido [id=" + this.id + ", itens=" + this.itens + ", valor=" + 
		 this.valor + ", emailCliente=" + this.emailCliente + ", situacao=" + 
		 this.situacao + ", criadoEm=" + this.criadoEm + ", entregaPrevistaPara=" + 
		 this.entregaPrevistaPara + "]";
   }
 }
