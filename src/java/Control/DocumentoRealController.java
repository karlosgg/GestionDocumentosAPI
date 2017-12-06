package Control;

import Modelo.DocumentoReal;
import Control.util.JsfUtil;
import Control.util.JsfUtil.PersistAction;
import Modelo.Usuario;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.io.Serializable;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

@Named("documentoRealController")
@SessionScoped
public class DocumentoRealController implements Serializable {

    @EJB
    private Control.DocumentoRealFacade ejbFacade;
    private List<DocumentoReal> items = null;
    private DocumentoReal selected;
    private UploadedFile file;
    private  String mensaje;
    private StreamedContent fileDown;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    public UploadedFile getFile() {
        return file;
    }
 
    public void setFile(UploadedFile file) {
        this.file = file;
    }
     
    public DocumentoRealController() {
    }

    public DocumentoReal getSelected() {
        return selected;
    }

    public void setSelected(DocumentoReal selected) {
        this.selected = selected;
    }

    protected void setEmbeddableKeys() {
    }

    protected void initializeEmbeddableKey() {
    }

    private DocumentoRealFacade getFacade() {
        return ejbFacade;
    }

    public DocumentoReal prepareCreate() {
        selected = new DocumentoReal();
        initializeEmbeddableKey();        
        mensaje="";
        return selected;

    }

    public void create() {
        Usuario usuario=(Usuario)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        selected.setIdUsuario(usuario);
        persist(PersistAction.CREATE, ResourceBundle.getBundle("/Bundle").getString("DocumentoRealCreated"));
        if (!JsfUtil.isValidationFailed()) {
            items = null;    // Invalidate list of items to trigger re-query.
        }
        mensaje="";
    }

    public void update() {
        persist(PersistAction.UPDATE, ResourceBundle.getBundle("/Bundle").getString("DocumentoRealUpdated"));
    }

    public void destroy() {
        persist(PersistAction.DELETE, ResourceBundle.getBundle("/Bundle").getString("DocumentoRealDeleted"));
        if (!JsfUtil.isValidationFailed()) {
            selected = null; // Remove selection
            items = null;    // Invalidate list of items to trigger re-query.
        }
    }

    public List<DocumentoReal> getItems() {
        if (items == null) {
            items = getFacade().findAll();
        }
        return items;
    }

    public void FileDownloadController() {
        InputStream stream = this.getClass().getResourceAsStream(selected.getDocumento());
        fileDown = new DefaultStreamedContent(stream, "application/pdf", "downloaded_file.pdf");
    }
    private StreamedContent DocPath;
	
    public StreamedContent FileDownloadView(String path) {        
        InputStream stream = this.getClass().getResourceAsStream(path); 
                //FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/demo/images/optimus.jpg");
		DocPath = new DefaultStreamedContent(stream, "application/pdf", "downloaded_.pdf");
                return DocPath;
	}
 
    public StreamedContent getFileDown() {
        return this.fileDown;
    }
    public void upload(FileUploadEvent event) throws IOException {
        UploadedFile uploadedFile = event.getFile();
        String fileName = uploadedFile.getFileName();
//        String contentType = uploadedFile.getContentType();
//        byte[] contents = uploadedFile.getContents(); // Or getInputStream()
//        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Succesful", fileName + " is uploaded.");
//        FacesContext.getCurrentInstance().addMessage(null, message);
          InputStream is = event.getFile().getInputstream();

            //String folder = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/uploads");
            String folder = "/home/karlos/NetBeansProjects/GestionDocumentosAPI/uploads";
            String ruta = folder+"/"+fileName;
            OutputStream os = new FileOutputStream(folder+"/"+fileName);
            selected.setDocumento(ruta);
            byte buf[] = new byte[1024];
            int len;
            while ((len = is.read(buf)) > 0) {
                os.write(buf, 0, len);
            }
            os.close();
            is.close();
            System.out.println("Archivo subido: "+fileName);
            //String filename = FilenameUtils.getBaseName(uploadedFile.getName()); 
            //String extension = FilenameUtils.getExtension(uploadedFile.getName());
            //Path file = Files.createTempFile(folder, filename + "-", "." + extension);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Succesful", fileName + " is uploaded."+folder);
            mensaje="Documento "+fileName+" adjuntado";
            FacesContext.getCurrentInstance().addMessage(null, message);
        
    }
    
    private void persist(PersistAction persistAction, String successMessage) {
        if (selected != null) {
            setEmbeddableKeys();
            try {
                if (persistAction != PersistAction.DELETE) {
                    getFacade().edit(selected);
                } else {
                    getFacade().remove(selected);
                }
                JsfUtil.addSuccessMessage(successMessage);
            } catch (EJBException ex) {
                String msg = "";
                Throwable cause = ex.getCause();
                if (cause != null) {
                    msg = cause.getLocalizedMessage();
                }
                if (msg.length() > 0) {
                    JsfUtil.addErrorMessage(msg);
                } else {
                    JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
                }
            } catch (Exception ex) {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
                JsfUtil.addErrorMessage(ex, ResourceBundle.getBundle("/Bundle").getString("PersistenceErrorOccured"));
            }
        }
    }

    public DocumentoReal getDocumentoReal(java.lang.Integer id) {
        return getFacade().find(id);
    }

    public List<DocumentoReal> getItemsAvailableSelectMany() {
        return getFacade().findAll();
    }

    public List<DocumentoReal> getItemsAvailableSelectOne() {
        return getFacade().findAll();
    }

    @FacesConverter(forClass = DocumentoReal.class)
    public static class DocumentoRealControllerConverter implements Converter {

        @Override
        public Object getAsObject(FacesContext facesContext, UIComponent component, String value) {
            if (value == null || value.length() == 0) {
                return null;
            }
            DocumentoRealController controller = (DocumentoRealController) facesContext.getApplication().getELResolver().
                    getValue(facesContext.getELContext(), null, "documentoRealController");
            return controller.getDocumentoReal(getKey(value));
        }

        java.lang.Integer getKey(String value) {
            java.lang.Integer key;
            key = Integer.valueOf(value);
            return key;
        }

        String getStringKey(java.lang.Integer value) {
            StringBuilder sb = new StringBuilder();
            sb.append(value);
            return sb.toString();
        }

        @Override
        public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
            if (object == null) {
                return null;
            }
            if (object instanceof DocumentoReal) {
                DocumentoReal o = (DocumentoReal) object;
                return getStringKey(o.getIdDocumentoReal());
            } else {
                Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, "object {0} is of type {1}; expected type: {2}", new Object[]{object, object.getClass().getName(), DocumentoReal.class.getName()});
                return null;
            }
        }

    }

}
