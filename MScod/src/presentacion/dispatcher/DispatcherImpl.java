package presentacion.dispatcher;

import presentacion.controller.Context;
import presentacion.vistas.empleado.EmpleadoGui;
import presentacion.vistas.factura.FacturaGui;
import presentacion.vistas.factura_tienda.FacturaTiendaGui;
import presentacion.vistas.main.MainGui;
import presentacion.vistas.marca.MarcaGui;
import presentacion.vistas.pase.PaseGui;
import presentacion.vistas.pelicula.PeliculaGui;
import presentacion.vistas.producto.ProductoGui;
import presentacion.vistas.proveedor.ProveedorGui;

public class DispatcherImpl extends Dispatcher {
	
	public void dispatch(Context responseContext) {

		switch(responseContext.getEvent()) {
			// Vista Main
			case MOSTRAR_INICIO:
			//case MOSTRAR_PELICULA:
				MainGui.getInstance().actualizar(responseContext);
				break;
		
			// Vista Pelicula
			case REGISTRAR_PELICULA_OK:
			case REGISTRAR_PELICULA_KO:
			case MODIFICAR_PELICULA_OK:
			case MODIFICAR_PELICULA_KO:
			case BORRAR_PELICULA_OK:
			case BORRAR_PELICULA_KO:
			case BUSCAR_PELICULA_OK:
			case BUSCAR_PELICULA_KO:
			case MOSTRAR_LISTA_PELICULA_OK:
			case MOSTRAR_LISTA_PELICULA_KO:
			case MOSTRAR_POR_FECHA_PELICULA_OK:
			case MOSTRAR_POR_FECHA_PELICULA_KO:
			case PELICULAS_MAS_VENDIDAS_OK:
			case PELICULAS_MAS_VENDIDAS_KO:
				PeliculaGui.getInstance().actualizar(responseContext);
				break;
				
			// Vista Pase
			case REGISTRAR_PASE_OK:
			case REGISTRAR_PASE_KO:
			case MODIFICAR_PASE_OK:
			case MODIFICAR_PASE_KO:
			case BORRAR_PASE_OK:
			case BORRAR_PASE_KO:
			case BUSCAR_PASE_OK:
			case BUSCAR_PASE_KO:
			case MOSTRAR_LISTA_PASE_OK:
			case MOSTRAR_LISTA_PASE_KO:
			case MOSTRAR_POR_PELICULA_PASE_OK:
			case MOSTRAR_POR_PELICULA_PASE_KO:
				PaseGui.getInstance().actualizar(responseContext);
				break;
				
			// Vista Empleado
			case REGISTRAR_EMPLEADO_OK:
			case REGISTRAR_EMPLEADO_KO:
			case MODIFICAR_EMPLEADO_OK:
			case MODIFICAR_EMPLEADO_KO:
			case BORRAR_EMPLEADO_OK:
			case BORRAR_EMPLEADO_KO:
			case BUSCAR_EMPLEADO_OK:
			case BUSCAR_EMPLEADO_KO:
			case MOSTRAR_LISTA_EMPLEADO_OK:
			case MOSTRAR_LISTA_EMPLEADO_KO:
			case MOSTRAR_POR_JORNADA_EMPLEADO_OK:
			case MOSTRAR_POR_JORNADA_EMPLEADO_KO:
				EmpleadoGui.getInstance().actualizar(responseContext);
				break;
				
			// Vista Factura
			case ABRIR_FACTURA:
			case AÑADIR_PASE_OK:
			case AÑADIR_PASE_KO:
			case QUITAR_PASE_OK:
			case QUITAR_PASE_KO:
			case CERRAR_FACTURA_OK:
			case CERRAR_FACTURA_KO:
			case DEVOLVER_PASE_OK:
			case DEVOLVER_PASE_KO:
			case BUSCAR_FACTURA_OK:
			case BUSCAR_FACTURA_KO:
			case MOSTRAR_LISTA_FACTURA_OK:
			case MOSTRAR_LISTA_FACTURA_KO:
				FacturaGui.getInstance().actualizar(responseContext);
				break;

			// JPA
			// Vista Marca
			case REGISTRAR_MARCA_OK:
			case REGISTRAR_MARCA_KO:
			case MODIFICAR_MARCA_OK:
			case MODIFICAR_MARCA_KO:
			case BORRAR_MARCA_OK:
			case BORRAR_MARCA_KO:
			case BUSCAR_MARCA_OK:
			case BUSCAR_MARCA_KO:
			case MOSTRAR_MARCAS_OK:
			case MOSTRAR_MARCAS_KO:
			case MOSTRAR_CALORIAS_MEDIAS_DE_MARCA_OK:
			case MOSTRAR_CALORIAS_MEDIAS_DE_MARCA_KO:
			case MOSTRAR_PRODUCTOS_POR_MARCA_OK:
			case MOSTRAR_PRODUCTOS_POR_MARCA_KO:
				MarcaGui.getInstance().actualizar(responseContext);
				break;
			
			// Vista Proveedor
			case REGISTRAR_PROVEEDOR_OK:
			case REGISTRAR_PROVEEDOR_KO:
			case MODIFICAR_PROVEEDOR_OK:
			case MODIFICAR_PROVEEDOR_KO:
			case BORRAR_PROVEEDOR_OK:
			case BORRAR_PROVEEDOR_KO:
			case BUSCAR_PROVEEDOR_OK:
			case BUSCAR_PROVEEDOR_KO:
			case MOSTRAR_PROVEEDORES_OK:
			case MOSTRAR_PROVEEDORES_KO:
			//case MOSTRAR_POR_DINERO_COBRADO_TRAS_FECHA_PROVEEDOR_OK:
			//case MOSTRAR_POR_DINERO_COBRADO_TRAS_FECHA_PROVEEDOR_KO:
				ProveedorGui.getInstance().actualizar(responseContext);
				break;
				
			// Vista Producto
			case REGISTRAR_PRODUCTO_OK:
			case REGISTRAR_PRODUCTO_KO:
			case MODIFICAR_PRODUCTO_OK:
			case MODIFICAR_PRODUCTO_KO:
			case BORRAR_PRODUCTO_OK:
			case BORRAR_PRODUCTO_KO:
			case BUSCAR_PRODUCTO_OK:
			case BUSCAR_PRODUCTO_KO:
			case MOSTRAR_PRODUCTOS_OK:
			case MOSTRAR_PRODUCTOS_KO:
			//case MOSTRAR_PRODUCTO_MAS_CALORICO_OK:
			//case MOSTRAR_PRODUCTO_MAS_CALORICO_KO:
			case MOSTRAR_PRODUCTOS_CON_MAS_DE_X_STOCK_OK:
			case MOSTRAR_PRODUCTOS_CON_MAS_DE_X_STOCK_KO:
				ProductoGui.getInstance().actualizar(responseContext);
				break;
				
			// Vista Factura Tienda
			case ABRIR_FACTURA_TIENDA:
			case AÑADIR_PRODUCTO_OK:
			case AÑADIR_PRODUCTO_KO:
			case QUITAR_PRODUCTO_OK:
			case QUITAR_PRODUCTO_KO:
			case CERRAR_FACTURA_TIENDA_OK:
			case CERRAR_FACTURA_TIENDA_KO:
			case DEVOLVER_PRODUCTO_OK:
			case DEVOLVER_PRODUCTO_KO:
			case BUSCAR_FACTURA_TIENDA_OK:
			case BUSCAR_FACTURA_TIENDA_KO:
			case LISTAR_FACTURAS_TIENDA_OK:
			case LISTAR_FACTURAS_TIENDA_KO:
			//case MOSTRAR_FACTURA_POR_PRODUCTO_CON_PRECIO_MINIMO_OK:
			//case MOSTRAR_FACTURA_POR_PRODUCTO_CON_PRECIO_MINIMO_KO:
				FacturaTiendaGui.getInstance().actualizar(responseContext);
				break;
			default:
				System.out.println("Evento en Dispatcher desconocido: " + responseContext.getEvent().toString());
				break;
		}
	}
}
