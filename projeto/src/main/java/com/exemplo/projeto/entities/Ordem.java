package com.exemplo.projeto.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.exemplo.projeto.entities.enums.OrdemStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_ordem")
public class Ordem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant momento;
	
	private Integer ordemStatus;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Usuario cliente;

	@OneToMany(mappedBy = "id.ordem")
	private Set<OrdemItem> itens = new HashSet<>();
	
	@OneToOne(mappedBy = "ordem", cascade = CascadeType.ALL)
	private Pagamento pagamento;
	
	public Ordem() {
	}

	public Ordem(Long id, Instant momento, OrdemStatus ordemStatus, Usuario cliente) {
		super();
		this.id = id;
		this.momento = momento;
		setOrdemStatus(ordemStatus);
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMomento() {
		return momento;
	}

	public void setMomento(Instant momento) {
		this.momento = momento;
	}
	
	public OrdemStatus getOrdemStatus() {
		return OrdemStatus.valueOf(ordemStatus);
	}

	public void setOrdemStatus(OrdemStatus ordemStatus) {
		if (ordemStatus != null) {
			this.ordemStatus = ordemStatus.getCod();
		}
	}

	public Usuario getCliente() {
		return cliente;
	}

	public void setCliente(Usuario cliente) {
		this.cliente = cliente;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	
	public Set<OrdemItem> getItems() {
		return itens;
	}
	
	public Double getTotal() {
		double sum = 0.0;
		for (OrdemItem x : itens) {
			sum += x.getSubTotal();
		}
		return sum;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ordem other = (Ordem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
