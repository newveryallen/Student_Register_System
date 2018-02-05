package tw.com.phctw.service;

import javax.servlet.http.Part;

import tw.com.phctw.bean.Photo;
import tw.com.phctw.dao.PhotoDao;
import tw.com.phctw.serviceI.PhotoServiceI;

public class PhotoService implements PhotoServiceI{
	
	 private PhotoDao dao;
		
		private PhotoDao getDao()
		{
			if( dao == null)
			{
				dao = new PhotoDao();
			}	
			return dao;
		}
		
		public Boolean headShotPhotoInsert() {
			
			Photo photo = new Photo();
			photo.setPhotoid(this.getMaxPhotoIdAndPlusOne());//這個要不重複且要一直往上加
//			photo.setPhotoid();//這個要能從存照片夾捉photopath塞入
			
			this.getDao().insertPhotoPathAndId(photo);
			
			
			return false;
		}
		
		public String getMaxPhotoIdAndPlusOne() {//photo欄位最大的+1
			
			    String maxPhotoId = getDao().maxPhotoId();
			    int  ConvertmaxPhotoIdIntoInt = Integer.parseInt(maxPhotoId) + 1;
			    String MaxPhotoIdAndPlusOne = String.valueOf(ConvertmaxPhotoIdIntoInt);
			return MaxPhotoIdAndPlusOne;
		}
		
		
		public String getFilename(Part part) { //取得上傳檔名
			String header = part.getHeader("Content-Disposition");
			String filename = 
					header.substring(header.indexOf("filename=\"") + 10,
					header.lastIndexOf("\""));
			
			return filename;
		}
		
		
		
		
		
		
		
		
		
	}//end of class
		
		


