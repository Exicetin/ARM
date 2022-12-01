package com.arm.tables;

import java.sql.Date;

@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idOrder;//id Наряда
    private int idOtv;//Ответсвенный
    private int systems;//система
    private String number;//номер
    private Date dateCreate;//дата создания
    private String changeObject;//изменяемый объект
    private int fcAgreement;//требуется согласование с ФЗ
    private String version;//Номер версии изменений
    private String reasons;//Основание
    private String conditions;//Условия выполнения наряда
    private changeList;
    private String docChange;//Изменения в документации
    private String dSrcProd;// источник данных Промышленный полигон
    private String dSrcTest;// источник данных Test полигон
    private String installTest;//установка на Тест
    private String installProd;//установка на пром
    private String methodTest;//метод проверки Тест
    private String methodProd;//метод проверки Пром
    private String methodProdF;//Методика проверки функций Пром
    private String methodTestF;//Методика проверки функций Тест
    private String rollback;//технология отката
    private String responsibleContact;//ответсвенный контакт
    private int stopSystem;//остановка системы 0-нет.1-да.
    private String downTime;//Время простоя системы
    private int idProg;//id программиста
    private int idTech;//id технолога
    private String phoneTech;//телефон технолога
    private String phoneProg;//телефон программиста
    private int idAdm;//id администратора
    private String phoneAdm;// телефон администратора
    private String fzFTest;// ответсвенный от функц. заказчика
    private String phoneFZFTest;//номер ответсвенного от функц. заказчика

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdOtv() {
        return idOtv;
    }

    public void setIdOtv(int idOtv) {
        this.idOtv = idOtv;
    }

    public int getSystems() {
        return systems;
    }

    public void setSystems(int systems) {
        this.systems = systems;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getChangeObject() {
        return changeObject;
    }

    public void setChangeObject(String changeObject) {
        this.changeObject = changeObject;
    }

    public int getFcAgreement() {
        return fcAgreement;
    }

    public void setFcAgreement(int fcAgreement) {
        this.fcAgreement = fcAgreement;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getReasons() {
        return reasons;
    }

    public void setReasons(String reasons) {
        this.reasons = reasons;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public String getDocChange() {
        return docChange;
    }

    public void setDocChange(String docChange) {
        this.docChange = docChange;
    }

    public String getdSrcProd() {
        return dSrcProd;
    }

    public void setdSrcProd(String dSrcProd) {
        this.dSrcProd = dSrcProd;
    }

    public String getdSrcTest() {
        return dSrcTest;
    }

    public void setdSrcTest(String dSrcTest) {
        this.dSrcTest = dSrcTest;
    }

    public String getInstallTest() {
        return installTest;
    }

    public void setInstallTest(String installTest) {
        this.installTest = installTest;
    }

    public String getInstallProd() {
        return installProd;
    }

    public void setInstallProd(String installProd) {
        this.installProd = installProd;
    }

    public String getMethodTest() {
        return methodTest;
    }

    public void setMethodTest(String methodTest) {
        this.methodTest = methodTest;
    }

    public String getMethodProd() {
        return methodProd;
    }

    public void setMethodProd(String methodProd) {
        this.methodProd = methodProd;
    }

    public String getMethodProdF() {
        return methodProdF;
    }

    public void setMethodProdF(String methodProdF) {
        this.methodProdF = methodProdF;
    }

    public String getMethodTestF() {
        return methodTestF;
    }

    public void setMethodTestF(String methodTestF) {
        this.methodTestF = methodTestF;
    }

    public String getRollback() {
        return rollback;
    }

    public void setRollback(String rollback) {
        this.rollback = rollback;
    }

    public String getResponsibleContact() {
        return responsibleContact;
    }

    public void setResponsibleContact(String responsibleContact) {
        this.responsibleContact = responsibleContact;
    }

    public int getStopSystem() {
        return stopSystem;
    }

    public void setStopSystem(int stopSystem) {
        this.stopSystem = stopSystem;
    }

    public String getDownTime() {
        return downTime;
    }

    public void setDownTime(String downTime) {
        this.downTime = downTime;
    }

    public int getIdProg() {
        return idProg;
    }

    public void setIdProg(int idProg) {
        this.idProg = idProg;
    }

    public int getIdTech() {
        return idTech;
    }

    public void setIdTech(int idTech) {
        this.idTech = idTech;
    }

    public String getPhoneTech() {
        return phoneTech;
    }

    public void setPhoneTech(String phoneTech) {
        this.phoneTech = phoneTech;
    }

    public String getPhoneProg() {
        return phoneProg;
    }

    public void setPhoneProg(String phoneProg) {
        this.phoneProg = phoneProg;
    }

    public int getIdAdm() {
        return idAdm;
    }

    public void setIdAdm(int idAdm) {
        this.idAdm = idAdm;
    }

    public String getPhoneAdm() {
        return phoneAdm;
    }

    public void setPhoneAdm(String phoneAdm) {
        this.phoneAdm = phoneAdm;
    }

    public String getFzFTest() {
        return fzFTest;
    }

    public void setFzFTest(String fzFTest) {
        this.fzFTest = fzFTest;
    }

    public String getPhoneFZFTest() {
        return phoneFZFTest;
    }

    public void setPhoneFZFTest(String phoneFZFTest) {
        this.phoneFZFTest = phoneFZFTest;
    }
}
