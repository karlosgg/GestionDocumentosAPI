
package Control;

/**
 *
 * @author José Carlos Grijalva González
 */

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.persistence.criteria.Path;
 
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
 
@ManagedBean
public class DocumentoUploadController {
     
    private UploadedFile file;
    private  String mensaje;
    private String pathDocumento;

    public String getPathDocumento() {
        return pathDocumento;
    }

    public void setPathDocumento(String pathDocumento) {
        this.pathDocumento = pathDocumento;
    }

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
            OutputStream os = new FileOutputStream(folder+"/"+fileName);
            pathDocumento=folder+"/"+fileName;
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
}