package tw.com.phctw.bean;

public class Photo {
	
		private String photoid;
		private String photopath;
		
		public String getPhotoid() {
			return photoid;
		}
		public void setPhotoid(String photoid) {
			this.photoid = photoid;
		}
		public String getPhotopath() {
			return photopath;
		}
		public void setPhotopath(String photopath) {
			this.photopath = photopath;
		}
		@Override
		public String toString() {
			return "Photo [photoid=" + photoid + ", photopath=" + photopath + "]";
		} 
}
