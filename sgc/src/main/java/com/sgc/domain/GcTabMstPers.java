package com.sgc.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the gc_tab_mst_pers database table.
 * 
 */
@Entity
@Table(name="gc_tab_mst_pers")
@NamedQuery(name="GcTabMstPers.findAll", query="SELECT g FROM GcTabMstPers g")
public class GcTabMstPers implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_PERS", unique=true, nullable=false)
	private Integer idPers;

	@Column(name="CO_TIPO_DOCU", length=10)
	private String coTipoDocu;

	@Column(name="CO_USUA_CREA", length=45)
	private String coUsuaCrea;

	@Column(name="CO_USUA_MODI", length=45)
	private String coUsuaModi;

	@Column(name="DE_APEL_MATE", length=45)
	private String deApelMate;

	@Column(name="DE_APEL_PATE", length=45)
	private String deApelPate;

	@Column(name="DE_CORR", length=45)
	private String deCorr;

	@Column(name="DE_NOMB", length=45)
	private String deNomb;

	@Temporal(TemporalType.DATE)
	@Column(name="FE_NACI")
	private Date feNaci;

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

	@Column(name="IP_USUA_MODI", length=45)
	private String ipUsuaModi;

	@Column(name="NU_DOCU", length=20)
	private String nuDocu;

	//bi-directional many-to-one association to GcTabMstSegUsua
	@OneToMany(mappedBy="gcTabMstPer")
	private List<GcTabMstSegUsua> gcTabMstSegUsuas;

	public GcTabMstPers() {
	}

	public Integer getIdPers() {
		return this.idPers;
	}

	public void setIdPers(Integer idPers) {
		this.idPers = idPers;
	}

	public String getCoTipoDocu() {
		return this.coTipoDocu;
	}

	public void setCoTipoDocu(String coTipoDocu) {
		this.coTipoDocu = coTipoDocu;
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

	public String getDeApelMate() {
		return this.deApelMate;
	}

	public void setDeApelMate(String deApelMate) {
		this.deApelMate = deApelMate;
	}

	public String getDeApelPate() {
		return this.deApelPate;
	}

	public void setDeApelPate(String deApelPate) {
		this.deApelPate = deApelPate;
	}

	public String getDeCorr() {
		return this.deCorr;
	}

	public void setDeCorr(String deCorr) {
		this.deCorr = deCorr;
	}

	public String getDeNomb() {
		return this.deNomb;
	}

	public void setDeNomb(String deNomb) {
		this.deNomb = deNomb;
	}

	public Date getFeNaci() {
		return this.feNaci;
	}

	public void setFeNaci(Date feNaci) {
		this.feNaci = feNaci;
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

	public String getNuDocu() {
		return this.nuDocu;
	}

	public void setNuDocu(String nuDocu) {
		this.nuDocu = nuDocu;
	}

	public List<GcTabMstSegUsua> getGcTabMstSegUsuas() {
		return this.gcTabMstSegUsuas;
	}

	public void setGcTabMstSegUsuas(List<GcTabMstSegUsua> gcTabMstSegUsuas) {
		this.gcTabMstSegUsuas = gcTabMstSegUsuas;
	}

	public GcTabMstSegUsua addGcTabMstSegUsua(GcTabMstSegUsua gcTabMstSegUsua) {
		getGcTabMstSegUsuas().add(gcTabMstSegUsua);
		gcTabMstSegUsua.setGcTabMstPer(this);

		return gcTabMstSegUsua;
	}

	public GcTabMstSegUsua removeGcTabMstSegUsua(GcTabMstSegUsua gcTabMstSegUsua) {
		getGcTabMstSegUsuas().remove(gcTabMstSegUsua);
		gcTabMstSegUsua.setGcTabMstPer(null);

		return gcTabMstSegUsua;
	}

}