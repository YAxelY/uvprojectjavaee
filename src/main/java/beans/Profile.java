package beans;

import java.io.Serializable;

public class Profile implements Serializable {
    private static final long serialVersionUID = 1L;

    private int idProfile;
    private String nomProfile;
    private String prenomProfile;
    private String emailProfile;
    private String passwordProfile;
    private String telephoneProfile;
    private String photoProfile;
    private int idProducteur;

    // Getters and Setters

    public int getIdProfile() {
        return idProfile;
    }

    public void setIdProfile(int idProfile) {
        this.idProfile = idProfile;
    }

    public String getNomProfile() {
        return nomProfile;
    }

    public void setNomProfile(String nomProfile) {
        this.nomProfile = nomProfile;
    }

    public String getPrenomProfile() {
        return prenomProfile;
    }

    public void setPrenomProfile(String prenomProfile) {
        this.prenomProfile = prenomProfile;
    }

    public String getEmailProfile() {
        return emailProfile;
    }

    public void setEmailProfile(String emailProfile) {
        this.emailProfile = emailProfile;
    }

    public String getPasswordProfile() {
        return passwordProfile;
    }

    public void setPasswordProfile(String passwordProfile) {
        this.passwordProfile = passwordProfile;
    }

    public String getTelephoneProfile() {
        return telephoneProfile;
    }

    public void setTelephoneProfile(String telephoneProfile) {
        this.telephoneProfile = telephoneProfile;
    }

    public String getPhotoProfile() {
        return photoProfile;
    }

    public void setPhotoProfile(String photoProfile) {
        this.photoProfile = photoProfile;
    }

    public int getIdProducteur() {
        return idProducteur;
    }

    public void setIdProducteur(int idProducteur) {
        this.idProducteur = idProducteur;
    }

	@Override
	public String toString() {
		return "Profile [idProfile=" + idProfile + ", nomProfile=" + nomProfile + ", prenomProfile=" + prenomProfile
				+ ", emailProfile=" + emailProfile + ", passwordProfile=" + passwordProfile + ", telephoneProfile="
				+ telephoneProfile + ", photoProfile=" + photoProfile + ", idProducteur=" + idProducteur + "]";
	}
    
}
