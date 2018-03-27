package Bean;

import java.util.ArrayList;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import dao.EjercicioDao;
import dao.RutinaDao;
import vo.EjercicioVo;
import vo.RutinaVo;


@ManagedBean
@ViewScoped
public class RutinaBean {
    RutinaVo mirutina;
    Map params;
    String MsjBD;
    EjercicioDao miejerciciodao;
    RutinaDao mirutinaDao;
    private ArrayList<EjercicioVo> listaEjercicio=new ArrayList<>();
    String nivel;
    String ID;
    private ArrayList<String> IdsEjercicios =new ArrayList<>();
    private boolean asociar = false;
    private ArrayList<RutinaVo> listaPecho=new ArrayList<>();
    private ArrayList<RutinaVo> listaEspalda=new ArrayList<>();
    private ArrayList<RutinaVo> listaBicep=new ArrayList<>();
    private ArrayList<RutinaVo> listaTricep=new ArrayList<>();
    private ArrayList<RutinaVo> listaCaderas=new ArrayList<>();
    private ArrayList<RutinaVo> listaHombro=new ArrayList<>();
    private ArrayList<RutinaVo> listaPiernas=new ArrayList<>();
    private ArrayList<RutinaVo> listaMuslos=new ArrayList<>();
    private ArrayList<RutinaVo> listaTrapesios=new ArrayList<>();
    FacesContext context = FacesContext.getCurrentInstance();
    HttpSession session = (HttpSession)context.getExternalContext().getSession(true);
    
	public RutinaBean() {
	mirutinaDao= new RutinaDao();
	mirutina=new RutinaVo();
	miejerciciodao=new EjercicioDao();
	}
	public void eliminarRutina(RutinaVo rutina) {
		setMsjBD(mirutinaDao.eliminarRutina(rutina));
		
	}
    public String editarRutina(String idrutina) {
    	System.out.println("ingresa");
		System.out.println(idrutina);
		mirutina=mirutinaDao.obtenerRutina(idrutina);
	    session.setAttribute("Rutina", mirutina);
	    
		
	return "editarRutina.jsf";
    }

	public String guardarRutina(RutinaVo rutina) {
		setMsjBD(mirutinaDao.editarRutina(rutina));
		return "listaRutina.jsf?faces-redirect=true";
		
	}

	public void AsigarE() {
		System.out.println("Entro metodo AsignarE");
		
	}
	public void TodoslosEjercicios() {
		FacesContext facescontext=FacesContext.getCurrentInstance();
		params=facescontext.getExternalContext().getRequestParameterMap();
		nivel=((String) params.get("nivel"));
		listaEjercicio.clear();
		listaEjercicio=miejerciciodao.obtenerListaEjercicios(nivel);	
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().clear();
	}
	
	public void RegistrarRutina() {
	if (mirutina==null) {
		System.out.println("esta nula la instancia");
	}else {
		String nombre;
		String id;
		nombre=mirutina.getNombre();
		id=mirutina.getId();
		System.out.println("Si tiene algo la instancia");
		System.out.println(nombre);
		System.out.println(id);
		System.out.println(IdsEjercicios);

	}
	
	
	}
	public void LlenaArreglo(String id) {
		asociar=true;
		System.out.println("entro a llenararreglo");
		IdsEjercicios.add(id);
		System.out.println(IdsEjercicios);
	}

	

	public void quitarId(String id) {
		asociar=false;
		IdsEjercicios.remove(id);
		System.out.println("se elimino de la lista");
		System.out.println("la lista queda asi "+IdsEjercicios);
	}
	public RutinaVo getMirutina() {
		return mirutina;
	}

	public void setMirutina(RutinaVo mirutina) {
		this.mirutina = mirutina;
	}

	public ArrayList<EjercicioVo> getListaEjercicio() {
		return listaEjercicio;
	}

