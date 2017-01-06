package com.sgc.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the gc_tab_mst_utl_para database table.
 * 
 */
@Entity
@Table(name="gc_tab_mst_utl_para")
@NamedQueries({
	@NamedQuery(name="GcTabMstUtlPara.findAll", query="SELECT g FROM GcTabMstUtlPara g"),
	@NamedQuery(name = "buscarParametroPorCodigoGrupo", query = "select g from GcTabMstUtlPara g where g.inRegiActi = '1' and g.coPara = coalesce(:coPara, g.coPara) and g.coGrupPara = coalesce(:coGrupPara, g.coGrupPara) order by g.deVal") 
})
public class GcTabMstUtlPara implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CO_PARA", unique=true, nullable=false, length=45)
	private String coPara;

	@Column(name="CO_GRUP_PARA", length=45)
	private String coGrupPara;

	@Column(name="CO_USUA_CREA", length=45)
	private String coUsuaCrea;

	@Column(name="CO_USUA_MODI", length=45)
	private String coUsuaModi;

	@Column(name="DE_VAL", length=50)
	private String deVal;
	
	@Column(name="DE_PARA", length=100)
	private String dePara;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FE_USUA_CREA")
	private Date feUsuaCrea;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FE_USUA_MODI")
	private Date feUsuaModi;

	@Column(name="IN_REGI_ACTI", length=1)
	private String inRegiActi;

	@Column(name="IP_USUA_CREA", length=15)
	private String ipUsuaCrea;

	@Column(name="IP_USUA_MODI", length=15)
	private String ipUsuaModi;
	
	

	@Override
	public String toString() {
		return "GcTabMstUtlPara [coPara=" + coPara + ", coGrupPara="
				+ coGrupPara + ", coUsuaCrea=" + coUsuaCrea + ", coUsuaModi="
				+ coUsuaModi + ", deVal=" + deVal + ", dePara=" + dePara
				+ ", feUsuaCrea=" + feUsuaCrea + ", feUsuaModi=" + feUsuaModi
				+ ", inRegiActi=" + inRegiActi + ", ipUsuaCrea=" + ipUsuaCrea
				+ ", ipUsuaModi=" + ipUsuaModi + "]";
	}

	public GcTabMstUtlPara() {
	}

	public String getCoPara() {
		return this.coPara;
	}

	public void setCoPara(String coPara) {
		this.coPara = coPara;
	}

	public String getCoGrupPara() {
		return this.coGrupPara;
	}

	public void setCoGrupPara(String coGrupPara) {
		this.coGrupPara = coGrupPara;
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

	public String getDePara() {
		return this.dePara;
	}

	public void setDePara(String dePara) {
		this.dePara = dePara;
	}
	
	public String getDeVal() {
		return deVal;
	}
	
	public void setDeVal(String deVal) {
		this.deVal = deVal;
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

}