package com.sgc.domain;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the gc_tab_mst_seg_opcn database table.
 * 
 */
@Entity
@Table(name="gc_tab_mst_seg_opcn")
@NamedQueries({
	@NamedQuery(name = "GcTabMstSegOpcn.findAll", query = "SELECT g FROM GcTabMstSegOpcn g"),
	@NamedQuery(name = "buscarOpcionPorOpcionPadre", query = "select g from GcTabMstSegOpcn g where g.inRegiActi = '1' and g.idOpcnPadr = :idOpcnPadr") 
})
public class GcTabMstSegOpcn implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_OPCN", unique=true, nullable=false)
	private Integer idOpcn;

	@Column(name="CO_ICON", length=45)
	private String coIcon;

	@Column(name="CO_OPCN", length=45)
	private String coOpcn;

	@Column(name="CO_TIPO_DEST", length=20)
	private String coTipoDest;

	@Column(name="CO_USUA_CREA", length=45)
	private String coUsuaCrea;

	@Column(name="CO_USUA_MODI", length=45)
	private String coUsuaModi;

	@Column(name="DE_DESC", length=100)
	private String deDesc;

	@Column(name="DE_OPCN", length=45)
	private String deOpcn;

	@Column(name="DE_URL", length=45)
	private String deUrl;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FE_USUA_CREA")
	private Date feUsuaCrea;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FE_USUA_MODI")
	private Date feUsuaModi;

	@Column(name="ID_OPCN_PADR")
	private Integer idOpcnPadr;

	@Column(name="IN_REGI_ACTI", length=1)
	private String inRegiActi;

	@Column(name="IP_USUA_CREA", length=15)
	private String ipUsuaCrea;

	@Column(name="IP_USUA_MODI", length=15)
	private String ipUsuaModi;

	@Column(name="NU_ORDN")
	private Integer nuOrdn;

	//bi-directional many-to-one association to GcTabMstSegRolOpcn
	@OneToMany(mappedBy="gcTabMstSegOpcn")
	private List<GcTabMstSegRolOpcn> gcTabMstSegRolOpcns;
	
	@Transient
	private List<GcTabMstSegOpcn> gcTabMstSegOpcnHijos;

	public GcTabMstSegOpcn() {
	}

	public Integer getIdOpcn() {
		return this.idOpcn;
	}

	public void setIdOpcn(Integer idOpcn) {
		this.idOpcn = idOpcn;
	}

	public String getCoIcon() {
		return this.coIcon;
	}

	public void setCoIcon(String coIcon) {
		this.coIcon = coIcon;
	}

	public String getCoOpcn() {
		return this.coOpcn;
	}

	public void setCoOpcn(String coOpcn) {
		this.coOpcn = coOpcn;
	}

	public String getCoTipoDest() {
		return this.coTipoDest;
	}

	public void setCoTipoDest(String coTipoDest) {
		this.coTipoDest = coTipoDest;
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

	public String getDeDesc() {
		return this.deDesc;
	}

	public void setDeDesc(String deDesc) {
		this.deDesc = deDesc;
	}

	public String getDeOpcn() {
		return this.deOpcn;
	}

	public void setDeOpcn(String deOpcn) {
		this.deOpcn = deOpcn;
	}

	public String getDeUrl() {
		return this.deUrl;
	}

	public void setDeUrl(String deUrl) {
		this.deUrl = deUrl;
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

	public Integer getIdOpcnPadr() {
		return this.idOpcnPadr;
	}

	public void setIdOpcnPadr(Integer idOpcnPadr) {
		this.idOpcnPadr = idOpcnPadr;
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

	public Integer getNuOrdn() {
		return this.nuOrdn;
	}

	public void setNuOrdn(Integer nuOrdn) {
		this.nuOrdn = nuOrdn;
	}

	public List<GcTabMstSegRolOpcn> getGcTabMstSegRolOpcns() {
		return this.gcTabMstSegRolOpcns;
	}

	public void setGcTabMstSegRolOpcns(List<GcTabMstSegRolOpcn> gcTabMstSegRolOpcns) {
		this.gcTabMstSegRolOpcns = gcTabMstSegRolOpcns;
	}

	public GcTabMstSegRolOpcn addGcTabMstSegRolOpcn(GcTabMstSegRolOpcn gcTabMstSegRolOpcn) {
		getGcTabMstSegRolOpcns().add(gcTabMstSegRolOpcn);
		gcTabMstSegRolOpcn.setGcTabMstSegOpcn(this);

		return gcTabMstSegRolOpcn;
	}

	public GcTabMstSegRolOpcn removeGcTabMstSegRolOpcn(GcTabMstSegRolOpcn gcTabMstSegRolOpcn) {
		getGcTabMstSegRolOpcns().remove(gcTabMstSegRolOpcn);
		gcTabMstSegRolOpcn.setGcTabMstSegOpcn(null);

		return gcTabMstSegRolOpcn;
	}
	
	public void setGcTabMstSegOpcnHijos(List<GcTabMstSegOpcn> gcTabMstSegOpcnHijos) {
		this.gcTabMstSegOpcnHijos = gcTabMstSegOpcnHijos;
	}
	
	public List<GcTabMstSegOpcn> getGcTabMstSegOpcnHijos() {
		return gcTabMstSegOpcnHijos;
	}

}