	public void setListaEjercicio(ArrayList<EjercicioVo> listaEjercicio) {
		this.listaEjercicio = listaEjercicio;
	}
	public ArrayList<String> getIdsEjercicios() {
		return IdsEjercicios;
	}
	public void setIdsEjercicios(ArrayList<String> idsEjercicios) {
		IdsEjercicios = idsEjercicios;
	}
	public boolean isAsociar() {
		return asociar;
	}
	public void setAsociar(boolean asociar) {
		this.asociar = asociar;
	}
	
	public void listaRutinaPecho() {
		listaPecho.clear();
		listaPecho = mirutinaDao.obtenerListaRutinaPecho() ;
		
		if (listaPecho == null) {
			setMsjBD("No se pudo conectar, verifique que la Base de Datos " + "se encuentre iniciada");
		}
	}
	public void listaRutinaEspalda() {
		listaEspalda.clear();
		listaEspalda = mirutinaDao.obtenerListaRutinaEspalda() ;
		
		if (listaEspalda == null) {
			setMsjBD("No se pudo conectar, verifique que la Base de Datos " + "se encuentre iniciada");
		}
	}
	public void listaBiceps() {
		listaBicep.clear();
		listaBicep = mirutinaDao.obtenerListaRutinaBiceps() ;
		
		if (listaBicep == null) {
			setMsjBD("No se pudo conectar, verifique que la Base de Datos " + "se encuentre iniciada");
		}
	}
	public void listaTriceps() {
		listaTricep.clear();
		listaTricep = mirutinaDao.obtenerListaRutinaTriceps() ;
		
		if (listaTricep == null) {
			setMsjBD("No se pudo conectar, verifique que la Base de Datos " + "se encuentre iniciada");
		}
	}
	public void listaCadera() {
		listaCaderas.clear();
		listaCaderas = mirutinaDao.obtenerListaRutinaCadera() ;
		
		if (listaCaderas == null) {
			setMsjBD("No se pudo conectar, verifique que la Base de Datos " + "se encuentre iniciada");
		}
	}
	public void listaHombros() {
		listaHombro.clear();
		listaHombro = mirutinaDao.obtenerListaRutinaHombros() ;
		
		if (listaHombro == null) {
			setMsjBD("No se pudo conectar, verifique que la Base de Datos " + "se encuentre iniciada");
		}
	}
	public void listaPierna() {
		listaPiernas.clear();
		listaPiernas = mirutinaDao.obtenerListaRutinaPierna() ;
		
		if (listaPiernas == null) {
			setMsjBD("No se pudo conectar, verifique que la Base de Datos " + "se encuentre iniciada");
		}
	}
	public void listaMuslo() {
		listaMuslos.clear();
		listaMuslos = mirutinaDao.obtenerListaRutinaMuslo() ;
		
		if (listaMuslos == null) {
			setMsjBD("No se pudo conectar, verifique que la Base de Datos " + "se encuentre iniciada");
		}
	}
	public void listaTrapecio() {
		listaTrapesios.clear();
		listaTrapesios = mirutinaDao.obtenerListaRutinaTrapecio() ;
		
		if (listaTrapesios == null) {
			setMsjBD("No se pudo conectar, verifique que la Base de Datos " + "se encuentre iniciada");
		}
	}
	public String getMsjBD() {
		return MsjBD;
	}


	public void setMsjBD(String msjBD) {
		MsjBD = msjBD;
	}
	public ArrayList<RutinaVo> getListaPecho() {
		return listaPecho;
	}
	
	public ArrayList<RutinaVo> getListaEspalda() {
		return listaEspalda;
	}

	public ArrayList<RutinaVo> getListaBicep() {
		return listaBicep;
	}
	
	public ArrayList<RutinaVo> getListaTricep() {
		return listaTricep;
	}

	public ArrayList<RutinaVo> getListaCaderas() {
		return listaCaderas;
	}
	
	public ArrayList<RutinaVo> getListaHombro() {
		return listaHombro;
	}
	
	public ArrayList<RutinaVo> getListaPiernas() {
		return listaPiernas;
	}

	public ArrayList<RutinaVo> getListaMuslos() {
		return listaMuslos;
	}

	public ArrayList<RutinaVo> getListaTrapesios() {
		return listaTrapesios;
	}
	
	
	
	
	
	
}
