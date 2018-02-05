package tw.com.phctw.serviceI;

import javax.servlet.http.Part;

public interface PhotoServiceI {
	public Boolean headShotPhotoInsert();
	public String getMaxPhotoIdAndPlusOne();
	public String getFilename(Part part);
	
}
