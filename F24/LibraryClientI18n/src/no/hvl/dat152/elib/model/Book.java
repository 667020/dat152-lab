/**
 * 
 */
package no.hvl.dat152.elib.model;

/**
 * @author tdoy
 */
public class Book {

	private String isbn;
	
	private String title;
	
	private String descprition;
	
	private String icon;
	
	public Book(String isbn, String title, String description, String icon) {
		
		this.isbn = isbn;
		this.title = title;
		this.descprition = description;
		this.icon = icon;
	}

	/**
	 * @return the iSBN
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * @param iSBN the iSBN to set
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the descprition
	 */
	public String getDescprition() {
		return descprition;
	}

	/**
	 * @param descprition the descprition to set
	 */
	public void setDescprition(String descprition) {
		this.descprition = descprition;
	}

	/**
	 * @return the icon
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * @param icon the icon to set
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
}
