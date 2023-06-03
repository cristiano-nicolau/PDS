package lab08.ex2;

import java.util.Collections;
import java.util.List;

public class Maker {
    private Employee p;
    private SocialSecurity ss;
    private Insurance ins;
    private Parking park;
    private CC cc;
    private Company company;

    public Maker() {
        ss = new SocialSecurity();
        ins = new Insurance();
        park = new Parking();
        cc = new CC();
        company = new Company();
    }

    public void makeSS(Person p) {
        ss.regist(p); 
    }

    public void makeIns(Person p) {
        ins.regist(p);
    }

    public void makeCC(Person p){
        cc.createCC(p);
    }

    public void makePark(Person p){
        park.allow(p);
    }

    public void admitEmployee(Person p,double salary){
        this.company.admitEmployee(p,salary);
        makeSS(p);
        makeIns(p);
        makeCC(p);
        makePark(p);
    }

    public List<Employee> employees() {
		return this.company.employees();
	}
    
    public void paySalaries(int month){
        this.company.paySalaries(month);
    }
}
