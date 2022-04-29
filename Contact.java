/*
* Purpose: Contact object
*/
public class Contact{
    private String name;
    private String relation;
    private String birthday;
    private String phoneNum;
    private String email;

    public Contact(String name, String relation, String birthday, String phoneNum, String email){
        this.name = name;
        this.relation = relation;
        this.birthday = birthday;
        this.phoneNum = phoneNum;
        this.email = email;
    }

    // getter & setter methods
    public String getName(){
        return name;
    }
    public void setName(String n){
        name = n;
    }

    public String getRelation(){
        return relation;
    }
    public void setRelation(String r){
        relation = r;
    }

    public String getBirthday(){
        return birthday;
    }
    public void setBirthday(String b){
        birthday = b;
    }

    public String getPhoneNum(){
        return phoneNum;
    }
    public void setPhoneNum(String p){
        phoneNum = p;
    }

    public String getEmail(){
        return email;
    }
    public void setEmail(String e){
        email = e;
    }

    public String toString(){
        String str = String.format("%-18s %-11s %-11s %-16s %-15s", name, relation, birthday, phoneNum, email);
        return str;
    }

}