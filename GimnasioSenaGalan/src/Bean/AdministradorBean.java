package Bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import dao.AdministradorDao;
import vo.AdministradorVo;

@ManagedBean
@SessionScoped
public class AdministradorBean {

	private AdministradorVo miAdmin;
	private AdministradorVo miAdmin2;
	private boolean siinicio=false;
	private AdministradorDao administradorDao;
	private String msLG;
	private boolean muestrainfo=false;
	FacesContext context = FacesContext.getCurrentInstance();
	HttpSession session = (HttpSession)context.getExternalContext().getSession(true);
	
	
	public AdministradorBean(){   
		 miAdmin=new AdministradorVo();  
		 miAdmin2=new AdministradorVo();
		 administradorDao=new AdministradorDao(); 
		 }
	
	
	
	
	
	public boolean isMuestrainfo() {
		return muestrainfo;
	}





	public void setMuestrainfo(boolean muestrainfo) {
		this.muestrainfo = muestrainfo;
	}





	public String getMsLG() {
		return msLG;
	}





	public void setMsLG(String msLG) {
		this.msLG = msLG;
	}





	public boolean isSiinicio() {
		return siinicio;
	}
	

	public void setSiinicio(boolean siinicio) {
		this.siinicio = siinicio;
	}
	public AdministradorVo getMiAdmin2() {
		return miAdmin2;
	}

	public void setMiAdmin2(AdministradorVo miAdmin2) {
		this.miAdmin2 = miAdmin2;
	}
	  
	
	public AdministradorVo getMiAdmin() {
		return miAdmin;
	}

	public void setMiAdmin(AdministradorVo miAdmin) {
		this.miAdmin = miAdmin;
	}
	
	public void validarUsuario(){
		miAdmin2=administradorDao.ValidarUsuario(miAdmin.getDocumento(),miAdmin.getContraseña());
		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("admin",miAdmin2);
			
	}


	public String laotrapagina(){
		String resp="";
		String inicio="";
		if(administradorDao.isSi()==true){
		inicio="inicio.jsf";
		setSiinicio(true);
		setMuestrainfo(false);
		System.out.println("Aqui entro tambien");
		}else{
			setMuestrainfo(true);
			resp="Datos Incorrectos";
			return resp;
		}
		return inicio;
		
	}
	public void CerrarSesion() {
		try {

			FacesContext context = FacesContext.getCurrentInstance();

			
			context.getExternalContext().invalidateSession();

			context.getExternalContext().redirect("login.jsf");

		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}
}
