 package br.com.oliverapps.pedepizza.bean.entity;
 
 import java.math.BigDecimal;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.com.oliverapps.pedepizza.bean.domain.EnumCategoriaCardapio;
  
 @Entity
 @NamedQuery(name="getCategoriasDoCardapio", query="SELECT p.categoriaCardapio  FROM Pizza p WHERE p.cardapio.id = :id")
 @Table(name="PIZZAS")
 public class Pizza
   implements IPedePizzaEntity
 {
   private static final long serialVersionUID = -8591116734512164070L;
   @Id
   @Column(name="PIZZA_ID")
   @GeneratedValue(strategy=GenerationType.AUTO)
   private Integer id;
   @Column(name="IN_MAIS_PEDIDA")
   private boolean isMaisPedida;
   @Column(name="CATEGORIA")
   private String categoriaCardapio;
   @OneToOne
   private Pedido pedido;
   @ManyToOne
   private Cardapio cardapio;
   @Column(name="NOME")
   private String nome;
   @ElementCollection(fetch=FetchType.EAGER)
   private Collection<String> ingredientes = new HashSet();
   
   @Column(name="DESCRICAO")
   private String descricao;
   
   @Column(name="PRECO")
   private BigDecimal preco;
   
   @Column(name="AVALIACAO")
   private Float avaliacao;
   
   @Column(name="FOTO_URL")
   private String fotoURL;
   
   public Pizza() {}
   
   public Pizza(Integer id, Pizzaria p, String nome, Set<String> ingreds, BigDecimal preco, EnumCategoriaCardapio c)
   {
     this.id = id;
     this.nome = nome;
     this.ingredientes = ingreds;
     this.preco = preco;
     this.categoriaCardapio = c.name();
   }
   
   public Integer getId() {
     return this.id;
   }
   
   public void setId(Integer id) { this.id = id; }
   
   public String getNome() {
     return this.nome;
   }
   
   public void setNome(String nome) { this.nome = nome; }
   
   public String getDescricao() {
     return this.descricao;
   }
   
   public void setDescricao(String descricao) { this.descricao = descricao; }
   
   public Collection<String> getIngredientes()
   {
     return this.ingredientes;
   }
   
   public void setIngredientes(Collection<String> ingredientes) { this.ingredientes = ingredientes; }
   
   public Float getAvaliacao() {
     return this.avaliacao;
   }
   
   public void setAvaliacao(Float numRatings) { this.avaliacao = numRatings; }
   
   public BigDecimal getPreco() {
     return this.preco;
   }
   
   public void setPreco(BigDecimal preco) { this.preco = preco; }
   
   public String getFotoURL()
   {
     return this.fotoURL;
   }
   
   public void setFotoURL(String fotoURL) {
     this.fotoURL = fotoURL;
   }
   
   public String getCategoriaCardapio() {
     return this.categoriaCardapio;
   }
   
   public void setCategoriaCardapio(String categoriaCardapio) {
     this.categoriaCardapio = categoriaCardapio;
   }
   
   public Pedido getPedido() {
     return this.pedido;
   }
   
   public void setPedido(Pedido pedido) {
     this.pedido = pedido;
   }
   
   public boolean isMaisPedida() {
     return this.isMaisPedida;
   }
   
   public void setMaisPedida(boolean isMaisPedida) {
     this.isMaisPedida = isMaisPedida;
   }
   
   public String toString()
   {
     return 
       "Pizza [id=" + this.id + ", isMaisPedida=" + this.isMaisPedida + ", categoriaCardapio=" + 
       this.categoriaCardapio + ", pedido=" + this.pedido + ", nome=" + this.nome + ", ingredientes=" + 
       this.ingredientes + ", descricao=" + this.descricao + ", preco=" + this.preco + ", avaliacao=" + 
       this.avaliacao + ", fotoURL=" + this.fotoURL + "]";
   }
 }