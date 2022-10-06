package main.code.com.entity;

public class UserInformation implements Identifiable {
    private int id;
    private String name;
    private String surname;
    private String phone;

    public UserInformation() {}

    public UserInformation(int id, String name, String surname, String  phone) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;

        UserInformation userInformation = (UserInformation) o;
        return id == userInformation.id &&
                name.equals(userInformation.name) &&
                surname.equals(userInformation.surname) &&
                phone.equals(userInformation.phone);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result +  id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((surname == null) ? 0 : surname.hashCode());
        result = prime * result +  ((phone==null) ? 0: phone.hashCode());
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder result = new StringBuilder("UserInformation{");
        result.append("id=").append(id);
        result.append(", name='").append(name).append('\'');
        result.append(", surname='").append(surname).append('\'');
        result.append(", phone=").append(phone);
        result.append('}');
        return result.toString();
    }
}
