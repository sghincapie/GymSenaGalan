package vo;

public class RutinaVo {

	private String id;
	private String Tipo;
	private String Nombre;
	private String idE1;
	private String idE2;
	private String idE3;
	private String idE4;
	private String idE5;
	private String idE6;
	private String idE7;
	private String idE8;
		
	public RutinaVo() {
		
	}
		
	public RutinaVo(String id,String tipo, String nombre,String idE1,String idE2,String idE3,String idE4,String idE5,
			String idE6,String idE7,String idE8) {
	super();
	this.id=id;
	this.Tipo=tipo;
	this.Nombre=nombre;
	this.idE1=idE1;
	this.idE2=idE2;
	this.idE3=idE3;
	this.idE4=idE4;
	this.idE5=idE5;
	this.idE6=idE6;
	this.idE7=idE7;
	this.idE8=idE8;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getTipo() {
		return Tipo;
	}


	public void setTipo(String tipo) {
		Tipo = tipo;
	}


	public String getNombre() {
		return Nombre;
	}


	public void setNombre(String nombre) {
		Nombre = nombre;
	}


	public String getIdE1() {
		return idE1;
	}


	public void setIdE1(String idE1) {
		this.idE1 = idE1;
	}


	public String getIdE2() {
		return idE2;
	}


	public void setIdE2(String idE2) {
		this.idE2 = idE2;
	}


	public String getIdE3() {
		return idE3;
	}


	public void setIdE3(String idE3) {
		this.idE3 = idE3;
	}


	public String getIdE4() {
		return idE4;
	}


	public void setIdE4(String idE4) {
		this.idE4 = idE4;
	}


	public String getIdE5() {
		return idE5;
	}


	public void setIdE5(String idE5) {
		this.idE5 = idE5;
	}


	public String getIdE6() {
		return idE6;
	}


	public void setIdE6(String idE6) {
		this.idE6 = idE6;
	}


	public String getIdE7() {
		return idE7;
	}


	public void setIdE7(String idE7) {
		this.idE7 = idE7;
	}


	public String getIdE8() {
		return idE8;
	}


	public void setIdE8(String idE8) {
		this.idE8 = idE8;
	}


}
