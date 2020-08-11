package cm.beni.main.julia.model.schema.factures;
// Generated 2 ao�t 2020 02:36:36 by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * RubriquesFacture generated by hbm2java
 */
@Entity
@Table(name = "rubriques_facture", schema = "factures")
//@JsonIdentityInfo(generator=ObjectIdGenerators.UUIDGenerator.class, property="@rubriquesFacture", scope = RubriquesFacture.class, resolver = ObjectIdResolver.class)
public class RubriquesFacture implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String identify;
	private Facture facture;
	private Rubrique rubrique;
	private double montant;
	private boolean taxable;

	public RubriquesFacture() {
	}

	public RubriquesFacture(String identify, Facture facture, Rubrique rubrique, double montant, boolean taxable) {
		this.identify = identify;
		this.facture = facture;
		this.rubrique = rubrique;
		this.montant = montant;
		this.taxable = taxable;
	}

	@Id

	@Column(name = "identify", unique = true, nullable = false, length = 64)
	public String getIdentify() {
		return this.identify;
	}

	public void setIdentify(String identify) {
		this.identify = identify;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "facture", nullable = false)
	public Facture getFacture() {
		return this.facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "rubrique", nullable = false)
	public Rubrique getRubrique() {
		return this.rubrique;
	}

	public void setRubrique(Rubrique rubrique) {
		this.rubrique = rubrique;
	}

	@Column(name = "montant", nullable = false, scale = 0)
	public double getMontant() {
		return this.montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	@Column(name = "taxable", nullable = false)
	public boolean isTaxable() {
		return this.taxable;
	}

	public void setTaxable(boolean taxable) {
		this.taxable = taxable;
	}

}