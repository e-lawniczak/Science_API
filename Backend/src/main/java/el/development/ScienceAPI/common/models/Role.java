package el.development.ScienceAPI.common.models;

public enum Role {
    TEACHER("PROMOTER"),
    STUDENT("STUDENT"),
    ADMIN("ADMIN"),
    NONE("");
    private String name;

    Role(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}