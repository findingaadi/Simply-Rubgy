/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplyrugby;

/**
 *
 * @author HP
 */
public class JuniorPlayer {

    private Integer juniorPlayerId;
    private String name;
    private String sruNum;
    private String address;
    private String phone;
    private Integer postCode;
    private String doctor;
    private String nextOfKin;
    private String guardian1;
    private String guardian1Relation;
    private String guardian2;
    private String guardian2Relation;
    private Team team;
    private String knownHealth;
    
    public JuniorPlayer(){}

    public JuniorPlayer(Integer juniorPlayerId, String name, String sruNum, String address, String phone,
            Integer postCode, String doctor, String nextOfKin, String guardian1, String guardian1Relation, 
            String guardian2, String guardian2Relation,String knownHealth) {
        this.juniorPlayerId = juniorPlayerId;
        this.name = name;
        this.sruNum = sruNum;
        this.address = address;
        this.phone = phone;
        this.postCode = postCode;
        this.doctor = doctor;
        this.nextOfKin = nextOfKin;
        this.guardian1 = guardian1;
        this.guardian1Relation = guardian1Relation;
        this.guardian2 = guardian2;
        this.guardian2Relation = guardian2Relation;
        this.knownHealth = knownHealth;
        
    }

    public Integer getJuniorPlayerId() {
        return juniorPlayerId;
    }

    public void setJuniorPlayerId(Integer juniorPlayerId) {
        this.juniorPlayerId = juniorPlayerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSruNum() {
        return sruNum;
    }

    public void setSruNum(String sruNum) {
        this.sruNum = sruNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getPostCode() {
        return postCode;
    }

    public void setPostCode(Integer postCode) {
        this.postCode = postCode;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getNextOfKin() {
        return nextOfKin;
    }

    public void setNextOfKin(String nextOfKin) {
        this.nextOfKin = nextOfKin;
    }

    public String getGuardian1() {
        return guardian1;
    }

    public void setGuardian1(String guardian1) {
        this.guardian1 = guardian1;
    }

    public String getGuardian1Relation() {
        return guardian1Relation;
    }

    public void setGuardian1Relation(String guardian1Relation) {
        this.guardian1Relation = guardian1Relation;
    }

    public String getGuardian2() {
        return guardian2;
    }

    public void setGuardian2(String guardian2) {
        this.guardian2 = guardian2;
    }

    public String getGuardian2Relation() {
        return guardian2Relation;
    }

    public void setGuardian2Relation(String guardian2Relation) {
        this.guardian2Relation = guardian2Relation;
    }

    public String getKnownHealth() {
        return knownHealth;
    }

    public void setKnownHealth(String knownHealth) {
        this.knownHealth = knownHealth;
    }
    

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
