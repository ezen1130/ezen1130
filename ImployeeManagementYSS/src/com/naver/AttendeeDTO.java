package com.naver;

import java.io.Serializable;


public class AttendeeDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String intime;
	private String exittime;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIntime() {
		return intime;
	}

	public void setIntime(String intime) {
		this.intime = intime;
	}

	public String getExittime() {
		return exittime;
	}

	public void setExittime(String exittime) {
		this.exittime = exittime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public AttendeeDTO(String id, String name, String intime, String exittime) {
		super();
		this.id = id;
		this.name = name;
		this.intime = intime;
		this.exittime = exittime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AttendeeDTO other = (AttendeeDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "[사원ID: "+id+" | "+"이름: "+name+" | "+"출근시간: "+intime+" | "+"퇴근시간: "+exittime+"]";
	}

}
