	package Bean;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import dao.PersonaDao;
import vo.MedidasUsuarioVo;
import vo.UsuarioVo;

@ManagedBean
@ViewScoped
public class TablaBean {
	private ArrayList<UsuarioVo> listaPersona = new ArrayList<>();
	private ArrayList<UsuarioVo> listaPersona2 = new ArrayList<>();
	private ArrayList<UsuarioVo> listaPersona3 = new ArrayList<>();
	private UsuarioVo miusuario;
	private UsuarioVo miusuario2;
	private MedidasUsuarioVo medidas;
	PersonaDao personaDao;
	private String msjBD;
	private String msjBD2;
	private boolean muestrainfo;
	private String documentoabuscar;
	FacesContext context = FacesContext.getCurrentInstance();
	HttpSession session = (HttpSession)context.getExternalContext().getSession(true);
	
	
	

	public String getDocumentoabuscar() {
		return documentoabuscar;
	}

	public void setDocumentoabuscar(String documentoabuscar) {
		this.documentoabuscar = documentoabuscar;
	}

	public String getMsjBD2() {
		return msjBD2;
	}

	public void setMsjBD2(String msjBD2) {
		this.msjBD2 = msjBD2;
	}

	public boolean isMuestrainfo() {
		return muestrainfo;
	}

	public void setMuestrainfo(boolean muestrainfo) {
		this.muestrainfo = muestrainfo;
	}

	public TablaBean() {
		miusuario = new UsuarioVo();
		miusuario2 = new UsuarioVo();
		personaDao = new PersonaDao();
		medidas=new MedidasUsuarioVo();
		cargarPersonas2();
		cargarPersonas3();
	}

	public void consultarPersona(UsuarioVo documento) {
		
		
		if (miusuario != null) {
			setMuestrainfo(true);
			setMsjBD("");
		} else {
			setMuestrainfo(false);
			setMsjBD("No se encuentra la persona");
			miusuario = new UsuarioVo();
		}
	}

	

	public void cargarPersonas() {
		listaPersona.clear();
		listaPersona = personaDao.obtenerListaPersonas();
		if (listaPersona == null) {
			setMsjBD("No se pudo conectar, verifique que la Base de Datos " + "se encuentre iniciada");
		}
	}
	
	public void cargarPersonas2() {
		
		listaPersona2 = personaDao.obtenerListaPersonasRegistrados();
		if (listaPersona2 == null) {
			setMsjBD("No se pudo conectar, verifique que la Base de Datos " + "se encuentre iniciada");
		}
	}
	public void cargarPersonas3() {
		
		listaPersona3 = personaDao.obtenerListaPersonasRegistradosInactivos();
		if (listaPersona2 == null) {
			setMsjBD("No se pudo conectar, verifique que la Base de Datos " + "se encuentre iniciada");
		}
	}

	public ArrayList<UsuarioVo> getListaPersona() {
		return listaPersona;
	}
	
	
	public ArrayList<UsuarioVo> getListaPersona2() {
		return listaPersona2;
	}
	
	public ArrayList<UsuarioVo> getListaPersona3() {
		return listaPersona3;
	}

	

	public void agregarPersona() {
		listaPersona.add(miusuario);
		setMsjBD(personaDao.agregarPersona(miusuario));
		miusuario = new UsuarioVo();// limpiamos el objeto
		cargarPersonas2();
	}

	public void agregarRegistro() {
		setMsjBD2(personaDao.AgregarIngreso(miusuario2.getDocumento()));
		miusuario2 = new UsuarioVo();// limpiamos el objeto
		cargarPersonas2();
	}
	public void agregarRegistroMedidad() {
		setMsjBD2(personaDao.agregarMedidasUsuarios(medidas));
		medidas = new MedidasUsuarioVo();// limpiamos el objeto
		cargarPersonas2();
	}

	public void eliminarPersona(UsuarioVo UsuarioVo) {
		setMsjBD(personaDao.eliminarPersona(UsuarioVo));
		listaPersona2.remove(UsuarioVo);
		cargarPersonas2();
	}
	public void ActivarPersona(UsuarioVo datos) {
		setMsjBD(personaDao.ActivarPersona(datos));
		listaPersona3.add(datos);
		cargarPersonas3();
	}

	public String editarPersona(String documento) {
		     System.out.println(documento);
             System.out.println("ingresa");
             miusuario = personaDao.consultarPersonaIndividual(documento);
             session.setAttribute("Usuario", miusuario);
             
			
		return "editarUsuario.jsf";
	}
	

	public String guardarPersona(UsuarioVo UsuarioVo) {
		setMsjBD(personaDao.editarPersona(UsuarioVo));
		return "listaUsuarios.jsf?faces-redirect=true";
		
	}

	public UsuarioVo getMiusuario2() {
		return miusuario2;
	}

	public void setMiusuario2(UsuarioVo miusuario2) {
		this.miusuario2 = miusuario2;
	}

	public UsuarioVo getMiusuario() {
		return miusuario;
	}

	public void setMiusuario(UsuarioVo miusuario) {
		this.miusuario = miusuario;
	}
	
	

	public MedidasUsuarioVo getMedidas() {
		return medidas;
	}

	public void setMedidas(MedidasUsuarioVo medidas) {
		this.medidas = medidas;
	}

	public String getMsjBD() {
		return msjBD;
	}

	public void setMsjBD(String msjBD) {
		this.msjBD = msjBD;
	}

	public void CerrarSesion() {

	}
}
