package model;

public class Guest {
    private String id;
    private String fullName;
    private String idDocument;
    private String phone;
    private String email;

    public Guest(String id, String fullName, String idDocument, String phone, String email) {
        this.id = id;
        this.fullName = fullName;
        this.idDocument = idDocument;
        this.phone = phone;
        this.email = email;
    }

    public String getId() { return id; }
    public String getFullName() { return fullName; }
    public String getIdDocument() { return idDocument; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }
}
