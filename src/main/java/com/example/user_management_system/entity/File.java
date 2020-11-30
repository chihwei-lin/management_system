package com.example.user_management_system.entity;

import javax.persistence.*;

@Entity
@Table(name = "files")
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="uid")
    private Integer uid;

    @Column(name = "type")
    private String type;

    @Column(name = "name")
    private String name;

    @Column(name = "path")
    private String path;

    @Column(name = "created_at")
    private String created_at;

    @Column(name = "updated_at")
    private String updated_at;

    public File() {
    }

    public File(Long id, Integer uid, String type, String name, String path, String created_at, String updated_at) {
        this.id = id;
        this.uid = uid;
        this.type = type;
        this.name = name;
        this.path = path;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return "File{" +
                "id=" + id +
                ", uid=" + uid +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                ", created_at='" + created_at + '\'' +
                ", updated_at='" + updated_at + '\'' +
                '}';
    }
}
