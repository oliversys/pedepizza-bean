 package br.com.oliverapps.pedepizza.bean.dto;
 
 import br.com.oliverapps.pedepizza.bean.domain.EnumLogradouro;
 import br.com.oliverapps.pedepizza.bean.entity.IPedePizzaEntity;
 import javax.persistence.Column;
 import javax.persistence.Embeddable;
 import javax.persistence.Enumerated;
 import javax.persistence.Table;

 @Embeddable
 @Table(name="ENDERECOS")
 public class Endereco
   implements IPedePizzaEntity
 {
   private static final long serialVersionUID = -550443407755905508L;
   @Column(name="END_CEP")
   private String CEP;
   @Enumerated
   @Column(name="END_LOGRADOURO")
   private EnumLogradouro logradouro;
   @Column(name="END_NOME_RUA")
   private String nomeRua;
   @Column(name="END_NUM_RUA")
   private Integer numero;
   @Column(name="END_COMPLEMENTO")
   private String complemento;
   @Column(name="END_BAIRRO")
   private String bairro;
   @Column(name="END_CIDADE")
   private String cidade;
   @Column(name="END_ESTADO")
   private String estado;
   
   public Endereco() {}
   
   public Endereco(String CEP, EnumLogradouro log, String rua, Integer num, String complemento, String bairro, String cidade, String estado)
   {
     this.CEP = CEP;this.logradouro = log;this.nomeRua = rua;this.numero = num;this.complemento = complemento;
     this.bairro = bairro;this.cidade = cidade;this.estado = estado;
   }
   
   public EnumLogradouro getLogradouro() {
     return this.logradouro;
   }
   
   public void setLogradouro(EnumLogradouro logradouro) { this.logradouro = logradouro; }
   
   public String getNomeRua() {
     return this.nomeRua;
   }
   
   public void setNomeRua(String nomeRua) { this.nomeRua = nomeRua; }
   
   public Integer getNumero() {
     return this.numero;
   }
   
   public void setNumero(Integer numero) { this.numero = numero; }
   
   public String getComplemento() {
     return this.complemento;
   }
   
   public void setComplemento(String complemento) { this.complemento = complemento; }
   
   public String getBairro() {
     return this.bairro;
   }
   
   public void setBairro(String bairro) { this.bairro = bairro; }
   
   public String getCidade() {
     return this.cidade;
   }
   
   public void setCidade(String cidade) { this.cidade = cidade; }
   
   public String getEstado() {
     return this.estado;
   }
   
   public void setEstado(String estado) { this.estado = estado; }
   
   public String getCEP() {
     return this.CEP;
   }
   
   public void setCEP(String cEP) { this.CEP = cEP; }
    
   public String toString()
   {
     return "Endereco [CEP=" + this.CEP + ", logradouro=" + this.logradouro + ", nomeRua=" + this.nomeRua + ", numero=" + this.numero + ", complemento=" + this.complemento + ", bairro=" + this.bairro + ", cidade=" + this.cidade + ", estado=" + this.estado + "]";
   }
    
   public Object getId()
   {
     return null;
   }
 }