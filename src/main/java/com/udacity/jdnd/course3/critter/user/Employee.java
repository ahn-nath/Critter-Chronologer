package com.udacity.jdnd.course3.critter.user;

import javax.persistence.*;

import com.udacity.jdnd.course3.critter.schedule.Schedule;

import java.time.DayOfWeek;
import java.util.List;
import java.util.Set;

@Entity
public class Employee extends Users {
	@Column
    @ElementCollection(targetClass=EmployeeSkill.class)
    private Set<EmployeeSkill> employeeSkills;
	
	@Column
    @ElementCollection(targetClass=DayOfWeek.class)
    private Set<DayOfWeek> workDays;
    
    @ManyToMany(mappedBy = "employees")
    private List<Schedule> schedules;
    
    

	public Set<EmployeeSkill> getEmployeeSkills() {
		return employeeSkills;
	}

	public void setEmployeeSkills(Set<EmployeeSkill> employeeSkills) {
		this.employeeSkills = employeeSkills;
	}

	public Set<DayOfWeek> getWorkDays() {
		return workDays;
	}

	public void setWorkDays(Set<DayOfWeek> workDays) {
		this.workDays = workDays;
	}

	public List<Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}
	

		

}
