package com.project.TaskUnity.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    public int id;

    @Column(name = "name")
    public String projectName;

    @Column(name = "description")
    public String projectDescription;

    @Column(name = "type")
    public String projectType;

    @Column(name = "created_by")
    public int createdBy;

    @Column(name = "team_members")
    public String teamMember;

    public Project() {
    }

    public Project(String projectName, String projectDescription, String projectType, int createdBy, String teamMember) {
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.projectType = projectType;
        this.createdBy = createdBy;
        this.teamMember = teamMember;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public int getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(int createdBy) {
        this.createdBy = createdBy;
    }

    public String getTeamMember() {
        return teamMember;
    }

    public void setTeamMember(String teamMember) {
        this.teamMember = teamMember;
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", projectName='" + projectName + '\'' +
                ", projectDescription='" + projectDescription + '\'' +
                ", projectType='" + projectType + '\'' +
                ", createdBy=" + createdBy +
                ", teamMember='" + teamMember + '\'' +
                '}';
    }
}
