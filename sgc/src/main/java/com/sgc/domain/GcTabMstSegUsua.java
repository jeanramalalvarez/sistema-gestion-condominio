package com.sgc.domain;

import java.io.Serializable;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * The persistent class for the gc_tab_mst_seg_usua database table.
 * 
 */
@Entity
@Table(name = "gc_tab_mst_seg_usua")
@NamedQueries({
		@NamedQuery(name = "GcTabMstSegUsua.findAll", query = "SELECT g FROM GcTabMstSegUsua g"),
		@NamedQuery(name = "buscarUsuarioPorCodigoUsuario", query = "select g from GcTabMstSegUsua g where g.inRegiActi = '1' and g.coUsua = :coUsua") 
})
@NamedNativeQueries({ 
		@NamedNativeQuery(name = "buscarUsuarioPorCodigoUsuario2", callable = true, 
				query = "call DS_PCK_VTA_PEDIDO.SP_GET_DESC_MEMO_LINE(?, "
																	+ ":coUsua" 
																	+ ")", 
				readOnly = true, cacheable = true, resultClass = GcTabMstSegUsua.class), 
})
public class GcTabMstSegUsua implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_USUA", unique = true, nullable = false)
	private Integer idUsua;

	@Column(name = "CO_ACTI", length = 500)
	private String coActi;

	@NotEmpty
	@Length(max = 10)
	@Column(name = "CO_USUA", length = 45)
	private String coUsua;

	@Column(name = "CO_USUA_CREA", length = 45)
	private String coUsuaCrea;

	@Column(name = "CO_USUA_MODI", length = 45)
	private String coUsuaModi;

	@NotEmpty
	@Length(max = 6)
	@Column(name = "DE_CONT", length = 100)
	private String deCont;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FE_ULTI_LOGI")
	private Date feUltiLogi;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FE_USUA_CREA")
	private Date feUsuaCrea;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FE_USUA_MODI")
	private Date feUsuaModi;

	@Column(name = "IN_REGI_ACTI", length = 1)
	private String inRegiActi;

	@Column(name = "IP_USUA_CREA", length = 15)
	private String ipUsuaCrea;

	@Column(name = "IP_USUA_MODI", length = 45)
	private String ipUsuaModi;

	// bi-directional many-to-one association to GcTabMstPers
	@ManyToOne
	@JoinColumn(name = "ID_PERS")
	private GcTabMstPers gcTabMstPer;

	// bi-directional many-to-one association to GcTabMstSegUsuaRol
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "gcTabMstSegUsua")
	private List<GcTabMstSegUsuaRol> gcTabMstSegUsuaRols;
	
	@Transient
	private List<GcTabMstSegOpcn> gcTabMstSegOpcns;

	public GcTabMstSegUsua() {
	}

	public Integer getIdUsua() {
		return this.idUsua;
	}

	public void setIdUsua(Integer idUsua) {
		this.idUsua = idUsua;
	}

	public String getCoActi() {
		return this.coActi;
	}

	public void setCoActi(String coActi) {
		this.coActi = coActi;
	}

	public String getCoUsua() {
		return this.coUsua;
	}

	public void setCoUsua(String coUsua) {
		this.coUsua = coUsua;
	}

	public String getCoUsuaCrea() {
		return this.coUsuaCrea;
	}

	public void setCoUsuaCrea(String coUsuaCrea) {
		this.coUsuaCrea = coUsuaCrea;
	}

	public String getCoUsuaModi() {
		return this.coUsuaModi;
	}

	public void setCoUsuaModi(String coUsuaModi) {
		this.coUsuaModi = coUsuaModi;
	}

	public String getDeCont() {
		return this.deCont;
	}

	public void setDeCont(String deCont) {
		this.deCont = deCont;
	}

	public Date getFeUltiLogi() {
		return this.feUltiLogi;
	}

	public void setFeUltiLogi(Date feUltiLogi) {
		this.feUltiLogi = feUltiLogi;
	}

	public Date getFeUsuaCrea() {
		return this.feUsuaCrea;
	}

	public void setFeUsuaCrea(Date feUsuaCrea) {
		this.feUsuaCrea = feUsuaCrea;
	}

	public Date getFeUsuaModi() {
		return this.feUsuaModi;
	}

	public void setFeUsuaModi(Date feUsuaModi) {
		this.feUsuaModi = feUsuaModi;
	}

	public String getInRegiActi() {
		return this.inRegiActi;
	}

	public void setInRegiActi(String inRegiActi) {
		this.inRegiActi = inRegiActi;
	}

	public String getIpUsuaCrea() {
		return this.ipUsuaCrea;
	}

	public void setIpUsuaCrea(String ipUsuaCrea) {
		this.ipUsuaCrea = ipUsuaCrea;
	}

	public String getIpUsuaModi() {
		return this.ipUsuaModi;
	}

	public void setIpUsuaModi(String ipUsuaModi) {
		this.ipUsuaModi = ipUsuaModi;
	}

	public GcTabMstPers getGcTabMstPer() {
		return this.gcTabMstPer;
	}

	public void setGcTabMstPer(GcTabMstPers gcTabMstPer) {
		this.gcTabMstPer = gcTabMstPer;
	}

	public List<GcTabMstSegUsuaRol> getGcTabMstSegUsuaRols() {
		return this.gcTabMstSegUsuaRols;
	}

	public void setGcTabMstSegUsuaRols(
			List<GcTabMstSegUsuaRol> gcTabMstSegUsuaRols) {
		this.gcTabMstSegUsuaRols = gcTabMstSegUsuaRols;
	}

	public GcTabMstSegUsuaRol addGcTabMstSegUsuaRol(
			GcTabMstSegUsuaRol gcTabMstSegUsuaRol) {
		getGcTabMstSegUsuaRols().add(gcTabMstSegUsuaRol);
		gcTabMstSegUsuaRol.setGcTabMstSegUsua(this);

		return gcTabMstSegUsuaRol;
	}

	public GcTabMstSegUsuaRol removeGcTabMstSegUsuaRol(
			GcTabMstSegUsuaRol gcTabMstSegUsuaRol) {
		getGcTabMstSegUsuaRols().remove(gcTabMstSegUsuaRol);
		gcTabMstSegUsuaRol.setGcTabMstSegUsua(null);

		return gcTabMstSegUsuaRol;
	}
	
	public List<GcTabMstSegOpcn> getGcTabMstSegOpcns() {
		return gcTabMstSegOpcns;
	}
	
	public void setGcTabMstSegOpcns(List<GcTabMstSegOpcn> gcTabMstSegOpcns) {
		this.gcTabMstSegOpcns = gcTabMstSegOpcns;
	}

}