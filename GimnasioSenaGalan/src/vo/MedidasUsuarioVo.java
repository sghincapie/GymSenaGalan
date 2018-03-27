package vo;

public class MedidasUsuarioVo {
	private String documento;	
	private double peso;
	private String estatura;
	private String cuello;
	private String pecho;
	private String brazo;
	private String antebrazo;
	private String cintura;
	private String caderas;
	private String muslo;
	private String pantorrilla;
	private boolean editar;
	
	 public boolean isEditar() {
		return editar;
	}

	public void setEditar(boolean editar) {
		this.editar = editar;
	}

	public MedidasUsuarioVo(){}
		
		public MedidasUsuarioVo(String documento,double peso,String estatura,String cuello,String pecho,String brazo,String antebrazo,
		String cintura,String caderas,String muslo,String pantorrilla){
			super();
			

			this.peso=peso;
			this.estatura=estatura;
			this.cuello=cuello;
			this.pecho=pecho;
			this.brazo=brazo;
			this.antebrazo=antebrazo;
			this.cintura=cintura;
			this.caderas=caderas;
			this.muslo=muslo;
			this.pantorrilla=pantorrilla;
	
			this.documento=documento;
			
			
		}
		
		
		

		public String getDocumento() {
			return documento;
		}

		public void setDocumento(String documento) {
			this.documento = documento;
		}


		public double getPeso() {
			return peso;
		}

		public void setPeso(double peso) {
			this.peso = peso;
		}

		public String getEstatura() {
			return estatura;
		}

		public void setEstatura(String estatura) {
			this.estatura = estatura;
		}

		public String getCuello() {
			return cuello;
		}

		public void setCuello(String cuello) {
			this.cuello = cuello;
		}

		public String getPecho() {
			return pecho;
		}

		public void setPecho(String pecho) {
			this.pecho = pecho;
		}

		public String getBrazo() {
			return brazo;
		}

		public void setBrazo(String brazo) {
			this.brazo = brazo;
		}

		public String getAntebrazo() {
			return antebrazo;
		}

		public void setAntebrazo(String antebrazo) {
			this.antebrazo = antebrazo;
		}

		public String getCintura() {
			return cintura;
		}

		public void setCintura(String cintura) {
			this.cintura = cintura;
		}

		public String getCaderas() {
			return caderas;
		}

		public void setCaderas(String caderas) {
			this.caderas = caderas;
		}

		public String getMuslo() {
			return muslo;
		}

		public void setMuslo(String muslo) {
			this.muslo = muslo;
		}

		public String getPantorrilla() {
			return pantorrilla;
		}

		public void setPantorrilla(String pantorrilla) {
			this.pantorrilla = pantorrilla;
		}

	

		
}
