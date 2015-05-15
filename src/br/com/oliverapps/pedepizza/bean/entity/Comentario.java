 package br.com.oliverapps.pedepizza.bean.entity;
 
 import java.util.Date;
 import javax.persistence.Column;
 import javax.persistence.Entity;
 import javax.persistence.GeneratedValue;
 import javax.persistence.GenerationType;
 import javax.persistence.Id;
 import javax.persistence.OneToOne;
 import javax.persistence.PrePersist;
 import javax.persistence.Table;
 import javax.persistence.Temporal;
 import javax.persistence.TemporalType;
 
 @Entity
 @Table(name="COMENTARIOS")
 public class Comentario
   implements IPedePizzaEntity
 {
   private static final long serialVersionUID = -3466524441164651559L;
   @Id
   @Column(name="COMENTARIO_ID")
   @GeneratedValue(strategy=GenerationType.AUTO)
   private Long id;
   @OneToOne
   private Pizzaria pizzaria;
   @Column(name="MENSAGEM")
   private String mensagem;
   @Column(name="AUTOR")
   private String autor;
   @Column(name="DATA_CRIACAO")
   @Temporal(TemporalType.TIMESTAMP)
   private Date dataCriacao;
   
   @PrePersist
   protected void onCreate()
   {
     this.dataCriacao = new Date();
   }
   
   public Long getId() { return this.id; }
   public String getMensagem() { return this.mensagem; }
   public String getAutor() { return this.autor; }
   public Date getDataCriacao() { return this.dataCriacao; }
   
   public void setId(Long id) { this.id = id; }
   public void setMensagem(String m) { this.mensagem = m; }
   public void setAutor(String a) { this.autor = a; }
   public void setDataCriacao(Date d) { this.dataCriacao = d; }
   
   public Comentario(Long id, String message, String poster, Date postDate) {
     this.id = id;
     this.mensagem = message;
     this.autor = poster;
     this.dataCriacao = postDate;
   }
   
   public Comentario() {}
   
   public String toString()
   {
     return "Comentario [id=" + this.id + ", mensagem=" + this.mensagem + ", autor=" + this.autor + ", dataCriacao=" + this.dataCriacao + "]";
   }
 }