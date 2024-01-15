/**
 * 
 */
package negocio.producto;

import javax.persistence.*;

@Entity
public class ProductoComida extends Producto {

	@Column(name = "peso")
	private Integer peso;

	public ProductoComida(Integer id, double precio, Integer calorias, Integer version, Integer stock, Integer peso) {

		super(id, precio, calorias, version, stock);
		this.setPeso(peso);

	}

	public ProductoComida() {
	}

	public Integer getPeso() {
		return peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}

	public Integer calculateCalorias() {
		return calorias * peso;
	}

}