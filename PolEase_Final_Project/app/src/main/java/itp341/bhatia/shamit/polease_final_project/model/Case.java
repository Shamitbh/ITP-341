package itp341.bhatia.shamit.polease_final_project.model;

import android.graphics.Bitmap;
import android.media.Image;

public class Case {

    private String caseTitle;
    private String caseDescription;
    private Bitmap imageEvidence;
    // private Image imageEvidence;
    private boolean caseStatus; // true for open, false for closed

    public Case(String caseTitle, String caseDescription, Bitmap imageEvidence, boolean caseStatus) {
        this.caseTitle = caseTitle;
        this.caseDescription = caseDescription;
        this.imageEvidence = imageEvidence;
        this.caseStatus = caseStatus;
    }

    public Case(){
        super();
    }
    public Case(String caseTitle, String caseDescription, boolean caseStatus) {
        this.caseTitle = caseTitle;
        this.caseDescription = caseDescription;
        this.caseStatus = caseStatus;
    }

    public Case(String caseDescription, boolean caseStatus) {
        this.caseDescription = caseDescription;
        this.caseStatus = caseStatus;
    }

    public String getCaseDescription() {
        return caseDescription;
    }

    public void setCaseDescription(String caseDescription) {
        this.caseDescription = caseDescription;
    }

    public String getCaseTitle() {
        return caseTitle;
    }

    public void setCaseTitle(String caseTitle) {
        this.caseTitle = caseTitle;
    }

    public Bitmap getImageEvidence() {
        return imageEvidence;
    }

    public void setImageEvidence(Bitmap imageEvidence) {
        this.imageEvidence = imageEvidence;
    }

    public boolean isCaseStatus() {
        return caseStatus;
    }

    public void setCaseStatus(boolean caseStatus) {
        this.caseStatus = caseStatus;
    }
}
