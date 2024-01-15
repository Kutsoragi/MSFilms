package negocio.facturaTienda;

import java.util.Objects;

import javax.persistence.*;

@Embeddable
public class LineaFacturaTiendaID {

	@Column(name = "id_factura")
	private int idFactura;
	
	@Column(name = "id_producto")
	private int idProducto;
	
	public LineaFacturaTiendaID(){
		
	}
	
	public LineaFacturaTiendaID(int idFactura, int idProducto){
		this.idFactura = idFactura;
		this.idProducto = idProducto;
	}

	public int getIdFactura() {
		return idFactura;
	}

	public void setIdFactura(int idFactura) {
		this.idFactura = idFactura;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	
	 @Override
    public int hashCode() {
        int hash = 1;
        hash = 34 * hash + Objects.hashCode(this.idFactura);
        hash = 34 * hash + Objects.hashCode(this.idProducto);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final LineaFacturaTiendaID other = (LineaFacturaTiendaID) obj;
        if (!Objects.equals(this.idFactura, other.idFactura)) {
            return false;
        }
        if (!Objects.equals(this.idProducto, other.idProducto)) {
            return false;
        }
        return true;
    }
}
