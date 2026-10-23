package model;

public class Guest {
    private final String id;
    private final String fullName;
    private final String document;
    private final String phone;
    private final String email;

    public Guest(String id, String fullName, String document, String phone, String email) {
        this.id = id;
        this.fullName = fullName;
        this.document = document;
        this.phone = phone;
        this.email = email;
    }

    public String getId() { return id; }
    public String getFullName() { return fullName; }
    public String getDocument() { return document; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }
}
