package edu.javacourse.studentorder.domain.register;

public class CityRegisterRespons {
    private boolean existing;
    private Boolean temporal;

    public boolean isExisting() {
        return existing;
    }

    public void setExisting(boolean existing) {
        this.existing = existing;
    }

    public Boolean getTemporal() {
        return temporal;
    }

    public void setTemporal(Boolean temporal) {
        this.temporal = temporal;
    }

    @Override
    public String toString() {
        return "CityRegisterCheckerRespons{" +
                "existing=" + existing +
                ", temporal=" + temporal +
                '}';
    }
}
