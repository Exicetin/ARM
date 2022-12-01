package com.arm.tables;

@Entity
public class Groups {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idGroups;//id
    private int idSotr;//Сотрудник
    public int getIdGroups() {
        return idGroups;
    }

    public void setIdGroups(int idGroups) {
        this.idGroups = idGroups;
    }


    public int getIdSotr() {
        return idSotr;
    }

    public void setIdSotr(int idSotr) {
        this.idSotr = idSotr;
    }


}
