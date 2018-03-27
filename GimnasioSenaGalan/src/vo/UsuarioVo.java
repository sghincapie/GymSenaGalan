package vo;

public class UsuarioVo {

	private String nombre;
	private String apellido;
	private String correo;
	private String telefono;
    private String ficha;
    private String formacion;
	private String rutina;
	private String documento;
	private String sexo;
	private boolean editar;
	private String idingreso;
	private String horaIngreso;
	private String imagen;
	private String estado;
	
    public UsuarioVo(){}
	
	public UsuarioVo(String nombre,String apellido,String correo,String telefono,String ficha,String formacion,String rutina,
	String documento, boolean editar,String sexo,String idingreso,String horaIngreso,String imagen,String estado){
		super();
		this.documento=documento;
		this.nombre=nombre;
		this.apellido=apellido;
		this.correo=correo;
		this.telefono=telefono;
		this.ficha=ficha;
		this.formacion=formacion;
		this.rutina=rutina;
		this.editar=editar;
		this.horaIngreso=horaIngreso;
		this.idingreso=idingreso;
		this.imagen=imagen;
		this.estado=estado;
		this.sexo=sexo;
		
	}
	
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getFicha() {
		return ficha;
	}

	public void setFicha(String ficha) {
		this.ficha = ficha;
	}

	public String getFormacion() {
		return formacion;
	}

	public void setFormacion(String formacion) {
		this.formacion = formacion;
	}

	public String getRutina() {
		return rutina;
	}

	public void setRutina(String rutina) {
		this.rutina = rutina;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public boolean isEditar() {
		return editar;
	}

	public void setEditar(boolean editar) {
		this.editar = editar;
	}

	public String getIdingreso() {
		return idingreso;
	}

	public void setIdingreso(String idingreso) {
		this.idingreso = idingreso;
	}

	public String getHoraIngreso() {
		return horaIngreso;
	}

	public void setHoraIngreso(String horaIngreso) {
		this.horaIngreso = horaIngreso;
	}
	
	
	
	
}
