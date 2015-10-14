package agenda.listener;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;

import agenda.bean.LoginBean;
import agenda.model.Usuario;

public class PhaseListener implements javax.faces.event.PhaseListener {

	private static final long serialVersionUID = 1L;

	@Override
    public void beforePhase(PhaseEvent event) {
    }

    @Override
    public void afterPhase(PhaseEvent event) {
        if ("/login.xhtml".equals(FacesContext.getCurrentInstance().getViewRoot().getViewId())) {
            return;
        }
        LoginBean usuarioBean = (LoginBean) FacesContext.getCurrentInstance()
                .getExternalContext().getSessionMap().get("loginBean");
        Usuario usuarioLogado = null;
        if (usuarioBean != null) {
            usuarioLogado = usuarioBean.getUsuario();
        }
        if (usuarioLogado == null || !usuarioLogado.getLogado()) {
            FacesContext.getCurrentInstance()
                    .getApplication().getNavigationHandler()
                    .handleNavigation(FacesContext.getCurrentInstance(),
                            null, "login?faces-redirect=true");
            FacesContext.getCurrentInstance().renderResponse();
        }
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }
}
