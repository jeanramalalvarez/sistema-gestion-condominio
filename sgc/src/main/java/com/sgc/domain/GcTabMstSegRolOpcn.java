package com.sgc.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the gc_tab_mst_seg_rol_opcn database table.
 * 
 */
@Entity
@Table(name="gc_tab_mst_seg_rol_opcn")
@NamedQuery(name="GcTabMstSegRolOpcn.findAll", query="SELECT g FROM GcTabMstSegRolOpcn g")
public class GcTabMstSegRolOpcn implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_ROL_OPCN", unique=true, nullable=false)
	private Integer idRolOpcn;

	@Column(name="CO_USUA_CREA", length=45)
	private String coUsuaCrea;

	@Column(name="CO_USUA_MODI", length=45)
	private String coUsuaModi;

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

	@Column(name="NU_ORDN")
	private Integer nuOrdn;

	//bi-directional many-to-one association to GcTabMstSegOpcn
	@ManyToOne
	@JoinColumn(name="ID_OPCN")
	private GcTabMstSegOpcn gcTabMstSegOpcn;

	//bi-directional many-to-one association to GcTabMstSegRol
	@ManyToOne
	@JoinColumn(name="ID_ROL")
	private GcTabMstSegRol gcTabMstSegRol;

	public GcTabMstSegRolOpcn() {
	}

	public Integer getIdRolOpcn() {
		return this.idRolOpcn;
	}

	public void setIdRolOpcn(Integer idRolOpcn) {
		this.idRolOpcn = idRolOpcn;
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

	public Integer getNuOrdn() {
		return this.nuOrdn;
	}

	public void setNuOrdn(Integer nuOrdn) {
		this.nuOrdn = nuOrdn;
	}

	public GcTabMstSegOpcn getGcTabMstSegOpcn() {
		return this.gcTabMstSegOpcn;
	}

	public void setGcTabMstSegOpcn(GcTabMstSegOpcn gcTabMstSegOpcn) {
		this.gcTabMstSegOpcn = gcTabMstSegOpcn;
	}

	public GcTabMstSegRol getGcTabMstSegRol() {
		return this.gcTabMstSegRol;
	}

	public void setGcTabMstSegRol(GcTabMstSegRol gcTabMstSegRol) {
		this.gcTabMstSegRol = gcTabMstSegRol;
	}

}