package com.sgc.domain;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the gc_tab_mst_seg_rol database table.
 * 
 */
@Entity
@Table(name="gc_tab_mst_seg_rol")
@NamedQuery(name="GcTabMstSegRol.findAll", query="SELECT g FROM GcTabMstSegRol g")
public class GcTabMstSegRol implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_ROL", unique=true, nullable=false)
	private Integer idRol;

	@Column(name="CO_ROL", length=45)
	private String coRol;
	
	@Column(name="CO_ROL_INTR", length=45)
	private String coRolIntr;

	@Column(name="CO_USUA_CREA", length=45)
	private String coUsuaCrea;

	@Column(name="CO_USUA_MODI", length=45)
	private String coUsuaModi;

	@Column(name="DE_ROL", length=45)
	private String deRol;

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
	
	//bi-directional many-to-one association to GcTabMstSegRolOpcn
	@OneToMany(fetch = FetchType.EAGER, mappedBy="gcTabMstSegRol")
	private List<GcTabMstSegRolOpcn> gcTabMstSegRolOpcns;

	//bi-directional many-to-one association to GcTabMstSegUsuaRol
	@OneToMany(mappedBy="gcTabMstSegRol")
	private List<GcTabMstSegUsuaRol> gcTabMstSegUsuaRols;

	public GcTabMstSegRol() {
	}

	public Integer getIdRol() {
		return this.idRol;
	}

	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}

	public String getCoRol() {
		return this.coRol;
	}

	public void setCoRol(String coRol) {
		this.coRol = coRol;
	}
	
	public String getCoRolIntr() {
		return coRolIntr;
	}
	
	public void setCoRolIntr(String coRolIntr) {
		this.coRolIntr = coRolIntr;
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

	public String getDeRol() {
		return this.deRol;
	}

	public void setDeRol(String deRol) {
		this.deRol = deRol;
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
	
	public List<GcTabMstSegRolOpcn> getGcTabMstSegRolOpcns() {
		return gcTabMstSegRolOpcns;
	}
	
	public void setGcTabMstSegRolOpcns(
			List<GcTabMstSegRolOpcn> gcTabMstSegRolOpcns) {
		this.gcTabMstSegRolOpcns = gcTabMstSegRolOpcns;
	}
	
	public GcTabMstSegRolOpcn addGcTabMstSegRolOpcn(GcTabMstSegRolOpcn gcTabMstSegRolOpcn) {
		getGcTabMstSegRolOpcns().add(gcTabMstSegRolOpcn);
		gcTabMstSegRolOpcn.setGcTabMstSegRol(this);

		return gcTabMstSegRolOpcn;
	}

	public GcTabMstSegRolOpcn removeGcTabMstSegRolOpcn(GcTabMstSegRolOpcn gcTabMstSegRolOpcn) {
		getGcTabMstSegRolOpcns().remove(gcTabMstSegRolOpcn);
		gcTabMstSegRolOpcn.setGcTabMstSegRol(null);

		return gcTabMstSegRolOpcn;
	}

	public List<GcTabMstSegUsuaRol> getGcTabMstSegUsuaRols() {
		return this.gcTabMstSegUsuaRols;
	}

	public void setGcTabMstSegUsuaRols(List<GcTabMstSegUsuaRol> gcTabMstSegUsuaRols) {
		this.gcTabMstSegUsuaRols = gcTabMstSegUsuaRols;
	}

	public GcTabMstSegUsuaRol addGcTabMstSegUsuaRol(GcTabMstSegUsuaRol gcTabMstSegUsuaRol) {
		getGcTabMstSegUsuaRols().add(gcTabMstSegUsuaRol);
		gcTabMstSegUsuaRol.setGcTabMstSegRol(this);

		return gcTabMstSegUsuaRol;
	}

	public GcTabMstSegUsuaRol removeGcTabMstSegUsuaRol(GcTabMstSegUsuaRol gcTabMstSegUsuaRol) {
		getGcTabMstSegUsuaRols().remove(gcTabMstSegUsuaRol);
		gcTabMstSegUsuaRol.setGcTabMstSegRol(null);

		return gcTabMstSegUsuaRol;
	}

}