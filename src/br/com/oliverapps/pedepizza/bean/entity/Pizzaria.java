 package br.com.oliverapps.pedepizza.bean.entity;
 
 import br.com.oliverapps.pedepizza.bean.dto.Endereco;
 import java.util.List;
 import java.util.Set;
 import javax.persistence.Column;
 import javax.persistence.ElementCollection;
 import javax.persistence.Entity;
 import javax.persistence.FetchType;
 import javax.persistence.GeneratedValue;
 import javax.persistence.GenerationType;
 import javax.persistence.Id;
 import javax.persistence.JoinColumn;
 import javax.persistence.OneToMany;
 import javax.persistence.OneToOne;
 import javax.persistence.Table;
  
 @Entity
 @Table(name="PIZZARIAS")
 public class Pizzaria
   implements IPedePizzaEntity
 {
   private static final long serialVersionUID = 4573043592846939847L;
   @Id
   @Column(name="PIZZARIA_ID")
   @GeneratedValue(strategy=GenerationType.AUTO)
   private Long id;
   @Column(name="NOME")
   private String nome;
   @OneToMany(cascade={javax.persistence.CascadeType.ALL}, fetch=FetchType.EAGER)
   @JoinColumn(name="CARDAPIO_PIZZARIA_ID")
   private List<Cardapio> cardapios;
   @ElementCollection(fetch=FetchType.EAGER)
   private Set<Endereco> enderecos;
   @Column(name="EH_ASSINANTE")
   private Boolean isAssinante;
   @Column(name="LOGO_URL")
   private String logoURL;
   @OneToOne(mappedBy="pizzaria")
   private PizzariaProfile perfil;
   @Column(name="TAXA_ENTREGA")
   private Double taxaEntrega;
   @OneToMany(cascade={javax.persistence.CascadeType.ALL}, fetch=FetchType.EAGER)
   @JoinColumn(name="PIZZARIA_ID")
   private Set<Comentario> comentarios;
   @Column(name="AVALIACAO")
   private Float avaliacao = Float.valueOf(1.0F);
   
   @Column(name="DISTANCIA_EM_KM")
   private Float distanciaEmKM;
   
   @Column(name="TEMPO_MEDIO_ESPERA_EM_MINUTOS")
   private Integer tempoMedioEntregaEmMinutos;
   
   @Column(name="DIA_HORA_FUNCIONAMENTO")
   private String diaHoraFuncionamento;
   
   public Pizzaria() {}
   
   public Pizzaria(Long id, String n, Set<Endereco> ends, Double tx)
   {
     this.id = id;
     this.nome = n;
     this.enderecos = ends;
     this.taxaEntrega = tx;
   }
   
   public String getNome() {
     return this.nome;
   }
   
   public void setNome(String nome) {
     this.nome = nome;
   }
   
   public Float getAvaliacao() {
     return this.avaliacao;
   }
   
   public void setAvaliacao(Float a) {
     this.avaliacao = a;
   }
   
   public Set<Comentario> getComentarios() {
     return this.comentarios;
   }
   
   public void setComentarios(Set<Comentario> comentarios) {
     this.comentarios = comentarios;
   }
   
   public Long getId() {
     return this.id;
   }
   
   public void setId(Long id) { this.id = id; }
   
   public Set<Endereco> getEnderecos() {
     return this.enderecos;
   }
   
   public void setEnderecos(Set<Endereco> endereco)
   {
     this.enderecos = endereco;
   }
   
   public Boolean getIsAssinante() { return this.isAssinante; }
   
   public void setIsAssinante(Boolean isAssinante) {
     this.isAssinante = isAssinante;
   }
   
   public PizzariaProfile getPerfil() { return this.perfil; }
   
   public void setPerfil(PizzariaProfile perfil)
   {
     this.perfil = perfil;
   }
   
   public Double getTaxaEntrega() {
     return this.taxaEntrega;
   }
   
   public void setTaxaEntrega(Double taxaEntrega) {
    this.taxaEntrega = taxaEntrega;
   }
   
   public List<Cardapio> getCardapios() {
     return this.cardapios;
   }
   
   public void setCardapios(List<Cardapio> cardapios) {
     this.cardapios = cardapios;
   }
   
   public String getLogoURL() {
     return this.logoURL;
   }
   
   public void setLogoURL(String logoURL) {
     this.logoURL = logoURL;
   }
   
   public Float getDistanciaEmKM() {
     return this.distanciaEmKM;
   }
   
   public void setDistanciaEmKM(Float distancia) {
     this.distanciaEmKM = distancia;
   }
   
   public Integer getTempoMedioEntregaEmMinutos() {
     return this.tempoMedioEntregaEmMinutos;
   }
   
   public void setTempoMedioEntregaEmMinutos(Integer tempo) {
    this.tempoMedioEntregaEmMinutos = tempo;
   }
   
   public String getDiaHoraFuncionamento() {
     return this.diaHoraFuncionamento;
   }
   
   public void setDiaHoraFuncionamento(String diaHoraFuncionamento) {
     this.diaHoraFuncionamento = diaHoraFuncionamento;
   }
   
   public String toString()
   {
     return 
       "Pizzaria [id=" + this.id + ", nome=" + this.nome + ", cardapios=" + this.cardapios + ", enderecos=" + this.enderecos + ", isAssinante=" + this.isAssinante + ", logoURL=" + this.logoURL + ", perfil=" + this.perfil + ", taxaEntrega=" + this.taxaEntrega + ", comentarios=" + this.comentarios + ", avaliacao=" + this.avaliacao + ", distanciaEmKM=" + this.distanciaEmKM + ", tempoMedioEntregaEmMinutos=" + this.tempoMedioEntregaEmMinutos + ", diaHoraFuncionamento=" + this.diaHoraFuncionamento + "]";
   }
 }