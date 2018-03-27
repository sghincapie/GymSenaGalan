package Bean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import dao.EjercicioDao;

import vo.EjercicioVo;



@ManagedBean
@ViewScoped
public class EjercicioBean {
	
	
String MsjBD;

private ArrayList<EjercicioVo> listaEjercicio = new ArrayList<>();
private ArrayList<EjercicioVo> listaEjercicioConsulta = new ArrayList<>();
private ArrayList<EjercicioVo> listaEjercicio2 = new ArrayList<>();	
private ArrayList<EjercicioVo> listaEjercicioPecho = new ArrayList<>();	
private ArrayList<EjercicioVo> listaEjercicioEspalda = new ArrayList<>();	
private ArrayList<EjercicioVo> listaEjercicioBiceps = new ArrayList<>();	
private ArrayList<EjercicioVo> listaEjercicioTriceps = new ArrayList<>();	
private ArrayList<EjercicioVo> listaEjercicioCadera = new ArrayList<>();	
private ArrayList<EjercicioVo> listaEjercicioHombros = new ArrayList<>();	
private ArrayList<EjercicioVo> listaEjercicioPierna = new ArrayList<>();	
private ArrayList<EjercicioVo> listaEjercicioMuslo= new ArrayList<>();	
private ArrayList<EjercicioVo> listaEjercicioTrapesio = new ArrayList<>();	
EjercicioVo miejercicio;
EjercicioVo miejercicioEditar;
EjercicioDao miejerciciodao;
FacesContext context = FacesContext.getCurrentInstance();
HttpSession session = (HttpSession)context.getExternalContext().getSession(true);




public EjercicioBean() {
	miejercicio= new EjercicioVo();
	miejerciciodao = new EjercicioDao();
	miejercicioEditar= new EjercicioVo();
	
}


public void eliminarEjercicio(EjercicioVo ejercicio) {
	setMsjBD(miejerciciodao.eliminarEjercicio(ejercicio));
	
	listaEjercicio2.remove(ejercicio);
	listaEjercicioPecho.remove(ejercicio);
	listaEjercicioEspalda.remove(ejercicio);
	listaEjercicioHombros.remove(ejercicio);
	listaEjercicioCadera.remove(ejercicio);
	listaEjercicioBiceps.remove(ejercicio);
	listaEjercicioTriceps.remove(ejercicio);
	listaEjercicioMuslo.remove(ejercicio);
	listaEjercicioPierna.remove(ejercicio);
	listaEjercicioTrapesio.remove(ejercicio);
	
	
}
public void ConsultarEjercicio() {
	listaEjercicioConsulta.clear();
	listaEjercicioConsulta=miejerciciodao.ConsultaEjercicio(miejercicioEditar);
	miejercicioEditar = new EjercicioVo();
}


public String editarEjercicio(String idEjercicio) {

	System.out.println("ingresa");
	System.out.println(idEjercicio);
    System.out.println("ingresa");
    miejercicio= (EjercicioVo) miejerciciodao.obtenerListaEjercicios2(idEjercicio);
    session.setAttribute("Ejercicio", miejercicio);
    
	
return "editarEjercicio.jsf";
	
	
	
}
public String guardarEjercicio(EjercicioVo ejercicio) {
	setMsjBD(miejerciciodao.editarEjercicio(ejercicio));
	return "listaEjercicio.jsf?faces-redirect=true";
	
}


public void agregarEjercicio() {
	setMsjBD(miejerciciodao.agregarEjercicio(miejercicio));
	miejercicio = new EjercicioVo();// limpiamos el objeto
	
}

public void listaEjerciciosPecho() {
	listaEjercicioPecho.clear();
	listaEjercicioPecho = miejerciciodao.obtenerListaEjerciciosPecho() ;
	
	if (listaEjercicioPecho == null) {
		setMsjBD("No se pudo conectar, verifique que la Base de Datos " + "se encuentre iniciada");
	}
}
public void listaEjerciciosEspalda() {
	listaEjercicioEspalda.clear();
	listaEjercicioEspalda = miejerciciodao.obtenerListaEjerciciosEspalda() ;
	
	if (listaEjercicioEspalda == null) {
		setMsjBD("No se pudo conectar, verifique que la Base de Datos " + "se encuentre iniciada");
	}
}
public void listaEjerciciosBiceps() {
	listaEjercicioBiceps.clear();
	listaEjercicioBiceps = miejerciciodao.obtenerListaEjerciciosBiceps() ;
	
	if (listaEjercicioBiceps == null) {
		setMsjBD("No se pudo conectar, verifique que la Base de Datos " + "se encuentre iniciada");
	}
}
public void listaEjerciciosTriceps() {
	listaEjercicioTriceps.clear();
	listaEjercicioTriceps = miejerciciodao.obtenerListaEjerciciosTriceps() ;
	
	if (listaEjercicioTriceps == null) {
		setMsjBD("No se pudo conectar, verifique que la Base de Datos " + "se encuentre iniciada");
	}
}
public void listaEjerciciosCadera() {
	listaEjercicioCadera.clear();
	listaEjercicioCadera = miejerciciodao.obtenerListaEjerciciosCadera() ;
	
	if (listaEjercicioCadera == null) {
		setMsjBD("No se pudo conectar, verifique que la Base de Datos " + "se encuentre iniciada");
	}
}
public void listaEjerciciosHombros() {
	listaEjercicioHombros.clear();
	listaEjercicioHombros = miejerciciodao.obtenerListaEjerciciosHombros() ;
	
	if (listaEjercicioHombros == null) {
		setMsjBD("No se pudo conectar, verifique que la Base de Datos " + "se encuentre iniciada");
	}
}
public void listaEjerciciosPierna() {
	listaEjercicioPierna.clear();
	listaEjercicioPierna = miejerciciodao.obtenerListaEjerciciosPierna() ;
	
	if (listaEjercicioPierna == null) {
		setMsjBD("No se pudo conectar, verifique que la Base de Datos " + "se encuentre iniciada");
	}
}
public void listaEjerciciosMuslo() {
	listaEjercicioMuslo.clear();
	listaEjercicioMuslo = miejerciciodao.obtenerListaEjerciciosMuslo() ;
	
	if (listaEjercicioMuslo == null) {
		setMsjBD("No se pudo conectar, verifique que la Base de Datos " + "se encuentre iniciada");
	}
}
public void listaEjerciciosTrapecio() {
	listaEjercicioTrapesio.clear();
	listaEjercicioTrapesio = miejerciciodao.obtenerListaEjerciciosTrapecio() ;
	
	if (listaEjercicioTrapesio == null) {
		setMsjBD("No se pudo conectar, verifique que la Base de Datos " + "se encuentre iniciada");
	}
}



public String getMsjBD() {
	return MsjBD;
}


public void setMsjBD(String msjBD) {
	MsjBD = msjBD;
}

public ArrayList<EjercicioVo> getListaEjercicioPecho() {
	return listaEjercicioPecho;
}





public ArrayList<EjercicioVo> getListaEjercicio() {
	return listaEjercicio;
}





public ArrayList<EjercicioVo> getListaEjercicio2() {
	return listaEjercicio2;
}





public EjercicioVo getMiejercicio() {
	return miejercicio;
}


public void setMiejercicio(EjercicioVo miejercicio) {
	this.miejercicio = miejercicio;
}


public EjercicioDao getMiejerciciodao() {
	return miejerciciodao;
}


public void setMiejerciciodao(EjercicioDao miejerciciodao) {
	this.miejerciciodao = miejerciciodao;
}

public ArrayList<EjercicioVo> getListaEjercicioEspalda() {
	return listaEjercicioEspalda;
}

public ArrayList<EjercicioVo> getListaEjercicioBiceps() {
	return listaEjercicioBiceps;
}

public ArrayList<EjercicioVo> getListaEjercicioTriceps() {
	return listaEjercicioTriceps;
}

public ArrayList<EjercicioVo> getListaEjercicioCadera() {
	return listaEjercicioCadera;
}

public ArrayList<EjercicioVo> getListaEjercicioHombros() {
	return listaEjercicioHombros;
}

public ArrayList<EjercicioVo> getListaEjercicioPierna() {
	return listaEjercicioPierna;
}

public ArrayList<EjercicioVo> getListaEjercicioMuslo() {
	return listaEjercicioMuslo;
}

public ArrayList<EjercicioVo> getListaEjercicioTrapesio() {
	return listaEjercicioTrapesio;
}

public EjercicioVo getMiejercicioEditar() {
	return miejercicioEditar;
}

public void setMiejercicioEditar(EjercicioVo miejercicioEditar) {
	this.miejercicioEditar = miejercicioEditar;
}

public ArrayList<EjercicioVo> getListaEjercicioConsulta() {
	return listaEjercicioConsulta;
}

public void setListaEjercicioConsulta(ArrayList<EjercicioVo> listaEjercicioConsulta) {
	this.listaEjercicioConsulta = listaEjercicioConsulta;
}





}
