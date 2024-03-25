package com.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Orders {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)		// pk with auto_increment 
private int oid;
private int pid;
private LocalDateTime ldt;
public int getOid() {
	return oid;
}
public void setOid(int oid) {
	this.oid = oid;
}
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public LocalDateTime getLdt() {
	return ldt;
}
public void setLdt(LocalDateTime ldt) {
	this.ldt = ldt;
}
@Override
public String toString() {
	return "Orders [oid=" + oid + ", pid=" + pid + ", ldt=" + ldt + "]";
}

}
