package controller;

import model.Idee;
import controller.util.JsfUtil;
import controller.util.PaginationHelper;
import facade.IdeeFacade;

import facade.KommentarFacade;
import java.io.Serializable;
import java.util.Date;
import java.util.ResourceBundle;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import model.Kommentar;

@ManagedBean(name = "ideeController")
@SessionScoped
public class IdeeController implements Serializable {

    private Idee current;
    private Kommentar newKommentar;
    private DataModel items = null;
    @EJB
    private facade.IdeeFacade ejbFacade;
    @EJB
    private facade.KommentarFacade kommentarFacade;
    private PaginationHelper pagination;
    private int selectedItemIndex;

    public IdeeController() {
    }

    public Idee getSelected() {
	if (current == null) {
	    current = new Idee();
	    selectedItemIndex = -1;
	}
	return current;
    }

    public Kommentar getNewKommentar() {
	if (newKommentar == null) {
	    newKommentar = new Kommentar();
	}
	return newKommentar;
    }

    private IdeeFacade getFacade() {
	return ejbFacade;
    }

    private KommentarFacade getKommentarFacade() {
	return kommentarFacade;
    }

    public PaginationHelper getPagination() {
	if (pagination == null) {
	    pagination = new PaginationHelper(10) {

		@Override
		public int getItemsCount() {
		    return getFacade().count();
		}

		@Override
		public DataModel createPageDataModel() {
		    return new ListDataModel(getFacade().findRange(new int[]{getPageFirstItem(), getPageFirstItem() + getPageSize()}));
		}
	    };
	}
	return pagination;
    }

    public String prepareList() {
	recreateModel();
	return "List";
    }

    public String prepareView() {
	current = (Idee) getItems().getRowData();
	selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
	return "View";
    }

    public String prepareCreate() {
	current = new Idee();
	selectedItemIndex = -1;
	return "Create";
    }

    public String create() {
	try {
	    getFacade().create(current);
	    JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("IdeeCreated"));
	    return prepareCreate();
	} catch (Exception e) {
	    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
	    return null;
	}
    }

    /**
     * @author niels
     * @return
     */
    public String createWithDate() {
	try {
	    current.setDatum(new Date());
	    getFacade().create(current);
	    JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("IdeeCreated"));
	    return prepareList();
	} catch (Exception e) {
	    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
	    return null;
	}
    }

    /**
     * @author philipp
     * @return
     */
    public String addKommentar() {
	try {
	    newKommentar.setDatum(new Date());
	    getKommentarFacade().create(newKommentar);
	    current.getMyKommentare().add(newKommentar);
            newKommentar = null;
	    return update();
	} catch (Exception e) {
	    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
	    return null;
	}
    }

    public String prepareEdit() {
	current = (Idee) getItems().getRowData();
	selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
	return "Edit";
    }

    public String update() {
	try {
	    getFacade().edit(current);
	    JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("IdeeUpdated"));
	    return "View";
	} catch (Exception e) {
	    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
	    return null;
	}
    }

    public String destroy() {
	current = (Idee) getItems().getRowData();
	selectedItemIndex = pagination.getPageFirstItem() + getItems().getRowIndex();
	performDestroy();
	recreateModel();
	return "List";
    }

    public String destroyAndView() {
	performDestroy();
	recreateModel();
	updateCurrentItem();
	if (selectedItemIndex >= 0) {
	    return "View";
	} else {
	    // all items were removed - go back to list
	    recreateModel();
	    return "List";
	}
    }

    private void performDestroy() {
	try {
	    getFacade().remove(current);
	    JsfUtil.addSuccessMessage(ResourceBundle.getBundle("/Bundle").getString("IdeeDeleted"));
	} catch (Exception e) {
	    JsfUtil.addErrorMessage(e, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
	}
    }

    private void updateCurrentItem() {
	int count = getFacade().count();
	if (selectedItemIndex >= count) {
	    // selected index cannot be bigger than number of items:
	    selectedItemIndex = count - 1;
	    // go to previous page if last page disappeared:
	    if (pagination.getPageFirstItem() >= count) {
		pagination.previousPage();
	    }
	}
	if (selectedItemIndex >= 0) {
	    current = getFacade().findRange(new int[]{selectedItemIndex, selectedItemIndex + 1}).get(0);
	}
    }

    public DataModel getItems() {
	if (items == null) {
	    items = getPagination().createPageDataModel();
	}
	return items;
    }

    private void recreateModel() {
	items = null;
    }

    public String next() {
	getPagination().nextPage();
	recreateModel();
	return "List";
    }

    public String previous() {
	getPagination().previousPage();
	recreateModel();
	return "List";
    }

    public SelectItem[] getItemsAvailableSelectMany() {
	return JsfUtil.getSelectItems(ejbFacade.findAll(), false);
    }

    public SelectItem[] getItemsAvailableSelectOne() {
	return JsfUtil.getSelectItems(ejbFacade.findAll(), true);
    }

    @FacesConverter(forClass = Idee.class)
    public static class IdeeControllerConverter implements Converter {

	public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
	    if (value == null || value.length() == 0) {
		return null;
	    }
	    IdeeController controller = (IdeeController) facesContext.getApplication().getELResolver().
		    getValue(facesContext.getELContext(), null, "ideeController");
	    return controller.ejbFacade.find(getKey(value));
	}

	long getKey(String value) {
	    long key;
	    key = Long.parseLong(value);
	    return key;
	}

	String getStringKey(long value) {
	    StringBuffer sb = new StringBuffer();
	    sb.append(value);
	    return sb.toString();
	}

	public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
	    if (object == null) {
		return null;
	    }
	    if (object instanceof Idee) {
		Idee o = (Idee) object;
		return getStringKey(o.getId());
	    } else {
		throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: " + IdeeController.class.getName());
	    }
	}
    }
}
