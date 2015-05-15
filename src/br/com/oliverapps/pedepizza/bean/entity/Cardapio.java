 package br.com.oliverapps.pedepizza.bean.entity;
 
 import java.math.BigDecimal;
 import java.util.Set;
 import javax.persistence.Column;
 import javax.persistence.Entity;
 import javax.persistence.FetchType;
 import javax.persistence.GeneratedValue;
 import javax.persistence.GenerationType;
 import javax.persistence.Id;
 import javax.persistence.OneToMany;
 import javax.persistence.OrderColumn;
 import javax.persistence.Table;
 
 @Entity
 @Table(name="CARDAPIOS")
 public class Cardapio
   implements IPedePizzaEntity
 {
   private static final long serialVersionUID = 4304666227516918387L;
   @Id
   @Column(name="CARDAPIO_ID")
   @GeneratedValue(strategy=GenerationType.AUTO)
   private Byte id;
   @OneToMany(cascade={javax.persistence.CascadeType.ALL}, fetch=FetchType.EAGER, mappedBy="cardapio")
   @OrderColumn(name="CATEGORIA")
   private Set<Pizza> pizzas;
   @Column(name="CARDAPIO_PRECO_MIN")
   private BigDecimal precoMinimo;
   @Column(name="CARDAPIO_PRECO_MAX")
   private BigDecimal precoMaximo;
   
   public Cardapio() {}
   
   public Cardapio(Byte id, Set<Pizza> p, Pizzaria pz)
   {
     this.id = id;
     this.pizzas = p;
     
     calcularPrecoMinMax();
   }
   
   public Byte getId() {
     return this.id;
   }
   
   public void setId(Byte id) { this.id = id; }
   
   public Set<Pizza> getPizzas()
   {
     return this.pizzas;
   }
   
   public void setPizzas(Set<Pizza> pizzas) { this.pizzas = pizzas; }
   
   public BigDecimal getPrecoMinimo()
   {
     return this.precoMinimo;
   }
   
   public void setPrecoMinimo(BigDecimal precoMinimo) {
     this.precoMinimo = precoMinimo;
   }
   
   public BigDecimal getPrecoMaximo() {
     return this.precoMaximo;
   }
   
   public void setPrecoMaximo(BigDecimal precoMaximo) {
     this.precoMaximo = precoMaximo;
   }
   
   public String toString()
   {
     return 
       "Cardapio [id=" + this.id + ", pizzas=" + this.pizzas + " , precoMinimo=" + this.precoMinimo + ", precoMaximo=" + this.precoMaximo + "]";
   }
   
   private void calcularPrecoMinMax()
   {
     Double precoMin = null;
     Double precoMax = null;
     Double preco = null;
     for (Pizza p : this.pizzas)
     {
       preco = Double.valueOf(Double.parseDouble(p.getPreco().toString()));
       if (precoMax.compareTo(preco) < 0) {
         precoMax = preco;
       } else if (precoMax.compareTo(preco) > 0) {
         precoMin = preco;
       }
     }
     this.precoMinimo = new BigDecimal(precoMin.doubleValue());
     this.precoMaximo = new BigDecimal(precoMax.doubleValue());
   }
 }