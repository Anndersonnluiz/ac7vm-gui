package br.com.sistemags.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "feednoticias")
public class Feednoticias implements Serializable{

	/** 
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "idfeednoticias")
	private Integer idfeednoticias;
	@Column(name = "titulo")
	private String titulo;
	@Column(name = "idacesso")
	private Integer idacesso;

}
