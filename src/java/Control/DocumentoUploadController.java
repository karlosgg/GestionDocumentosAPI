
package Control;

/**
 *
 * @author José Carlos Grijalva González
 */

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
 
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
 
@ManagedBean
public class DocumentoUploadController {
     
    private UploadedFile file;
 
    public UploadedFile getFile() {
        return file;
    }
 
    public void setFile(UploadedFile file) {
        this.file = file;
    }
     
    public void upload() {
//        UploadedFile uploadedFile = event.getFile();
//        String fileName = uploadedFile.getFileName();
//        String contentType = uploadedFile.getContentType();
//        byte[] contents = uploadedFile.getContents(); // Or getInputStream()
//        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Succesful", fileName + " is uploaded.");
//        FacesContext.getCurrentInstance().addMessage(null, message);
        if(file != null) {
            
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,"Succesful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }
}