package vo;

public class EjercicioVo {
	
	private String tipoEjercicio;
	private String nombre;
	private String nivel;
	private String series;
	private String repeticiones;
	private String descripcion;
	private String imagen;
	private String idEjercicio;
	private boolean editar;
	
	public EjercicioVo() {
		
	}
	
	public EjercicioVo(String idEjercicio,String tipoEjercicio,String nombre,String nivel,String series,String repeticiones,String descripcion,
			String imagen,boolean editar){
				super();
				
				this.nombre=nombre;
				this.tipoEjercicio=tipoEjercicio;
				this.nivel=nivel;
				this.series=series;
				this.repeticiones=repeticiones;
				this.descripcion=descripcion;
				this.idEjercicio=idEjercicio;
				this.imagen=imagen;
				this.editar=editar;
				
			}
	
	

	public boolean isEditar() {
		return editar;
	}

	public void setEditar(boolean editar) {
		this.editar = editar;
	}

	public String getTipoEjercicio() {
		return tipoEjercicio;
	}

	public void setTipoEjercicio(String tipoEjercicio) {
		this.tipoEjercicio = tipoEjercicio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getRepeticiones() {
		return repeticiones;
	}

	public void setRepeticiones(String repeticiones) {
		this.repeticiones = repeticiones;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getIdEjercicio() {
		return idEjercicio;
	}

	public void setIdEjercicio(String idEjercicio) {
		this.idEjercicio = idEjercicio;
	}

	

}
